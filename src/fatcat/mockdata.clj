(ns fatcat.mockdata)

(def fatcat
  "An overweight house cat, needs to lose some pounds. "
  {:weight-in-lbs 16                                        ;;int
   :sex           "male"                                    ;;
   :age           10                                        ;;int
   :name          "chester"                                 ;;string
   :color         "orange"                                  ;;string
   :activity      :indoor                                   ;;keyword
   :goal          :maintain})                               ;;keyword

(def skinny-cat {})


(def regular-cat {})

(def bags-of-fewd "In lbs, integer that represents the common sizes of food available for purchase in the US. "
  {:small   3.5
   :medium  7
   :large   16
   :x-large 32})
