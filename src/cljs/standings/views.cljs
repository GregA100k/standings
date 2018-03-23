(ns standings.views
  (:require [re-frame.core :as re-frame]
            [standings.subs :as subs]
            ))


(defn draw-division [ml name] 
  ;(js/alert (str "drawing division " name))
  [:div name [:ul (map (fn [m] [:li (str (:name m) "  " (:wins m) " " (:losses m))]) ml)]])

(defn draw-nfcWest []
  (let [
        nfcWest (re-frame/subscribe [::subs/nfcWest])
       ]
     (draw-division @nfcWest "West")
     ))

(defn draw-nfcNorth []
  (let [
        nfcNorth (re-frame/subscribe [::subs/nfcNorth])
       ]
     (draw-division @nfcNorth "North")))

(defn draw-nfcEast []
  (let [
        nfcEast (re-frame/subscribe [::subs/nfcEast])
       ]
     (draw-division @nfcEast "East")))

(defn draw-nfcSouth []
  (let [
        nfcSouth (re-frame/subscribe [::subs/nfcSouth])
       ]
     (draw-division @nfcSouth "South")))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        nfcNorth (re-frame/subscribe [::subs/nfcNorth])
        nfcEast (re-frame/subscribe [::subs/nfcEast])
        nfcSouth (re-frame/subscribe [::subs/nfcSouth])
        ]

    ;[:div "Hello from " @name]
    [:div
     [:div [:h2 "Scores"]
       [:form
         "Team1" [:input
                  {
                   :value @(re-frame/subscribe [::subs/team1])
                   :on-change #(re-frame/dispatch [:change-team1 (-> % .-target .-value)])
                   }
                  ]
         "Score" [:input
                  {:value @(re-frame/subscribe [::subs/score1])
                   :on-change #(re-frame/dispatch [:change-score1 (-> % .-target .-value)])}
                  ]
                  [:br]
         "Team2" [:input
                  {:value @(re-frame/subscribe [::subs/team2])
                   :on-change #(re-frame/dispatch [:change-team2 (-> % .-target .-value)])}
                  ]
         "Score" [:input
                  {:value @(re-frame/subscribe [::subs/score2])
                   :on-change #(re-frame/dispatch [:change-score2 (-> % .-target .-value)])}
                  ]
                  [:br]
         [:input {:type "button" :value "submit"
                  :on-click (fn [e] (re-frame/dispatch [:submit-score]))
                  }]
       ]
     ]
     [draw-nfcWest]
     [draw-nfcNorth]
     [draw-nfcEast]
     [draw-nfcSouth]
    ]
    ))
