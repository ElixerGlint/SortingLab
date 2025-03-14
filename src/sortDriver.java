import javax.swing.JFrame;

public class sortDriver {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JOptionPane for dialogue NO SYSOUT
		Complex table = new Complex();
		frame.add(table);
		frame.setVisible(true);
        
	}



}