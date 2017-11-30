
import javax.swing.JOptionPane;
/**
 * 
 * @author aviel
 *
 */

public class Manager {
	
	private Queue<Integer>q;
	private Stack<Integer>st;
	private IntQueueStackHandler[] handlers;
	
	String menu="\n******Main-Menu******\n1 - Enqueue.\n2 - Dequeue.\n3 - Display Queue.\n4 - Push.\n5 - Pop.\n6 - Display Stack.\n7 - Exit.\n";
	
	public Manager() {
		 
			q= new Queue<Integer>();
			st= new Stack<Integer>();		
		
		
	IntQueueStackHandler handlers [] =new IntQueueStackHandler[7];
	handlers[0] = new EnqueuePushHandler(q);
	handlers[1] = new DequeuePopHandler(q);
	handlers[2] = new DisplayHandler(q);
	handlers[3] = new EnqueuePushHandler(st);
	handlers[4] = new DequeuePopHandler(st);
	handlers[5] = new DisplayHandler(st);
	handlers[6] = new ExitHandler(st);
	
	String choice=null;
	int value=0;
	while(value!=7) {
		try {
	JOptionPane.showMessageDialog(null,menu);
	choice=JOptionPane.showInputDialog(null,"please enter your choice: ");
	value=Integer.parseInt(choice);
	handlers[value-1].processRequest();
		
		}
		catch (NumberFormatException ex) {
        if (choice != null)
            JOptionPane.showMessageDialog(null, String.format("%s is not numeric, try again!", choice));
    }
      catch (ArrayIndexOutOfBoundsException e) {
    if (choice != null)
        JOptionPane.showMessageDialog(null, String.format("%s is not an option, try again!", choice));
    }
			
	}	
	
}
public static void main(String[] args) {
	Manager mngr = new Manager();
}
}
