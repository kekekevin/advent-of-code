(ns aoc.day05)

(defn three-vowels? [input]
  (>= (count (re-seq #"[aeiou]" input)) 3))

(defn double? [input]
  (loop [remaining input]
    (let [pair (take 2 remaining)]
      (if (< (count remaining) 2)
        false
        (if (apply = pair)
          true
          (recur (rest remaining)))))))

(defn banned? [input]
  (>= (count (re-seq #"ab|cd|pq|xy" input)) 1))

(defn nice? [input]
  (and (three-vowels? input)
       (double? input)
       (not (banned? input))))

(defn aoc5-1 [inputs]
  (reduce (fn [sum item] (if item (inc sum) sum)) 0 (map #(nice? %) inputs)))
