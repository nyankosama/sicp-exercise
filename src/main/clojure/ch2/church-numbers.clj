(ns
  ^{:author nyankosama}
  ch2.church-numbers)

;church计数，将数的表示转换为f函数的调用次数

(def zero (fn [f] (fn [x] x)))
(def one (fn [f] (fn [x] (f x))))
(def two (fn [f] (fn [x] (f (f x)))))
(defn add-1 [n] (fn [f] (fn [x] (f ((n f) x)))))
(defn add [a b] (fn [f] (fn [x] ((a f) ((b f) x)))))
(defn show-num [n] ((n (fn [x] (+ 1 x))) 0))

;test
(println (show-num zero))
(println (show-num one))
(println (show-num two))
(println (show-num (add two two)))
