(ns fatcat.mockdata)

; Pet Food Calculator
; improvements: 
; - provide several units of weight: kg, g, lb, oz so more flexible
; - gives result of how many bags of food need to purchase in a given time period (ex. how many bags per month)

(def toffee-cat {:weight-kgs 4.1})

(def liveclear-turkey-small
  {:bag-lbs	           3.2
   :bag-grams              1451.5
   :bag-kg                 1.4515
   :grams-per-kg-of-pet    12.5})

(defn days-per-bag
"Takes weight of animal (int), weight of bag (int), and amount of food per kg of animal. Returns number of daily servings per food bag."
  [{:keys [weight-kgs]}
   {:keys [bag-grams grams-per-kg-of-cat]}]
  (/ bag-grams (* weight-kgs grams-per-kg-of-pet)))

(days-per-bag toffee-cat liveclear-turkey-small) ;; => 28.3219512195122


(def new-cat {:weight 
              {:unit 
               {:kg 4.1 :lb 9}
               }})
;; => #'fatcat.mockdata/new-cat

; data to design:

; food remaining / last delivery date

; rewrite bag data to mirrow new-cat


; fn to design:

; fn that returns how much food to feed cat each day (servings per day)

; is low?

; fn that returns daily servings per bag (can modify existing)

; conversion from lb to g ?

; conversion from g to lb ?
