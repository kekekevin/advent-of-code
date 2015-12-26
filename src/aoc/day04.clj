(ns aoc.day04
  (:require [digest :refer [md5]]))

(defn mine [secret number]
  (md5 (str secret number)))

(defn coin? [hash pattern]
  (= pattern (take (count pattern) hash)))

(defn find-coin [input pattern]
  (loop [number 1]
    (if (coin? (mine input number) pattern)
      number
      (recur (+ 1 number)))))

(defn aoc4-1 [input]
  (find-coin input [\0 \0 \0 \0 \0]))

(defn aoc4-2 [input]
  (find-coin input [\0 \0 \0 \0 \0 \0]))
