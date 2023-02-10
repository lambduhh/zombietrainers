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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def new-cat 
  {:weight {:unit {:kg 4.1 :lb 9}}})

(def liveclear-turkey
 {:weight {:unit {:kg 1.4515 :lb 3.2 :g 1451.5}}
 ; :food-remaining {:unit {:kg (* x :lb) :g (* x :lb)}} ; does this idea belong here?
 ; :last-delivered x                                ; does this idea belong here?
 ; :is-low?                                        ; does this belong here?
  :grams-per-kg-of-cat 12.5})

(defn daily-serving
"Takes weight of cat in kg and multiplies it by how many grams of food per kg of cat. Returns how much food to serve cat each day."
  [{:keys [weight]}
   {:keys [grams-per-kg-of-cat]}]
  (* kg grams-per-kg-of-cat))

{{:keys [kg]} {{:keys [unit]}} :weight}
{{:keys [kg]} :unit}

;; ex: {{:keys [width height]} :resolution}
;; see "associative destructuring"

(daily-serving new-cat liveclear-turkey)

;;;;;;;; data to design:

; MAYBE food remaining and/or last delivery date

; maybe make each value for the weight key be a fn for conversion

;;;;;;; fn to design:

; working on it: fn that returns how much food to feed cat each day (servings per day)

; is low?

; fn that returns daily servings per bag (can modify existing)

; lb to g ?

; g to lb ?

