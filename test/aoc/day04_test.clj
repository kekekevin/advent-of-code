(ns aoc.day04-test
  (:require [clojure.test :refer :all]
            [aoc.day04 :refer :all]))

(deftest aoc4-1-test
    (testing "mine"
      (is (= "000001dbbfa3a5c83a2d506429c7b00e" (mine "abcdef" 609043)))))

