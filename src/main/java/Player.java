package main.java;

import java.awt.*;

import javax.swing.JPanel;

import main.java.Bullet.BulletCreator;

public class Player extends JPanel{
    
    private int positionx;
    private int positiony;
    private int level;
    private int health;
    private int lives;
    private int score;
    private BulletCreator bulletCreator;
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
                isDead = true;
            }else{
                health = 100;
            }
        }
        return isDead;
    }
    public void shoot(){
        
        bulletCreator.createBullet(1,positionx, positiony, 0, -3);
    }
    public void die(){

    }


    @Override
    public void paint (Graphics g){
        g.drawImage(sprite, positionx, positiony, this);
    }
}