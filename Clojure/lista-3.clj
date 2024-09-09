; 1059 - Números Pares
(dorun (map println (range 2 101 2)))

; 1067 - Números Ímpares
(def n (read))
(dorun (map println (filter odd? (range 1 (+ 1 n)))))

; 1070 - Seis Números Ímpares
(def n (read))
(dorun (map println (filter odd? (range n (+ n 12)))))

; 1073 - Quadrados de Pares
(def n (read))
(dorun (map #(println (format "%d^2 = %d" % (* % %))) (range 2 (+ n 1) 2)))

; 1074 - Par ou Ímpar
(def n (Integer/parseInt (read-line)))
(def valores (repeatedly n #(Integer/parseInt (read-line))))

(defn classificar [x]
  (cond
    (= x 0) "NULL"
    (and (even? x) (> x 0)) "EVEN POSITIVE"
    (and (even? x) (< x 0)) "EVEN NEGATIVE"
    (and (odd? x) (> x 0)) "ODD POSITIVE"
    (and (odd? x) (< x 0)) "ODD NEGATIVE"))

(dorun (map #(println (classificar %)) valores))
; (dorun (map (fn [x] (println (classificar x))) valores))

; 1075 - Resto 2
(def n (Integer/parseInt (read-line)))

(defn divisivel [numero]
  (= 2 (mod numero n)))

(dorun (map println (filter #(divisivel %) (range 10000))))

; 1078 - Tabuada
(def n (Integer/parseInt (read-line)))
(dorun (map #(println (format "%d x %d = %d" % n (* % n))) (range 1 11)))

; 1079 - Médias Ponderadas
(def n (Integer/parseInt (read-line)))

(def valores
  (flatten
   (repeatedly n
               (fn [] (map #(Float/parseFloat %) (clojure.string/split (read-line) #" "))))))

(defn media [valores]
  (/ (+ (* 2 (nth valores 0)) (* 3 (nth valores 1)) (* 5 (nth valores 2))) 10))

(dorun (map #(println (format "%.1f" (media %))) (partition 3 valores)))
; EXPLICAÇÃO:
; repeatedly n (fn [] ...): Executa a função anônima n vezes.
; read-line: Lê uma linha de entrada do usuário.
; clojure.string/split (read-line) #" ": Divide a linha lida em uma lista de strings, usando o espaço como delimitador.
; map #(Float/parseFloat %) ...: Converte cada string da lista em um número Float.
; flatten: Achata a lista de listas resultante em uma única lista de valores.
; =================================================================================

; 1116 - Dividindo X por Y
(def n (Integer/parseInt (read-line)))

(def valores
  (flatten
   (repeatedly n
               (fn [] (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))))

(defn divisao [valores]
  (if (zero? (nth valores 1))
    "divisao impossivel"
    (/ (nth valores 0) (nth valores 1))))

(dorun (map #(println (if (string? (divisao %))
                        (divisao %)
                        (format "%.1f" (double (divisao %)))))
            (partition 2 valores)))

; 1133 - Resto da Divisão
(def x (Integer/parseInt (read-line)))
(def y (Integer/parseInt (read-line)))

(def maior (max x y))
(def menor (min x y))

(defn resto [n]
  (or (= 2 (mod n 5)) (= 3 (mod n 5))))

(dorun (map println (filter #(resto %) (range (inc menor) maior))))
; 1 - (inc menor) no range para garantir que o valor menor não seja incluído no intervalo, conforme o enunciado da questão.
; 2 - O intervalo range vai até maior, mas não o inclui, então não é necessário incrementar maior.

; 1142 - PUM
(def n (Integer/parseInt (read-line)))

(dorun (map #(println (str % " " (+ % 1) " " (+ % 2) " PUM")) (range 1 (inc (* n 4)) 4)))