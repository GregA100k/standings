(ns standings.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(defn find-division [db div]
  (filter #(= div (:division %)) (:teams db))
  )
(re-frame/reg-sub
  ::nfcNorth
  (fn [db]
    (find-division db "NFC North")))

(re-frame/reg-sub
  ::nfcEast
  (fn [db]
    (find-division db "NFC East")))

(re-frame/reg-sub
  ::nfcWest
  (fn [db]
    (find-division db "NFC West")))

(re-frame/reg-sub
  ::nfcSouth
  (fn [db]
    (find-division db "NFC South")))

(re-frame/reg-sub
  ::team1
  (fn [db _] (get db :team1)))

(re-frame/reg-sub
  ::score1
  (fn [db _] (get db :score1)))

(re-frame/reg-sub
  ::team2
  (fn [db _] (get db :team2)))

(re-frame/reg-sub
  ::score2
  (fn [db _] (get db :score2)))

