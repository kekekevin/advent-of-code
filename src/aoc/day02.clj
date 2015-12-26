(ns aoc.day02
  (:require [clojure.string :refer [split]]))

(defn slack [areas]
  (apply min areas))

(defn lw [dimensions]
  (* (:l dimensions) (:w dimensions)))

(defn wh [dimensions]
  (* (:w dimensions) (:h dimensions)))

(defn hl [dimensions]
  (* (:h dimensions) (:l dimensions)))

(defn areas [dimensions]
  [(lw dimensions) (wh dimensions) (hl dimensions)])

(defn total [dimensions]
  (reduce + (conj (map (fn [ area ] (* area 2)) (areas dimensions)) (slack (areas dimensions)))))

(defn total-from-input [input]
  (let [[l w h] (map (fn [str] (read-string str)) (split input #"x"))]
    (total {:l l :w w :h h})))
