(def n(read))

(defn par [numero]
  (if (even? numero)
    "sim"
    "nao"))

(println (par n))