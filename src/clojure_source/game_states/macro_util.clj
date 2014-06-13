(ns game-states.macro-util
  (:import (General Zomboid)))

(defmacro make-interactive
  "places watches on update and render functions"
  []
  `(do (add-watch (resolve '~(symbol "update"))
                  (keyword (str ":" (rand-int 100000)))
                  (fn [~(symbol "a")
                       ~(symbol "b")
                       ~(symbol "c")
                       ~(symbol "d")]
                    (println "update reloaded")
                    (Zomboid/reload ~(symbol "update")
                                    ~(symbol "render"))))
       (add-watch (resolve '~(symbol "render"))
                  (keyword (str ":" (rand-int 100000)))
                  (fn [~(symbol "a")
                       ~(symbol "b")
                       ~(symbol "c")
                       ~(symbol "d")]
                    (println "render reloaded")
                    (Zomboid/reload ~(symbol "update")
                                    ~(symbol "render"))))))
