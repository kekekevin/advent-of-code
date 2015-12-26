(ns aoc.day02-test
  (:require [clojure.test :refer :all]
            [aoc.day02 :refer :all]))

(deftest aoc2-1-test
  (testing "total"
    (is (= 58 (total {:l 2 :w 3 :h 4})))
    (is (= 43 (total {:l 1 :w 1 :h 10}))))
  (testing "total-from-input"
    (is (= 58 (total-from-input "2x3x4" total)))))

(deftest aoc2-2-test
  (testing "ribbon-total"
    (is (= 34 (ribbon-total {:l 2 :w 3 :h 4})))
    (is (= 14 (ribbon-total {:l 1 :w 1 :h 10})))))
