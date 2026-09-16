import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class SimpleLevel implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(new Velocity(3, -3));
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100; // בערך 2 בלוקים
    }

    @Override
    public String levelName() {
        return "Simple Level";
    }

    @Override
    public Sprite getBackground() {
        return new Background(Color.WHITE); // ניצור עוד רגע Background
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();

        int blockWidth = 50, blockHeight = 20;
        int startX = 100, y = 100;

        for (int i = 0; i < 10; i++) {
            Rectangle rect = new Rectangle(new Point(startX + i * blockWidth, y), blockWidth, blockHeight);
            Block b = new Block(rect);
            blocks.add(b);
        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 10;
    }
}
