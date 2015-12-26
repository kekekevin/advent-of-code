(ns aoc.day01-test
  (:require [clojure.test :refer :all]
            [aoc.day01 :refer :all]))

(deftest aoc1-test
  (testing "example 1"
    (is (= 0 (aoc1-1 "()()")))
    (is (= 0 (aoc1-1 "(())")))
    )
  (testing "example 2"
    (is (= 3 (aoc1-1 "(((")))
    (is (= 3 (aoc1-1 "(()(()(")))
    )
  )
