(ns leiningen.middleware-mwe-plugin
  (:require [leiningen.core.main :as main]))

(defn middleware-mwe-plugin
  "I don't do a lot."
  [project & args]
  (println "Hi!"))

(defn explicit-middleware
  [project]
  (main/info "explicit middleware invoked")
  (System/exit 0))
