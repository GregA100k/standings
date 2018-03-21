(ns standings.db)

(def default-db
  {:name "re-frame"
   :team1 "a"
   :team2 "b"
   :score1 "c"
   :score2 "d"
   :teams [{:name "Packers" :division "NFC North" :wins 0 :losses 0}
           {:name "Vikings" :division "NFC North" :wins 0 :losses 0}
           {:name "Bears" :division "NFC North" :wins 0 :losses 0}
           {:name "Lions" :division "NFC North" :wins 0 :losses 0}
           {:name "Giants" :division "NFC East" :wins 0 :losses 0}
           {:name "Eagles" :division "NFC East" :wins 0 :losses 0}
           {:name "Cowboys" :division "NFC East" :wins 0 :losses 0}
           {:name "Redskins" :division "NFC East" :wins 0 :losses 0}
           {:name "Falcons" :division "NFC South" :wins 0 :losses 0}
           {:name "Panthers" :division "NFC South" :wins 0 :losses 0}
           {:name "Saints" :division "NFC South" :wins 0 :losses 0}
           {:name "Bucaneers" :division "NFC South" :wins 0 :losses 0}
           {:name "Cardinals" :division "NFC West" :wins 0 :losses 0}
           {:name "Rams" :division "NFC West" :wins 0 :losses 0}
           {:name "49ers" :division "NFC West" :wins 0 :losses 0}
           {:name "Seahawks" :division "NFC West" :wins 0 :losses 0}
          ]

   })
