// ********************************************************
// Reference-based implementation of the ADT Sorted List.
// *********************************************************
 /**
 * class SortedListReferenceBased
 *
 *    A class that implements the SortedListInterface using a linked list
 *
 */

public class ListReferenceBased implements ListInterface
{
	private Node head;
  	private int numItems;  // number of items in list


  	public ListReferenceBased()
  	// creates an empty list
  	{
		head = null;
		numItems = 0;
  	}  // end default constructor

  	public boolean isEmpty()
  	// Determines whether a list is empty
  	{
		//YOUR CODE GOES HERE.
//  		if(head.equals(null))
//  			return true;
		return numItems == 0;
  	} // end isEmpty

  	public int size()
  	// Returns the number of items that are in a list
  	{
		//YOUR CODE GOES HERE.
		return numItems;
  	}  // end size

    private Node find(int index)
    {
    // --------------------------------------------------
    // Locates a specified node in a linked list.
    // Precondition: index is the number of the desired node.
    // Assumes that 1 <= index <= numItems+1
    // Postcondition: Returns a reference to the desired node.
    // --------------------------------------------------
    	Node curr = head;
    	for (int skip = 0; skip < index; skip++) {
			curr = curr.getNext();
		} // end for
		return curr;
	} // end find


  public Object get(int index)
                throws ListIndexOutOfBoundsException {
    if (index >= 0 && index < numItems) {
      // get reference to node, then data in node
      Node curr = find(index);
//      Object dataItem = curr.getItem();
      return curr.getItem();
    }
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
    } // end if
  } // end get

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException {
    if (index >= 0 && index <= numItems) {
      if (index == 0) {
        // insert the new node containing item at
        // beginning of list
	  	//YOUR CODE GOES HERE.
    	  Node newNode =  new Node(item, head);
    	  head = newNode;
      }
      else {
        Node prev = find(index-1);
        // insert the new node containing item after
        // the node that prev references
		//YOUR CODE GOES HERE.
        Node newNode = new Node(item, prev.getNext());
        prev.setNext(newNode);
      } // end if
      numItems++;
    }
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on add");
    } // end if
  }  // end add

  public void remove(int index)
                     throws ListIndexOutOfBoundsException {
    if (index >= 0 && index < numItems) {
      if (index == 0) {
        // delete the first node from the list
		//YOUR CODE GOES HERE.
    	  head = head.getNext();
      }
      else {
		//YOUR CODE GOES HERE.
    	  Node prev = find(index - 1);
    	  Node curr = prev.getNext();
    	  prev.setNext(curr.getNext());
      } // end if
      numItems--;
    } // end if
    else {
      throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
    } // end if
  }   // end remove

  public void removeAll() {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage
    // collection
	//YOUR CODE GOES HERE.
	  head = null;
	  numItems = 0;
  } // end removeAll


  public String toString()
  {
	//YOUR CODE GOES HERE.
	  String s = " ";
	  Node curr = head;
	  while(curr != null)
	  {
		  s += (curr.getItem() + " ");
		  curr = curr.getNext();
	  }
	return s;
  }


}  // end SortedListReferenceBased


