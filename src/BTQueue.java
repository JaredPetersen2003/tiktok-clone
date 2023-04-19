// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**
 * This class implements a Binary tree queue
 * 
 * @author Hussein Suleman & Jared Petersen
 * @date 26 March 2017
 */
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
      
   
   /**
    * The BTQueue function adds a new node to the end of the queue.
    * 
    *
    *
    * @return A reference to a new btqueue object
    */
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   
   /**
    * The getNext function returns the next node in the queue.
    *
    *
    * @return The next node in the queue
    *
    */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   
   /**
    * The enQueue function adds a node to the end of the queue.
    * 
    *
    * @paramBinaryTreeNode<dataType> node Store the node that is being added to the queue
    *
    */
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
