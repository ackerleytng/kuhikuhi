(ns kuhikuhi-front.electron
  (:require [kuhikuhi.core :as main]
            [cljs.nodejs :as nodejs]))

(def Electron (nodejs/require "electron"))

(defn get-current-window []
  (.. Electron -remote getCurrentWindow))

(defn show-open-dialog
  [options]
  (.. Electron -remote -dialog (showOpenDialog (get-current-window) options)))
