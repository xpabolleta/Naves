package main.java;

import javax.swing.JPanel;
import java.awt.*;

public class player extends JPanel {
    
    private int[] position;
    private int level;
    private int health;
    private int lives;
    private int score;

    public player(){
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

    public void shoot(){

    }
    public void die(){
        
    }

    @Override

    public void paint (Graphics g){
        
        Toolkit t = Toolkit.getDefaultToolkit();
        Image sprite;
        switch (level) {
            case 1:
                sprite = t.getImage(getClass().getResource("src/main/resources/nave01.png"));
                break;
            case 2:
                sprite = t.getImage(getClass().getResource("src/main/resources/nave02.png"));
                break;
            case 3:
                sprite = t.getImage(getClass().getResource("src/main/resources/nave03.png"));
                break;
            case 4:
                sprite = t.getImage(getClass().getResource("src/main/resources/nave04.png"));
                break;
            case 5:
                sprite = t.getImage(getClass().getResource("src/main/resources/nave05.png"));
                break;
            default:
            sprite = null;
                break;
        }
        g.drawImage(sprite, position[0], position[1], this);
    }

}