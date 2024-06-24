package org.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
public class MontyHollGame {
    private List<Door> doors;
    private int choice;
    private int openDoorLeader;
    private Random random;

    public MontyHollGame() {
        this.doors = new ArrayList<>();
        random = new Random();
        addThreeDoors();
        choice = userChoiceDoor();
        openDoorLeader = leaderOpenFirstDoor();
    }

    private void addThreeDoors() {
        doors.add(new Door("AUTO"));
        doors.add(new Door("GOAT"));
        doors.add(new Door("GOAT"));
        Collections.shuffle(doors);
    }

    public int userChoiceDoor() {
        choice = random.nextInt(3);
        return choice;
    }

    public int leaderOpenFirstDoor() {
        int doorToOpen;
        do {
            doorToOpen = random.nextInt(3);
        } while (doorToOpen == choice || doors.get(doorToOpen).getSurprize().equals("AUTO"));
        return doorToOpen;
    }

    public boolean playGame(Strategy strategy) {
        boolean switchDoor;
        switch (strategy) {
            case ALWAYS_SWITCH:
                switchDoor = true;
                break;
            case NEVER_SWITCH:
                switchDoor = false;
                break;
            case RANDOM:
                switchDoor = RandomUtils.nextBoolean();
                break;
            default:
                throw new IllegalArgumentException("Unknown strategy: " + strategy);
        }

        if (switchDoor) {
            int newChoice;
            do {
                newChoice = random.nextInt(3);
            } while (newChoice == choice || newChoice == openDoorLeader);
            choice = newChoice;
        }

        return doors.get(choice).getSurprize().equals("AUTO");
    }
}


