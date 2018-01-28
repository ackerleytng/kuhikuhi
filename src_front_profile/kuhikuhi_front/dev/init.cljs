(ns kuhikuhi-front.init
  (:require [figwheel.client :as fw :include-macros true]
            [kuhikuhi-front.core :as core]
            [kuhikuhi-front.conf :as conf]))

(enable-console-print!)

(fw/watch-and-reload
 :websocket-url   "ws://localhost:3449/figwheel-ws"
 :jsload-callback 'start-descjop!)

(defn start-descjop! []
  (core/init! conf/setting))

(start-descjop!)
