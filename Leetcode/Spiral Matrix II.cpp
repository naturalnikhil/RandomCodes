class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        
        vector<vector<int> > matrix(n,vector<int>(n,0));
        
        if(n==0) return matrix;
        
        int sq=0;
        helper(matrix, sq, 0, n-1, 0, n-1);
        
        return matrix;
    }
    
    
    void helper(vector<vector<int> >& matrix, int& sq, int r1, int r2, int c1, int c2)
    {
        if(r1>r2 || c1>c2) return;
        
        if(r1==r2 && c1==c2)
        {
            matrix[r1][c1]=++sq;
            return;
        }
        
        for(int i=c1;i<=c2;++i) matrix[r1][i]=++sq;;
        
        for(int i=r1+1;i<=r2-1;++i) matrix[i][c2]=++sq;;
        
        if(r1!=r2)
            for(int i=c2;i>=c1;--i) matrix[r2][i]=++sq;;
        
        if(c1!=c2)
            for(int i=r2-1;i>=r1+1;--i) matrix[i][c1]=++sq;;
        
        helper(matrix, sq, r1+1, r2-1, c1+1, c2-1);
    }
};
