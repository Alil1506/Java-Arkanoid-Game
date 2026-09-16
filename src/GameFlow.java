import biuoop.KeyboardSensor;
import java.util.List;

public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor keyboard;

    public GameFlow(AnimationRunner runner, KeyboardSensor keyboard) {
        this.runner = runner;
        this.keyboard = keyboard;
    }

    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            Game level = new Game(levelInfo, keyboard, runner);
            level.initialize();
            level.run();

        }
    }
}
