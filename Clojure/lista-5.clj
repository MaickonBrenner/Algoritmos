; 1113 - Crescente e Descrescente
(defn ordem [X Y]
  (cond
    (> X Y) (do
              (println "Decrescente")
              (recur (read) (read)))
    (< X Y) (do
              (println "Crescente")
              (recur (read) (read)))))

(ordem (read) (read))

; 1114 - Senha Fixa
(defn senha [X]
  (cond
    (not= X 2002) (do
                    (println "Senha Invalida")
                    (recur (read)))
    (= X 2002) (println "Acesso Permitido")))

(senha (read))

; 1115 - Quadrante
(defn quadrante [X Y]
  (cond
    (and (> X 0) (> Y 0)) (do
                            (println "primeiro")
                            (recur (read) (read)))
    (and (> X 0) (< Y 0)) (do
                            (println "quarto")
                            (recur (read) (read)))
    (and (< X 0) (< Y 0)) (do
                            (println "terceiro")
                            (recur (read) (read)))
    (and (< X 0) (> Y 0)) (do
                            (println "segundo")
                            (recur (read) (read)))))

(quadrante (read) (read))

; 1134 - Tipo de Combustível
(defn tipoCombus

  ([]
   (tipoCombus 0 0 0))

  ([alcool gasolina diesel]
   (let [n (read)]
     (cond
       (= n 4) (do
                 (println "MUITO OBRIGADO")
                 (println (str "Alcool: " alcool))
                 (println (str "Gasolina: " gasolina))
                 (println (str "Diesel: " diesel)))
       (= n 1) (recur (inc alcool) gasolina diesel)
       (= n 2) (recur alcool (inc gasolina) diesel)
       (= n 3) (recur alcool gasolina (inc diesel))
       :else (recur alcool gasolina diesel)))))

(tipoCombus)

; 1154 - Idades
(defn calcular-media

  ([]
   (calcular-media 0 0))

  ([soma contador]
   (let [idade (read)]
     (if (< idade 0)
       (println (format "%.2f" (double (/ soma contador))))
       (recur (+ soma idade) (inc contador))))))

(calcular-media)

; 1131 - Grenais


; 1151 - Fibonacci Fácil
(defn fibonacci [n]
  (let [sequencia (fn sequencia [a b n acc]
                    (if (zero? n)
                      acc
                      (recur b (+ a b) (dec n) (str acc " " b))))]
    (println (sequencia 0 1 (dec n) "0"))))

(fibonacci (read))

; 1028 - Figurinhas 

; 1029 - Fibonacci, Quantas Chamadas?
(defn fibonacci

  ([n]
   (fibonacci n 0 1 1 0))

  ([n a b calls sum]
   (if (zero? n)
     (println (format "fib(%d) = %d calls = %d" b calls sum))
     (recur (dec n) b (+ a b) (inc calls) (+ sum a)))))

(fibonacci (read))

; 1030 - A Lenda de Flavious Josephus
