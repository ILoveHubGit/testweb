(ns testweb.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [testweb.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[testweb started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[testweb has shut down successfully]=-"))
   :middleware wrap-dev})
