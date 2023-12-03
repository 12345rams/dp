//problem 1 You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
class Solution 
{ 
   
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][]=new int [n+1][W+1];
         // your code here 
         for(int i= 1 ; i< n+1; i++) {
            for (int j=1 ;j< W+1 ; j++) { 
                if(i==0 || j==0 ) dp[i][j]=0;
            }
        }
         for(int i= 1 ; i< n+1; i++) {
            for (int j=1 ;j< W+1 ; j++) { 
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    } 
}
