package main.java;

import javax.swing.JFrame;

public class Main extends JFrame{
    public static void main(String[] args) {

        JFrame window = new JFrame("Practica 07");
        window.setSize(1000,600);
        window.setDefaultCloseOperation(3);
        window.setLocationRelativeTo(null);

        Screen screen = new Screen();
        screen.addKeyListener(screen);
        screen.setFocusable(true);
        
        Player player = new Player(500, 400, 1, 100, 3, 0);
        screen.setPlayer(player);

        window.add(screen);
        window.setVisible(true);

        GameLoop gameLoop = new GameLoop(screen);
        gameLoop.start();

    }
}
