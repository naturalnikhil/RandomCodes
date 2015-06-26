class Solution {
public:

    string arr[8] = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    vector<string> letterCombinations(string digits) {
        
        vector<string> res;
        
        if(digits.empty()) 
        {
            res.push_back(string());
            return res;
        }
        
        string t(digits.size(),'\0');
        
        helper(digits, 0, t, res);
        
        return res;
    }
    
    
    void helper(string& digits, int pos, string& t, vector<string>& res)
    {
        string temp = arr[digits[pos]-'0'-2];
        
        for(int i=0;i<temp.size();++i)
        {
            t[pos]=temp[i];
            
            if(pos+1==digits.size())
            {
                res.push_back(t);
                continue;
            }
            
            helper(digits, pos+1, t, res);
        }
    }
};
