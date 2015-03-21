(ns
  ^{:author nyankosama}
  ch2.subsets)
;练习2.32
;假定集合为(1 2 3)，返回所有的子集的集合如(() (1) (2) (3) (1 2) (2 3) (1 3) (1 2 3))
(defn subsets [s]
  (if (empty? s)
    s
    (let [rst (subsets (rest s))]
      (concat rst (map (fn [item] (cons (first s) item)) rst)))))
