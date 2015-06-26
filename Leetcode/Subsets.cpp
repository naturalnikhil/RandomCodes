class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        
        sort(S.begin(),S.end());
        
        vector<vector<int> > res;
        vector<int> t;
        
        int l = pow(2,S.size());
        
        for(int i=0;i<l;++i)
        {
            int k=1,p=0;
            t.clear();
            
            while(k<=i)
            {
                if(k&i)
                {
                    t.push_back(S[p]);
                }
                
                ++p;
                k=k<<1;
            }
            
            res.push_back(t);
        }
        
        return res;
    }
};
