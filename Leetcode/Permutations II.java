public class Solution {
    
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Set<List<Integer>> set = new HashSet<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] num) {
        
        Arrays.sort(num);
        
        helper(num,0);
        
        return res;
    }
    
    private void helper(int[] num,int pos)
    {
        if(pos==num.length)
        {
            ArrayList<Integer> list = new ArrayList<Integer>(num.length);
            for(int n:num) list.add(n);
            
            if(set.contains(list)) return;
            
            set.add(list);
            res.add(list);
            return;
        }
        
        helper(num,pos+1);

        Integer orig = num[pos], last = num[pos];
        
        for(int i=pos+1; i<num.length; ++i)
        {
            if(num[i]==last) continue;
            
            last=num[i];
            num[pos]=num[i];
            num[i]=orig;
            
            helper(num,pos+1);
            
            num[i]=num[pos];
            num[pos]=orig;
        }
    }

}
