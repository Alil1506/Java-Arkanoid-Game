import java.util.List;
import java.awt.Color;

public interface LevelInformation {
    int numberOfBalls();
    List<Velocity> initialBallVelocities();

    int paddleSpeed();
    int paddleWidth();

    String levelName();
    Sprite getBackground();

    List<Block> blocks();
    int numberOfBlocksToRemove();
}

