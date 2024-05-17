package main.java;

public class Main {
    public static void main(String[] args) {
        
        int[] position = {0,600};
        Player player = new Player(position, 1, 100, 3, 0);
        Screen screen = new Screen(1000,700);

        screen.setVisible(true);
        screen.add(player);
    }
}
