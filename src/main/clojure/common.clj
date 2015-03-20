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