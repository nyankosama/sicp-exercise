(ns
  ^{:author nyankosama}
  ch2.sequence-interface)

;map函数
(defn my-map [proc items]
  (if (empty? items)
    nil
    (cons (proc (first items)) (my-map proc (rest items)))))

;filter函数
(defn my-filter [predicate items]
  (cond
    (empty? items) nil
    (predicate (first items))
    (cons
      (first items)
      (my-filter predicate (rest items)))
    :else (my-filter predicate (rest items))))

;accumulate函数，类似于reduce-left
(defn my-accumulate [op init items]
  (if (empty? items)
    init
    (op (first items) (my-accumulate op init (rest items)))))

;对n个seq的accumulate
(defn my-accumulate-n [op init items]
  (if (empty? (first items))
    nil
    (cons (my-accumulate op init
            (my-map first items))
      (my-accumulate-n op init (my-map rest items)))))

;test case
(println (my-accumulate cons nil (my-map inc (my-filter even? (list 1 2 3 4 5)))))
(println (my-accumulate max 0 (list 1 2 3 6 4)))
(println (my-map first (list (list 1 2) (list 3 4))))
(println (my-accumulate-n + 0 (list (list 1 2) (list 3 4))))
