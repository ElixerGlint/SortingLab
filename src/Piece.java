﻿import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piece extends JPanel {
    private Building[] buildings;
	private int index1;
	private int index2;
    private int sortednum;

	public Piece() { 
		buildings = new Building[10];
		for(int i=0; i<buildings.length; i++) {
			buildings[i] =  new Building(-(int)(Math.random()*600),70); //makes all buildings
		}
		index1 = -1;
		index2 = -1;
        sortednum = -1;
        for(int i = 0; i < buildings.length; i++) {
			buildings[i].setX((i*(980/buildings.length))); //cool math: scales it for the # of buildings (i*(1040/buildings.length))
        }
	}

	public Piece(int numofbuildings) {
		buildings = new Building[numofbuildings];
		for(int i=0; i<buildings.length; i++) {
			buildings[i] =  new Building(-(int)(Math.random()*600),700/buildings.length); //makes all buildings
		}
		index1 = -1;
		index2 = -1;
        sortednum = -1;
        for(int i = 0; i < buildings.length; i++) {
			buildings[i].setX((i*(980/buildings.length))); //cool math: scales it for the # of buildings (i*(1040/buildings.length))
        }
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		printbackgroup(g);

		for(int i = 0; i < buildings.length; i++) {
			
			if(i == index1 || i == index2 || i < sortednum) {
				buildings[i].drawPiece(g,Color.green);
			}
			else {
				buildings[i].drawPiece(g,Color.black);
			}
			
			
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


	/*public static void selectionsort(Comparable[] arr) {
        
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
    }*/

	/* 
    public static void insertion(Integer[] arr) { //considered to be the fastest of the three sorting ON AVG
        for(int i = 1; i < arr.length; i++) {
            int j = i-1;
            int mover = arr[i];
            while(j >= 0 && arr[j] > mover) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = mover;
        }
    }*/
	
    /*public static int binarysearch (Integer[] arr, int waldo) {
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
    }*/
    
	
    public void bubblesort() throws InterruptedException {
        int scans = 0;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < buildings.length -1 - scans; i++) {

                if(buildings[i].compareTo(buildings[i+1]) < 0) {
					index1 = i;
					index2 = i+1;
                    repaint();
                    Thread.sleep(10); //normally 500, maybe scale

                    flip(index1,index2);
                    sorted = false;
                }
            }
        }
        
        for(int i = 0; i < buildings.length + 1; i++) {
            sortednum++;
            repaint();
            Thread.sleep(10); //normally 500, maybe scale
        }
        index1 = -1;
        index2 = -1;
    }

    private void flip(int index1, int index2) throws InterruptedException {



        int building1height = buildings[index1].getHeight();
        int building2height = buildings[index2].getHeight();
        int building1x = buildings[index1].getX();
        int building2x = buildings[index2].getX();


        while(true) {
            buildings[index1].setHeight(buildings[index1].getHeight() + 10);
            Thread.sleep(100);
            repaint();
            

            if(buildings[index1].getHeight() > 0) {
                buildings[index1].setHeight(0);
                repaint();
                Thread.sleep(1000);
                break;
            }
        }
        
        while(true) { //-----------------------------ANIMATION------------------------------ANIMATION--------------------------ANIMATION-----------------------
            buildings[index2].setX(buildings[index2].getX()-10);
            System.out.println("I am stucl");
            repaint();
            Thread.sleep(100);
            if(buildings[index2].getX() < building1x) {
                buildings[index2].setX(building1x);
                break;
            }
        }



        buildings[index1].setHeight(building2height);
        buildings[index2].setHeight(building1height);
    }
}