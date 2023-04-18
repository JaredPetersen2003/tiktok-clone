/**
 * Hussein's Binary Search Tree
 * 
 * @date 27 March 2017
 * @author Hussein Suleman
*/
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
  
   /**
    * The insert function inserts a new node into the binary tree.
    * 
    *
    * @param dataType d Store the data that is to be inserted into the tree
    */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   
   /**
    * The insert function takes in a dataType object and a BinaryTreeNode<dataType> node.
    * It then compares the data of the given node to that of the root, and if it is less than or equal to 0,
    * it will insert itself into the left subtree. If not, it will insert itself into the right subtree. 
    
    *
    * @param dataType d Compare the data in the node to see if it is less than or greater than
    * @param BinaryTreeNode<dataType> node Keep track of where we are in the tree
    */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   
   /**
    * The find function searches the binary tree for a node containing the data
    * value d. If it finds such a node, it returns that node; otherwise, it
    * returns null.
    *
    * @param dataType d Find the node with that data
    *
    * @return The node with data value d
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }

   
   /**
    * The find function takes in a dataType d and BinaryTreeNode<dataType> node.
    * It then compares the data of the node to that of d, if they are equal it returns 
    * the node. If not, it checks if d is less than or greater than the data in 
    * order to determine which side of the tree to search for a match. If there is no match, null is returned.  
    
    *
    * @param dataType d Find the node that contains the data d
    * @param BinaryTreeNode<dataType> node Keep track of the current node
    *
    * @return The node containing d
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   
   /**
    * The delete function is a recursive function that takes in a dataType and the root of the tree.
    * It then searches for the node containing d, and deletes it from the tree.
    * 
    *
    * @param dataType d Determine which node to delete
    *
    * @return The root of the subtree after
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   
   /**
    * The delete function is used to delete a node from the tree.
    * 
    *
    * @param dataType d Compare the data in the node to see if it is equal
    *
    * @return The root of the tree
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   
   /**
    * The findMin function finds the minimum value in a binary search tree.
    * 
    *
    * @param  BinaryTreeNode<dataType> node Keep track of the current node
    *
    * @return The node containing the smallest value in the tree
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   
   /**
    * The removeMin function removes the minimum value from a binary search tree.
    * 
    *
    * @param BinaryTreeNode<dataType> node Keep track of the current node in the tree
    *
    * @return The node that is the left child of the
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
