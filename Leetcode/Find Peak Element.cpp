public class Solution {
    public int findPeakElement(int[] num) {
        
        if(num.length==0) return -1;

        return helper(num,0,num.length-1).mxPos;
    }
    
    private class Pair
    {
        int mx, mxPos;
        
        Pair(int mx, int mxPos)
        {
            this.mx=mx;
            this.mxPos=mxPos;
        }
    }
    
    private Pair helper(int[] num, int s, int e)
    {
        if(s>e) return null;
        
        if(s==e)
        {
            return new Pair(num[s],s);
        }
        
        int mid = s+(e-s)/2;
        Pair left = helper(num,s,mid);
        Pair right = helper(num,mid+1,e);
        
        if(left==null) return right;
        
        if(right==null) return left;
        
        if(left!=null && right!=null)
        {
            if(left.mx>right.mx) return left;
            else return right;
        }
        
        return null;
    }
}
