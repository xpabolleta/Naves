package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import main.java.Bullet.BulletCreator;
import main.java.Explosion.ExplosionCreator;

public class Screen extends JPanel implements KeyListener, BulletCreator, ExplosionCreator{

    private final int ARRIBA = 38;
    private final int ABAJO = 40;
    private final int IZQUIERDA = 37;
    private final int DERECHA = 39;
    private final int ESPACIO = 32;
    private ArrayList <Enemy> enemies;
    private ArrayList <Bullet> enemyBullets;
    private ArrayList <Bullet> playerBullets;
    private ArrayList <Explosion> explosions;
    private Player player;
    private Panel panel;

    public Screen(){

        enemies = new ArrayList<Enemy>();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        explosions = new ArrayList<Explosion>();
        setLayout(null);
        setBackground(Color.BLACK);

    }

    // Setters
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
        for (Enemy enemy : enemies) {
            enemy.setBulletCreator(this);
            enemy.setExplosionCreator(this);
        }
    }
    public void setPlayer(Player player) {
        this.player = player;
        panel = new Panel(player.getLives(), player.getHealth(), player.getScore());
        player.setBulletCreator(this);
        player.setExplosionCreator(this);
    }
    public void setEnemyBullets(ArrayList<Bullet> enemyBullets) {
        this.enemyBullets = enemyBullets;
    }
    public void setPlayerBullets(ArrayList<Bullet> playerBullets) {
        this.playerBullets = playerBullets;
    }

    // Getters
    public Player getPlayer() {
        return player;
    }
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public ArrayList<Bullet> getEnemyBullets() {
        return enemyBullets;
    }
    public ArrayList<Bullet> getPlayerBullets() {
        return playerBullets;
    }
    public ArrayList<Explosion> getExplosions() {
        return explosions;
    }

    public void update(){

        player.update();
        panel.setLives(player.getLives());
        panel.setHealth(player.getHealth());
        panel.setScore(player.getScore());

        if(enemies.size() > 0){
        
            for(int i = 0; i < enemies.size();i++){
                Enemy enemy = enemies.get(i);
                enemy.update();
            }
        }
        if(enemyBullets.size() > 0){
            for(int i = 0; i < enemyBullets.size(); i++){
                Bullet bullet = enemyBullets.get(i);
                bullet.update();
                Rectangle bulletRect = new Rectangle(bullet.getPositionx(), bullet.getPositiony(), bullet.getWidth(), bullet.getHeight());
                Rectangle playerRect = new Rectangle(player.getPositionx(), player.getPositiony(), player.getWidth(), player.getHeight());
                if(bulletRect.intersects(playerRect)){
                    enemyBullets.remove(bullet);
                    if(player.hit(bullet.getDamage())){
                        // Fin del juego
                    }
                }
            }
        }
        if(playerBullets.size() > 0){
            for(int i = 0; i < playerBullets.size(); i++){
                Bullet bullet = playerBullets.get(i);
                bullet.update();
                if(enemies.size() > 0){
                    for(int j = 0; j < enemies.size(); j++){
                        Enemy enemy = enemies.get(j);
                        Rectangle bulletRect = new Rectangle(bullet.getPositionx(), bullet.getPositiony(), bullet.getWidth(), bullet.getHeight());
                        Rectangle enemyRect = new Rectangle(enemy.getPositionx(), enemy.getPositiony(), enemy.getWidth(), enemy.getHeight());
                        if(bulletRect.intersects(enemyRect)){
                            playerBullets.remove(bullet);
                            if(enemy.hit(bullet.getDamage())){
                                player.setScore(player.getScore() + enemy.getLevel() * 10);
                                enemies.remove(enemy);
                            }
                        }
                    }
                }
            }
        }
        if(explosions.size() > 0){
            for(int i = 0; i < explosions.size(); i++){
                Explosion explosion = explosions.get(i);
                if(explosion.update()){
                    explosions.remove(explosion);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        player.paint(g);
        panel.paint(g);
        if(enemyBullets.size() > 0){
        
            for (Bullet bullet : enemyBullets) {
        
                bullet.paint(g);
        
            }
        }
        if(playerBullets.size() > 0){
        
            for (Bullet bullet : playerBullets) {
        
                bullet.paint(g);
        
            }
        }
        if(enemies.size() > 0){
        
            for (Enemy enemy : enemies) {
        
                enemy.paint(g);
        
            }
        }
        if(explosions.size() > 0){

            for (Explosion explosion : explosions) {

                explosion.paint(g);

            }
        }
    }
    
    @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case ARRIBA:
                    player.move(0, -3);
                    break;
                case ABAJO:
                    player.move(0, 3);
                    break;
                case IZQUIERDA:
                    player.move(-3, 0);
                    break;
                case DERECHA:
                    player.move(3, 0);
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
    public void createBullet(int type, int positionx, int positiony, int directionx, int directiony) {
        Bullet bullet = new Bullet(type, positionx, positiony, directionx, directiony);
        if((type == Bullet.DISPARO1)||(type == Bullet.DISPARO2)||(type == Bullet.DISPARO3)||(type == Bullet.DISPARO4)||(type == Bullet.MISIL)){
            playerBullets.add(bullet);
        }else{
            enemyBullets.add(bullet);
        }
    }
    @Override
    public void createExplosion(int positionx, int positiony) {
        Explosion explosion = new Explosion(positionx, positiony);
        explosions.add(explosion);

    }
}
