import javax.swing.JFrame;
import javax.swing.JOptionPane;

//This is my driver

public class sortDriver {
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();

		String[] choices = {"Bubble Sort","Insertion Sort","Selection Sort"};
		String whichsort = (String)(JOptionPane.showInputDialog(null, "What type of sorting should the city use to make the skyline more pretty?", "Algorithm Selector",JOptionPane.QUESTION_MESSAGE,null,choices,choices[0])); 

		String[] choices1 = {"Random","Backwards"};
		String mixtype = (String)(JOptionPane.showInputDialog(null, "How would you like the city to initially be?", "City Selector",JOptionPane.QUESTION_MESSAGE,null,choices1,choices1[0])); 
		
		String[] choices2 = {"10","2","3","4","5","6","7","8","9","15","20","25","30"};
		String amountofbuild = (String)(JOptionPane.showInputDialog(null, "How many buildings would you like?", "City Selector",JOptionPane.QUESTION_MESSAGE,null,choices2,choices2[0])); 
		

		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JOptionPane for dialogue NO SYSOUT
		Piece table = new Piece(Integer.valueOf(amountofbuild));

		if(mixtype.equals("Backwards")) {
			table.selectionsortnopause();
			table.flipallbuildings();

			table.getD().setAccessed(0);
			table.getD().setMutated(0);
		}

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
		table.getDestroyer().setX(-200);
		frame.repaint();

	}
}