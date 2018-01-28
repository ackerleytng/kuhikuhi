(ns kuhikuhi-front.core
  (:require [reagent.core :as reagent :refer [atom]]
            [kuhikuhi-front.electron :as e]
            [kuhikuhi-front.fs :as fs]))

(defonce state (atom {:message "Hello Reagent world"}))

(defn handle-open []
  (if-let [path (e/show-open-dialog (clj->js {:properties ["openFile"]}))]
    (->> path
         first
         fs/read-edn)))

(defn menu-bar []
  [:nav.navbar.is-fixed-top
   [:div.navbar-brand
    [:div.navbar-item
     [:h1.title "kuhikuhi"]]]
   [:div.navbar-menu.is-active
    [:div.navbar-start
     [:div.navbar-item.is-hoverable
      [:a.navbar-link {:on-click handle-open}
       [:span.icon
        [:i.far.fa-folder-open]]
       [:span "Open"]]]]]])

(defn root-component []
  [menu-bar])

(defn mount-root [setting]
  (reagent/render [root-component]
                  (.getElementById js/document "app")))

(defn init! [setting]
  (mount-root setting))
