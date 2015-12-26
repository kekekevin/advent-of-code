(ns aoc.day03
  (:require [clojure.set :refer [union]]))

(defn move [location direction]
  (case direction
    \< (update-in location [:x] dec)
    \> (update-in location [:x] inc)
    \^ (update-in location [:y] inc)
    \v (update-in location [:y] dec)))

(defn visit [location visited]
  (union #{location} visited))

(defn travel [input]
  (loop [location {:x 0 :y 0}
         visited #{location}
         remaining input]
    (if (empty? remaining) 
      visited
      (let [next (move location (first remaining))]
        (recur next
               (visit next visited)
               (rest remaining))))))

(defn aoc3-1 [input]
  (count (travel input)))

(defn aoc3-2 [input]
  (let [indexed-input (map-indexed vector input)
       santa (filter #(even? (get % 0)) indexed-input)
       robo (filter #(odd? (get % 0)) indexed-input)]
    (count (union (travel (map #(get % 1) santa)) (travel (map #(get % 1) robo))))))
