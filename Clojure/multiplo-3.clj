(def n(read))

(defn multiplo-3 [dividendo]
  (= 0 (mod dividendo 3)))

(println (multiplo-3 n))