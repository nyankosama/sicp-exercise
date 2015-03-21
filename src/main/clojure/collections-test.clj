;naive逆序mapping
(defn reverse-map [items proc]
  (if (empty? items)
    items
    (concat (reverse-map (rest items) proc) (list (proc (first items))))))


