(def n(read))

(defn divisivel-por [dividendo divisor]
  (zero? (mod dividendo divisor)))

(defn fizzbuzz [numero]
  (cond (and (divisivel-por numero 3) 
             (divisivel-por numero 5)) "fizzbuzz"
        (divisivel-por numero 3) "fizz"
        (divisivel-por numero 5) "buzz"
        :else numero))

(println (fizzbuzz n))