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

    void helper(TreeNode *root, int total, int& sum) {
        
        if(!root) return;
        
        if(!root->right && !root->left)
        {
            sum += total*10 + root->val;
            return;
        }
        
        if(root->left)
        {
            helper(root->left, total*10 + root->val, sum);
        }

        if(root->right)
        {
            helper(root->right, total*10 + root->val, sum);
        }
    }



    int sumNumbers(TreeNode *root) {
        
        int sum=0;
        
        helper(root,0, sum);
        
        return sum;
    }
    
};
