(ns tommy-side-car)

;; probably not the most performant with a big collection ... 

(defn take-smallest-out
  "this function helps reduce the size of our initial-coll later"
  [smallest-int initial-coll]
  (remove #(= % smallest-int) initial-coll))

(defn find-min-sort
  [sorted-coll initial-coll]
  (println sorted-coll)
  (if (empty? initial-coll) 
    sorted-coll
    (let [smallest-int (apply min initial-coll)]
      (find-min-sort (conj sorted-coll smallest-int) 
                     (take-smallest-out smallest-int initial-coll)))))



(comment
  ;
  (def seq-data1 [1 2 3 4 5])
  (find-min-sort [] seq-data1)
  
  (def seq-data2 [2 4 3 1 5])
  (find-min-sort [] seq-data2)
  
  (def seq-data3 [2 1])
  (find-min-sort [] seq-data3)
  
  (def seq-data4 [2 3 4 5 1 6 9 8 7])
  (find-min-sort [] seq-data4)
  ;
  )