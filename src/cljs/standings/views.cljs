(ns standings.views
  (:require [re-frame.core :as re-frame]
            [standings.subs :as subs]
            ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        nfcNorth (re-frame/subscribe [::subs/nfcNorth])
        nfcEast (re-frame/subscribe [::subs/nfcEast])
        nfcWest (re-frame/subscribe [::subs/nfcWest])
        nfcSouth (re-frame/subscribe [::subs/nfcSouth])
        draw-list-entry (fn [m] [:li (str (:name m) "  " (:wins m) " " (:losses m))])
        draw-division (fn [ml name] 
                        ;(js/alert (str "drawing division " name))
                        [:div name [:ul (map (fn [m] [:li (str (:name m) "  " (:wins m) " " (:losses m))]) ml)]])
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
     (draw-division @nfcWest "West")
     (draw-division @nfcNorth "North")
     (draw-division @nfcEast "East")
     (draw-division @nfcSouth "South")
    ]
    ))
