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
    TreeNode *sortedArrayToBST(vector<int> &num) {
        
        return helper(num, 0, num.size()-1);
    }
    
    TreeNode* helper(vector<int>& num, int start,int end)
    {
        if(start>end) return NULL;
        
        if(start==end) return new TreeNode(num[start]);
        
        int mid = start + (end-start)/2;
        
        TreeNode* l = helper(num,start,mid-1);
        TreeNode* r = helper(num,mid+1,end);
        
        TreeNode* root = new TreeNode(num[mid]);
        root->left=l;
        root->right=r;
        
        return root;
    }
};
