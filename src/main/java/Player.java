package main.java;

import java.awt.*;
import javax.swing.JPanel;
import main.java.Bullet.BulletCreator;
import main.java.Explosion.ExplosionCreator;

public class Player extends JPanel{
    
    private int positionx;
    private int positiony;
    private int level;
    private int health;
    private int lives;
    private int score;
    private BulletCreator bulletCreator;
    private ExplosionCreator explosionCreator;
    private Image sprite;

    public Player(){
    }
    public Player(int positionx,int positiony,int level, int health, int lives, int score){

        this.positionx = positionx;
        this.positiony = positiony;
        this.level = level;
        this.health = health;
        this.lives = lives;
        this.score = score;
        setSprite();
        
    }

    // Setters
    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setSprite() {

        Toolkit t = Toolkit.getDefaultToolkit();
        switch (level) {
            case 1:
                this.sprite = t.getImage("src/main/resources/nave01.png");
                this.setSize(64,40);
                break;
            case 2:
                this.sprite = t.getImage("src/main/resources/nave02.png");
                this.setSize(100,40);
                break;
            case 3:
                this.sprite = t.getImage("src/main/resources/nave03.png");
                this.setSize(100,75);
                break;
            case 4:
                this.sprite = t.getImage("src/main/resources/nave04.png");
                this.setSize(100,75);
                break;
            case 5:
                this.sprite = t.getImage("src/main/resources/nave05.png");
                this.setSize(170,90);
                break;
            default:
                this.sprite = null;
                break;
        }
    }
    public void setBulletCreator(BulletCreator bulletCreator) {
        this.bulletCreator = bulletCreator;
    }
    public void setExplosionCreator(ExplosionCreator explosionCreator) {
        this.explosionCreator = explosionCreator;
    }

    // Getters
    public int getPositionx() {
        return positionx;
    }
    public int getPositiony() {
        return positiony;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }
    public int getLives() {
        return lives;
    }
    public int getScore() {
        return score;
    }
    public Image getSprite() {
        return sprite;
    }

    public void update(){
        if(score < 2000){
            level = 1;
        }else if(score < 4000){
            level = 2;
        }
        else if(score < 4000){
            level = 3;
        }
        else if(score < 4000){
            level = 4;
        }
        else if(score < 4000){
            level = 5;
        }
        setSprite();
    }
    public void move(int directionx, int directiony){
        positionx += directionx;
        positiony += directiony;
    }
    public boolean hit(int damage){
        boolean isDead = false;
        setHealth(health - damage);
        if(health <=  0){
            lives--;
            if(lives < 0){
                die();
                isDead = true;
            }else{
                health = 100;
            }
        }
        return isDead;
    }
    public void shoot(){
        switch (level) {
            case 1:
                bulletCreator.createBullet(Bullet.DISPARO1,positionx + (getWidth()/2), positiony, 0, -3);
                break;
            case 2:
                bulletCreator.createBullet(Bullet.DISPARO2,positionx, positiony, 0, -3);
                bulletCreator.createBullet(Bullet.DISPARO2,positionx + getWidth(), positiony, 0, -3);
                break;
            case 3:
                bulletCreator.createBullet(Bullet.DISPARO3,positionx, positiony, 0, -3);
                bulletCreator.createBullet(Bullet.DISPARO3,positionx + getWidth()/2, positiony, 0, -3);
                bulletCreator.createBullet(Bullet.DISPARO3,positionx + getWidth(), positiony, 0, -3);
                break;
            case 4:
                bulletCreator.createBullet(Bullet.DISPARO4,positionx, positiony, 0, -3);
                bulletCreator.createBullet(Bullet.DISPARO4,positionx + getWidth()/2, positiony, 0, -3);
                bulletCreator.createBullet(Bullet.DISPARO4,positionx + getWidth(), positiony, 0, -3);
                break;
            case 5:
                bulletCreator.createBullet(Bullet.MISIL,positionx, positiony, 0, -3);
                bulletCreator.createBullet(Bullet.MISIL,positionx + getWidth()/2, positiony, 0, -3);
                bulletCreator.createBullet(Bullet.MISIL,positionx + getWidth(), positiony, 0, -3);
                break;
            default:
                break;
        }        
    }
    public void die(){
        explosionCreator.createExplosion(positionx, positiony);
    }


    @Override
    public void paint (Graphics g){
        g.drawImage(sprite, positionx, positiony, this);
    }
}