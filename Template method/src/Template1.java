public abstract class Template1 {


    abstract void loading();

    abstract void startGame();

    abstract void endGame();


    public final void play() {
        //initialize the game
        loading();

        //start the game
        startGame();

        //end the game
        endGame();
    }
}

