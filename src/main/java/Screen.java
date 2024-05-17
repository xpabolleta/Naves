package main.java;

import java.awt.Color;

import javax.swing.JFrame;

public class Screen extends JFrame implements Runnable{

    public Screen(){
    
    }
    public Screen(int width, int height){

        Color color = new Color(0,0,0);
        setSize(width,height);
        setBackground(color);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

    }

    @Override

    public void run(){
        
    }
}
