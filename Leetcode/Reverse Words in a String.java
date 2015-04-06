public class Solution {
    public String reverseWords(String s) {
        
        StringBuilder builder = new StringBuilder();
        int i=s.length()-1;
        
        char ch=' ';
        while(i>=0 && (ch=s.charAt(i))==' ') --i;

        while(true)
        {
            int j=i;

            while(j>=0 && (ch=s.charAt(j))!=' ')
            {
                --j;
            }
            
            builder.append(s.substring(j+1,i+1));
            i=j;
            
            if(i<0) break;
            
            while(i>=0 && (ch=s.charAt(i))==' ') --i;
            
            if(i<0) break;
            
            builder.append(' ');
        }
        
        return builder.toString();
    }
}