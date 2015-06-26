public class LRUCache {
    
    class Node{
        
        int key,value;
        Node next,prev;
        
        public Node(int k, int val, Node p, Node n)
        {
            key=k;
            value=val;
            next=n;
            prev=p;
        }
    };
    
    int capacity;
    
    Node head,tail;
    
    Map<Integer,Node> map = new HashMap<Integer,Node>();
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        head=null;
        tail=null;
        
    }
    
    public int get(int key) {
        
        // if key present here
        if(map.containsKey(key))
        {
            Node t = map.get(key);
            
            updateRank(t);
            
            return t.value;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        
        // if key present
        if(map.containsKey(key))
        {
            Node t = map.get(key);
            t.value=value;
            updateRank(t);
        }
        else
        {
            // if cache is full
            if(map.size()==capacity)
            {
                map.remove(tail.key);
                
                if(head==tail)
                {
                    // only one node
                    head=null;
                    tail=null;
                }
                else
                {
                    // free tail
                    tail=tail.prev;
                    tail.next=null;
                }
            }
            
            // new node
            Node n = new Node(key,value,null,null);
            n.next=head;
            if(head!=null) head.prev=n;
            head=n;
            
            // if first node
            if(tail==null) tail=head;
            
            map.put(key,n);
        }
    }
    
    
    private void updateRank(Node t)
    {
        // if node is head
        if(t==head) return;
        
        // if node is tail
        if(t.next==null)
        {
            t.prev.next=null;
            tail=t.prev;
        }
        
        // else node is in middle
        else
        {
            Node next = t.next;
            t.prev.next=next;
            next.prev=t.prev;
        }   
        
        t.prev=null;
        t.next=head;
        head.prev=t;
        head=t;
    }
    
}








