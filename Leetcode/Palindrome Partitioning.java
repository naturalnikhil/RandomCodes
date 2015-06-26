public class Solution {
    
    private boolean[][] T;
    
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        
        T = new boolean[s.length()][s.length()];
        res = new ArrayList<List<String>>();

        createTable(s);
        
        findPartitions(s, 0, new ArrayList<String>());
        
        return res;
    }
    
    
    private void findPartitions(String s, int start, ArrayList<String> temp)
    {
        if(start>=s.length()) 
        {
            res.add((List)temp.clone());//new ArrayList<String>(temp));
            return;
        }
        
        for(int i=start; i<s.length(); ++i)
        {
            if(T[start][i])
            {
                
                temp.add(s.substring(start, i+1));
                
                findPartitions(s, i+1, temp);
                
                temp.remove(temp.size()-1);
            }
        }
    }
    
    
    private void createTable(String s)
    {
        for(int i=0;i<s.length();++i) 
        {
            // single char sub-strings
            T[i][i]=true;
            
            // odd cases
            int left = i-1, right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                T[left][right]=true;
                --left;
                ++right;
            }
            
            // even cases
            left = i; right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                T[left][right]=true;
                --left;
                ++right;
            }
        }
    }
}
