(ns
  ^{:author nyankosama}
  ch2.nested-map)

;单重循环
(doall (map print (range 0 5)))
(println)

;嵌套的map可以用来模拟多重循环
(doall (map println (map (fn [i] (map (fn [j] j) (range 0 i))) (range 0 5))))
