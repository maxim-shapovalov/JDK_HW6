/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
(Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям

 */
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Result result = new Result();
        int numberOfGames = 1000;

        for (int i = 0; i < numberOfGames; i++) {
            MontyHollGame montyHollGameAlwaysSwitch = new MontyHollGame();
            result.recordResult(i, montyHollGameAlwaysSwitch.playGame(Strategy.ALWAYS_SWITCH));

            MontyHollGame montyHollGameNeverSwitch = new MontyHollGame();
            result.recordResult(i + numberOfGames, montyHollGameNeverSwitch.playGame(Strategy.NEVER_SWITCH));

            MontyHollGame montyHollGameRandom = new MontyHollGame();
            result.recordResult(i + 2 * numberOfGames, montyHollGameRandom.playGame(Strategy.RANDOM));
        }

        result.displayResults(numberOfGames);
    }
}
