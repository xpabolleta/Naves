package main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
    private int lives;
    private int health;
    private int score;

    public Panel(){

    }

    public Panel(int lives, int health, int score){
        this.lives = lives;
        this.score = score;
        this.health = health;
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

    public int getHealth() {
        return health;
    }
    public int getLives() {
        return lives;
    }
    public int getScore() {
        return score;
    }

    @Override
    public void paint(Graphics g) {

        Font font = new Font("Arial",1,15);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Vidas: " + lives, 5, 20);
        g.drawString("Puntuacion: " + score, 5, 60);
        g.fillRect(5, 25, 102, 15);
        g.setColor(Color.RED);
        g.fillRect(6, 26, health, 13);
        
    }
}
