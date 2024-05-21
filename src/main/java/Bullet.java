package main.java;

import javax.swing.JPanel;
import java.awt.*;

public class Bullet extends JPanel{
    
    public static final int DISPARO1 = 0;
    public static final int DISPARO2 = 1;
    public static final int DISPARO3 = 2;
    public static final int DISPARO4 = 3;
    public static final int LASER1 = 4;
    public static final int LASER2 = 5;
    public static final int LASER3 = 6;
    public static final int LASER4 = 7;
    public static final int LASER5 = 8;
    public static final int MISIL = 9;

    private int aux;
    private int type;
    private int damage;
    private int positionx;
    private int positiony;
    private int directionx;
    private int directiony;
    private Image sprite;

    // Constructores
    public Bullet(){
    }
    public Bullet(int type, int positionx, int positiony, int directionx, int directiony){

        this.type = type;
        this.positionx = positionx;
        this.positiony = positiony;
        this.directionx = directionx;
        this.directiony = directiony;
        setDamage();
        setSprite();

    }

    // Setters
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
    public void setDamage() {
        switch (type) {
            case DISPARO1:
                damage = 5;
                break;
            case DISPARO2:
                damage = 10;
                break;
            case DISPARO3:
                damage = 15;
                break;
            case DISPARO4:
                damage = 20;
                break;
            case LASER1:
                damage = 5;
                break;
            case LASER2:
                damage = 10;
                break;
            case LASER3:
                damage = 15;
                break;
            case LASER4:
                damage = 20;
                break;
            case LASER5:
                damage = 25;
                break;
            case MISIL:
                damage = 25;
                break;    
            default:
                break;
        }
    }
    public void setSprite() {

        Toolkit t = Toolkit.getDefaultToolkit();
        switch (type) {
            case DISPARO1:
                this.sprite = t.getImage("src/main/resources/disparo01.png");
                setSize(7,13);
                break;
            case DISPARO2:
                this.sprite = t.getImage("src/main/resources/disparo02.png");
                setSize(7,13);
                break;
            case DISPARO3:
                this.sprite = t.getImage("src/main/resources/disparo03.png");
                setSize(7,13);
                break;
            case DISPARO4:
                this.sprite = t.getImage("src/main/resources/disparo04.png");
                setSize(7,13);
                break;
            case LASER1:
                this.sprite = t.getImage("src/main/resources/laser1.png");
                setSize(3,6);
                break;
            case LASER2:
                this.sprite = t.getImage("src/main/resources/laser2.png");
                setSize(3,6);
                break;
            case LASER3:
                this.sprite = t.getImage("src/main/resources/laser3.png");
                setSize(3,6);
                break;
            case LASER4:
                this.sprite = t.getImage("src/main/resources/laser4.png");
                setSize(3,6);
                break;
            case LASER5:
                this.sprite = t.getImage("src/main/resources/laser5.png");
                setSize(3,6);
                break;
            case MISIL:
                this.sprite = t.getImage("src/main/resources/misil"+aux+".png");
                setSize(10,20);
                break;
            default:
            this.sprite = null;
                break;
        }
        this.setSize(10,20);
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

    // Metodos
    public void update(){
        move();
        if(type == MISIL){
            aux++;
            if(aux > 3){
                aux = 1;
            }
            setSprite();
        }
    }
    public void move(){
        positionx += directionx;
        positiony += directiony;
    }

    // Interfaz bulletCreator
    public interface BulletCreator {
        void createBullet(int type, int positionx, int positiony, int directionx, int directiony);
    }

    // Dibujar
    @Override
    public void paint (Graphics g){
        g.drawImage(sprite, positionx, positiony, this);
        Toolkit.getDefaultToolkit().sync();
    }
}
