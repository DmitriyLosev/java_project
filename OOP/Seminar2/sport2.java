import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sport2 {
    public static void main(String[] args) {
        // Создание массивов участников и препятствий
        String[] participants = {"Максим", "Сергей", "Павел", "Олег"};
        String[] obstacles = {"Стена", "Веревочная лестница", "Бревно", "Кольца"};

        // Создание списков участников и препятствий, чтобы можно было удалять элементы
        List<String> participantsList = new ArrayList<>();
        for (String participant : participants) {
            participantsList.add(participant);
        }
        List<String> obstaclesList = new ArrayList<>();
        for (String obstacle : obstacles) {
            obstaclesList.add(obstacle);
        }

        // Создание объекта Random для случайного выбора результата прохождения препятствия
        Random random = new Random();

        // Прохождение каждого препятствия каждым участником
        for (String obstacle : obstaclesList) {
            System.out.println("Препятствие: " + obstacle);
            List<String> participantsToRemove = new ArrayList<>();
            for (String participant : participantsList) {
                boolean canPass = random.nextBoolean(); // Случайный выбор результата прохождения препятствия
                if (canPass) {
                    System.out.println(participant + " проходит препятствие");
                } else {
                    System.out.println(participant + " не смог пройти препятствие и выбывает из соревнования");
                    participantsToRemove.add(participant); // Добавление участника в список на удаление
                }
            }
            participantsList.removeAll(participantsToRemove); // Удаление неуспешных участников из списка
            if (participantsList.isEmpty()) {
                System.out.println("Никто не смог пройти все препятствия и соревнование завершается");
                break; // Если не осталось участников, то завершаем гонку
            }
        }
        System.out.println("Соревнование завершено. Участники, прошедшие все препятствия: " + participantsList);
    }
}

