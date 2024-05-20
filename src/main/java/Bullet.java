package main.java;

import javax.swing.JPanel;
import java.awt.*;

public class Bullet extends JPanel{
    
    private final int DISPARO = 0;
    private final int MISIL = 1;
    private final int LASER = 2;

    private int aux;
    private int type;
    private int damage;
    private int positionx;
    private int positiony;
    private int directionx;
    private int directiony;
    private Image sprite;

    public Bullet(){
    }
    public Bullet(int type, int damage, int positionx, int positiony, int directionx, int directiony){

        this.type = type;
        this.damage = damage;
        this.positionx = positionx;
        this.positiony = positiony;
        this.directionx = directionx;
        this.directiony = directiony;
        setSprite();
        
    }
    // Setters
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setDirectionx(int directionx) {
        this.directionx = directionx;
    }
    public void setDirectiony(int directiony) {
        this.directiony = directiony;
    }
    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setSprite() {

        Toolkit t = Toolkit.getDefaultToolkit();
        switch (type) {
            case DISPARO:
                this.sprite = t.getImage("src/main/resources/disparo0"+aux+".png");
                break;
            case MISIL:
                this.sprite = t.getImage("src/main/resources/misil"+aux+".png");
                break;
            case LASER:
                this.sprite = t.getImage("src/main/resources/laser"+aux+".png");
                break;
            default:
            this.sprite = null;
                break;
        }
    }

    //Getters
    public int getDamage() {
        return damage;
    }
    public int getDirectionx() {
        return directionx;
    }
    public int getDirectiony() {
        return directiony;
    }
    public int getPositionx() {
        return positionx;
    }
    public int getPositiony() {
        return positiony;
    }
    public int getType() {
        return type;
    }

    public void update(){
        aux++;
        switch (type) {
            case DISPARO:
                if(aux > 4){
                    aux = 1;
                }
                break;
            case MISIL:
                if(aux > 3){
                    aux = 1;
                }
                break;
            case LASER:
                if(aux > 5){
                    aux = 1;
                }
                break;
            default:
                break;
        }
        positionx += directionx;
        positiony += directiony;
        setSprite();
    }

    @Override

    public void paint (Graphics g){

        g.drawImage(sprite, positionx, positiony, this);

    }
}
