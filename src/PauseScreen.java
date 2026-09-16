import biuoop.DrawSurface;
import java.awt.Color;

public class PauseScreen implements Animation {
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(180, 250, "paused -- press space to continue", 32);
    }

    public boolean shouldStop() {
        return false; //
    }
}
