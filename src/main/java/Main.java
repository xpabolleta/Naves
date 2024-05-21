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
        
        Player player = new Player(0, 0, 1, 100, 1, 0);
        screen.setPlayer(player);

        Enemy enemy = new Enemy(50, 50, 1, 20);
        Enemy enemy2 = new Enemy(150, 50, 1, 20);
        Enemy enemy3 = new Enemy(200, 50, 1, 20);
        ArrayList <Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(enemy);
        enemies.add(enemy2);
        enemies.add(enemy3);
        screen.setEnemies(enemies);

        window.add(screen);
        window.setVisible(true);

        GameLoop gameLoop = new GameLoop(screen);
        gameLoop.start();

    }
}
