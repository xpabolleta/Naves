package main.java;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;
import main.java.Bullet.BulletCreator;
import main.java.Explosion.ExplosionCreator;;

public class Enemy extends JPanel{
    
    private int positionx;
    private int positiony;
    private int directionx = 1;
    private int directiony = 1;
    private int level;
    private int health;
    private BulletCreator bulletCreator;
    private ExplosionCreator explosionCreator;
    private Image sprite;
    
    // Constructores
    public Enemy(){
    }
    public Enemy(int positionx,int positiony,int level, int health){

        this.positionx = positionx;
        this.positiony = positiony;
        this.level = level;
        this.health = health;
        this.setSprite();
    
    }
    
    // Setters
    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
    public void setDirectionx(int directionx) {
        this.directionx = directionx;
    }
    public void setDirectiony(int directiony) {
        this.directiony = directiony;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setSprite() {
        
        Toolkit t = Toolkit.getDefaultToolkit();
        switch (level) {
            case 1:
                setSize(30,30);
                if(health > 14){
                    this.sprite = t.getImage("src/main/resources/enemigo1-verde.png");
                }else if(health > 12){
                    this.sprite = t.getImage("src/main/resources/enemigo1-rojo.png");
                }else if(health > 10){
                    this.sprite = t.getImage("src/main/resources/enemigo1-naranja.png");
                }else if(health > 8){
                    this.sprite = t.getImage("src/main/resources/enemigo1-gris.png");
                }else if(health > 4){
                    this.sprite = t.getImage("src/main/resources/enemigo1-azulclaro.png");
                }else if(health > 2){
                    this.sprite = t.getImage("src/main/resources/enemigo1-azul.png");
                }else{
                    this.sprite = t.getImage("src/main/resources/enemigo1-amarillo.png");
                }
                break;

            case 2:
                setSize(30,40);
                if(health > 28){
                    this.sprite = t.getImage("src/main/resources/enemigo2-verde.png");
                }else if(health > 26){
                    this.sprite = t.getImage("src/main/resources/enemigo2-rojo.png");
                }else if(health > 24){
                    this.sprite = t.getImage("src/main/resources/enemigo2-naranja.png");
                }else if(health > 22){
                    this.sprite = t.getImage("src/main/resources/enemigo2-gris.png");
                }else if(health > 20){
                    this.sprite = t.getImage("src/main/resources/enemigo2-azulclaro.png");
                }else if(health > 18){
                    this.sprite = t.getImage("src/main/resources/enemigo2-azul.png");
                }else{
                    this.sprite = t.getImage("src/main/resources/enemigo2-amarillo.png");
                }
                break;

            case 3:
                setSize(50,30);
                if(health > 42){
                    this.sprite = t.getImage("src/main/resources/enemigo3-verde.png");
                }else if(health > 40){
                    this.sprite = t.getImage("src/main/resources/enemigo3-rojo.png");
                }else if(health > 38){
                    this.sprite = t.getImage("src/main/resources/enemigo3-naranja.png");
                }else if(health > 36){
                    this.sprite = t.getImage("src/main/resources/enemigo3-gris.png");
                }else if(health > 34){
                    this.sprite = t.getImage("src/main/resources/enemigo3-azulclaro.png");
                }else if(health > 32){
                    this.sprite = t.getImage("src/main/resources/enemigo3-azul.png");
                }else{
                    this.sprite = t.getImage("src/main/resources/enemigo3-amarillo.png");
                }
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
    public int getDirectionx() {
        return directionx;
    }
    public int getDirectiony() {
        return directiony;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }

    // Metodos
    public static ArrayList<Enemy> createWave(int round){
        ArrayList<Enemy> wave = new ArrayList<Enemy>();
        int level;
        int health;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                if(round < 9){
                    level = (int) (Math.random()*2)+1;
                    if(i-round >= 0){
                        level = (round/5) + 1;
                    }else{
                        level = (round/5) +2;
                    }
                }else{
                    level = (int) (Math.random()*2)+1;
                }
                health = level * 14 + 2;
                Enemy enemy = new Enemy(j*55, i*45, level, health);
                wave.add(enemy);
            }
        }
        return wave;
    }
    public void update(){
        move();
        if(Math.random()*3000 < 2*level){
            shoot();
        }
    }
    public void move(){
        positionx += directionx;
        if(positionx > 1000){
            positiony += directiony;
            directionx = -directionx;
        }else if(positionx < 0){
            positiony += directiony;
            directionx = Math.abs(directionx);
        }
    }
    public void shoot(){
        int type;
        type = (int) (Math.random()*5)+4;
        bulletCreator.createBullet(type,positionx, positiony, 0, 3);
    }
    public boolean hit(int damage){
        boolean isDead = false;
        setHealth(health - damage);
        if(health <=  0){
            die();
            isDead = true;
        }
        setSprite();
        return isDead;
    }
    public void die(){
        explosionCreator.createExplosion(positionx, positiony);
    }
    // Dibujar
    @Override
    public void paint (Graphics g){
        g.drawImage(sprite, positionx, positiony, this);
        Toolkit.getDefaultToolkit().sync();
    }
}