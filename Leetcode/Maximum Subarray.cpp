class Solution {
public:
    int maxSubArray(int A[], int n) {
        
        int sum=INT_MIN,xsum=0,lmin=INT_MIN;
        for(int i=0;i<n;++i)
        {
            xsum+=A[i];
            sum= max(sum,xsum);
            
            // start afresh
            if(xsum<0) xsum=0;
            
            lmin=max(lmin,A[i]);  // find least -ve no.; in case all elements of array are -ve
        }
        
        if(sum>=0) return sum;
        else return lmin;
    }
};
