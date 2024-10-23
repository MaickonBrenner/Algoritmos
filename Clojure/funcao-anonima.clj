(fn [nome]
  (str "Olá, " nome "!"))

(filter #(> (:valor %) 100))
; O % significa que as função anonima irá receber algum argumento

