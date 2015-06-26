/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        
        vector<vector<int> > level;
        
        if(root==NULL) return level;
        
        deque<TreeNode*> Q;
        
        level.push_back(vector<int>());
        Q.push_back(root);
        Q.push_back(NULL);
        
        int i=0;
        bool flag=false, alt=true;
        
        while(!Q.empty())
        {
            TreeNode* n;
            
            if(alt)
            {
                n = Q.front();
                Q.pop_front();
            }
            else
            {
                n=Q.back();
                Q.pop_back();
            }
            
            if(n==NULL) 
            {
                if(!flag) break;
                
                flag=false;
                ++i;
                
                if(!alt) Q.push_back(NULL);
                else Q.push_front(NULL);
                
                alt = !alt;
                                
                continue;
            }
            
            if(i==level.size()) level.push_back(vector<int>());
            
            flag=true;
            level[i].push_back(n->val);
            
            if(alt)
            {
                if(n->left) Q.push_back(n->left);
                if(n->right) Q.push_back(n->right);
            }
            else
            {
                if(n->right) Q.push_front(n->right);
                if(n->left) Q.push_front(n->left);
            }
        }
        
        return level;
    }
};
