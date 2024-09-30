; 1060 - Número Positivos
(defn val-pos [lista]
  (count (filter pos? lista)))

(defn main []
  (def valores (repeatedly 6 read))
  (println (format "%d valores positivos" (val-pos valores))))

(main)

; Outra maneira
(def valores (repeatedly 6 read))
(println (format "%d valores positivos" (count (filter pos? valores))))

; 1064 - Positivos e Média

(defn val-pos [lista]
  (count (filter pos? lista)))

(defn val-media [lista]
  (/ (reduce + (filter pos? lista)) (count (filter pos? lista))))

(defn main []
  (def valores (repeatedly 6 read))
  (println (format "%d valores positivos" (val-pos valores)))
  (println (format "%.1f" (val-media valores))))

(main)

; Outra maneira
(def valores (repeatedly 6 read))
(println (format "%d valores positivos" (count (filter pos? valores))))
(println (format "%.1f" (/ (reduce + (filter pos? valores)) (count (filter pos? valores)))))

; 1065 - Pares entre Cinco Números
(defn val-par [lista]
  (count (filter even? lista)))

(defn main []
  (def valores (repeatedly 5 read))
  (println (format "%d valores pares" (val-par valores))))

(main)

; Outra maneira
(def valores (repeatedly 5 read))
(println (format "%d valores pares" (count (filter even? valores))))

; 1066 - Pares, Ímpares Positivos e Negativos
(defn val-par [lista]
  (count (filter even? lista)))

(defn val-impar [lista]
  (count (filter odd? lista)))

(defn val-pos [lista]
  (count (filter pos? lista)))

(defn val-neg [lista]
  (count (filter neg? lista)))

(defn main []
  (def valores (repeatedly 5 read))
  (println (format "%d valor(es) par(es)" (val-par valores)))
  (println (format "%d valor(es) impar(es)" (val-impar valores)))
  (println (format "%d valor(es) positivo(s)" (val-pos valores)))
  (println (format "%d valor(es) negativo(s)" (val-neg valores))))

(main)

; Outra maneira
(def valores (repeatedly 5 read))
(println (format "%d valor(es) par(es)" (count (filter even? valores))))
(println (format "%d valor(es) impar(es)" (count (filter odd? valores))))
(println (format "%d valor(es) positivo(s)" (count (filter pos? valores))))
(println (format "%d valor(es) negativo(s)" (count (filter neg? valores))))

; 1071 - Soma de Impares Consecutivos I
(defn somar [x, y]
  (if (> x y)
    (reduce + (filter odd? (range (inc y) x)))
    (reduce + (filter odd? (range (inc x) y)))))

(defn main []
  (def x (read))
  (def y (read))
  (println (somar x y)))

(main)

; Outra maneira
(def x (read)) ; Maior
(def y (read)) ; Menor

(if (> x y)
  (println (reduce + (filter odd? (range (inc y) x))))
  (println (reduce + (filter odd? (range (inc x) y)))))

; 1072 - Intervalo 2
(defn verifica [x]
  (and (>= x 10) (<= x 20)))

(defn dentro? [lista]
  (count (filter verifica lista)))

(defn fora? [lista]
  (count (remove verifica lista)))

(defn main []
  (def n (read))
  (def valores (repeatedly n read))
  (println (format "%d in" (dentro? valores)))
  (println (format "%d out" (fora? valores))))

(main)

; 1080 - Maior e Posição
(defn main []
  (def valores (repeatedly 100 read))
  (println (apply max valores))
  (println (inc (.indexOf valores (apply max valores)))))

(main)

; Outra maneira
(defn procurarValor [lista]
  (reduce (fn [[maior-valor indice-maior] [indice valor]]
            (if (> valor maior-valor)
              [valor indice]
              [maior-valor indice-maior]))
          [(first lista) 0]
          (map-indexed vector lista)))

(defn main []
  (let [valores (repeatedly 100 read)
        [maior-valor indice-maior] (procurarValor valores)]
    (println maior-valor) ; Maior valor
    (println (inc indice-maior)))) ; Posição

(main)

; 1094 - Experiências
(defn checkTotal [lista]
  (reduce + (map (fn [x] (first x)) lista)))

(defn coelhoTotal [lista]
  (reduce + (map (fn [x] (if (= (second x) "C") (first x) 0)) lista)))

(defn ratoTotal [lista]
  (reduce + (map (fn [x] (if (= (second x) "R") (first x) 0)) lista)))

(defn sapoTotal [lista]
  (reduce + (map (fn [x] (if (= (second x) "S") (first x) 0)) lista)))

(defn main []
  (let [n (Integer/parseInt (read-line))
        valores (repeatedly n #(let [num-tipo (clojure.string/split (read-line) #" ")]
                                 [(Integer/parseInt (first num-tipo)) (second num-tipo)]))]
    (println (format "Total: %d cobaias" (checkTotal valores)))
    (println (format "Total de coelhos: %d" (coelhoTotal valores)))
    (println (format "Total de ratos: %d" (ratoTotal valores)))
    (println (format "Total de sapos: %d" (sapoTotal valores)))
    (println (format "Percentual de coelhos: %.2f" (double (/ (* (coelhoTotal valores) 100) (checkTotal valores)))) "%")
    (println (format "Percentual de ratos: %.2f" (double (/ (* (ratoTotal valores) 100) (checkTotal valores)))) "%")
    (println (format "Percentual de sapos: %.2f" (double (/ (* (sapoTotal valores) 100) (checkTotal valores)))) "%")))

(main)

; 1153 - Fatorial Simples
(defn fatorial [n]
  (reduce * (range 1 (inc n))))

(defn main []
  (def valor (read))
  (println (fatorial valor)))

(main)

; 1155 - Sequência S
(defn sequencia []
  (println (format "%.2f" (double (reduce + (map (fn [y] (/ 1 y)) (range 1 (inc 100))))))))

(sequencia)

; 1156 - Sequência S II
(defn sequencia []
  (println (format "%.2f" (double (reduce + (map (fn [x, y] (/ x y)) (range 1 (inc 39) 2) (take 100 (iterate #(* 2 %) 1))))))))

(sequencia)

; Outra maneira
(defn sequencia []
  (println (format "%.2f" (double (reduce + (map (fn [x, y] (/ x y)) (range 1 (inc 39) 2) (map #(Math/pow 2 %) (range 100))))))))

(sequencia)

; 1165 - Número Primo
(defn primo? [n]
  (cond
    (< n 2) false
    (= n 2) true
    (even? n) false
    :else (not-any? #(zero? (rem n %)) (range 3 (inc (Math/sqrt n)) 2))))

(defn main []
  (def n (read))
  (def valores (repeatedly n read))
  (doseq [v valores]
    (let [verificar (primo? v)]
      (println (format "%d %s" v (if verificar "eh primo" "nao eh primo"))))))

(main)