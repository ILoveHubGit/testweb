(ns testweb.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[testweb started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[testweb has shut down successfully]=-"))
   :middleware identity})
