(ns
  ^{:author nyankosama}
  ch2.subsets)
;练习2.32
;假定集合为(1 2 3)，返回所有的子集的集合如(() (1) (2) (3) (1 2) (2 3) (1 3) (1 2 3))
(defn subsets [s]
  (if (empty? s)
    (list s) ;这里返回的一定要是一个最终返回集的中间结果集，集嵌套的集合
    (let [rst (subsets (rest s))]
      (concat rst (map #(cons (first s) %) rst)))))

(println (subsets (list 1 2 3)))
