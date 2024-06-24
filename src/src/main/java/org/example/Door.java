package org.example;

import lombok.Getter;

@Getter
public class Door {
    private String surprize;

    public Door(String surprize) {
        this.surprize = surprize;
    }

    public String getSurprize() {
        return surprize;
    }
}
