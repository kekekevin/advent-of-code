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

(defn total-from-input [input f]
  (let [[l w h] (map (fn [str] (read-string str)) (split input #"x"))]
    (f {:l l :w w :h h})))

(defn aoc2-1 [inputs]
  (reduce + (map #(total-from-input % total) inputs)))

(defn bow [dimensions]
  (* (:l dimensions) (:w dimensions) (:h dimensions)))

(defn ribbon-wrap [dimensions]
  (let [{l :l w :w h :h} dimensions]
    (* 2 (apply + (take 2 (sort [l w h]))))))

(defn ribbon-total [dimensions]
  (+ (ribbon-wrap dimensions) (bow dimensions)))

(defn aoc2-2 [inputs]
  (reduce + (map #(total-from-input % ribbon-total) inputs)))
