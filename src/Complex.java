import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Complex extends JPanel {
    private Building[] buildings;

	public Complex() { //MAY NOT BE UP TO DATE COMPARED TO NUMOFBUILDINGS COMPLEX VERSION
		buildings = new Building[10];
		for(int i=0; i<buildings.length; i++) {
			buildings[i] =  new Building(Color.black, -(int)(Math.random()*600)); //makes all buildings
		}
	}

	public Complex(int numofbuildings) {
		buildings = new Building[numofbuildings];
		for(int i=0; i<buildings.length; i++) {
			buildings[i] =  new Building(Color.black, -(int)(Math.random()*600)); //makes all buildings
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		printbackgroup(g);

		

		for(int i = 0; i < buildings.length; i++) {
			buildings[i].setX(i*99); //cool math: scales it for the # of buildings (i*(1040/buildings.length))
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

	public static void selectionsort(Comparable[] arr) {
        
        for(int i = 0; i < arr.length -1; i++) {
            int minSpot = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[minSpot].compareTo(arr[j]) > 0) {
                    minSpot = j;
                }
            }
            Comparable temp = arr[i];
            arr[i] = arr[minSpot];
            arr[minSpot] = temp;
        }
    }

    public static void insertion(Integer[] arr) { //considered to be the fastest of the three sorting
        for(int i = 1; i < arr.length; i++) {
            int j = i-1;
            int mover = arr[i];
            while(j >= 0 && arr[j] > mover) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = mover;
        }
    }


    public static int binarysearch (Integer[] arr, int waldo) {
        int left = 0;
        int right = arr.length-1;
        while(right >= left) {
            int middle = (right + left)/2;
            if(arr[middle] == waldo) {
                return middle;
            }
            else if(arr[middle] > waldo) {
                right = middle -1;
            }
            else {
                left = middle +1;
            }
        }
        return -1;
    }

    /**
     * is quite efficient because it has a getout, (if perfect)
     * @param arr
     * @return
     */
    public static int bubblesort(Integer[] arr) {
        int scans = 0;
        int counter = 0;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < arr.length -1 - scans; i++) {
                counter++;
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
            scans++;
        }


        System.out.println("Efficiency:" + counter);
        return scans;
    }

}