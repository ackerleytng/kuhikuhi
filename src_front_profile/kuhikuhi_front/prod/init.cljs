(ns kuhikuhi-front.init
    (:require [kuhikuhi-front.core :as core]
              [kuhikuhi-front.conf :as conf]))

(enable-console-print!)

(defn start-descjop! []
  (core/init! conf/setting))

(start-descjop!)
