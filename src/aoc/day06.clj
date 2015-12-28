(ns aoc.day06)

(def initial-grid (vec (repeat 1000 (vec (repeat 1000 false)))))

(defn update-grid [position grid action] 
  (assoc grid (:x position) (update (get grid (:x position)) (:y position) action)))

(defn toggle 
  ([light]
   (not light))
  ([position grid] (update-grid position grid toggle)))

(defn on 
  ([light]
   true)
  ([position grid] (update-grid position grid on)))

(defn off 
  ([light] false)
  ([position grid] (update-grid position grid off)))

(defn light [input position grid]
  (case input
    "turn on" (update-grid position grid on)
    "turn off" (update-grid position grid off)
    "toggle" (update-grid position grid toggle)))

(defn light-grid [input grid]
  (let [action (re-find #"turn on|turn off|toggle" input)
        *matcher* (re-matcher #"\d+" input)
        start {:x (read-string (re-find *matcher*)) :y (read-string (re-find *matcher*))}
        end {:x (read-string (re-find *matcher*)) :y (read-string (re-find *matcher*))}]
    (loop [x (:x start)
           y (:y start)
           result grid]
      (if (= x (:x end))
        (if (= y (:y end))
          (light action {:x x :y y} result)
          (recur (:x start)
                 (inc y)
                 (light action {:x x :y y} result)))
        (recur (inc x)
               y
               (light action {:x x :y y} result))
        ))))

(defn count-lights [row]
  (reduce (fn [sum light] (if light (inc sum) sum)) 0 row)) 

(defn aoc6-1 [inputs]
  (reduce (fn [sum row] (+ sum (count-lights row))) 0 (reduce (fn [result input] (light-grid input result)) initial-grid inputs)))
