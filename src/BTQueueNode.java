// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/** This class implements a Binary tree queue node
* 
* @author Hussein Suleman
* @date 26 March 2017
*/
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   
   /**
    * The BTQueueNode function is a constructor for the BTQueueNode class.
    * It takes in two parameters, one of type BinaryTreeNode and another of type BTQueueNode.
    * The function sets the node variable to be equal to n and next variable to be equal to nxt.
    
    *
    * @param BinaryTreeNode<dataType> n Set the node variable
    * @param BTQueueNode<dataType> nxt Set the next node in the queue
    *
    * @return A reference to the next node in the queue
    *
    * @docauthor Trelent
    */
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
