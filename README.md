# 2D Arkanoid Game Engine (Java)

An interactive 2D arcade game inspired by Arkanoid / Breakout, built entirely in Java. The project emphasizes Object-Oriented Programming (OOP) principles, modular architecture, and event driven design patterns.

---

## Features
- **Object-Oriented Architecture**: Clean separation between game logic, physics/collision calculations, and graphical rendering.
- **Physics & Collision Detection**: 
  - Dynamic trajectory and collision detection for moving balls against paddle and blocks.
  - Multi directional bounce mechanics based on collision point hit angles.
- **Event Driven Mechanics (Observer Pattern)**: 
  - `HitListener` and `HitNotifier` system for tracking block destruction, ball removal, and score tracking without tight coupling.
- **Smooth Animation & Flow Control**:
  - Centralized `AnimationRunner` managing target frames per second (FPS).
  - Countdown animation screens, pause screens, and high scores management.
- **Level & Game Environment**:
  - Dynamic level configurations with custom layouts, background themes, and difficulty progression.

---

##  Architecture & Design Patterns
- **Observer Pattern**: Used for game event notifications (e.g., removing blocks and updating the score when hit).
- **Strategy & Polymorphism**: Interfaces like `Collidable`, `Animation`, and `Sprite` decouple behavior from specific game elements.
- **Composition over Inheritance**: Game objects maintain environments and listeners dynamically.

---

##  Tech Stack
- **Language**: Java
- **Graphics/GUI**: Java Swing / AWT (biuoop GUI library)
- **Tooling**: IntelliJ IDEA, Git

---

## Getting Started

## Prerequisites
- Java Development Kit (JDK 8 or higher)
- Any standard Java IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation & Run
1. Clone this repository:
   ```bash
   git clone [https://github.com/Alil1506/Java-Arkanoid-Game.git](https://github.com/Alil1506/Java-Arkanoid-Game.git)
