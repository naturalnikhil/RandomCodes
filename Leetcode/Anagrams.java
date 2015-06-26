public class Solution {
    public List<String> anagrams(String[] strs) {
        
        HashMap<String,String> map = new HashMap<String,String>();
        List<String> res = new LinkedList<String>();
        
        for(String s:strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
            
            if(map.containsKey(ns))
            {
                String value = map.get(ns);
                if(value!=null)
                {
                    res.add(value);
                    map.put(ns,null);
                }
                res.add(s);
            }
            else
            {
                map.put(ns,s);
            }
        }
        
        return res;
    }
}
