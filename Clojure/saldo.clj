(def n(read))

(defn saldo [valor]
  (cond (< valor 0) "negativo"
        (> valor 0) "positivo"
        :else "zero"))

(println (saldo n))