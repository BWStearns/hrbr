(ns hrbr.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [hrbr.core-test]))

(doo-tests 'hrbr.core-test)

