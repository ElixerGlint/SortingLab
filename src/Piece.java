import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piece extends JPanel {
    private Building[] buildings;
    private int index1;
    private int index2;
    private int sortednum;
    private car destroyer;
    private data d;

    /**
     * default constructor
     */
    public Piece() {
        buildings = new Building[10];
        for (int i = 0; i < buildings.length; i++) {
            buildings[i] = new Building(-(int) (Math.random() * 600), 70); // makes all buildings
        }
        index1 = -1;
        index2 = -1;
        sortednum = -1;
        for (int i = 0; i < buildings.length; i++) {
            buildings[i].setX((i * (980 / buildings.length))); // cool math: scales it for the # of buildings (i*(1040/buildings.length))
        }
        destroyer = new car();
        d = new data();
    }

    /**
     * full param constructor
     * @param numofbuildings the number of buildings
     */
    public Piece(int numofbuildings) {
        buildings = new Building[numofbuildings];
        for (int i = 0; i < buildings.length; i++) {
            buildings[i] = new Building(-(int) (Math.random() * 600), 700 / buildings.length); // makes all buildings
        }
        index1 = -1;
        index2 = -1;
        sortednum = -1;
        for (int i = 0; i < buildings.length; i++) {
            buildings[i].setX((i * (980 / buildings.length))); // cool math: scales it for the # of buildings (i*(1040/buildings.length))
        }
        destroyer = new car();
        d = new data();
    }

    /**
     * The master print function, is called every time it is repainted
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        printbackgroup(g);

        destroyer.drawcar(g);

        for (int i = 0; i < buildings.length; i++) {

            if (i == index1 || i == index2 || i < sortednum) {
                buildings[i].drawPiece(g, Color.green);
            } else {
                buildings[i].drawPiece(g, Color.black);
            }

        }

        d.printdata(g);
    }

    /**
     * This prints the background, every time
     * @param g the graphics driver
     */
    public void printbackgroup(Graphics g) {
        Color skyblue = new Color(135, 206, 235);
        g.setColor(skyblue);
        g.fillRect(0, 0, 1000, 700);
        g.setColor(Color.gray);
        g.fillRect(0, 650, 1000, 150);
        g.setColor(Color.black);
        for (int i = 0; i < 32; i++) {
            g.fillRect(30 * i + 20, 700, 15, 5);
        }
    }

    /**
     * This does the selection sort on the buildings
     * @throws InterruptedException for the thread.pause
     */
    public void selectionsort() throws InterruptedException {
        for (int i = 0; i < buildings.length; i++) {
            int minspot = i;
            for (int j = i; j < buildings.length; j++) {
                destroyer.setX(buildings[i].getX());
                repaint();
                Thread.sleep(100);
                // ----------------------------------------------------------
                d.setAccessed(d.getAccessed()+2); //+=2
                if (buildings[minspot].compareTo(buildings[j]) < 0) {
                    minspot = j;
                }
            }

            index1 = i;
            index2 = minspot;

            d.setAccessed(d.getAccessed()+2);
            d.setMutated(d.getMutated()+2);
            
            repaint();
            flip(index1, index2);
        }

        for (int i = 0; i < buildings.length + 1; i++) {
            sortednum++;
            repaint();
            Thread.sleep(50); // normally 500, maybe scale
        }
        index1 = -1;
        index2 = -1;
    }

    /**
     * This is only for when im making it go backwards, i wanted it to go fast so i removed all the pauses.
     * This function pairs with flipnopause
     * @throws InterruptedException 
     */
    public void selectionsortnopause() throws InterruptedException {
        for (int i = 0; i < buildings.length; i++) {
            int minspot = i;
            for (int j = i; j < buildings.length; j++) {
                destroyer.setX(buildings[i].getX());
                repaint();
                // ----------------------------------------------------------
                d.setAccessed(d.getAccessed()+2); //+=2
                if (buildings[minspot].compareTo(buildings[j]) < 0) {
                    minspot = j;
                }
            }

            index1 = i;
            index2 = minspot;

            d.setAccessed(d.getAccessed()+2);
            d.setMutated(d.getMutated()+2);
            
            repaint();
            flipnopause(index1, index2);
        }

        index1 = -1;
        index2 = -1;
    }

    /**
     * This is the insertion sort for the buildings
     * @throws InterruptedException for thread.sleep
     */
    public void insertionsort() throws InterruptedException { // considered to be the fastest of the three sorting ON AVG

        for (int i = 1; i < buildings.length; i++) {
            int j = i-1;
            int mover = buildings[i].getHeight();
            destroyer.setX(buildings[i].getX());
            repaint();
            Thread.sleep(1000);
            while(j >= 0 && buildings[j].getHeight() < mover) {
                d.setAccessed(d.getAccessed()+1);
                index1 = j+1;
                index2 = j;
                d.setMutated(d.getMutated()+2);
                d.setAccessed(d.getAccessed()+2);
                flip(index1, index2);
                j--;
            }
            // ----------------------------------------------------------

        }

        for (int i = 0; i < buildings.length + 1; i++) {
            sortednum++;
            repaint();
            Thread.sleep(50); // normally 500, maybe scale
        }
        index1 = -1;
        index2 = -1;
    }

    /**
     * This bubble sorts the buildings
     * @throws InterruptedException for thread.sleep
     */
    public void bubblesort() throws InterruptedException {
        int scans = 0;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;

            for (int i = 0; i < buildings.length - 1 - scans; i++) {
                destroyer.setX(buildings[i].getX());
                repaint();
                Thread.sleep(1000);

                // ----------------------------------------------------------
                d.setAccessed(d.getAccessed()+2);
                if (buildings[i].compareTo(buildings[i + 1]) < 0) {
                    index1 = i;
                    index2 = i + 1;
                    repaint();

                    d.setAccessed(d.getAccessed()+2);
                    d.setMutated(d.getMutated()+2);
                    flip(index1, index2);
                    sorted = false;
                }
            }
        }

        for (int i = 0; i < buildings.length + 1; i++) {
            sortednum++;
            repaint();
            Thread.sleep(50); // normally 500, maybe scale
        }
        index1 = -1;
        index2 = -1;
        // System.out.println(accessed);
        // System.out.println(mutated);
    }

    /**
     * This is my master flip function, which is called from all of my sorts
     * @param index1 the first index to be flipped
     * @param index2 the second index to be flipped
     * @throws InterruptedException for thread.sleep
     */
    private void flip(int index1, int index2) throws InterruptedException { // this flips two buildings.
        int building1height = buildings[index1].getHeight();
        int building2height = buildings[index2].getHeight();
        int building1x = buildings[index1].getX();
        int building2x = buildings[index2].getX();

        Graphics g = this.getGraphics();

        if (index1 == -1) {
            destroyer.setX(0);
        } else { // moving animation here
            destroyer.setX(buildings[index1].getX());
        }

        while (true) {
            buildings[index1].setHeight(buildings[index1].getHeight() + 10); // left down
            Thread.sleep(10);
            repaint();

            if (buildings[index1].getHeight() > 0) {
                buildings[index1].setHeight(0);
                repaint();
                Thread.sleep(100);
                break;
            }
        }

        if (index2 == -1) {
            destroyer.setX(0);
        } else { // moving animation here
            destroyer.setX(buildings[index2].getX());
        }
        while (true) {
            buildings[index2].setHeight(buildings[index2].getHeight() + 10); // right down
            Thread.sleep(10);
            repaint();

            if (buildings[index2].getHeight() > 0) {
                buildings[index2].setHeight(0);
                repaint();
                Thread.sleep(100);
                break;
            }
        }

        buildings[index1].setX(building2x);
        buildings[index2].setX(building1x);

        while (true) {
            buildings[index1].setHeight(buildings[index1].getHeight() - 10);
            repaint();
            Thread.sleep(10);
            if (buildings[index1].getHeight() < building1height) {
                buildings[index1].setHeight(building1height);
                break;
            }
        }

        while (true) {
            buildings[index2].setHeight(buildings[index2].getHeight() - 10);
            repaint();

            Thread.sleep(10);
            if (buildings[index2].getHeight() < building2height) {
                buildings[index2].setHeight(building2height);
                break;
            }
        }

        buildings[index1].setX(building1x);
        buildings[index2].setX(building2x);
        buildings[index1].setHeight(building2height);
        buildings[index2].setHeight(building1height);
    }

    /**
     * pairs with selectionsortnopause-- for explanation open it
     * @param index1 index1
     * @param index2 index2
     * @throws InterruptedException 
     */
    private void flipnopause(int index1, int index2) throws InterruptedException { // this flips two buildings.

        int building1height = buildings[index1].getHeight();
        int building2height = buildings[index2].getHeight();
        int building1x = buildings[index1].getX();
        int building2x = buildings[index2].getX();

        Graphics g = this.getGraphics();

        if (index1 == -1) {
            destroyer.setX(0);
        } else { // moving animation here
            destroyer.setX(buildings[index1].getX());
        }

        while (true) {
            buildings[index1].setHeight(buildings[index1].getHeight() + 10); // left down
            repaint();

            if (buildings[index1].getHeight() > 0) {
                buildings[index1].setHeight(0);
                repaint();
                break;
            }
        }

        if (index2 == -1) {
            destroyer.setX(0);
        } else { // moving animation here
            destroyer.setX(buildings[index2].getX());
        }
        while (true) {
            buildings[index2].setHeight(buildings[index2].getHeight() + 10); // right down
      
            repaint();

            if (buildings[index2].getHeight() > 0) {
                buildings[index2].setHeight(0);
                repaint();
             
                break;
            }
        }

        buildings[index1].setX(building2x);
        buildings[index2].setX(building1x);

        while (true) {
            buildings[index1].setHeight(buildings[index1].getHeight() - 10);
            repaint();
    
            if (buildings[index1].getHeight() < building1height) {
                buildings[index1].setHeight(building1height);
                break;
            }
        }

        while (true) {
            buildings[index2].setHeight(buildings[index2].getHeight() - 10);
            repaint();

         
            if (buildings[index2].getHeight() < building2height) {
                buildings[index2].setHeight(building2height);
                break;
            }
        }

        buildings[index1].setX(building1x);
        buildings[index2].setX(building2x);
        buildings[index1].setHeight(building2height);
        buildings[index2].setHeight(building1height);
    }
  
    /**
     * This is for making the buildings go backwards, it sorts them then calls this function to flip them the other way
     */
    public void flipallbuildings() {
        for(int i = 0; i < buildings.length/2; i++) {
            int count = buildings.length-1-i;
            int temp = buildings[i].getHeight();
            buildings[i].setHeight(buildings[count].getHeight());
            buildings[count].setHeight(temp);
        }
        index1 = -1;
        index2 = -1;
        sortednum = 0;
    }

    //getters and setters
    public data getD() {
        return d;
    }

    public void setD(data d) {
        this.d = d;
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }

    public car getDestroyer() {
        return destroyer;
    }

    public void setDestroyer(car destroyer) {
        this.destroyer = destroyer;
    }

    
    
}