(ns core
  (:import (com.badlogic.gdx.backends.lwjgl LwjglApplication)
           (General GameConfig Zomboid))
  (:require [game-states.states :as state]))

(def game (Zomboid. (fn []) (fn [])))

(defn main
  []
  (LwjglApplication. game
          (GameConfig.)))
(main)

(Zomboid/reload (state/get-current-update-fn)
                (state/get-current-render-fn))
