public class Solution {
    
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] num) {
        
        helper(num,0);
        
        return res;
    }
    
    private void helper(int[] num,int pos)
    {
        if(pos==num.length)
        {
            ArrayList<Integer> list = new ArrayList<Integer>(num.length);
            for(int n:num) list.add(n);
            res.add(list);
            return;
        }
        
        helper(num,pos+1);

        Integer orig = num[pos];
        for(int i=pos+1; i<num.length; ++i)
        {
            num[pos]=num[i];
            num[i]=orig;
            
            helper(num,pos+1);
            
            num[i]=num[pos];
            num[pos]=orig;
        }
    }
}
