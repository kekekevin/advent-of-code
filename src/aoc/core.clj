(ns aoc.core
  (:require [clojure.string :refer [trim split]])
  (:require [aoc.day01 :refer [aoc1-1 aoc1-2]])
  (:require [aoc.day02 :refer [aoc2-1 aoc2-2]])
  (:require [aoc.day03 :refer [aoc3-1 aoc3-2]])
  (:require [aoc.day04 :refer [aoc4-1 aoc4-2]])
  (:require [aoc.day05 :refer [aoc5-1 aoc5-2]])
  (:require [aoc.day06 :refer [aoc6-1]])
  (:gen-class))


(defn -main
  [& args]
  (println "1-1: " (aoc1-1 (trim (slurp "1.in"))))
  (println "1-2: " (aoc1-2 (trim (slurp "1.in"))))
  (println "2-1: " (aoc2-1 (split (slurp "2.in") #"\n")))
  (println "2-2: " (aoc2-2 (split (slurp "2.in") #"\n")))
  (println "3-1: " (aoc3-1 (trim (slurp "3.in"))))
  (println "3-2: " (aoc3-2 (trim (slurp "3.in"))))
  ;;(println "4-1: " (aoc4-1 "yzbqklnj"))
  ;;(println "4-2: " (aoc4-2 "yzbqklnj"))
  (println "5-1: " (aoc5-1 (split (trim (slurp "5.in")) #"\n")))
  (println "5-2: " (aoc5-2 (split (trim (slurp "5.in")) #"\n")))
  (println "6-1: " (aoc6-1 (split (trim (slurp "6.in")) #"\n"))))

