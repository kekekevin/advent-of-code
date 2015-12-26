(ns aoc.day03-test
  (:require [clojure.test :refer :all]
            [aoc.day03 :refer :all]))

(deftest aoc3-1-test
    (testing "travel"
      (is (= 2 (count (travel ">"))))
      (is (= 4 (count (travel "^>v<"))))
      (is (= 2 (count (travel "^v^v^v^v^v"))))))

