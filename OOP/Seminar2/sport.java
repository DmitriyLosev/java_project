

public class sport {
    public static void main(String[] args) {
        Track track = new Track(1000);
        Wall wall = new Wall(1);

        People[] peoples = {
                new Human("Иван", 1500, 1),
                new Human("Максим", 1200, 2),
                new Human("Ольга", 800, 1),
                new Human("Сергей", 300, 3)
        };

        for (People people : peoples) {
            boolean passTrack = track.pass(people);
            boolean passWall = wall.pass(people);
            if (!passTrack || !passWall) {
                System.out.println(people.getName() + " выбыл из соревнования");
            }
        }
    }
}
class Track {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    public boolean pass(People people) {
        if (people.run() >= length) {
            System.out.println(people.getName() + " успешно пробежал беговую дорожку длиной " + length);
            return true;
        } else {
            System.out.println(people.getName() + " не смог пробежать беговую дорожку длиной " + length);
            return false;
        }
    }
}

class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean pass(People people) {
        if (people.jump() >= height) {
            System.out.println(people.getName() + " успешно перепрыгнул стену высотой " + height);
            return true;
        } else {
            System.out.println(people.getName() + " не смог перепрыгнуть стену высотой " + height);
            return false;
        }
    }
}

abstract class People {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public People(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public String getName() {
        return name;
    }

    public int run() {
        return maxRunDistance;
    }

    public int jump() {
        return maxJumpHeight;
    }
}

class Human extends People {
    public Human(String name, int maxRunDistance, int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
    }
}


