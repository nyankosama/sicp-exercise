(ns
  ^{:author nyankosama}
  ch2.rational-number)
(require 'common)
;表示一个有理数的数据抽象
(defn make-rat [n d]
  (let [g (gcd n d)]
    (list (/ n g) (/ d g))))
(defn number [x] (nth x 0)) ;返回分子
(defn denom [x] (nth x 1)) ;返回分母

(defn add-rat [x y]
  (make-rat (+ (* (number x) (denom y))
              (* (number y) (denom x)))
    (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat (- (* (number x) (denom y))
              (* (number y) (denom x)))
  (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (number x) (number y))
    (* (denom x) (denom y))))

(defn div-rat [x y]
  (make-rat (* (number x) (denom y))
    (* (denom x) (number y))))

(defn equal-rat? [x y]
  (= (* (number x) (denom y)) (* (number y) (denom x))))

(defn print-rat [x]
  (print (number x))
  (print "/")
  (print (denom x))
  (println))

(print-rat (make-rat 2 4))
