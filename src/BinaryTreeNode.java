// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   
   /**
    * The BinaryTreeNode function is a constructor that creates a new BinaryTreeNode object.
    * 
    *
    * @param dataType d Set the data field of the node
    * @param BinaryTreeNode&lt;dataType&gt; l Set the left node to a new binarytreenode
    * @param BinaryTreeNode&lt;dataType&gt; r Set the right node of the current node
    *
    * @return A binarytreenode object
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
}
