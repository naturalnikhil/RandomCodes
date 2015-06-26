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
    void flatten(TreeNode *root) {
        
        rec(root);
    }
    
    
    TreeNode* rec(TreeNode* root)   // it will return bottom pointer
    {
        if(!root) return NULL;
        
        if(!root->left && !root->right) return root;
        
        TreeNode* rb=NULL;
        if(root->right)
        {
            rb = rec(root->right);
        }
        
        TreeNode* lb=NULL;
        if(root->left)
        {
            lb = rec(root->left);
            
            lb->right = root->right;
            root->right = root->left;
            root->left=NULL;
        }

        if(!rb) rb=lb;
        
        return rb;
    }
};
