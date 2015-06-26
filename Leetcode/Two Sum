public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] res = new int[2];
        
        Map<Integer,Integer> numIdx = new HashMap<Integer,Integer>();
        
        int i=0;
        for(int n:numbers)
        {
            i++;
            if(numIdx.containsKey(target-n))
            {
                res[0]=numIdx.get(target-n);
                res[1]=i;
                break;
            }
            
            numIdx.put(n,i);
        }
        return res;
    }
}
