import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class sortDriver {
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();

		//int amountoftowers = JOptionPane.showOptionDialog(null, "How many towers would you like", null, 0, 0, JOptionPane.QUESTION_MESSAGE, null, 10);

		String[] choices = {"Bubble Sort","Insertion Sort","Selection Sort"};
		String whichsort = (String)(JOptionPane.showInputDialog(null, "What type of sorting should the city use to make the skyline more pretty?", "Algorithm Selector",JOptionPane.QUESTION_MESSAGE,null,choices,choices[0])); 

		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JOptionPane for dialogue NO SYSOUT
		Piece table = new Piece(4);
		frame.add(table);

		frame.setVisible(true);
		Thread.sleep(1000);

		if(whichsort.equals("Bubble Sort")) {
			table.bubblesort();
		}
		
		if(whichsort.equals("Selection Sort")) {
			table.selectionsort();
		}

		if(whichsort.equals("Insertion Sort")) {
			table.insertionsort();
		}

		frame.repaint();



	}
}