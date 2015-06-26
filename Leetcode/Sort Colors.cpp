class Solution {
public:
    void sortColors(int A[], int n) {
        
        int count1=0, count2=0, count3=0;
        
        for(int i=0;i<n;++i)
        {
            if(A[i]==0) ++count1;
            else if(A[i]==1) ++count2;
            else ++count3;
        }
        
        int i=0;
        for(;i<count1;++i) A[i]=0;
        for(;i<count1+count2;++i) A[i]=1;
        for(;i<n;++i) A[i]=2;
    }
};
