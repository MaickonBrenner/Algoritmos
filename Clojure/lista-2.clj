; 1035 - Teste de Seleção 1
(def A (read))
(def B (read))
(def C (read))
(def D (read))

(if (and (> B C) (> D A) (> (+ C D) (+ A B)) (> C 0) (> D 0) (even? A))
  (println "Valores aceitos")
  (println "Valores nao aceitos"))

; 1036 - Fórmula de Bhaskara
(def A (read))
(def B (read))
(def C (read))
(def delta (- (* B B) (* 4 A C)))

(if (and (not= A 0.0) (>= delta 0.0))
  (let [sqrt-delta (Math/sqrt delta)
        denom (* 2 A)
        R1 (/ (+ (- B) sqrt-delta) denom)
        R2 (/ (- (- B) sqrt-delta) denom)]
    (println (format "R1 = %.5f" R1))
    (println (format "R2 = %.5f" R2)))
  (println "Impossivel calcular"))

; 1037 - Intervalo
(def numero (read))
(cond
  (<= 0 numero 25) (println "Intervalo [0,25]")
  (<= 25 numero 50) (println "Intervalo (25,50]")
  (<= 50 numero 75) (println "Intervalo (50,75]")
  (<= 75 numero 100) (println "Intervalo (75,100]")
  :else (println "Fora de intervalo"))

; 1038 - Lanche
(def codigo (read))
(def quantidade (read))

(let [total (case codigo
              1 (* quantidade 4.00)
              2 (* quantidade 4.50)
              3 (* quantidade 5.00)
              4 (* quantidade 2.00)
              5 (* quantidade 1.50))]
  (println (format "Total: R$ %.2f" total)))

; 1040 - Média 3
(def A (read))
(def B (read))
(def C (read))
(def D (read))

(def media (float (/ (+ (* A 2) (* B 3) (* C 4) (* D 1)) 10)))
(println (format "Media: %.1f" media))

(if (>= media 7.0)
  (println "Aluno aprovado.")
  (if (< media 5.0)
    (println "Aluno reprovado.")
    (do
      (println "Aluno em exame.")
      (let [exame (read)]
        (println (str "Nota do exame: " (format "%.1f" exame)))
        (let [media (/ (+ media exame) 2)]
          (if (>= media 5.0)
            (println "Aluno aprovado.")
            (println "Aluno reprovado."))
          (println (str "Media final: " (format "%.1f" media))))))))

; 1041 - Coordenadas de um Ponto
(def X (read))
(def Y (read))

(defn pontos [X, Y]
  (cond
    (> X 0.0) (cond
                (> Y 0.0) (println "Q1")
                (< Y 0.0) (println "Q4")
                :else (println "Eixo X"))
    (< X 0.0) (cond
                (> Y 0.0) (println "Q2")
                (< Y 0.0) (println "Q3")
                :else (println "Eixo X"))
    :else (cond
            (> Y 0.0) (println "Eixo Y")
            (< Y 0.0) (println "Eixo Y")
            :else (println "Origem"))))

(pontos X, Y)

; 1043 - Triângulo
(def A (read))
(def B (read))
(def C (read))

(defn pontos [A B C]
  (cond
    (and (< A (+ B C)) (< B (+ A C)) (< C (+ A B))) (println (str "Perimetro = " (+ A B C)))
    :else (println (format "Area = %.1f" (* (/ (+ A B) 2.0) C)))))

(pontos A B C)

; 1044 - Múltiplos
(def A (read))
(def B (read))

(cond
  (or (= 0 (mod A B)) (= 0 (mod B A))) (println "Sao Multiplos")
  :else (println "Nao sao Multiplos"))

; 1045 - Tipos de Triângulos
(def A (read))
(def B (read))
(def C (read))

(def valores (list A B C))
(def ordenada (sort valores))
(def maior (nth ordenada 2)) ;A
(def medio (nth ordenada 1)) ;B
(def menor (nth ordenada 0)) ;C

(cond
  (>= maior (+ medio menor)) (println "NAO FORMA TRIANGULO")
  :else (do
          (cond
            (= (* maior maior) (+ (* medio medio) (* menor menor))) (println "TRIANGULO RETANGULO")
            (> (* maior maior) (+ (* medio medio) (* menor menor))) (println "TRIANGULO OBTUSANGULO")
            :else (println "TRIANGULO ACUTANGULO"))
          (cond
            (and (= maior medio) (= medio menor)) (println "TRIANGULO EQUILATERO")
            (or (= maior medio) (= maior menor) (= medio menor)) (println "TRIANGULO ISOSCELES"))))

; 1046 - Tempo de Jogo
(def A (read))
(def B (read))

(cond
  (> A B) (println (str "O JOGO DUROU " (- 24 (- A B)) " HORA(S)"))
  (> B A) (println (str "O JOGO DUROU " (- B A) " HORA(S)"))
  :else (println "O JOGO DUROU 24 HORA(S)"))

; 1047 - Tempo de Jogo com Minutos
(def hi (read))
(def mi (read))
(def hf (read))
(def mf (read))

(let [mi-total (+ mi (* hi 60))
      mf-total (+ mf (* hf 60))
      tempo (- mf-total mi-total)
      tempo (if (<= tempo 0) (+ tempo (* 24 60)) tempo)
      h (quot tempo 60)
      m (mod tempo 60)]
  (println (str "O JOGO DUROU " h " HORA(S) E " m " MINUTO(S)")))

; 1048 - Aumento de Salário
(def salario (read))

(let [reajuste (cond
                 (<= 0 salario 400) (* salario 0.15)
                 (<= 400 salario 800) (* salario 0.12)
                 (<= 800 salario 1200) (* salario 0.10)
                 (<= 1200 salario 2000) (* salario 0.07)
                 :else (* salario 0.04))
      novo-salario (+ salario reajuste)
      percent (cond
                (<= 0 salario 400) 15
                (<= 400 salario 800) 12
                (<= 800 salario 1200) 10
                (<= 1200 salario 2000) 7
                :else 4)]
  (println (str "Novo salario: " (format "%.2f" novo-salario)))
  (println (str "Reajuste ganho: " (format "%.2f" reajuste)))
  (println (str "Em percentual: " percent " %")))

; 1049 - Animal
(def estrut (read-line))
(def classe (read-line))
(def aliment (read-line))

(cond
  (= estrut "vertebrado")
  (cond
    (= classe "ave")
    (if (= aliment "carnivoro")
      (println "aguia")
      (println "pomba"))

    (= classe "mamifero")
    (if (= aliment "onivoro")
      (println "homem")
      (println "vaca")))
  (= estrut "invertebrado")
  (cond
    (= classe "inseto")
    (if (= aliment "hematofago")
      (println "pulga")
      (println "lagarta"))

    (= classe "anelideo")
    (if (= aliment "hematofago")
      (println "sanguessuga")
      (println "minhoca"))))

; 1050 - DDD
(def DDD (read))

(case DDD
  61 (println "Brasilia")
  71 (println "Salvador")
  11 (println "Sao Paulo")
  21 (println "Rio de Janeiro")
  32 (println "Juiz de Fora")
  19 (println "Campinas")
  27 (println "Vitoria")
  31 (println "Belo Horizonte")
  (println "DDD nao cadastrado"))

; 1052 - Mês
(def numero (read))

(let [mes (case numero
            1 (println "January")
            2 (println "February")
            3 (println "March")
            4 (println "April")
            5 (println "May")
            6 (println "June")
            7 (println "July")
            8 (println "August")
            9 (println "September")
            10 (println "October")
            11 (println "November")
            12 (println "December"))])

; 