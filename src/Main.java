/*
� �������� ������ ��������� ��� ����������� ��� ��� ������������ ��������� ����� �����
(�������� ����� ����� � ��������� ) � �������� ��������� � �������� ���������
(��������� ���� � ����� �� 1000 � ������� �������� ����).
����������:
������� ���� Java Maven ��� Gradle ������;
���������� ����������� lombok.
����� �������� � ����������� �����-������ �������������� ���������� ��� ������ �� �����������
�������������� ����������� ���������� ������;
��������� ��������� � HashMap<��� �����, ���������>
������� �� ����� ���������� �� ������� � ����������

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
