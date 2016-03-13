(ns hrbr.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[hrbr started successfully]=-"))
   :middleware identity})
