class Solution {
public:
    int jump(int A[], int n) {
        
        if(n<=1) return 0;
        
        if(A[0]>=n-1) return 1;
        
        int step=1;
        int maxJumpIdx=A[0], curJumpIdx=A[0];
        
        for(int i=1; i<=curJumpIdx; ++i)
        {
            if(maxJumpIdx>=n-1)
            return ++step;
            
            if(i==0) continue;
            
            maxJumpIdx = max(maxJumpIdx, i+A[i]);
            
            if(i==curJumpIdx)  // if idx boundary of crrnt jump; ++step
            {
                ++step;
                curJumpIdx=maxJumpIdx;
                
            if(maxJumpIdx>=n-1) return step;
            }
        }
        
        return 0;
    }
};
