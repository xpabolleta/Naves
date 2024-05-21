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
    private int round;
    private ArrayList <Enemy> enemies;
    private ArrayList <Bullet> enemyBullets;
    private ArrayList <Bullet> playerBullets;
    private ArrayList <Explosion> explosions;
    private ArrayList <Star> stars;
    private ArrayList<Integer> pressedKeys;
    private Player player;
    private Panel panel;

    public Screen(){

        enemies = new ArrayList<Enemy>();
        enemyBullets = new ArrayList<Bullet>();
        playerBullets = new ArrayList<Bullet>();
        explosions = new ArrayList<Explosion>();
        stars = new ArrayList<Star>();
        pressedKeys = new ArrayList<Integer>();
        round = 1;
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
    public ArrayList<Star> getStars() {
        return stars;
    }

    public boolean update(){
        checkKey();
        player.update();
        panel.setLives(player.getLives());
        panel.setHealth(player.getHealth());
        panel.setScore(player.getScore());
        if((Math.random()*60) < 5){
            int positionx = (int) (Math.random()*1000);
            int diameter = (int) (Math.random()*3+2);
            int speed = (int) (Math.random()*12+6);
            Star star = new Star(positionx, 0, diameter, speed);
            stars.add(star);
        }
        if(stars.size() > 0){
            for(int i = 0; i < stars.size();i++){
                Star star = stars.get(i);
                star.update();
                if(star.getPositiony() > 650){
                    stars.remove(star);
                }
            }
        }
        if(enemies.size() > 0){
        
            for(int i = 0; i < enemies.size();i++){
                Enemy enemy = enemies.get(i);
                enemy.update();
            }
        }else{
            setEnemies(Enemy.createWave(round));
            round++;
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
                        return true;
                    }
                }
                if((bullet.getPositionx() < 0)||(bullet.getPositionx() > 1000)||(bullet.getPositiony() < 0)||(bullet.getPositiony() > 600)){
                    enemyBullets.remove(bullet);
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
                                player.setScore(player.getScore() + enemy.getLevel() * 30);
                                enemies.remove(enemy);
                            }
                        }
                    }
                }
                if((bullet.getPositionx() < 0)||(bullet.getPositionx() > 1000)||(bullet.getPositiony() < 0)||(bullet.getPositiony() > 600)){
                    playerBullets.remove(bullet);
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
        return false;
    }

    private void checkKey() {
        int dx = 0;
        int dy = 0;
    
        if (pressedKeys.contains(ARRIBA)) {
            dy -= 5;
        }
        if (pressedKeys.contains(ABAJO)) {
            dy += 5;
        }
        if (pressedKeys.contains(IZQUIERDA)) {
            dx -= 5;
        }
        if (pressedKeys.contains(DERECHA)) {
            dx += 5;
        }
        if (pressedKeys.contains(ESPACIO)) {
            player.shoot();
        }
    
        player.move(dx, dy);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        if(stars.size() > 0){
        
            for (Star star : stars) {
        
                star.paint(g);
        
            }
        }
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
        player.paint(g);
        panel.paint(g);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (!pressedKeys.contains(e.getKeyCode())) {
            pressedKeys.add(e.getKeyCode());
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove((Integer) e.getKeyCode());
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
