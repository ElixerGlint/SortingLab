import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Complex extends JPanel {
    private Building[] buildings;

	public Complex() { //MAY NOT BE UP TO DATE COMPARED TO NUMOFBUILDINGS COMPLEX VERSION
		buildings = new Building[10];
		for(int i=0; i<buildings.length; i++) {
			buildings[i] =  new Building(Color.black, -(int)(Math.random()*600),100); //makes all buildings
		}
	}

	public Complex(int numofbuildings) {
		buildings = new Building[numofbuildings];
		for(int i=0; i<buildings.length; i++) {
			buildings[i] =  new Building(Color.black, -(int)(Math.random()*600),100); //makes all buildings
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		printbackgroup(g);

		

		for(int i = 0; i < buildings.length; i++) {
			buildings[i].setX(i*(1040/buildings.length)); //cool math: scales it for the # of buildings
			buildings[i].drawPiece(g);
		}
	}

	public void printbackgroup(Graphics g) {
		Color skyblue = new Color(135,206,235);
		g.setColor(skyblue);
		g.fillRect(0, 0, 1000, 700);
		g.setColor(Color.gray);
		g.fillRect(0, 650, 1000, 150);
		g.setColor(Color.black);
		for(int i = 0; i < 32; i++) {
			g.fillRect(30*i + 20, 700, 15, 5);
		}
	}

}