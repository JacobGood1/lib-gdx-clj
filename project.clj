(defproject lib-gdx-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"
            :distribution :repo
            :comments "Same as LibGDX"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.badlogicgames.gdx/gdx "1.1.0"]
                 [com.badlogicgames.gdx/gdx-backend-lwjgl "1.1.0"]
                 [com.badlogicgames.gdx/gdx-platform "1.1.0"
                  :classifier "natives-desktop"]
                 [com.badlogicgames.gdx/gdx-box2d "1.1.0"]
                 [com.badlogicgames.gdx/gdx-box2d-platform "1.1.0"
                  :classifier "natives-desktop"]
                 [language-extensions "1.3"]
                 [org.clojure/core.typed "0.2.48"]]
  :repositories [["sonatype"
                  "https://oss.sonatype.org/content/repositories/snapshots/"]]
  :source-paths ["src/clojure_source"]
  :java-source-paths ["src/java_source"]
  :aot :all
  :main core)