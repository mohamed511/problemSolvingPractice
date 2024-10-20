package com.ant.study;

public class WordLocator {
    public static void main(String[] args) {
        String[][] names = {
                {"Alice", "John", "Bob"},
                {"Charlie", "Bill", "Ben", "John"},
                {"John", "Brian", "John"}
        };
        WordLocation location = WordLocator.find(names, "John");
        System.out.println("row: " + location.getRow() + " col: " + location.getColumn());
    }
    public static class WordLocation {
        private int row;
        private int column;

        public WordLocation(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    public static WordLocation find(String[][] names, String name) {
        int row = 0, col = 0;
        for (row = 0; row < names.length; row++) {
            for (col = 0; col < names[0].length; col++) {
                if (names[row][col].equals(name)) {
                    break;
                }
            }
        }
        return new WordLocation(row, col);
    }
}
