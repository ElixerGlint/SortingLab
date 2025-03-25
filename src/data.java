import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class data {
    private int accessed;
    private int mutated;


    public data () {
        accessed = 0;
        mutated = 0;
    }



    public void printdata(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 20)); //URL
		g.setColor(Color.white); 
        g.drawString("Acessed: " + accessed, 0, 20);
        g.drawString("Mutated: " + mutated, 0, 40);
    }



    public int getAccessed() {
        return accessed;
    }

    public void setAccessed(int accessed) {
        this.accessed = accessed;
    }

    public int getMutated() {
        return mutated;
    }

    public void setMutated(int mutated) {
        this.mutated = mutated;
    }

}
