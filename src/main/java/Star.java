package main.java;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Star extends JPanel{
    private int positionx;
    private int positiony;
    private int diameter;
    private int speed;
    private long now;
    private long last;

    public Star(){

    }
    public Star(int positionx, int positiony, int diameter, int speed){
        this.positionx = positionx;
        this.positiony = positiony;
        this.diameter = diameter;
        this.speed = speed;
        this.now = System.currentTimeMillis();
        this.last = System.currentTimeMillis();
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
    public void setdiameter(int diameter) {
        this.diameter = diameter;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPositionx() {
        return positionx;
    }
    public int getPositiony() {
        return positiony;
    }
    public int getdiameter() {
        return diameter;
    }
    public int getSpeed() {
        return speed;
    }

    public void update(){
        now = System.currentTimeMillis();
        if(now - last > speed){
            setPositiony(positiony + 3);
        }
        last = now;
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillOval(positionx, positiony, diameter, diameter);
    }

}
