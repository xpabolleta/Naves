package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable{

    private ArrayList <Enemy> enemies;
    private ArrayList <Bullet> bullets;
    private Player player;

    public Screen(){

        setLayout(null);
        setBackground(Color.BLACK);
        
    }

    // Setters
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    // Getters
    public Player getPlayer() {
        return player;
    }
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        player.paint(g);

        if(bullets != null){
        
            for (Bullet bullet : bullets) {
        
                bullet.paint(g);
        
            }
        }

        if(enemies != null){
        
            for (Enemy enemy : enemies) {
        
                enemy.paint(g);
        
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
