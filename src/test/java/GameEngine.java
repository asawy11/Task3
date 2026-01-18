public class GameEngine {

    private static final int MAX_ATTEMPTS = 10;

    private final int min;
    private final int max;

    private int target;
    private int attempts;

    private boolean gameWon;
    private boolean userQuit;
    private boolean gameOver;

    public GameEngine(int min, int max) {
        this.min = min;
        this.max = max;
        reset();
    }

    public GuessResult makeGuess(int guess) {

        // Quit (negative number)
        if (guess < 0) {
            userQuit = true;
            return new GuessResult(false, "Exiting game...", attempts);
        }

        // If game already ended
        if (gameWon) {
            return new GuessResult(true, "Game already won.", attempts);
        }

        if (gameOver) {
            return new GuessResult(false, "Game over! Maximum attempts reached.", attempts);
        }

        attempts++;

        if (guess == target) {
            gameWon = true;
            return new GuessResult(true,
                    "Correct! You guessed it in " + attempts + " attempts.",
                    attempts);
        }

        // Check max attempts
        if (attempts >= MAX_ATTEMPTS) {
            gameOver = true;
            if (guess < target) {
                return new GuessResult(false, "Too low! Game over.", attempts);
            } else {
                return new GuessResult(false, "Too high! Game over.", attempts);
            }
        }

        if (guess < target) {
            return new GuessResult(false, "Too low! Try a higher number.", attempts);
        } else {
            return new GuessResult(false, "Too high! Try a lower number.", attempts);
        }
    }

    public void reset() {
        target = Utils.randomInt(min, max);
        attempts = 0;
        gameWon = false;
        userQuit = false;
        gameOver = false;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public boolean hasUserQuit() {
        return userQuit;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    // For testing purposes only
    protected void setTarget(int target) {
        this.target = target;
    }

    protected int getTarget() {
        return target;
    }
}
