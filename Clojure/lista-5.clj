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
(defn grenais 
  ([]
   (do
        (def interCont 0)
        (def gremioCont 0)
        (def empate 0)
        (def contador 0)
       
        (def placar (repeatedly 2 read))
        (def inter (first placar))
        (def gremio (second placar))
          
          (grenais
              (if (> inter gremio) (inc interCont) interCont)
              (if (< inter gremio) (inc gremioCont) gremioCont)
              (if (= inter gremio) (inc empate) empate)
              (inc contador))))
    
  ([interCont gremioCont empate contador]

  (println "Novo grenal (1-sim 2-nao)")
  (def resp (read))

  (if (= resp 2)
      (do 
        (println (str contador " grenais"))
        (println (str "Inter:" interCont))
        (println (str "Gremio:" gremioCont))
        (println (str "Empates:" empate))
        (println (cond 
                    (> interCont gremioCont) "Inter venceu mais"
                    (< interCont gremioCont) "Gremio venceu mais"
                    :else "Nao houve vencedor")))
      (do
          (def placar (repeatedly 2 read))
          (def inter (first placar))
          (def gremio (second placar))
          
          (grenais
              (if (> inter gremio) (inc interCont) interCont)
              (if (< inter gremio) (inc gremioCont) gremioCont)
              (if (= inter gremio) (inc empate) empate)
              (inc contador))))))             

(grenais)

; 1151 - Fibonacci Fácil
(defn fibonacci [n]
  (let [sequencia (fn sequencia [a b n acc]
                    (if (zero? n)
                      acc
                      (recur b (+ a b) (dec n) (str acc " " b))))]
    (println (sequencia 0 1 (dec n) "0"))))

(fibonacci (read))

; 1028 - Figurinhas 
(defn mdc [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn figuras [valores]
   (map (fn [[a b]] (mdc a b)) valores))

(defn main []
  (def n (read))
  (def valores (repeatedly n #(doall (repeatedly 2 read))))
  (doall (map println (figuras valores))))

(main)

; 1029 - Fibonacci, Quantas Chamadas?
; Quase 1
(defn fibonacci

  ([n]
   (fibonacci n 0 1 0 0))

  ([n a b calls index]
   (if (= index n)
     (println (format "fib(%d) = %d calls = %d" n calls a))
     (recur n b (+ a b) (inc calls) (inc index)))))

(defn main []
  (def n (read))
  (def valores (repeatedly n read))
  (doall (map fibonacci valores)))

(main) 

; Quase 2
(defn fibonacci
  ([n]
   (fibonacci n 0 1 1 0 0))
  ([n a b calls sum index]
   (if (= index n)
     (println (format "fib(%d) = %d calls = %d" n sum calls))
     (recur n b (+ a b) (inc calls) (+ sum a) (inc index)))))

(defn main []
  (def n (read))
  (def valores (repeatedly n read))
  (doall (map fibonacci valores)))

(main)

; Gambiarra
(defn fibonacci
  ([n]
   (fibonacci n 0 1 1 0 0))
  ([n a b calls sum index]
   (if (= index n)
     (println (format "fib(%d) = %d calls = %d" n sum a))
     (recur n b (+ a b) (inc calls) (+ sum (* 2 a)) (inc index)))))

(defn main []
  (def n (read))
  (def valores (repeatedly n read))
  (doall (map fibonacci valores)))

(main)
; 1030 - A Lenda de Flavious Josephus
(defn josephus
  ([lista]
   (def n (first lista))
   (def k (second lista))
   (josephus n k))

  ([n k]
   (loop [people (range 1 (inc n))
          index 0]
     (if (= 1 (count people))
       (first people)
       (let [index (mod (+ index (dec k)) (count people))]
         (recur (concat (subvec (vec people) 0 index) (subvec (vec people) (inc index))) index))))))

(defn main []
  (let [n (read)
        valores (repeatedly n #(doall (repeatedly 2 read)))
        resultados (map josephus valores)]
    (doseq [[i resultado] (map-indexed vector resultados)]
      (println (format "Case %d: %d" (inc i) resultado)))))

(main)
; Abordagem mais rápida
(defn josephus [n k]
  (loop [i 1
         res 0]
    (if (> i n)
      (inc res)
      (recur (inc i) (mod (+ res k) i)))))

(defn main []
  (let [t (read)
        casos (repeatedly t #(doall (repeatedly 2 read)))]
    (dorun
     (map-indexed
      (fn [i [n k]]
        (println (format "Case %d: %d" (inc i) (josephus n k))))
      casos))))
(main)

; Minha tentativa
(defn josephus
  ([lista]
   (def n (first lista))
    (def k (second lista))
    (josephus n k)))
  
  ([n k]
   (println "Entrou aqui")
   )

(defn main []
  (def n (read))
  (def valores (repeatedly n #(doall (repeatedly 2 read))))
  (doall (map josephus valores)))

(main)