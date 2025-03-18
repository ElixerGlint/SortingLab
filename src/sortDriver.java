import javax.swing.JFrame;

public class sortDriver {
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JOptionPane for dialogue NO SYSOUT
		Piece table = new Piece(60);
		frame.add(table);

		frame.setVisible(true);
		Thread.sleep(1000);
        table.bubblesort();
		frame.repaint();

	}



}