public class Solution {
    public int findMin(int[] num) {
        
        int idx = bs(num,0,num.length-1);
        
        if(idx==-1 || num.length==1) return num[0];
        
        if(idx==num.length-1)
        {
            if(num[idx-1]>num[idx]) return num[idx];
            else return num[0];
        }
        
        return num[idx];
    }
    
    
    int bs(int[] arr, int start, int end)
    {
        if(start>end) return -1;
        
        if(start==end) return start;
        
        int mid = start + (end-start)/2;
        
        // for the pivot cases
        if(mid+1<=end && arr[mid]>arr[mid+1]) return mid+1;
        if(mid-1>=start && arr[mid-1]>arr[mid]) return mid;
        
        int a = bs(arr, start, mid);
        
        int b = bs(arr, mid+1, end);
        
        if(a==-1) return b;
        if(b==-1) return a;
        
        if(arr[a]==arr[b]) return a;
        if(arr[a]<arr[b]) return a;
        else return b;
    }
}
