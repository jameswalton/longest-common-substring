(ns longest-common-substring.core
  (:require [clojure.set :as set])
  (:gen-class))

(defn permutations-vec
  [string]
  (let [l (-> string count inc)]
    (for [x (range 0 l) y (range 0 l) :while (> x y)] [y x])))

(defn linear-permutations
  [string]
  (let [permutations (permutations-vec string)]
    (map #(apply (partial subs string) %) permutations)))

(defn longest-common-substring
  [strings]
  (let [l-perms (map (comp set linear-permutations) strings)
        intersections (apply set/intersection l-perms)
        grouped-perms (group-by count intersections)
        longest-perms (-> (apply (partial max-key first) grouped-perms)
                          val)]
    (set longest-perms)))

(defn -main [& strings]
  (let [lcs (longest-common-substring strings)]
    (println (format "Longest common substring(s): %s" lcs))))