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
        draw-list-entry (fn [m] [:li (:name m)])
        ]

    ;[:div "Hello from " @name]
    [:div
     [:div "West"
        [:ul (map draw-list-entry @nfcWest)]
        ]
     [:div "North"
        [:ul (map draw-list-entry @nfcNorth)]
     ]
     [:div "East"
        [:ul (map draw-list-entry @nfcEast)]
        ]
     [:div "South"
        [:ul (map draw-list-entry @nfcSouth)]
     ]
     ]
    ))
