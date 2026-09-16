import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

public class AnimationRunner {
    private GUI gui;
    private int fps;
    private Sleeper sleeper = new Sleeper();

    public AnimationRunner(GUI gui, int fps) {
        this.gui = gui;
        this.fps = fps;
    }

    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / fps;

        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);
            gui.show(d);

            long used = System.currentTimeMillis() - startTime;
            long left = millisecondsPerFrame - used;
            if (left > 0) sleeper.sleepFor(left);
        }
    }
}
