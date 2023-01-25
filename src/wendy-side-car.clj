(ns wendy-side-car)

(defn compare-and-swap
"Takes two integers and returns the ints in order. Returns a hashmap with a data key whose value is a vector with the two processed ints and a swapped? key whose value indicates if the ints have been swapped or not"
  [foo bar]
  (if (< foo bar)
    {:data [foo bar] :swapped? false}
    {:data [bar foo] :swapped? true}))

(defn bubble-cycle
"Takes a collection, loops compare-and-swap over it, returns a hashmap containing two things: 1) a vector whose pairs have been compared and swapped until theres nothing left to compare, and 2) the number of times pairs have been swapped."
  [coll]
  (loop [result []
         [first-int next-int & the-rest] coll
         swap-count 0]
    (let [{:keys [data swapped?]} (compare-and-swap first-int next-int)
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
"Takes a collection, loops bubble-cycle over it, returns a sorted collection."
  [coll]
  (loop [{:keys [result swapped]} (bubble-cycle coll)]
    (if (> swapped 0)
      (recur (bubble-cycle result))
      result)))

(bubble-sort '[5 3 4 2 1])
;; => [1 2 3 4 5]
