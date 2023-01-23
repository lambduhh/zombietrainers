(ns wendy-side-car)

(defn cas
  [foo bar]
  (if (< foo bar)
    {:data [foo bar] :swapped? false}
    {:data [bar foo] :swapped? true}))

(defn bubble-cycle 
  [coll]
  (loop [result []
         [first-int next-int & the-rest] coll
         swap-count 0]

    (let [{:keys [data swapped?]} (cas first-int next-int)
          [x y] data
          swap-test (if swapped? 
                      (inc swap-count)
                      swap-count)]
      
      (if (seq the-rest)

        (recur (conj result x)
               (cons y the-rest)
               swap-test )
        
        {:result (conj result x y)
         :swapped swap-test}))))

(defn bubble-sort
  [coll]
  (loop [{:keys [result swapped]} (bubble-cycle coll)]
    (if (> swapped 0)
      (recur (bubble-cycle result))
      result)))

(bubble-sort '[5 3 4 2 1])
;; => [1 2 3 4 5]

