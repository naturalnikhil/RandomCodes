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
    bool isValidBST(TreeNode *root) {
        
        if(!root) return true;
        
        bool flag=true;
        helper(root,flag);
        
        return flag;
    }
    
    pair<int,int> helper(TreeNode* root, bool& isBST)  // min & max
    {
        if(!isBST) return pair<int,int>(0,0);
        
        int xmin = root->val, xmax=root->val;

        if(root->left)
        {
            pair<int,int> p = helper(root->left,isBST);
            
            xmin = std::min(xmin,p.first);
            xmax = std::max(xmax,p.second);
            
            if(!isBST || root->val <= p.second) 
            {
                isBST=false;
                return pair<int,int>(0,0);
            }
        }

        if(root->right)
        {
            pair<int,int> p = helper(root->right, isBST);
            
            xmin = std::min(xmin,p.first);
            xmax = std::max(xmax,p.second);
            
            if(!isBST || root->val >= p.first) 
            {
                isBST=false;
                return pair<int,int>(0,0);
            }
        }

        return pair<int,int>(xmin,xmax);
    }
};
