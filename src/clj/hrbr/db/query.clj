(ns hrbr.db.query
  (:require [korma.core :refer :all]))

(use 'korma.db)

;; Or without predefining a connection map:
(defdb prod (postgres {:db "hrbr"
                       :user "postgres"}))

(defentity users)

(defn all-users []
  (select users))

