package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import main.java.Bullet.BulletCreator;

public class Screen extends JPanel implements KeyListener, BulletCreator{

    private final int ARRIBA = 38;
    private final int ABAJO = 40;
    private final int IZQUIERDA = 37;
    private final int DERECHA = 39;
    private final int ESPACIO = 32;
    private ArrayList <Enemy> enemies;
    private ArrayList <Bullet> bullets;
    private Player player;

    public Screen(){

        bullets = new ArrayList<Bullet>();
        setLayout(null);
        setBackground(Color.BLACK);

    }

    // Setters
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
    public void setPlayer(Player player) {
        this.player = player;
        player.setBulletCreator(this);
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

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    public void addBullet(Bullet bullet){
        bullet.add(bullet);
    }

    public void update(){

        player.update();
        
        if(enemies != null){
        
            for (Enemy enemy : enemies) {
        
                enemy.update();
        
            }
        }
        if(bullets != null){
        
            for (Bullet bullet : bullets) {
        
                bullet.update();
        
            }
        }
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
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case ARRIBA:
                    player.setPositiony(player.getPositiony() - 5);
                    break;
                case ABAJO:
                    player.setPositiony(player.getPositiony() + 5);
                    break;
                case IZQUIERDA:
                    player.setPositionx(player.getPositionx() - 5);
                    break;
                case DERECHA:
                    player.setPositionx(player.getPositionx() + 5);
                    break;
                case ESPACIO:
                    player.shoot();
                    break;    
                default:
                    break;
            }
        }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void createBullet(int positionx, int positiony, int directionx, int directiony) {
        Bullet bullet = new Bullet(1, 10, positionx, positiony, directionx, directiony);
        bullets.add(bullet);
    }
}
