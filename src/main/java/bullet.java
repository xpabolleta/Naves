package main.java;

import javax.swing.JPanel;
import java.awt.*;

public class bullet extends JPanel{
    
    private final int DISPARO = 0;
    private final int MISIL = 1;
    private final int LASER = 2;

    private int aux;
    private int type;
    private int damage;
    private int[] position;
    private int[] direction;

    public bullet(){

    }

    // Setters
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setDirection(int[] direction) {
        this.direction = direction;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
    public void setType(int type) {
        this.type = type;
    }

    //Getters
    public int getDamage() {
        return damage;
    }
    public int[] getDirection() {
        return direction;
    }
    public int[] getPosition() {
        return position;
    }
    public int getType() {
        return type;
    }

    public void refresh(){
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
        position[0] += direction[0];
        position[1] += direction[1]; 
    }

    @Override

    public void paint (Graphics g){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image sprite;
        switch (type) {
            case DISPARO:
                sprite = t.getImage(getClass().getResource("src/main/resources/disparo0"+aux+".png"));
                break;
            case MISIL:
                sprite = t.getImage(getClass().getResource("src/main/resources/misil"+aux+".png"));
                break;
            case LASER:
                sprite = t.getImage(getClass().getResource("src/main/resources/laser"+aux+".png"));
                break;
            default:
            sprite = null;
                break;
        }
        g.drawImage(sprite, position[0], position[1], this);
    }
}
