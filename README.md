# Tdd-Training
Tdd training about player
```
// give two player
given: 3c 2d   ->  then: 3c win
given: 2c 3d   ->  then: 3d win
given: 3c 3d   ->  then: a draw
given: jc qd   ->  then: qd win
given: qc kd   ->  then: kd win
given: kc ad   ->  then: ad win

//give five player at the first level
given: [2h 3c 5s 9c 6d] VS [3h 5d 6c 7c 2d] -> then: [2h 3c 5s 9c 6d] win
given: [2h 3c 5s 9c kd] VS [3h 5d 6c 7c ad] -> then: [3h 5d 6c 7c ad] win

//give five player at the second level
given: [2h 3c 5s 9c 6d] VS [3h 3d 6c 7c 2d] -> then: [3h 3d 6c 7c 2d] win
given: [3h 3d 6c 7c 2d] VS [5h 5d 6c 7c 2d] -> then: [5h 5d 6c 7c 2d] win
```
