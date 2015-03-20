;1.3 高阶函数
(load "common")
;高阶函数顺序递归求和模板
(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a)
      (sum term (next a) next b))))

;求和迭代式模板
(defn sum-iter [term a next b]
  (letfn [(iter [n result]
            (if (> n b)
              result
              (iter (next n) (+ (term n) result))))]
    iter a 0))

;更一般的accumulate函数
(defn accumulate [combiner null-value term a next b]
  (if (> a b)
    null-value
    (combiner (term a)
      (accumulate combiner null-value term (next a) next b))))

;带有filter的更一般的accumulate函数
(defn accumulate-with-filter
  [combiner null-value filter term next a b]
  (if (> a b)
    null-value
    (combiner (if (filter a) (term a) 0)
      (accumulate-with-filter combiner null-value filter term next (next a) b))))

(defn sum-cubes [a b]
  (sum-iter cube a inc b))

(defn normal-sum [a b]
  (accumulate + 0 identity a inc b))

(defn sum-even [a b]
  (accumulate-with-filter + 0 even? identity inc a b))

;test
(println (normal-sum 1 10))
(println (sum-even 1 10))
