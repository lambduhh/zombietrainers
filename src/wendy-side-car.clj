(ns wendy-side-car)

(defn cas
  [foo bar]
  (if (< foo bar)
    [foo bar]
    [bar foo]))

(cas 4 1)
