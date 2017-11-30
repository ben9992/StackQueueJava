

class ListElement<T> {
	
	private T val;
	private ListElement <T>prev;
	private ListElement <T>next;
	
	
	public ListElement() {//constructor 1
		this(null,null,null);
	}
	
	public ListElement(T val) {//constructor 2
		this(val,null,null);
	}
	
	public ListElement(T val,ListElement<T> next) {//constructor 3
		this(val,next,null);
	}
	public ListElement(T val,ListElement<T> next,ListElement<T> prev) {//constructor 4
		this.val=val;
		this.prev=prev;
		this.next=next;
	}
	public T getVal() {
		return val;
	}
	public ListElement<T> getNext() {
		return next;
	}

	public ListElement<T> getPrev() {
		return prev;
	}
	
	public void setNext(ListElement<T> next) {
		this.next = next;
	}
	
	public void setPrev(ListElement<T> prev) {
		this.prev = prev;
	}
	public String toString() {
		return ""+val;
	}
	
}

/**
 * This Class implements the state and behaviour of basic doubly linked list infrastructure.
 *  It is now implemented as a Generic Class. Notice: as infrastructural class, this class does not have any outputs to the user. 
 *  Hence, we remove all the "System.out" messages from this class and remove the "display" method. Instead, we provide "toString" method, which returns a string with ALL string representation of its members (invokes the toString metod of every ListElement object).
 * @author aviel
 *
 * @param <T>
 */



public class DDLinkedList<T>{
	
	private ListElement<T> head;
	private ListElement<T> tail;
	
/**
 * Add an element to the head of the list
 * @param val  the generic-type value to be added to the head of the list
 */
	protected void addToHead(T val) {
		ListElement<T> element=new ListElement<T>(val,head,null);
		if(head!=null)
			head.setPrev(element);
		else 
			tail=element;
			head=element;
	}
	/**
	 * Add an element to the tail of the list
	 * @param val the generic-type value to be added to the tail of the list
	 */
		protected void addToTail(T val) {
		ListElement<T> element=new ListElement<T>(val,null,tail);
		if(head!=null) {
			tail.setNext(element);
			tail=element;
		}
		else 
		{
			head=element;
			tail=element;
		}
	}
/**
 * Removes an element from the head of the list
 * @return the generic-type value of the element removed, or null if the list is empty. Recall, generic types can be instansiated only by "reference types" and not "primitive types".
 *  Hence, an empty list is marked by null.
 */
		protected T removeFromHead() {
		if(head==null)return null;// if list is empty
		ListElement<T> tmp = new ListElement<T>();
		tmp=head;
		head=head.getNext();
		if(head==null)tail=null;
		else
			head.setPrev(null);
		return tmp.getVal();
		
	}
		/**
		 * Removes an element from the tail of the list
		 * @return the geneic-type value of the element removed, or -1 if the list is empty. Recall, generic types can be instansiated only by "reference types" and not "primitive types". 
		 * Hence, an empty list is marked by null.
		 */
     	protected T removeFromTail() {
     		if(tail==null) return null;
     		ListElement<T> tmp=new ListElement<T>();
     		tmp=tail;
     		tail=tail.getPrev();
     		if(tail==null)
     			head=null;
     		else
     			tail.setNext(null);
     		return tmp.getVal();
 
  
	}
     	/**
     	 * Add an already allocated element to the list, before a given element.
     	 * @param newElm  the allocated element to be added to the generic-type list
     	 * @param beforeElm  the existing element (in the generic-type list) to add newElm before it. 
     	 * If beforeElm == null, means add after tail
     	 */
     	protected void addElm(ListElement<T> newElm, ListElement<T> beforeElm) {
     	if(beforeElm==null) {
     		addToTail(newElm.getVal());
     		return;
     	}
     		if(beforeElm==head) {
     			addToHead(newElm.getVal());
    			return;
     		}
     		
     	
     	newElm.setNext(beforeElm);
     	newElm.setPrev(beforeElm.getPrev());
     	beforeElm.getPrev().setNext(newElm);
     	beforeElm.setPrev(newElm);
     	
     	}
     	/**
     	 * Notice: as infrastructural class, this class does not have any outputs to the user. Hence, we remove all the "System.out" messages from this class and remove the "display" method.
     	 *  Instead, we provide "toString" method, which returns a string with ALL string representation of its members (invokes the toString metod of every ListElement object).
     	 *   This method can be called directly (or implicitly in the context of String operations) by the user of this class.
     	 *   @overrides toString in class java.lang.Object
     	 */
    	public String toString() {
    		String contents = "";
    		ListElement<T> tmp = head;
    		while(tmp!=null) {
    			contents+=tmp + " ";
    			tmp=tmp.getNext();
    		}
    		return contents; 
    	}

 
   /**
    * Indicates whether or not the list is empty.
    * @return true if the list is empty; otherwise, false.
    */
    		public boolean isEmpty() {
    			if(head==null&&tail==null)
    				return true;
    			return false;
    		}
}
     	