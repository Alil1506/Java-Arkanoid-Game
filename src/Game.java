import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

public class Game implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private LevelInformation levelInfo;

    private KeyboardSensor keyboard;
    private AnimationRunner runner;
    private boolean running;

    public Game(LevelInformation levelInfo, KeyboardSensor keyboard, AnimationRunner runner) {
        this.levelInfo = this.levelInfo;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.keyboard = keyboard;
        this.runner = runner;
        this.running = false;
    }

    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    public void initialize() {
        // --- Counters ---
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.score = new Counter();

        // --- Listeners ---
        BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);
        BallRemover ballRemover = new BallRemover(this, remainingBalls);
        ScoreTrackingListener scoreTracking = new ScoreTrackingListener(score);

        // --- Score display ---
        this.addSprite(levelInfo.getBackground());
        this.addSprite(new ScoreIndicator(this.score));


        // --- Ball (1) ---
        for (Velocity v : levelInfo.initialBallVelocities()) {
            Ball ball = new Ball(new Point(400, 500), 8, Color.RED);
            ball.setVelocity(v);
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
            remainingBalls.increase(1);
        }

        // --- Borders ---
        for (Block block : levelInfo.blocks()) {
            block.addToGame(this);
            // listeners כמו שיש לך
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTracking);
            remainingBlocks.increase(1);
        }
        int thickness = 20;

        Block topBorder = new Block(new Rectangle(new Point(0, 0), 800, thickness));
        topBorder.addToGame(this);

        Block leftBorder = new Block(new Rectangle(new Point(0, thickness), thickness, 600 - thickness));
        leftBorder.addToGame(this);

        Block rightBorder = new Block(new Rectangle(new Point(800 - thickness, thickness), thickness, 600 - thickness));
        rightBorder.addToGame(this);

        Block deathRegion = new Block(new Rectangle(new Point(0, 600 - thickness), 800, thickness));
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);


        // --- Paddle ---
        int paddleWidth = levelInfo.paddleWidth();
        int paddleHeight = 15;
        int paddleY = 560;

        Rectangle paddleRect = new Rectangle(
                new Point((800 - paddleWidth) / 2.0, paddleY),
                paddleWidth, paddleHeight
        );

        Paddle paddle = new Paddle(paddleRect, this.keyboard, levelInfo.paddleSpeed(), thickness, 800 - thickness);
        paddle.addToGame(this);
    }

    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.runner.run(this);
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        // Pause
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(
                    this.keyboard, "space", new PauseScreen()
            ));
        }

        // stop conditions
        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
