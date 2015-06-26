class Solution {
public:
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        
        vector<vector<int> > res;
        set<vector<int> > tres;
        vector<int> t;
        
        sort(num.begin(),num.end());
        
        helper(num,target,0,t,tres);
        
        for(set<vector<int> >::iterator it=tres.begin();it!=tres.end();++it)
        {
            res.push_back(*it);
        }
        
        return res;
    }
    
    void helper(vector<int>& arr, int target, int pos, vector<int>& t, set<vector<int> >& res)
    {
        for(int i=pos;i<arr.size();++i)
        {
            if(arr[i]>target) break;
            
            t.push_back(arr[i]);

            if(arr[i]==target)
            {
                res.insert(res.begin(),t);
                t.pop_back();
                break;
            }
            
            helper(arr,target-arr[i],i+1,t,res);
            t.pop_back();
        }
    }
};
