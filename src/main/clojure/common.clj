(defn ++ [n] (+ n 1))
(defn -- [n] (- n 1))
(defn += [n deta] (+ n deta))
(defn -= [n deta] (- n deta))

(defn square [n] (* n n))
(defn cube [n] (* n n n))
(defn average [v1 v2] (/ (+ v1 v2) 2))

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

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

;accumulate函数，即fold-right
(defn my-accumulate [op init items]
  (if (empty? items)
    init
    (op (first items) (my-accumulate op init (rest items)))))

:test
(println (my-accumulate cons nil (my-map inc (my-filter even? (list 1 2 3 4 5)))))
(println (my-accumulate max 0 (list 1 2 3 6 4)))
