(ns cassiopeia.destination.flatiron.scores
  (:use [overtone.live]
        [cassiopeia.engine.expediency]
        [mud.core]
        [mud.chords]))

(def dark-chords-score
  (let [_ [0 0 0 0]
        [f31 f32 f33 f34 f35 f36 f37] (chords-for :F3 :minor 3)]
    (chords-seq [:F3 :1*16 :3*16 :4*16 :6*8 :m+5*8
                 :F3 :1*16 :3*16 :4*16 :6*8 :m7+5*8])
    (concat
     (repeat 16 f31)
     (repeat 16 f33)
     (repeat 16 f34)
     (repeat 8 f36) (repeat 8 (chord :F3 :m+5))

     (repeat 16 f31)
     (repeat 16 f33)
     (repeat 16 f34)
     (repeat 8 f36) (repeat 8 (chord :F3 :m7+5)))))

(def darker-pinger-score
  (let [_ [0 0 0 0]
        [c31 c32 c33 c34 c35 c36 c37]  (chords-for :C3 :minor 1)
        [c41 c42 c43 c44 c45 c46 c47]  (chords-for :C4 :minor 1)
        [f21 f22 f23 f24 f25 f26 f27]  (chords-for :F2 :minor 1)
        [f31 f32 f33 f34 f35 f36 f37]  (chords-for :F3 :minor 1)
        [f41 f42 f43 f44 f45 f46 f47]  (chords-for :F4 :minor 1)]
    (chord-score (repeat 6 [c41 f31 f33 f34  f31 f31 f41 f31  c41 f31 f33 f34  f31 f31 f41 f31])
                           [c37 f31 f33 f34  f31 f31 f41 f31  c37 f31 f33 f34  f31 f31 f41 f31]
                           [c41 f31 f33 f34  f31 f31 f41 f31  c34 f31 f33 f31  f31 f31 f41 f31]

                 (repeat 6 [c41 f31 f33 f34  f31 f31 f41 f31  c41 f31 f33 f34  f31 f31 f41 f31])
                           [c37 f31 f33 f34  f31 f31 f41 f31  c37 f31 f33 f34  f31 f31 f41 f31]
                           [c41 f31 f33 f41  f27 f31 f31 f31  c31 f31 f33 f41  f31 f31 f41 f31])))

(def apeg-swell
  (chord-score
   (repeat 16 (degrees [1] :minor :F3))
   (repeat 16 (degrees [1] :minor :F3))
   (repeat 16 (degrees [4] :minor :F3))
   (repeat 8 (degrees [4] :minor :F3))
   (repeat 4 (degrees [5] :minor :F3))
   (repeat 4 (degrees [4] :minor :F3))))

;;ia/b/c iia/b/c IIIa/b/c iva/b/c va/b/c VIa/b/c VIIa/b/c
(def chords-score
  (let [_ [0 0 0 0]
        [f21b f22b f23b f24b f25b f26b f27b] (chords-with-inversion [1] :F2 :minor :up 3)
        [f21c f22c f23c f24c f25c f26c f27c] (chords-with-inversion [1 2] :F2 :minor :up 3)
        [f21 f22 f23 f24 f25 f26 f27]        (chords-for :F2 :minor 3)]

    ;;  (chords-seq [:F2 :1c*8 :6*8  :3b*8 :4b*6 :sus4c*2  :F2 :1c*8 :1c*8 :3b*8 :5b*6 :7sus4c*2] :minor)
    ;;  (chords-seq "F2 1c*8 6*8  3b*8 4b*6 sus4c*2 F2 1c*8 1c*8 3b*8 5b*6 7sus4c*2" :minor)

    (concat
     (repeat 8 f21c)
     (repeat 8 f26)
     (repeat 8 f23b)
     [f24b f24b f24b f24b f24b f24b (chord :F2 :sus4 2) (chord :F2 :sus4 2)]

     (repeat 8 f21c)
     (repeat 8 f21c)
     (repeat 8 f23b)
     [f25b f25b f25b f25b f25b f25b (chord :F2 :7sus4 2) (chord :F2 :7sus4 2)])))

(def pinger-score-alternative
  (let [_ [0 0 0 0]
        [c31 c32 c33 c34 c35 c36 c37] (chords-for :C3 :minor 1)
        [c41 c42 c43 c44 c45 c46 c47] (chords-for :C4 :minor 1)
        [f31 f32 f33 f34 f35 f36 f37] (chords-for :F3 :minor 1)
        [f41 f42 f43 f44 f45 f46 f47] (chords-for :F4 :minor 1)]

    [f43 _   f43 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

     c41 f35 f31 f34 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     c41 f35 f31 f34 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

     f41 _   f43 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

     f37 f41 _ f41 c35 _ (as-chord (degrees [1] :minor :F3)) (as-chord (degrees [1] :minor :F3))
     f37 f41 _ f41 c41 _ (as-chord (degrees [1] :minor :F3)) (as-chord (degrees [1] :minor :F3))
     ;;--
     f41 _   f43 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

     f41 _   f43 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

     f41 _   f43 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 f36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

     f37 f41 _ f41 c35 _  (as-chord (degrees [1] :minor :F3)) (as-chord (degrees [1] :minor :F3))
     f37 f41 _ f41 c41 _  (as-chord (degrees [1] :minor :F3)) (as-chord (degrees [1] :minor :F3))]))

