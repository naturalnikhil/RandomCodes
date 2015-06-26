class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        
        vector<int> res;
        
        if(matrix.size()==0) return res;
        
        helper(matrix, res, 0, matrix.size()-1, 0, matrix[0].size()-1);
        
        return res;
    }
    
    
    void helper(vector<vector<int> >& matrix, vector<int>& res, int r1, int r2, int c1, int c2)
    {
        if(r1>r2 || c1>c2) return;
        
        if(r1==r2 && c1==c2)
        {
            res.push_back(matrix[r1][c1]);
            return;
        }
        
        for(int i=c1;i<=c2;++i) res.push_back(matrix[r1][i]);
        
        for(int i=r1+1;i<=r2-1;++i) res.push_back(matrix[i][c2]);
        
        if(r1!=r2)
            for(int i=c2;i>=c1;--i) res.push_back(matrix[r2][i]);
        
        if(c1!=c2)
            for(int i=r2-1;i>=r1+1;--i) res.push_back(matrix[i][c1]);
        
        helper(matrix, res, r1+1, r2-1, c1+1, c2-1);
    }
};
