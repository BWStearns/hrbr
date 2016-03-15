(ns hrbr.comps
  (:require [re-com.core    :refer [h-box v-box box gap line button label throbber p border]]
            [re-com.misc    :refer [throbber-args-desc]]
            [reagent.core   :as    reagent]
            [re-com.core   :refer [h-box v-box box gap hyperlink-href p]]
            [re-com.box    :refer [box-args-desc]]))
;;             [cljsjs.google-maps]))


(def example-harbors {:name "Oak Bluffs"
                     :id 1
                     :spots [{:id 1
                              :owner-id 1
                              :max-length 30
                              :location {:lat 12 :lon 34}
                              :schedule {:days-available [1 2 3 4 5]
                                         :days-booked [2 3]}}
                             {:id 2
                              :owner-id 1
                              :max-length 20
                              :location {:lat 12 :lon 34}
                              :schedule {:days-available [1 2 3 4 5]
                                         :days-booked []}}
                             {:id 3
                              :owner-id 2
                              :max-length 40
                              :location {:lat 12 :lon 34}
                              :schedule {:days-available [4 5 6 7 8]
                                         :days-booked [6]}}
                             {:id 4
                              :owner-id 3
                              :max-length 50
                              :location {:lat 45 :lon 34}
                              :schedule {:days-available [3 4 5 6 8 9 10]
                                         :days-booked []}}
                             {:id 5
                              :owner-id 4
                              :max-length 15
                              :location {:lat 45 :lon 34}
                              :schedule {:days-available [8 9 10 12 13 14]
                                         :days-booked [8 9 10]}}
                             ]
                     })


(defn map-div-render []
  [:div#map {:style {:height "360px"}}])

(defn map-did-mount []
;;   [:div "FOO"])
    (js/google-maps.Map "#map" {}))

(defn harbor-map []
  (reagent/create-class {:reagent-render map-div-render
                         :component-did-mount map-did-mount}))


(defn spot-detail [spot]
  [border
   :border "1px dashed red"
   :padding "30px"
   :child [v-box
     :size "auto"
     :children [
       [:div (str (:owner-id spot) "'s Spot")]
       [:div (str "Max Length " (:max-length spot))]
       [:div (str "Location: " (str (:location spot)))]]]])

(defn spot-row [left right]
  [h-box
   :children [
     (spot-detail left)
     (if right (spot-detail right) nil)]])

(defn harbor-detail [];[harbor]
  [:div.container
   [:h1 (:name example-harbors)]
   [:h3 "Spots Available"]
   [:div (for [s (partition-all 2 (:spots example-harbors))] (spot-row (first s) (second s)))]])






