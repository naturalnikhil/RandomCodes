public class Solution {
    public String reverseWords(String s) {
        
        StringBuilder builder = new StringBuilder();
        int i=s.length()-1;
        
        char ch=' ';
        while(i>=0 && (ch=s.charAt(i))==' ') --i;

        while(true)
        {
            StringBuilder t = new StringBuilder();

            while(i>=0 && (ch=s.charAt(i))!=' ')
            {
                t.append(ch);
                --i;
            }
            
            builder.append(t.reverse());
            
            if(i<0) break;
            
            while(i>=0 && (ch=s.charAt(i))==' ') --i;
            
            if(i<0) break;
            
            builder.append(' ');
        }
        
        return builder.toString();
    }
}
