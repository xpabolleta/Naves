package main.java;

public class GameLoop implements Runnable{

    private Screen screen;
    private boolean running;
    private final int FPS = 30;

    public GameLoop(){
    }

    public GameLoop(Screen screen){
        this.screen = screen;
    }

    // Setters
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    // Getters
    public Screen getScreen() {
        return screen;
    }

    // Metodos
    public void start(){
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }
    public void stop(){
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            screen.update();
            screen.repaint();
            try {
                Thread.sleep(1000/FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
