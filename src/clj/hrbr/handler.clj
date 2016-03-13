(ns hrbr.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [hrbr.layout :refer [error-page]]
            [hrbr.routes.home :refer [home-routes]]
            [hrbr.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [hrbr.middleware :as middleware]))

(def app-routes
  (routes
    #'service-routes
    (wrap-routes #'home-routes middleware/wrap-csrf)
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(def app (middleware/wrap-base #'app-routes))
