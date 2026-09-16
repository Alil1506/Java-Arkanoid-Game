import biuoop.DrawSurface;

public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;

    private boolean stop;
    private long startTime;
    private int current;

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.startTime = -1;
        this.current = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (startTime == -1) {
            startTime = System.currentTimeMillis();
        }

        gameScreen.drawAllOn(d);
        d.drawText(390, 300, "" + current, 60);

        double totalMillis = numOfSeconds * 1000.0;
        double perNumber = totalMillis / countFrom;

        long elapsed = System.currentTimeMillis() - startTime;
        int newCurrent = countFrom - (int) (elapsed / perNumber);

        if (newCurrent <= 0) {
            stop = true;
        } else {
            current = newCurrent;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}
