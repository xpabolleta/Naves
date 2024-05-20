package main.java;

import java.util.ArrayList;

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
        
        Player player = new Player(0, 0, 1, 100, 3, 0);
        screen.setPlayer(player);

        Enemy enemy = new Enemy(50, 50, 1, 100);
        Enemy enemy2 = new Enemy(150, 50, 1, 100);
        ArrayList <Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(enemy);
        enemies.add(enemy2);
        screen.setEnemies(enemies);

        window.add(screen);
        window.setVisible(true);

        GameLoop gameLoop = new GameLoop(screen);
        gameLoop.start();

    }
}
