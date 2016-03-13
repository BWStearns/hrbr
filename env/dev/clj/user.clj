(ns user
  (:require [mount.core :as mount]
            [hrbr.figwheel :refer [start-fw stop-fw cljs]]
            hrbr.core))

(defn start []
  (mount/start-without #'hrbr.core/repl-server))

(defn stop []
  (mount/stop-except #'hrbr.core/repl-server))

(defn restart []
  (stop)
  (start))


