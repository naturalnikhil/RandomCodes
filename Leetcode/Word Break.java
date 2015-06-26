public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        return helper2(s, dict);
    }
    
    
    private boolean helper2(String s, Set<String> dict)
    {
        boolean[] T = new boolean[s.length()+1];
        T[s.length()]=true;
        
        for(int i = s.length()-1; i>=0; --i)
        {
            for(int j=i; j<s.length(); ++j)
            {
                if(T[j+1] && dict.contains(s.substring(i,j+1))) 
                {
                    T[i]=true;
                    break;
                }
            }
        }
        
        return T[0];
    }
    
    
    private boolean helper(String s, int start, Set<String> dict)
    {
        if(start==s.length()) return true;
        
        StringBuilder builder = new StringBuilder();
        for(int i=start; i<s.length(); ++i)
        {
            builder.append(s.charAt(i));
            
            if(dict.contains(builder.toString()))
            {
                if(helper(s, i+1, dict)) return true;
            }
        }
        
        return false;
    }
}
