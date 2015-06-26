class Solution {
public:
    int maxProfit(vector<int> &prices) {
        
        if(prices.size()<2) return 0;
        
        int xmin=prices[0], res=0;
        for(int i=1;i<prices.size();++i)
        {
            res = max(res, prices[i]-xmin);
            xmin = min(xmin, prices[i]);
        }

        return res;
    }
};
