/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
                queue<TreeLinkNode*> Q;
        Q.push(root);
        Q.push(NULL);
        
        int i=0;
        bool flag=false;
        TreeLinkNode* prev=NULL;
        
        while(!Q.empty())
        {
            TreeLinkNode* n = Q.front();
            Q.pop();
            
            if(n==NULL) 
            {
                if(!flag) break;
                
                flag=false;
                ++i;
                Q.push(NULL);
                prev=NULL;
                continue;
            }
            
            flag=true;

            if(prev!=NULL) prev->next=n;
            prev=n;
            
            if(n->left) Q.push(n->left);
            if(n->right) Q.push(n->right);
        }

    }
};
