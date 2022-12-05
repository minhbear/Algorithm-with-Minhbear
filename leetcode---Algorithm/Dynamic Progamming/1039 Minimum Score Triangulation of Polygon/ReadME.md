This use for explain the idea and solution in the code

So we need to process the sub problem first and we can solve the general problem

In test case, we always see the triangle when trianglated have the connect of A[0] and A[n-1] with n is length of array input

So the idea is we will find the minimum score triangle from A[0] to A[n-1]
In polygon we will fix i and j is two point we will use to find the minimum score of triangle of dp[i][j]

In the code you will see the outer loop I use d with initial value is 2, So why I did that

Assume we defind the polygon with 8 side so we have 8 vertices

we have dp is 

    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | 0

if j = i so is mean we are evaluate just one point, that is the * I present in matrix below
  
    * | 0 | 0 | 0 | 0 | 0 | 0 | 0
    0 | * | 0 | 0 | 0 | 0 | 0 | 0
    0 | 0 | * | 0 | 0 | 0 | 0 | 0
    0 | 0 | 0 | * | 0 | 0 | 0 | 0
    0 | 0 | 0 | 0 | * | 0 | 0 | 0
    0 | 0 | 0 | 0 | 0 | * | 0 | 0
    0 | 0 | 0 | 0 | 0 | 0 | * | 0
    0 | 0 | 0 | 0 | 0 | 0 | 0 | *

that is not the form of triangle 

if j = i+1 is mean we proccess just a single line, that is the @ I present in maxtrix below
   
    * | @ | 0 | 0 | 0 | 0 | 0 | 0
    0 | * | @ | 0 | 0 | 0 | 0 | 0
    0 | 0 | * | @ | 0 | 0 | 0 | 0
    0 | 0 | 0 | * | @ | 0 | 0 | 0
    0 | 0 | 0 | 0 | * | @ | 0 | 0
    0 | 0 | 0 | 0 | 0 | * | @ | 0
    0 | 0 | 0 | 0 | 0 | 0 | * | @
    0 | 0 | 0 | 0 | 0 | 0 | 0 | *

that is not the form of triangle 

So if j = i+2 we can form is to triangle, but we fix i is the point and j is dynamic point depend on i so j must to be greater than i is mean that we just process the sub matrix above the '@' character. To present that is ALL 0 in matrix below

      |   | 0 | 0 | 0 | 0 | 0 | 0
      |   |   | 0 | 0 | 0 | 0 | 0
      |   |   |   | 0 | 0 | 0 | 0
      |   |   |   |   | 0 | 0 | 0
      |   |   |   |   |   | 0 | 0
      |   |   |   |   |   |   | 0
      |   |   |   |   |   |   |  
      |   |   |   |   |   |   | 

After that we have the value of i, j and we choose k is the point in range (i,j) *(not include i and j) to form of triangle

and we have the formula of triangle is A[i] * A[j] * A[j], but is just that triangle (ijk), in the head we define that
dp[i][j] is the minimum score triangle from i to j so is mean that is 
    subTrigangle(i, k) + subTriangle(k,j) + A[i] * A[j] * A[j]

and with that we can calculate the score
So the value we need to return is the dp[0][n-1] and to calculate we need to calculate entry that around of this -)))

Here is the idea I explain of this solution, but I will give you another link youtube that explain this same solution may be you can understand more
    https://www.youtube.com/watch?v=SlTPS9CF9hA

If you have stuck, please contact me, all information of me are in the readme at repository
