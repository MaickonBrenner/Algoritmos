; Fatorial com Recursão
(defn fatorial [n]
  (if (or (= n 0) (= n 1))
    1 
    (* n (fatorial (dec n)))))

; Fatorial com Recursão e Sobrecarga de Aridade
(defn fatorialRecur
  ; Caso ele recebe apenas um parâmetro
  ([n]
   (fatorialRecur n 1))
  ; Para dois parâmetros
  ([n p]
   (if (or (= n 0) (= n 1))
     p
     (recur (dec n) (bigint (* n p))))))

; Soma de uma Lista
(defn soma-lista [lista]
  (if (empty? lista)
    0
    (+ (first lista) (soma-lista (rest lista)))))

; Fibonacci
(defn fibonacci [n]
  (cond 
    (= n 0) 0
    (= n 1) 1
    :else (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

; Ordem Simples
(defn ordem [X Y]
  (if (> X Y)
    (println "Descrescente")
    (println "Crescente")))

(def X (read))
(def Y (read))

(ordem X Y)