//Binary Search tree to store user accounts 

public class UserTree{

    public class Node{
        String key;
        Node left;
        Node right;

        public Node(String key){
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    public UserTree(){
        root = null;   
    }

    public void visit(Node node){
        System.out.println(node.key);
    }

    public void inOrderTraversal(Node node){
        if (node != null)
        {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    
    public void insert(String key){
        if (root == null)
            root = new Node(key);
        else
            insert(key, root);

    }

    private void insert(String key, Node node){

        if(key.compareTo(node.key) <= 0){
            if(node.left == null)
                node.left = new Node(key);
            else
                insert(key, node.left);
        }
        else{
            if(node.right == null)
                node.right = new Node(key);
            else 
                insert(key, node.right);
        }
    }

   
}