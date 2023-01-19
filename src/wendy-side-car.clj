(ns wendy-side-car)

(defn cas
"cas stands for compare and swap. cas takes two ints and compares them and (maybe) swaps them. If foo is less than bar, return foo then bar. If foo is not less than bar, swap those positions, returning bar then foo."
  [foo bar]
  (if (< foo bar)
    [foo bar]
    [bar foo]))
;; => #'wendy-side-car/cas

(cas 4 1)
;; => [1 4]

; Let's destructure so we can get x and y.

(let [[x y] (cas 73 6)
       new-coll []]
  (conj new-coll x)) ;; => [6]

; Let's get the rest of a collection that contains 3 or more ints.

(let [orig-coll [5 4 3 2 1]
      _ (prn orig-coll)
      [poop scat & the-rest] orig-coll
      _ (prn the-rest)
      [x y] (cas poop scat)
      _ (prn x y)
      new-coll (conj [] x)]
      _ (prn new-coll)
  (if (empty? the-rest)
    (doto {:working [] :so-far (conj y new-coll)}
      prn) 
    (doto {:working (cons y the-rest) :so-far new-coll}
      prn))) 

;; => {:working (5 3 2 1), :so-far [4]}
; repl:
; [5 4 3 2 1]
; (3 2 1)
; 4 5
; [4]
; {:working (5 3 2 1), :so-far [4]}

; What do we get when the if is true?

(let [orig-coll [5 4]
      _ (prn orig-coll)
      [poop scat & the-rest] orig-coll
      _ (prn the-rest)
      [x y] (cas poop scat)
      _ (prn x y)
      new-coll (conj [] x)]
      _ (prn new-coll)
  (if (empty? the-rest) ;; should eval to true so i can see the true clause result
    (doto {:working [] :so-far (conj new-coll y)}
      prn) 
    (doto {:working (cons y the-rest) :so-far new-coll}
      prn)))
;; => {:working [], :so-far [4 5]}
; repl:
; [5 4]
; nil
; 4 5
; [4]
; {:working [], :so-far [4 5]}

; Let's use loop with a collection.

(let [initial [] ;; 
      coll '(3 5 12 10 21 15)] 

  (loop [result initial
         remaining coll]
         
    (if (empty? remaining) 
    
      result
      
      (recur (let [gotcha (first remaining) ; pick up my block
                   new-coll (if (not= 0 (mod gotcha 5)) ; if my first block is NOT divis by 5
                              (conj result gotcha) ; add my block to my arms (my result, my building)
                              result)] ; (if my block IS divis by 5), keep what i have in my arms.
              new-coll)

             (rest remaining)))))

;; => [3 12 21]

; 1/18/23 OK, lets solve some crap. Write it new:

; what do i have? a collection of ints

; what's the first thing i want? the first int, second int, and rest of coll

(let [coll '[5 3 4 2 1]
      [first-int next-int & the-rest] coll]
  the-rest)
;; => (4 2 1)

; what do i have? first-int, next-int, and the rest of a coll

; now what do i want? result of which int is smaller / bigger

(let [coll '[5 3 4 2 1]
      [first-int next-int & the-rest] coll]
  (cas first-int next-int))
;; => [3 5]

; what do i have? result of which int is smaller / bigger

; now what do I want? a result bucket 

(let [coll '[5 3 4 2 1]
      [first-int next-int & the-rest] coll
      result []] 
  (cas first-int next-int))
;; => [3 5]

; what do I have? my result bucket & the result of cas

; now what do i need? the smallest item we found earlier

(let [coll '[5 3 4 2 1]
      [first-int next-int & the-rest] coll
      result []]
  (let [[x y] (cas first-int next-int)]
    x))
;; => 3 

; what do I have? the smallest item we found earlier

; now what do I need? my result bucket with the smallest item in it

(let [coll '[5 3 4 2 1]
      [first-int next-int & the-rest] coll
      result []]
  (let [[x y] (cas first-int next-int)
        new-coll (conj [] x)]
    new-coll))
;; => [3]

; now what do I need? a collection with y at the front and the rest in the back...
