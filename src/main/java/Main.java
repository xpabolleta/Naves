package main.java;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(1000,700);
        int[] position = {50,50};
        Player player = new Player(position, 1, 100, 3, 0);
        screen.setVisible(true);
        screen.add(player);
    }
}
