package org.example.Day4;

public class Member {

    private String name;
    private int age;

    public boolean hasNotInfo() {
        return name.isEmpty() || age >= 0;
    }
}
