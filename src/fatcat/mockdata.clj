(ns fatcat.mockdata)

(def fatcat
  "An overweight house cat, needs to lose some pounds. "
  {:weight-in-lbs 16                                        ;;int
   :sex           "male"                                    ;;string
   :age           10                                        ;;int
   :name          "chester"                                 ;;string
   :color         "orange"                                  ;;string
   :activity      :indoor                                   ;;keyword
   :goal          :maintain})                               ;;keyword

(def skinny-cat
  "this cat is fair to middlin weight"
  {:weight-in-lbs 7
   :sex           "female"
   :age           5
   :name          "BB"
   :color         "black and white"
   :breed         "calico"
   :activity      :outdoor
   :goal          :gain
   :brand         "Purina"
   :last-purchase "10 06 22"
   :wet?          true})

(def regular-cat
  "A regular-weight house cat, needs to maintain weight."
  {:weight-in-lbs 9                                         ;;int
   :sex           "female"                                  ;;string
   :age           15                                        ;;int
   :name          "toffee"                                  ;;string
   :color         "tortoise-shell"                          ;;string
   :activity      :indoor                                   ;;keyword
   :goal          :maintain})                               ;;keyword

(def bags-of-fewd "In lbs, integer that represents the common sizes of food available for purchase in the US. "
  {:small   3.5
   :medium  7
   :large   16
   :x-large 32})

; Wendy's Pet Food Calculator
; improvements: 
; - make generic for any pet/animal
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
