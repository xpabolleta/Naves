package main.java;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends JFrame{
    public static void main(String[] args) {

        JFrame ventana = new JFrame("Practica 07");
        
        Player player = new Player(50, 50, 3, 100, 3, 0);
        
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        Enemy enemy = new Enemy(500, 500, 3, 100);
        enemies.add(enemy);
        Screen screen = new Screen();
        screen.setEnemies(enemies);
        screen.setPlayer(player);

        ventana.add(screen);
        ventana.setSize(1000, 700);
        ventana.setDefaultCloseOperation(3);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        screen.run();

    }
}
