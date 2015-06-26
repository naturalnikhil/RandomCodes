class Solution {
public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        
        vector<vector<int> > res;
        vector<int> t;
        
        sort(candidates.begin(),candidates.end());
        helper(candidates,target,0,t,res);
        
        return res;
    }
    
    void helper(vector<int>& arr, int target, int pos, vector<int>& t, vector<vector<int> >& res)
    {
        for(int i=pos;i<arr.size();++i)
        {
            if(arr[i]>target) break;
            
            t.push_back(arr[i]);

            if(arr[i]==target)
            {
                res.push_back(t);
                t.pop_back();
                break;
            }
            
            helper(arr,target-arr[i],i,t,res);
            t.pop_back();
        }
    }
};
