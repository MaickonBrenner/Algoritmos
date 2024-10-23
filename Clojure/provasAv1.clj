; AV1
; 1144 - Sequência Lógica
(def n (read))

(defn formata [x]
  (format "%d %.0f %.0f\n%d %.0f %.0f\n"
          x
          (Math/pow x 2)
          (Math/pow x 3)
          x
          (inc (Math/pow x 2))
          (inc (Math/pow x 3))))

(dorun (map print (map formata (range 1 (inc n)))))

; 1164 - Número Perfeito
(defn divisivel? [a b]
  (zero? (mod a b)))

(defn perfeito? [n]
  (= n (reduce + (filter (fn [x] (divisivel? n x)) (range 1 n)))))

(defn formata [n]
  (if (perfeito? n)
    (format "%d eh perfeito" n)
    (format "%d nao eh perfeito" n)))

(def n (read))

(dorun (map println (map formata (repeatedly n read))))