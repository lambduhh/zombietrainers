(ns zombietrainers.arg-extract1)

(defn arg-extract
  "Write a function takes a vector as an argument, `arg`
   extracts every other value and places it into a new vector. "
  [arg]
  (->> arg       ;; "->>" is the thread-last macro
       (cons 0)
       (take-nth 2)
       rest
       vec))

(comment
  ;
  (def arg1 ["random" "blue" false true "fifth" 6])

  (def return1 ["blue" true 6])
  
  (arg-extract arg1)
;
)
