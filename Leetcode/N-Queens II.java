public class Solution {
    
    private boolean[] col;
    private boolean[] ltr, rtl;
    
    private int res=0;
    
    public int totalNQueens(int n) {
        
        col = new boolean[n];
        ltr = new boolean[2*n-1];
        rtl = new boolean[2*n-1];
        
        char[][] arr = new char[n][n];
        for(int i=0;i<n;++i)
        for(int j=0;j<n;++j)
        arr[i][j]='.';
        
        helper(arr, 0);
        
        return res;
    }
    
    
    private void helper(char[][] arr, int row)
    {
        if(row==arr.length)
        {
            ++res;
            return;
        }
        
        int i=row;
            for(int j=0;j<arr.length;++j)
            {
                if(col[j] || ltr[i+j] || rtl[arr.length-(i-j)-1]) 
                continue;
                
                arr[i][j]='Q';
                col[j]=true;
                ltr[i+j]=true;
                rtl[arr.length-(i-j)-1]=true;
                
                helper(arr, row+1);
                
                arr[i][j]='.';
                col[j]=false;
                ltr[i+j]=false;
                rtl[arr.length-(i-j)-1]=false;
            }
    }
}
