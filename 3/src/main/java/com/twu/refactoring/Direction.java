package com.twu.refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Direction {

    private final char direction;

    private static final Map<Character, List<Direction>> CHARACTER_MAP
             = new HashMap<Character, List<Direction>>() {
        {
            put('N', Arrays.asList(new Direction('W'), new Direction('E')));
            put('S', Arrays.asList(new Direction('E'), new Direction('W')));
            put('E', Arrays.asList(new Direction('N'), new Direction('S')));
            put('W', Arrays.asList(new Direction('S'), new Direction('N')));
        }
    };

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        return findDirection(direction).get(1);
    }

    public Direction turnLeft() {
        return findDirection(direction).get(0);
    }

    private List<Direction> findDirection(char direction) {
        if (!CHARACTER_MAP.containsKey(direction)) {
            throw new IllegalArgumentException();
        } else {
            return CHARACTER_MAP.get(direction);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
