(ns aoc.day04
  (:require [digest :refer [md5]]))

(defn mine [secret number]
  (md5 (str secret number)))

(defn coin? [hash]
  (= [\0 \0 \0 \0 \0] (take 5 hash)))

(defn aoc4-1 [input]
  (loop [number 1]
    (if (coin? (mine input number))
      number
      (recur (+ 1 number)))))
