(ns katas.bs)

;; Write me a function that takes a sequential data structure of integers and returns them in order
;; do not use built in sort function!

(defn foo
  "a function that takes a sequential data structure of integers and returns them in order"
  [coll]
  )
 
(defn helper [seq-data]
  (let [[foo bar] seq-data]
    (if (< foo bar)
      (vec '(foo bar))
      [bar foo])))

(comment
  ;
  (helper seq-data2)
  (let [[x y z] my-vector]
    (println x y z))
   ;= 1 2 3
  
  (def seq-data1 [5 3 4 2 1])
  (def result1 [1 2 3 4 5])
  
  (def seq-data2 [2 1])
  (def result2 [1 2])
  
  (def seq-data3 [3 1 2]) 
  
  (first (rest seq-data2))
  
  ;
  )