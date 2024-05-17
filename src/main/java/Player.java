package main.java;

import javax.swing.JPanel;
import java.awt.*;

public class Player extends JPanel {
    
    private int[] position;
    private int level;
    private int health;
    private int lives;
    private int score;
    private Image sprite;

    public Player(){
    }
    public Player(int[] position,int level, int health, int lives, int score){
        this.position = position;
        this.level = level;
        this.health = health;
        this.lives = lives;
        this.score = score;
        setSprite();
    }

    // Setters
    public void setPosition(int[] position) {
        this.position = position;
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

    // Getters
    public int[] getPosition() {
        return position;
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

    public void shoot(){

    }
    public void die(){
        
    }

    @Override

    public void paint (Graphics g){
        
        g.drawImage(sprite, position[0], position[1], this);
    }

}