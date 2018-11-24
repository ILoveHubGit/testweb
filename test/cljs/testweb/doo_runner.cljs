(ns testweb.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [testweb.core-test]))

(doo-tests 'testweb.core-test)

