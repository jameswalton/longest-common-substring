(ns longest-common-substring.core-test
  (:require [clojure.test :refer :all]
            [longest-common-substring.core :refer :all]))

(deftest a-test
  (testing "returns the longest common substring"
    (let [strings #{"GCAAGTCTAATA"
                    "CAAGGTTATATA"
                    "GCAATTCTATAA"
                    "CAATTGATATAA"
                    "GCAATCATATAT"}]
      (is (= #{"CAA" "ATA"}
             (longest-common-substring strings))))))

(deftest linear-permutations-test
  (testing "returns the linear permutations for a given string"
    (is (= ["A" "AB" "B" "ABC" "BC" "C"]
           (linear-permutations "ABC")))))

(deftest permutations-vec-test
  (testing "returns a list of permutation vectors for string combinations"
    (is (= [[0 1] [0 2] [1 2]]
           (permutations-vec "AB")))))
