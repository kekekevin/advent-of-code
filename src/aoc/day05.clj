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
  (reduce (fn [sum item] (if item (inc sum) sum)) 0 (map nice? inputs)))

(defn repeating-pair? [input]
  (loop [remaining input]
    (let [pair (take 2 remaining)]
      (if (< (count remaining) 4)
        false
        (if (> (count (re-seq (re-pattern (apply str pair)) (apply str (drop 2 remaining)))) 0)
          true
          (recur (rest remaining)))))))

(defn split-pair? [input]
  (loop [remaining input]
    (if (< (count remaining) 3)
      false
      (let [triple (take 3 remaining)
            first (first triple)
            third (nth triple 2)]
        (if (= first third)
          true
          (recur (rest remaining)))))))

(defn real-nice? [input]
  (and (repeating-pair? input) (split-pair? input)))

(defn aoc5-2 [inputs]
  (reduce (fn [sum item] (if item (inc sum) sum)) 0 (map real-nice? inputs)))
