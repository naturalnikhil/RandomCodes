class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
        
        sort(num.begin(), num.end());
        
        int xtarget=num[0]+num[1]+num[2];
        
        for(int i=0;i<num.size()-2;++i)
        {
            int l=i+1, m=num.size()-1;
            
            while(l<m)
            {
                int sum = num[l] + num[m] + num[i];
                
                if(mod(target-xtarget) > mod(target-sum))
                {
                    xtarget=sum;
                }
                
                if(sum>target) --m;
                else if(sum<target) ++l;
                else
                {
                    return target;
                }
            }
        }
        
        return xtarget;
    }
    
    int mod(int n)
    {
        if(n<0) return -n;
        return n;
    }
};
