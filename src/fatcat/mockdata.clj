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


(def regular-cat
  "Fair to middlin weight range"
  {:weight-in-lbs 10
   :sex           "female"
   :age           5
   :name          "BB"
   :color         "black and white"
   :breed         "calico"
   :activity      :outdoor
   :goal          :gain
   :brand         "Purina"
   :last-purchase "10 06 22"
   :wet?          true
   })

(def bags-of-fewd "In lbs, integer that represents the common sizes of food available for purchase in the US. "
  {:small   3.5
   :medium  7
   :large   16
   :x-large 32})
