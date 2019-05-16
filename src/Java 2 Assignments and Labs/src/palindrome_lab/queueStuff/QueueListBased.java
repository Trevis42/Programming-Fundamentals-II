package palindrome_lab.queueStuff;

import ListReferenceBased.ListInterface;
import ListReferenceBased.ListReferenceBased;

public class QueueListBased implements QueueInterface
{
  private ListInterface aList;

  public QueueListBased()
  {
    aList = new ListReferenceBased();
  }  // end default constructor

  // queue operations:
  public boolean isEmpty()
  {
    return aList.isEmpty();
  }  // end isEmpty

  public void enqueue(Object newItem)
  {
    aList.add(aList.size(), newItem);
  }  // end enqueue
  public Object dequeue() throws QueueException
  {
    if (!isEmpty()) {
      // queue is not empty; remove front
      Object queueFront = aList.get(0);
      aList.remove(0);
      return queueFront;
    } else {
      throw new QueueException("Queue exception on dequeue: Queue empty");
    }  // end if
  }  // end dequeue

  public void dequeueAll()
  {
    aList.removeAll();
  }  // end dequeueAll

  public Object peek() throws QueueException
  {
    if (!isEmpty()) {
      // queue is not empty; retrieve front
      return aList.get(0);
    } else {
      throw new QueueException("Queue exception on peek: Queue empty");
    }  // end if
  }  // end peek


  public String toString()
  {
	  String s = new String();
	 	for(int i = 0; i < aList.size(); i++){
			s += (aList.get(i)+" ");
		}
  	//System.out.println();
	  return s.toString();
  } // end of toString

}  // end QueueListBased
