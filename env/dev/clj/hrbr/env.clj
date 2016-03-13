(ns hrbr.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [hrbr.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[hrbr started successfully using the development profile]=-"))
   :middleware wrap-dev})
