; Criando um Map (Composto por uma chave e um valor, as Keywords)
(hash-map :valor, 200 :tipo "receita")
; Ou assim
(def transacao {:valor 200, :tipo "receita"})
; Adicionando um par de chave-valor 
(assoc transacao :categoria "Educacao")
; Buscando valor
(get transacao :valor)
; Ou assim
(:valor transacao)

; Exemplo
(def transacao-desnecessaria {:valor 34
                              :tipo "despesa"
                              :rotulos '("desnecessaria"
                                         "cartao")})
(:rotulos transacao-desnecessaria)
;; ("desnecessária" "cartão")
(:rotulos transacao)
;; nil

; Aplicação
(defn resumo [transacao]
  (select-keys transacao [:valor :tipo :data]))

(def transacoes
  [{:valor 33.0 :tipo "despesa"
    :comentario "Almoço" :data "19/11/2016"}
   {:valor 2700.0 :tipo "receita"
    :comentario "Bico" :data "01/12/2016"}
   {:valor 29.0 :tipo "despesa"
    :comentario "Livro de Clojure" :data "03/12/2016"}])

(map resumo transacoes)

; APLICAÇÃO DO FILTER
(defn despesa [transacao]
  (= (:tipo transacao) "despesa"))

(filter despesa transacoes)

; APLICAÇÃO DO REDUCE
(defn so-valor [transacao]
  (:valor transacao))

(reduce + (map so-valor (filter despesa transacoes)))

; Agora utilizando uma funcao anonima
(reduce + (map #(:valor %)
               (filter #(= (:tipo %) "despesa")
                       transacoes)))
