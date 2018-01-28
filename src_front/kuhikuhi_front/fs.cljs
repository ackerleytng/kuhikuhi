(ns kuhikuhi-front.fs
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as reader]
            [reagent.core :as reagent :refer [atom]]))

(def fs (nodejs/require "fs"))

(def db (atom nil))

(add-watch db :db-watcher
           (fn [_ _ _ new]
             (.log js/console (clj->js [:db-watcher new]))))

(defn read-edn [path]
  (.readFile fs path "utf8" (fn [err, res] (reset! db (reader/read-string res)))))
