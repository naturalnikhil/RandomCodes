public class Solution {
    
    List<String> res = new LinkedList<String>();

    public List<String> restoreIpAddresses(String s) {
        
        if(s.length()<4) return res;
        
        int[] arr = new int[s.length()];
        for(int i=0;i<s.length();++i)
        arr[i] = Integer.valueOf(s.charAt(i)-'0');
        
        int[] ip = new int[4];
        helper(arr, 0, ip, 0);
        
        return res;
    }
    
    void helper(int[] arr, int arrPos, int[] ip, int ipPos)
    {
        if(ipPos==3)
        {
            if(arr.length-arrPos>3 || arrPos==arr.length) 
                return;
                
            if(arr[arrPos]==0 && arrPos+1<arr.length) return;

             int temp=0;
             for(int i=arrPos; i<arr.length; ++i)
                 temp = temp*10+arr[i];
             
             if(temp>255) return;
             
             ip[ipPos]=temp;
             
             // store to results
             
             res.add(""+ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
             
            return;
        }
        
        int temp=0;
        for(int i=arrPos; i<=arrPos+2 && i<arr.length; ++i)
        {
            temp= temp*10 + arr[i];
            if(temp>255) return;
            
            ip[ipPos]=temp;
            helper(arr, i+1, ip, ipPos+1);
            
            if(arr[arrPos]==0) break;
        }
    }
}
