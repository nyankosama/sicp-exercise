;some basic operators
(defn ++ [n] (+ n 1))
(defn -- [n] (- n 1))
(defn += [n deta] (+ n deta))
(defn -= [n deta] (- n deta))

(defn square [n] (* n n))

(defn fast-expt [b n]
  (cond
    (= n 0) 1
    (even? n) (square (fast-expt b (/ n 2)))
    :else (* b (fast-expt b (- n 1)))))


(defn iter-expt [product number count]
  (if (= count 0)
    product
    (iter-expt (* product number) number (-- count))))

(defn normal-expt [b n] (iter-expt 1 b n))

(defn sum-up-to [begin end]
  (if
    (= begin end)
    end
    (+ begin (sum-up-to (++ begin) end))))

(defn sum-up-to-iter [begin end]
  (letfn [(iter [n ret]
            (if (> n end)
              ret
              (iter (++ n) (+ n ret))))]
    (iter begin 0)))

(println (sum-up-to-iter 1 10))
