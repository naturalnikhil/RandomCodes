public class Solution {
    public int minDistance(String word1, String word2) {
        
        int n=word1.length(), m=word2.length();
        char[] arr1 = word1.toCharArray(), arr2=word2.toCharArray();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=n;i>=0;--i) dp[i][m]=n-i;
        for(int i=m;i>=0;--i) dp[n][i]=m-i;
        
        for(int i=n-1;i>=0;--i)
        {
            for(int j=m-1;j>=0;--j)
            {
                if(arr1[i]==arr2[j])
                {
                    dp[i][j]=dp[i+1][j+1];
                }
                else
                {
                    dp[i][j]=Math.min( Math.min(dp[i+1][j],dp[i][j+1])+1 , dp[i+1][j+1]+1) ;
                }
            }
        }
        
        return dp[0][0];
    }
}
