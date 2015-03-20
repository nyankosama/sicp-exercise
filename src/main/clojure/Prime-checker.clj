(require 'common)
;(defn sqaure [n] (* n n))
(defn find-divisor [n test-divisor]
  (cond
    (> (square test-divisor) n) n
    (= (rem n test-divisor) 0) test-divisor
    :else (find-divisor n (++ test-divisor))
    )
  )
(defn smallest-divisor [n] (find-divisor n 2))
(defn prime? [n] (= n (smallest-divisor n)))

(println (prime? 17))


