import javax.swing.JOptionPane;

public class ExitHandler extends GeneralHandler{
	public ExitHandler(Stack<Integer> st) {
		super(st);
	}
	public void processRequest() {
		JOptionPane.showMessageDialog(null,("Good bye!!"));
		System.exit(1);
	}
	

}
