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

        log.info("Количество игр: {}", numberOfGames);
        log.info("Всегда меняет дверь: {} побед, процент: {}%", countAlwaysSwitch, (countAlwaysSwitch * 100.0 / numberOfGames));
        log.info("Никогда не меняет дверь: {} побед, процент: {}%", countNeverSwitch, (countNeverSwitch * 100.0 / numberOfGames));
        log.info("Рандомно меняет дверь: {} побед, процент: {}%", countRandom, (countRandom * 100.0 / numberOfGames));
    }
}
