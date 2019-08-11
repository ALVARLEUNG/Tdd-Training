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

//give five player at the third level
given: [3h 3d 6c 6c 2d] VS [5h 5d 6c 7c 2d] -> then: [3h 3d 6c 6c 2d] win
given: [3h 3d 6c 6c 2d] VS [5h 5d 7c 7c 2d] -> then: [5h 5d 7c 7c 2d] win

//give five player at the fourth level
given: [3h 3d 3c 7c 2d] VS [5h 5d 7c 7c 2d] -> then: [3h 3d 3c 7c 2d] win
given: [3h 3d 3c 7c 2d] VS [5h 5d 5c 7c 2d] -> then: [5h 5d 5c 7c 2d] win

//give five player at the fifth level
given: [3h 3d 3c 7c 2d] VS [3h 4d 5c 6c 7d] -> then: [3h 4d 5c 6c 7d] win
given: [3d 4d 5c 6c 7d] VS [4h 5d 6c 7c 8d] -> then: [4h 5d 6c 7c 8d] win

//give five player at the Level six
given: [3d 4d 5c 6c 7d] VS [2d 5d 6d 4d 8d] -> then: [2d 5d 6d 4d 8d] win
given: [3c 8c 5c 6c 9c] VS [2d 5d 6d 4d 8d] -> then: a draw

//give five player at the level seven
given: [3c 8c 5c 6c 9c] VS [2d 2c 2h 3c 3d] -> then: [2d 2c 2h 3c 3d] win
given: [2d 2c 2h 3c 3d] VS [3d 3c 3h 2c 2d] -> then: [3d 3c 3h 2c 2d] win

//give five player at the level eight
given: [kd kc kh 3c 3d] VS [3d 3c 3h 3c 2d] -> then: [3d 3c 3h 3c 2d] win
given: [3d 3c 3h 3c 2d] VS [4d 4c 4h 4c 2d] -> then: [4d 4c 4h 4c 2d] win

//give five player at the level nine
given: [9d 9c 9h 9c 2d] VS [3h 4h 5h 6h 7h] -> then: [3h 4h 5h 6h 7h] win


```
