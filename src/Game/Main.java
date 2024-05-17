package Game;

public class Main {
    public static void main(String[] args) {

        GameFrame window = new GameFrame(500, 800);
        Player player = new Player(10, 10, 10);
        int floor = 50; // lowest point player will fall to


        //need player to FALL by default if not on bottom.
        if (window.getX() > floor) {
            player.goDown();
        }


    } // main method
} // main class
