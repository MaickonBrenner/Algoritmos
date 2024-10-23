; Lista 
(def um-ate-5 (list 1 2 3 4 5))
(println (count um-ate-5))

; Ou dessa forma, com o apostrofo antes do parêntese
(def um-ate-6 '(1 2 3 4 5 6))
(println (count um-ate-6))

; Nesse exemplo, temos o "range", que é uma estrutura de repetição
(def um-ate-15 (range 1 16))
(println um-ate-15)

(def cantor (list "Sideral" "Flausino" "Landau"))
(println (nth cantor 1))
(println (last cantor))
(println (first cantor))
(println (conj cantor "Barrone"))