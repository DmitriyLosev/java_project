
public class RunJump {
    public static void main(String[] args) {
        Human human = new Human();
        human.run();  // Running
        human.jump();  // Jumping

        Cat cat = new Cat();
        cat.run();  // Running
        cat.jump();  // Jumping

        Robot robot = new Robot();
        robot.run();  // Running
        robot.jump();  // Jumping
    }
}
class RunOrJump {
    public void run() {
        System.out.println("Running");
    }

    public void jump() {
        System.out.println("Jumping");
    }
}

class Human extends RunOrJump {
}

class Cat extends RunOrJump {
}

class Robot extends RunOrJump {
}
