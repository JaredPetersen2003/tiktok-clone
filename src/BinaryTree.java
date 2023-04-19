import javax.swing.JTextArea;

/**
 * This class implements a Binary tree
 * 
 * @author Hussein Suleman & Jared Petersen
 * @date 26 March 2017
 */
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root = null;
   
   
   /**
    * The BinaryTree function creates a new BinaryTree object.
    * 
    * @return A reference to a binarytree object
    *
    */
   public BinaryTree ()
   {
      root = null;
   }
   
   
   /**
    * The getHeight function returns the height of a binary tree.
    * 
    * @return The height of the tree,
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   

   
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   
   /**
    * The getSize function returns the number of nodes in the tree.
    *
    * @return The number of nodes in the tree
    *
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   
   /**
    * Prints out node data
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }

   
   
   /**
    * The preOrder function prints the tree in preOrder.
    *
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }

   
   /**
    * The postOrder function traverses the tree in post-order, printing out each node's data.
    * 
    *
    *
    * @return A string of the tree in post order
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   public void inOrder ()
   {
      inOrder (root);
   }
   
   /**
    * The inOrder function traverses the tree in order, printing out each node's data.
    * 
    *
    * @param BinaryTreeNode<dataType>  node Keep track of the current node
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   
   /**
    * The inOrder function traverses the tree in order, outputting each node's data to a JTextArea
    * 
    *
    * @param BinaryTreeNode&lt<dataType> node Keep track of the current node
    * @param JTextArea output Display the data in the tree
    *
    */
   public void inOrder ( BinaryTreeNode<dataType> node, JTextArea output )
   {
      if (node != null)
      {
         inOrder (node.getLeft (), output);
      
         output.append(node.data.toString() + "\n");
         
         inOrder(node.getRight (), output);
      } 
   }

   
   /**
    * The levelOrder function prints the contents of a binary tree in level order.
    * It uses a queue to keep track of which nodes have been visited and which ones
    * still need to be visited. The root node is added to the queue first, then its 
    * left child, then its right child (if they exist). Then it moves on to the next 
    * node in line and adds that one's children (if they exist) until all nodes have been printed.  
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
