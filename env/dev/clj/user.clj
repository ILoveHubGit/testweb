(ns user
  (:require [testweb.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [testweb.figwheel :refer [start-fw stop-fw cljs]]
            [testweb.core :refer [start-app]]
            [testweb.db.core]
            [conman.core :as conman]
            [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'testweb.core/repl-server))

(defn stop []
  (mount/stop-except #'testweb.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn restart-db []
  (mount/stop #'testweb.db.core/*db*)
  (mount/start #'testweb.db.core/*db*)
  (binding [*ns* 'testweb.db.core]
    (conman/bind-connection testweb.db.core/*db* "sql/queries.sql")))

(defn reset-db []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


