(ns game-states.states
  (:import (com.badlogic.gdx.physics.box2d BodyDef BodyDef$BodyType)
           (General Box2DUtil Zomboid CameraUtil))
  (:require [game-states.play :as play])
  (:use [language-extensions.core]))


(def current-state (atom 'play))

(defn get-current-state
  []
  @current-state)

(defn get-current-update-fn
  []
  (let [current-state @current-state]
    (cond (= current-state 'play) play/update
          :else "No states are matching this is a huge error!")))

(defn get-current-render-fn
  []
  (let [current-state @current-state]
    (cond (= current-state 'play) play/render
          :else "No states are matching this is a huge error!")))

;TODO
;relocate function once you have figured shat out
(defn make-body-definition!
  [x y type]
  (->> (case type
         :static BodyDef$BodyType/StaticBody
         :kinematic BodyDef$BodyType/KinematicBody
         :dynamic BodyDef$BodyType/DynamicBody)
       (Box2DUtil/makeBody x y)))

(defn make-box!
  [x-location y-location type dimension-x dimension-y]
  (Box2DUtil/makeBox (make-body-definition! x-location y-location type) dimension-x dimension-y))

(Box2DUtil. make-body-definition! make-box!)

(make-box! 100 100 :static 50 10)
(make-box! 100 200 :dynamic 5 5)

