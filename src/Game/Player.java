package Game;

class Player {

    int fallSpeed, runSpeed, jumpHeight, xPos, yPos; //player stats & position

    public Player(int fallSpeed, int runSpeed, int jumpHeight) {
        this.fallSpeed = fallSpeed;
        this.runSpeed = runSpeed;
        this.jumpHeight = jumpHeight;

        xPos = 200; //Default starting positions
        yPos = 51;

    }

    public void setX() {
        xPos += 5;
    }

    public void goUp() {
        yPos += 5;
    }

    public void goDown() {
        if (yPos > 50) {
            yPos -= 1;
        }
    }


} //Player class

