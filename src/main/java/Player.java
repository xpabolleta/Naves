package main.java;

import java.awt.*;

import main.java.Bullet.BulletCreator;

public class Player{
    
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
                break;
            case 2:
                this.sprite = t.getImage("src/main/resources/nave02.png");
                break;
            case 3:
                this.sprite = t.getImage("src/main/resources/nave03.png");
                break;
            case 4:
                this.sprite = t.getImage("src/main/resources/nave04.png");
                break;
            case 5:
                this.sprite = t.getImage("src/main/resources/nave05.png");
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
    public void shoot(){
        
        bulletCreator.createBullet(positionx, positiony, 0, -3);
    }
    public void die(){
        
    }


    public void paint (Graphics g){
        
        g.drawImage(sprite, positionx, positiony, null);

    }
}