Permutation game
==================
[link](https://www.hackerrank.com/challenges/permutation-game)

## since i get how it works, i'll put it off a bit,
### tbh, i don't really get how to actually do this, but i really hate it that this has been delayed for so long, therefore i'm gonna work on the next one for now
#### DO NOT CALL ME LAZY

Alice and Bob play the following game:

1) They choose a permutation of the first N numbers to begin with. 
2) They play alternately and Alice plays first. 
3) In a turn, they can remove any one remaining number from the permutation. 
4) The game ends when the remaining numbers form an increasing sequence. The person who played the last turn (after which the sequence becomes increasing) wins the game.

Assuming both play optimally, who wins the game?

Input: 
The first line contains the number of test cases T. T test cases follow. Each case contains an integer N on the first line, followed by a permutation of the integers 1..N on the second line.

Output: 
Output T lines, one for each test case, containing "Alice" if Alice wins the game and "Bob" otherwise.

Constraints: 
1 <= T <= 100 
2 <= N <= 15 
The permutation will not be an increasing sequence initially.

Sample Input: 
2 
3 
1 3 2 
5 
5 3 2 1 4

Sample Output: 
Alice 
Bob

Explanation: For the first example, Alice can remove the 3 or the 2 to make the sequence increasing and wins the game.

For the second example, if 4 is removed then the only way to have an increasing sequence is to only have 1 number left, which would take a total of 4 moves, thus allowing Bob to win. On the first move if Alice removes the 4, it will take 3 more moves to create an increasing sequence nad thus Bob wins. If Alice does not remove the 4, then Bob can remove it on his next turn since Alice can not win in one move.

<========== solution ============
This is a typical game problem. You have 2^15 possible positions which denote which are the remaining numbers. From the number of the remaining numbers you can derive whose turn it is. So now you have a graph that is defined in the following manner - the vertices are the possible sets of remaining numbers and there is an edge connecting two vertices u and v iff there is a move that changes set u to set v(i.e. set v has exactly one number less).

Now you already pointed out for which positions you know who is the winner straight away - the ones that represent increasing sequences of numbers this positions are marked as loosing. For all other positions you determine if they are wining or loosing in the following manner: a position is winning iff there is an edge connecting it to a loosing position. So all that is left is to something like a dfs with memoization and you can determine which positions are winning and which are loosing. As the graph is relatively small (2^15 vertices) this solution should be fast enough.

=================================>
