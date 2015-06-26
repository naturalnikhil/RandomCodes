class Solution {
    
    vector<string> res;
    vector<char> temp;
    int size;
    
public:
    vector<string> generateParenthesis(int n) {
        
        size=n<<1;
        
        int lp=0,rp=0;
        
        temp.push_back('(');
        helper(size-1, lp+1, rp);

        return res;
    }
    
    void helper(int n, int lp, int rp)
    {
        if(n==0)
        {
            if(isValid())
            {
                // push into string
                res.push_back(string(temp.begin(),temp.end()));
            }
            return;
        }
        
        temp.push_back('(');
        if(lp < size>>1) helper(n-1, lp+1, rp);
        temp.pop_back();
        
        temp.push_back(')');
        if(rp < size>>1) helper(n-1, lp, rp+1);
        temp.pop_back();
        
    }
    
    bool isValid()
    {
        if(temp.size()!=size) return false;
        
        int s=0;
        vector<char> t=temp;
        while(s>=0)
        {
            if(t.empty()) return true;
            
            if(t.back()==')') 
                ++s;
                
            else if(t.back()=='(') --s;

            t.pop_back();
        }
        return false;
    }
};
