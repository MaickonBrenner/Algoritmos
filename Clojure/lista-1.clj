; 1000 - Inicio
(println "Hello, World!")

; 1001 - Extremamente Básico
(def A (read))
(def B (read))
(println "X =" (+ A B))

; 1002 - Área do Círculo
(def raio (read))
(println (format "A=%.4f" (* 3.14159 (* raio raio))))

; 1003 - Soma Simples
(def A (read))
(def B (read))
(println "SOMA =" (+ A B))

; 1004 - Produto Simples
(def A (read))
(def B (read))
(def PROD (* A B))
(println "PROD =" PROD)

; 1005 - Média 1
(def A (read))
(def B (read))
(println (format "MEDIA = %.5f" (/ (+ (* A 3.5) (* B 7.5)) (+ 3.5 7.5))))

; 1006 - Média 2
(def A (read))
(def B (read))
(def C (read))
(println (format "MEDIA = %.1f" (/ (+ (* A 2) (* B 3) (* C 5)) (+ 2 3 5))))

; 1007 - Diferença
(def A (read))
(def B (read))
(def C (read))
(def D (read))
(println "DIFERENCA =" (- (* A B) (* C D)))

; 1008 - Salário
(def numero (read))
(def horas (read))
(def valor_hora (read))
(println "NUMBER =" numero)
(println (format "SALARY = U$ %.2f" (* horas valor_hora)))

; 1009 - Salário com Bônus
(def nome (read))
(def salario (read))
(def total_vendas (read))
(println (format "TOTAL = R$ %.2f" (+ salario (* 0.15 total_vendas))))

; 1011 - Esfera
(def raio (read))
(println (format "VOLUME = %.3f" (* (/ 4.0 3.0) 3.14159 (* raio raio raio))))

; 1014 - Consumo
(def X (read))
(def Y (read))
(println (format "%.3f km/l" (/ X Y)))

; 1016 - Distância
(def distancia (read))
(println (/ (* 60 distancia) 30) "minutos")

; 1017 - Gasto de Combustível
(def tempo (read))
(def velocidade (read))
(println (format "%.3f" (float (/ (* tempo velocidade) 12))))

; 1019 - Conversão de Tempo
(def N (read))
(def horas (quot N 3600))
(def segundos-restantes (mod N 3600))
(def minutos (quot segundos-restantes 60))
(def segundos-finais (mod segundos-restantes 60))
(println (format "%d:%d:%d" horas minutos segundos-finais))

; 1020 - Idade em Dias
(def dias (read))
(def anos (quot dias 365))
(def dias-restantes (mod dias 365))
(def meses (quot dias-restantes 30))
(def dias-finais (mod dias-restantes 30))
(println (format "%d ano(s)" anos))
(println (format "%d mes(es)" meses))
(println (format "%d dia(s)" dias-finais))