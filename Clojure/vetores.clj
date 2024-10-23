; 1º Maneira
(vector 1 2 3 4 5)

; 2º Maneira
[1 2 3 4 5]

; Em funções
(def numeros-vetorizados [1 2 3 4 5])

; Criando funções com Vetor e buscando elementos
(def playlist-musica ["Ela partiu" "Nao reclamo" "O vento"])
(println (get playlist-musica 0)) ; Retorna: "Ela partiu"
(println (last playlist-musica)) ; Retorna o ultimo elemntos
(println (conj playlist-musica "Na moral"))
(println playlist-musica)


