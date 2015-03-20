(require 'common)

;求不动点
(defn fix-point [f first-guess]
  (let [tolerance 0.00001
        close-enough? (fn [v1 v2] (< (Math/abs (- v1 v2)) tolerance))
        try (fn [guess]
              (let [next (f guess)]
                (if (close-enough? guess next)
                  next
                  (try next))))]
    try first-guess))

(defn sqrt [x]
  fix-point #(average % (/ x %)) 1.0)

;test
(println (sqrt 2))

