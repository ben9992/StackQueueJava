import javax.swing.JOptionPane;

/**
 * This Class inherits from the abstract class "GeneralHandler" - it defines two overloaded constructors, in order to match the overloaded constructors in "GeneralHandler" class.
 *  Each of these constructors simply invokes the appropriate "super" (super class constructor) constructor and pass it the corresponding reference to Integer Queue/Stack respectively. It then implements "processRequest" to Pop/Dequeue an item from Stack/Queue respectively. 
 * Then present it on a GUI message dialog.
 * @author aviel
 *
 */

public class DequeuePopHandler extends GeneralHandler {
	
	
	/**
	 * DequeuePopHandler constructor, initializes a new DequeuePopHandler with a reference to a Queue of Integers (the Stack reference will be initialized to null by default) - passed via the super constructor.
	 * @param intQ reference to the Queue of Integers
	 */
		public DequeuePopHandler(Queue<Integer> intQ) {
			super(intQ);
					operation="Dequeue";
					typeName="Queue";
			}
		/**
		 * DequeuePopHandler overloaded constructor, initializes a new DequeuePopHandler with a reference to a Stack of Integers (the Queue reference will be initialized to null by default) - passed via the super constructor.
		 * @param intSt  reference to the Stack of Integers
		 */
		
		
		public DequeuePopHandler(Stack<Integer> intSt)
		{
			super(intSt);
			operation="Pop";
			typeName="Stack";
		}
		
	/**
	 * This method implements the abstract method "processRequest", inherited from GeneralHandler class. This method Dequeue/Pop an item from the Queue/Stack respectively, and presents it on via showMessageDialog method of JOptionPane.
	 *  If the examined Queue/Stack is empty, issues an appropriate message to the user showInputDialog method of JOptionPane Java swing class (input dialog GUI). Likewise, ALL user messages are performed via showMessageDialog method of JOptionPane Java swing class (message dialog GUI).
	 */
		
		public void processRequest()
		{
			
				if(intQ!=null) {
					if(intQ.isEmpty()==true)
						JOptionPane.showMessageDialog(null,String.format("%s is empty!!!",typeName));
					else 	
				JOptionPane.showMessageDialog(null,String.format("The value %s from %s is:%d",operation,typeName,intQ.dequeue()));
			}
			
				else {
					if(intSt!=null) {
						if(intSt.isEmpty()==true)
							JOptionPane.showMessageDialog(null,String.format("%s is empty!!!",typeName));
						else 
		
							JOptionPane.showMessageDialog(null,String.format("The value %s from %s is:%d",operation,typeName,intSt.pop()));
				}
			
			}
				

		}
}
	




