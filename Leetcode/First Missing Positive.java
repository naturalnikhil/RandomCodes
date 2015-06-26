public class Solution {
    public int firstMissingPositive(int[] A) {
        
        for(int i=0;i<A.length;++i)
        if(A[i]<=0) A[i]=A.length+1;
        
        for(int i=0;i<A.length;++i)
        {
            if(Math.abs(A[i])<=A.length) A[Math.abs(A[i])-1]=-Math.abs(A[Math.abs(A[i])-1]);
        }
        
        for(int i=0;i<A.length;++i)
        if(A[i]>0) return i+1;
        
        return A.length+1;
    }
}
