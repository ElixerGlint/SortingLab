import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class car {
    private int x;
    private int y;

    public car() {
        x = 0;
        y = 650;
    }






    



    public void drawcar(Graphics g) {
        Color asd = new Color(200,200,200);
        g.setColor(asd);
        g.fillRect(x, y, 60, 40);
        g.setColor(Color.BLACK);
        g.fillOval(x-15, y+30, 20, 20);
        g.fillOval(x+45, y+30, 20, 20);
        Font font = new Font("Ariel", Font.PLAIN, 25);
        g.setFont(font);
        g.drawString("FBI",x,y+25);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    

}
