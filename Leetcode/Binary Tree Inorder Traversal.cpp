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
    vector<int> inorderTraversal(TreeNode *root) {
        
        vector<int> inorder;
        
        if(!root) return inorder;
        
        stack<TreeNode*> S;
        
        while(1)
        {
            while(root && root->left)
            {
                S.push(root);
                root=root->left;
            }
            
            if(!root)
            {
                if(S.empty()) break;
                
                root = S.top();
                S.pop();
            }
            
            inorder.push_back(root->val);
            
            root=root->right;
            
        };
        
        return inorder;
    }
};
