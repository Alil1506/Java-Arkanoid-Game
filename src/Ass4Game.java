import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

public class Ass4Game {
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);

        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new SimpleLevel());
        // later: levels.add(new AnotherLevel());

        GameFlow flow = new GameFlow(runner, gui.getKeyboardSensor());
        flow.runLevels(levels);
    }
}

