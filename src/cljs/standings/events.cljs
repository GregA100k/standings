(ns standings.events
  (:require [re-frame.core :as re-frame]
            [standings.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(defn handle-change-team1 [db [_ team1]]
  (assoc db :team1 team1))

(re-frame/reg-event-db :change-team1 handle-change-team1)

(defn handle-change-team2 [db [_ team2]]
  (assoc db :team2 team2))

(re-frame/reg-event-db :change-team2 handle-change-team2)

(defn handle-change-score1 [db [_ score1]]
  (assoc db :score1 score1))

(re-frame/reg-event-db :change-score1 handle-change-score1)

(defn handle-change-score2 [db [_ score2]]
  (assoc db :score2 score2))

(re-frame/reg-event-db :change-score2 handle-change-score2)


(defn find-index [m name]
  (reduce (fn [i m] (if (= name (:name m)) (reduced i) (inc i))) 0 m))

(defn handle-submit-score [db _]
  (let [team1 (:team1 db)
        score1 (:score1 db)
        team2 (:team2 db)
        score2 (:score2 db)
        winner (if (> (js/parseInt score1) (js/parseInt score2)) team1 team2)
        loser (if (< (js/parseInt score1) (js/parseInt score2)) team1 team2)
        db1 (update-in db  [:teams (find-index (:teams db) winner) :wins] inc)
        db2 (update-in db1 [:teams (find-index (:teams db) loser) :losses] inc)
       ]
   db2
  ))

(re-frame/reg-event-db :submit-score handle-submit-score)
