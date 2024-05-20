package main.java;

import java.awt.*;

public class Enemy {
    
    private int positionx;
    private int positiony;
    private int directionx = 3;
    private int directiony = 10;
    private int level;
    private int health;
    private Image sprite;
    

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

    public void update(){
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

    }
    public void die(){
        
    }

    public void paint (Graphics g){
        
        g.drawImage(sprite, positionx, positiony, null);
    
    }
}