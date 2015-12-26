(ns aoc.core
  (:require [clojure.string :refer [trim split]])
  (:require [aoc.day01 :refer [aoc1-1 aoc1-2]])
  (:require [aoc.day02 :refer [aoc2-1 aoc2-2]])
  (:gen-class))


(defn -main
  [& args]
  (println "1-1: " (aoc1-1 (trim (slurp "1.in"))))
  (println "1-2: " (aoc1-2 (trim (slurp "1.in"))))
  (println "2-1: " (aoc2-1 (split (slurp "2.in") #"\n")))
  (println "2-2: " (aoc2-2 (split (slurp "2.in") #"\n"))))

