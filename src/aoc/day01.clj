(ns aoc.day01)

(defn move [c]
  (if (= c \() 1 -1))

(defn basement-position [input] 
  (loop [position 1
         floor 0
         remaining input]
    (let [floor (+ floor (move (first remaining)))]
    (if (= -1 floor)
      position
      (recur (+ 1 position) 
             (+ floor )
             (rest remaining))
    ))))

(defn aoc1-1 [input]
  (reduce (fn [sum c]
            (+ (move c) sum)) 
          0 (seq input)))

(defn aoc1-2 [input]
  (basement-position input))
