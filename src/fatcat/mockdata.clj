(ns fatcat.mockdata)

; Pet Food Calculator
; improvements: 
; - gives result of how many bags of food need to purchase in a given time period (ex. how many bags per month)

(def new-cat 
  {:weight {:unit {:kg 4.1 :lb 9}}})

(def liveclear-turkey
 {:weight {:unit {:kg 1.4515 :lb 3.2 :g 1451.5}}
 ; :food-remaining {:unit {:kg (* x :lb) :g (* x :lb)}} ; does this idea belong here?
 ; :last-delivered x                                ; does this idea belong here?
 ; :is-low? (returns true or false)                 ; does this belong here?
  :grams-per-kg-of-cat 12.5})

(defn daily-serving
"Takes 2 arguments: weight of cat in kg and how many grams of food per kg of cat needed. Multiplies it by how many grams of food per kg of cat. Returns how much food to serve cat each day"
 [cat food]
  (* (get-in cat [:weight :unit :kg]) (get-in food [:grams-per-kg-of-cat])))

(comment
;
(daily-serving new-cat liveclear-turkey)
(get-in new-cat [:weight :unit :kg])
(get-in liveclear-turkey [:grams-per-kg-of-cat])
  ;; => 51.24999999999999
;
)

(defn servings-per-bag
  "Takes weight of bag in grams and divides it by daily servings. Returns number of daily servings per food bag."
  [{{{:keys [g]} :unit} :weight}]
  (/ g (daily-serving new-cat liveclear-turkey)))

(defn servings-per-bag
  "Takes weight of bag in grams and divides it by daily servings. Returns number of daily servings per food bag"
  [cat food] 
  (/ (get-in food [:weight :unit :g]) (daily-serving cat food)))

(comment
  (servings-per-bag new-cat liveclear-turkey)
  ;; => 28.3219512195122
)

;; conversion fns to work in later

(defn kgs-to-lbs
  [kgs]
  (* kgs 2.20462))

(kgs-to-lbs 1)
;; => 2.20462

(defn lbs-to-kgs
  [lbs]
  (* lbs 0.453592))

(lbs-to-kgs 2)
;; => 0.907184

(defn grams-to-lbs
  [grams]
  (/ grams 453.592))

(grams-to-lbs 1)
;; => 0.0022046244201837776

(defn lbs-to-grams
  [lbs]
  (* lbs 453.59))

(lbs-to-grams 1)
;; => 453.59

;;;;;;;; data to design:

; food-remaining

; last-delivered

; is-low?

; maybe make each value for the weight key be a fn for conversion
