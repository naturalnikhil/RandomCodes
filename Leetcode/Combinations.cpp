class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        
        vector<vector<int> > res;
        vector<int> t;
        
        helper(n,1,t,k,res);
        
        return res;
    }
    
    void helper(int n, int pos, vector<int>& t, int k, vector<vector<int> >& res)
    {
        for(int i=pos;i<=n;++i)
        {
            t.push_back(i);
            
            if(t.size()==k)
            {
                res.push_back(t);
                t.pop_back();
                continue;
            }
            
            helper(n,i+1,t,k,res);
            t.pop_back();
        }
    }
};
