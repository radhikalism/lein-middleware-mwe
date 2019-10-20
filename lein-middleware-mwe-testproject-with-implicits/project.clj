(defproject lein-middleware-mwe-testproject-with-implicits "0.1.0"
  :description "lein-middleware-mwe-testproject"
  :url "http://example.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :middleware [leiningen.middleware-mwe-plugin/explicit-middleware] ;; from .lein-classpath

  ;; true by default:
  ;;:implicit-middleware true
  ;;:implicits true
)
