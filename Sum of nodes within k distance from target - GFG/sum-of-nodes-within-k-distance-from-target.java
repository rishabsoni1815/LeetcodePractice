// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class solver{
    static int sum_at_distK(Node root, int t, int k){
        int ans=0;
        HashSet<Integer>jj=new HashSet<>();
        if(root==null) return ans;
           Map<Node, Node> parent = new HashMap<>();
           dfs(root,null,parent);
           int c=0;
          Node target= find(root,t);
        Queue<Node>q=new LinkedList<>();
        HashSet<Node>h=new HashSet<>();
        h.add(target);
        q.add(target);
        while(q.size()>0){
            int s=q.size();
            if(c<=k){
                for(Node r:q){
                    jj.add(r.data);
                }
            }else{
                break;
            }
            for(int i=0;i<s;i++){
                Node temp=q.poll();
                h.add(temp);
                if(temp.left!=null&&(h.contains(temp.left)==false)) q.add(temp.left);
                if(temp.right!=null&&(h.contains(temp.right)==false)) q.add(temp.right);
                if(parent.get(temp)!=null&&(h.contains(parent.get(temp))==false)) q.add(parent.get(temp));
            }
            c++;
        }
        // System.out.println(jj);
        for(int y:jj) ans+=y;
        return ans;
    }
  static void dfs(Node node, Node par,Map<Node, Node> parent) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node,parent);
            dfs(node.right, node,parent);
        }
    }
   static Node find(Node root,int t){
        if(root==null) return null;
        if(root.data==t) return root;
        Node l=find(root.left,t);
        Node r=find(root.right,t);
        if(l!=null) return l;
        return r;
    }
}

