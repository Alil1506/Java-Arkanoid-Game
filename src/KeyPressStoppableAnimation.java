import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    public KeyPressStoppableAnimation(KeyboardSensor keyboard, String key, Animation animation) {
        this.keyboard = keyboard;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true; // מתחילים true כדי לחכות לשחרור
    }

    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);

        if (keyboard.isPressed(key)) {
            if (!isAlreadyPressed) stop = true;
        } else {
            isAlreadyPressed = false;
        }
    }

    public boolean shouldStop() { return stop; }
}
