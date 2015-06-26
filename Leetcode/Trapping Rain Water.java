public class Solution {
    public int trap(int[] A) {
        
        int[] temp = new int[A.length];
        
        int max=0;
        for(int i=A.length-1;i>=0;--i) 
        {
            temp[i]=max;
            
            if(A[i]>max) max=A[i];
        }
        
        int i=0, store=0;
        max=0;
        while(i<A.length && A[i]==0) ++i;
        
        // if(i<A.length) max=A[i++];
        
        for(; i<A.length; ++i)
        {
            if(A[i]>=max) // choose new max
            {
                if(temp[i]>=A[i]) max=A[i];
                else max=temp[i];
            }
            else if(A[i]<max)
            {
                store+=max-A[i];
            }
        }
        
        return store;
    }
}
