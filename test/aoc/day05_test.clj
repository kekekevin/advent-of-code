(ns aoc.day05-test
  (:require [clojure.test :refer :all]
            [aoc.day05 :refer :all]))

(deftest aoc5-1-test
  (testing "three-vowels?"
    (is (= true (three-vowels? "aei")))
    (is (= true (three-vowels? "xazegov")))
    (is (= true (three-vowels? "aeiouaeiouaeiou"))))
  (testing "double?"
    (is (= true (double? "xx")))
    (is (= true (double? "abcdde")))
    (is (= true (double? "aabbccdd"))))
  (testing "banned?"
    (is (= true (banned? "abc")))
    (is (= true (banned? "cde")))
    (is (= true (banned? "pqr")))
    (is (= true (banned? "xyz"))))
  (testing "nice?"
    (is (= true (nice? "ugknbfddgicrmopn")))
    (is (= true (nice? "aaa")))
    (is (= false (nice? "jchzalrnumimnmhp")))
    (is (= false (nice? "haegwjzuvuyypxyu")))
    (is (= false (nice? "dvszwmarrgswjxmb")))))

