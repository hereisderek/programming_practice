nCr table
==================
[link](https://www.hackerrank.com/challenges/ncr-table)

Jim is doing his discrete maths homework which requires him to repeatedly calculate nCr(n choose r) for different values of n. Knowing that this is time consuming, he goes to his sister June for help. June, being a computer science student knows how to convert this into a computer program and generate the answers quickly. She tells him, by storing the lower values of nCr(n choose r), one can calculate the higher values using a very simple formula.

If you are June, how will you calculate nCr values for different values of n?

Input Format 
The first line contains the number of test cases T. 
T lines follow each containing an integer n.

Output Format 
For each n output the list of nC0 to nCn each separated by a single space in a new line. If the number is large, print only the last 9 digits. i.e. modulo 109

Constraints 
1<=T<=200 
1<=n< 1000

Sample Input
```
3
2
4
5
```
Sample Output
```
1 2 1
1 4 6 4 1
1 5 10 10 5 1
```
Explanation 
For 2 we can check 2C0 2C1 and 2C2 are 1, 2 and 1 respectively. The other inputs' answer follow similar pattern.

this is really a interesting, the hard part is not how you calculate, it's actually how you deal with integer overflow

>according to one of the staff's reply,
>`triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];`
>will lead to integer overflow. To avoid this, you need to add
>`triangle[i][j] = (triangle[i - 1][j - 1] + triangle[i - 1][j])%m;`