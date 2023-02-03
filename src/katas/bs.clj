(ns katas.bs)

;; Write a function that takes a sequential data structure of integers and returns them in order
;; do not use built in sort function!

;; Tommy solution

(defn take-smallest-out
  "this function helps reduce the size of our initial-coll later"
  [smallest-int initial-coll]
  (remove #(= % smallest-int) initial-coll))



(take-smallest-out 1 [1 1 2 3 4])

(defn find-min-sort
  [sorted-coll initial-coll]
  (println sorted-coll)
  (if (empty? initial-coll) 
    sorted-coll
    (let [smallest-int (apply min initial-coll)]
      (find-min-sort (conj sorted-coll smallest-int) 
                     (take-smallest-out smallest-int initial-coll)))))



(remove-first)
(comment
  ;
  (def data1 [ 0 12 2 3 0 0 0 1 2 3 ] )

  ;; call your final function here on data1 to ensure it works 
  (find-min-sort [] data1)
  )
