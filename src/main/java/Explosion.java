package main.java;

import java.awt.*;
import javax.swing.JPanel;

public class Explosion extends JPanel{

    private int positionx;
    private int positiony;
    private int aux;
    private Image sprite;

    public Explosion(){
    }
    public Explosion(int positionx, int positiony){
        this.positionx = positionx;
        this.positiony = positiony;
        this.aux = 1;
        setSprite();
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }

    public int getPositionx() {
        return positionx;
    }
    public int getPositiony() {
        return positiony;
    }

    public void setSprite() {
        Toolkit t = Toolkit.getDefaultToolkit();
        this.sprite = t.getImage("src/main/resources/explosion0"+ aux +".png");
    }
    public boolean update() {
        aux++;
        if(aux > 8){
            aux = 1;
            return true;
        }
        setSprite();
        return false;
    }
    
    // Interfaz bulletCreator
    public interface ExplosionCreator {
        void createExplosion(int positionx, int positiony);
    }

    @Override
    public void paint (Graphics g){
        g.drawImage(sprite, positionx, positiony, this);
        Toolkit.getDefaultToolkit().sync();
    }
}
