package main.java;

import javax.swing.JFrame;

public class Screen extends JFrame{

    public Screen(){
    
    }
    public Screen(int width, int height){
        setSize(width,height);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }
}
