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
    vector<int> preorderTraversal(TreeNode *root) {
        
        vector<int> preorder;
        
        if(!root) return preorder;
        
        stack<TreeNode*> S;
        
        while(1)
        {
            while(root)
            {
                preorder.push_back(root->val);
                
                if(root->left)
                {
                    S.push(root);
                    root=root->left;
                }
                else break;
            }
            
            if(!root)
            {
                if(S.empty()) break;
                
                root = S.top();
                S.pop();
            }
            
            root=root->right;
        }
        
        return preorder;
    }
};
