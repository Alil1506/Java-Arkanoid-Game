import biuoop.DrawSurface;
import java.awt.Color;

public class TestAnimation implements Animation {
    private boolean stop = false;

    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(200, 200, "it works!", 40);
    }

    public boolean shouldStop() { return stop; }
}

