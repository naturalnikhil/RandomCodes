class Solution {
public:
    int maxProfit(vector<int> &prices) {
        
        if(prices.size()<2) return 0;
        
        int xmin=prices[0];
        vector<int> temp(prices.size());
        temp[0]=0;
        for(int i=1;i<prices.size();++i)
        {
            temp[i]=max(temp[i-1], prices[i]-xmin);
            xmin=min(xmin,prices[i]);
        }
        
        int xmax=prices[prices.size()-1], res=0, t=0;
        for(int i=prices.size()-2;i>=0;--i)
        {
            t=max(t, xmax-prices[i]);
            xmax=max(xmax,prices[i]);
            
            res=max(res,temp[i]+t);
        }
        
        return res;
    }
};
