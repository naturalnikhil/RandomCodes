/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:

    unordered_map<int,UndirectedGraphNode*> map;
    
    unordered_map<int,bool> visited;



    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        
     if(node==NULL) return node;
     
     UndirectedGraphNode* newHead=NULL;
     
     queue<UndirectedGraphNode*> Q;
     Q.push(node);
     
     
     // Do it BFS wise
     while(!Q.empty())
     {
         // take out first node in queue
         UndirectedGraphNode* oldNode = Q.front();
         Q.pop();
         
         if(visited[oldNode->label]) continue;
         
         // clone this node
         UndirectedGraphNode* newNode = nodePtr(oldNode->label);
         
         // set root ptr
         if(newHead==NULL) newHead=newNode;
         
         // mark it visited
         visited[oldNode->label]=true;

         // clone all the neighbors of this node
         for(int i=0; i<oldNode->neighbors.size(); ++i)
         {
             UndirectedGraphNode* temp = oldNode->neighbors[i];
             
             UndirectedGraphNode* htemp = nodePtr(temp->label);
             
             newNode->neighbors.push_back(htemp);
             //htemp->neighbors.push_back(newNode);
             
             if(visited[temp->label]==false)
             {
                 Q.push(temp);
             }
         }
     }
    
     return newHead;
    }
    
    
    UndirectedGraphNode* nodePtr(int label)
    {
        unordered_map<int,UndirectedGraphNode*>::iterator it;
        
        if((it=map.find(label))!= map.end())
        {
            // new node already created for this
            return it->second;
        }
        else
        {
            // create new node; insert into map and return
            UndirectedGraphNode* newNode = new UndirectedGraphNode(label);
            map[label]=newNode;
            visited[label]=false;
            return newNode;
        }
    }
    
};