(def pinger-score-highlighted
  (let [_ [0 0 0 0]
        [c31 c32 c33 c34 c35 c36 c37]        (chords-for :C3 :minor 1)
        [c41 c42 c43 c44 c45 c46 c47]        (chords-for :C4 :minor 1)
        [f31 f32 f33 f34 f35 f36 f37]        (chords-for :F3 :minor 1)
        [f41 f42 f43 f44 f45 f46 f47]        (chords-for :F4 :minor 1)
        [f312 f322 f332 f342 f352 f362 f372] (chords-for :F3 :minor 2)]

    (comment
      (degrees-seq :minor
                   (repeat 2 [:F4 1 3 1     4 :F3 7 :C3 6 :F3 7     7])
                   (repeat 2 [:F4 1 3 1     4 :C3 7 :C3 6 :F3 7     7])

                   (repeat 2 [:F4 1 3 1     4 :F3 7 :C3 6 :F3 7     7])
                   [:F4 1 3 1     4 :C4 3 :C3 6 :F3 7     7]
                   [:F4 1 3 1 :C4 4     7     6 :C4 3 :F3 5]
                   ))


    [f41 f43 f41 f44 f37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

     f41 f43 f41 f44 f37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 c43 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 c44 c47 c46 (as-chord (degrees [3] :minor :C4)) (as-chord (degrees [5] :minor :F3))

     ;;-

     f41 f43 f41 f44 f37 c36 (degrees [1] :minor :F3) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f37 c36 (degrees [1] :minor :F3) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f41 c36 (degrees [1] :minor :F3) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 f41 c36 (degrees [1] :minor :F3) (as-chord (degrees [7] :minor :F3))

     f41 f43 f41 f44 c43 c36 (degrees [7] :minor :F3) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 c43 c36 (degrees [7] :minor :F3) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 f44 c41 c36 (degrees [1] :minor :F3) (as-chord (degrees [7] :minor :F3))
     f41 f43 f41 c44 c47 c36 f352 f312]))

(def pinger-score
  (let [_ [0 0 0 0]
        [c31 c32 c33 c34 c35 c36 c37] (chords-for :C3 :minor 1)
        [f31 f32 f33 f34 f35 f36 f37] (chords-for :F3 :minor 1)
        [f41 f42 f43 f44 f45 f46 f47] (chords-for :F4 :minor 1)]
    (let [new-pat (chord-score
                   (repeat 15 [f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))])
                              [f41 _   f43 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))])]

      [f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))

       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 f43 f41 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))
       f41 _   f43 f44 c37 c36 (as-chord (degrees [7] :minor :F3)) (as-chord (degrees [7] :minor :F3))])))

(def pinger-growth-score-spair
  (let [_ [0 0 0 0]
        [f31 f32 f33 f34 f35 f36 f37] (chords-for :F3 :minor 1)
        [f41 f42 f43 f44 f45 f46 f47] (chords-for :F4 :minor 1)
        ;;_ (concat   (degrees-seq [:f4 1 _ 34  :f3 7677] (repeat 3 (degrees-seq [:f4 1314  :f3 7677]))))
        ]

    [f41 _ f43 f44 f37 f36 (flatten [(degrees [7] :minor :F3) 0 0 0]) (flatten [(degrees [7] :minor :F3) 0 0 0])
     f41 f43 f41 f44 f37 f36 (flatten [(degrees [7] :minor :F3) 0 0 0]) (flatten [(degrees [7] :minor :F3) 0 0 0])
     f41 f43 f41 f44 f37 f36 (flatten [(degrees [7] :minor :F3) 0 0 0]) (flatten [(degrees [7] :minor :F3) 0 0 0])
     f41 f43 f41 f44 f37 f36 (flatten [(degrees [7] :minor :F3) 0 0 0]) (flatten [(degrees [7] :minor :F3) 0 0 0])]))

(def pinger-score-spair
  (let [_ [0 0 0 0]
        [c31 c32 c33 c34 c35 c36 c37] (chords-for :C3 :minor 1)
        [f31 f32 f33 f34 f35 f36 f37] (chords-for :F3 :minor 1)
        [f41 f42 f43 f44 f45 f46 f47] (chords-for :F4 :minor 1)]
    [f41 f43 f41 f44 c37 c36 (flatten [(degrees [7] :minor :F3) 0 0 0]) (flatten [(degrees [7] :minor :F3) 0 0 0])]))
