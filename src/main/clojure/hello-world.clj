;some basic operators
(defn ++ [n] (+ n 1))
(defn -- [n] (- n 1))
(defn += [n deta] (+ n deta))
(defn -= [n deta] (- n deta))

(defn square [n] (* n n))

(defn fastExpt [b n]
  (cond
    (= n 0) 1
    (even? n) (square (fastExpt b (/ n 2)))
    :else (* b (fastExpt b (- n 1)))
    )
  )


(defn iterExpt [product number count]
  (if (= count 0)
    product
    (iterExpt (* product number) number (-- count))
    )
  )

(defn nomalExpt [b n] (iterExpt 1 b n))

(defn sumUpTo [begin end]
  (if
    (= begin end)
    end
    (+ begin (sumUpTo (++ begin) end))
    )
  )

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))
    )
  )

