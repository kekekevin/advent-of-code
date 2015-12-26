(ns aoc.core
  (:require [clojure.string :refer [trim]])
  (:gen-class))

(defn move [c]
  (if (= c \() 1 -1))

(defn basement-position [input] 
  (loop [position 1
         floor 0
         remaining input]
    (let [floor (+ floor (move (first remaining)))]
    (if (= -1 floor)
      position
      (recur (+ 1 position) 
             (+ floor )
             (rest remaining))
    ))))

(defn aoc1-1 [input]
  (reduce (fn [sum c]
            (+ (move c) sum)) 
          0 (seq input)))

(defn aoc1-2 [input]
  (basement-position input))

(defn -main
  [& args]
  (println "1-1: " (aoc1-1 (trim (slurp "1.in"))))
  (println "1-2: " (aoc1-2 (trim (slurp "1.in")))))

