class Solution {
    
    vector<vector<char> >* board;
    string* word;
    
public:
    bool exist(vector<vector<char> > &board2, string word2) {
        
        this->board=&board2;
        this->word=&word2;
        
        for(int i=0;i<board->size();++i)
        {
            for(int j=0;j<(*board)[i].size();++j)
            {
                if((*board)[i][j]==(*word)[0])
                {
                    (*board)[i][j]='\0';
                    
                    if(helper(i,j,1)) return true;
                    
                    (*board)[i][j]=(*word)[0];
                }
            }
        }
        
        return false;
    }
    
    
    bool helper(int i, int j, int pos)
    {
        if(pos==word->size()) return true;
        
        // i+1 , j
        if(i+1<board->size() && helper2(i+1, j, pos)) return true;

        // i, j+1
        else if(j+1<(*board)[i].size() && helper2(i, j+1, pos)) return true;

        // i-1, j
        else if(i-1>=0 && helper2(i-1, j, pos)) return true;

        // i, j-1
        else if(j-1>=0 && helper2(i, j-1, pos)) return true;

        return false;
    }
    
    
    bool helper2(int i, int j, int pos)
    {
        char ch;

        if((*board)[i][j]==(*word)[pos])
        {
            ch=(*board)[i][j];
            (*board)[i][j]='\0';
            if(helper(i, j,pos+1)) return true;
            (*board)[i][j]=ch;
        }
        
        return false;
    }
};
