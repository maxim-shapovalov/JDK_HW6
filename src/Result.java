import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Result {
    private Map<Integer, Boolean> result;

    public Result() {
        result = new HashMap<>();
    }

    public void recordResult(int i, Boolean res) {
        result.put(i, res);
    }

    public void displayResults(int numberOfGames) {
        int countAlwaysSwitch = 0;
        int countNeverSwitch = 0;
        int countRandom = 0;

        for (int i = 0; i < numberOfGames; i++) {
            if (result.get(i)) countAlwaysSwitch++;
            if (result.get(i + numberOfGames)) countNeverSwitch++;
            if (result.get(i + 2 * numberOfGames)) countRandom++;
        }

        log.info("���������� ���: {}", numberOfGames);
        log.info("������ ������ �����: {} �����, �������: {}%", countAlwaysSwitch, (countAlwaysSwitch * 100.0 / numberOfGames));
        log.info("������� �� ������ �����: {} �����, �������: {}%", countNeverSwitch, (countNeverSwitch * 100.0 / numberOfGames));
        log.info("�������� ������ �����: {} �����, �������: {}%", countRandom, (countRandom * 100.0 / numberOfGames));
    }
}
