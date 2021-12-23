package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'e', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'a', 'a', 'r', 'o', 'v'},
                {'m', 'm', 'p', 'm', 'r', 'h'},
                {'p', 'e', 'e', 'e', 'e', 'j'}
        };
        List<Word> res = detectAllWords(crossword, "same", "home", "mam", "o");
        for (Word word : res) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        for (String word : words) {
            int wordLength = word.length();

            char charFromWord = word.charAt(0);
            if (wordLength == 1) {
                for (int x = 0; x < crossword.length; x++) {
                    for (int y = 0; y < crossword[x].length; y++) {
                        if ((char) crossword[x][y] == charFromWord) {
                            Word find = new Word(word);
                            find.setStartPoint(y, x);
                            find.setEndPoint(y, x);
                            result.add(find);
                        }
                    }
                }
            } else {
                for (int x = 0; x < crossword.length; x++) {
                    for (int y = 0; y < crossword[x].length; y++) {
                        if ((char) crossword[x][y] == charFromWord) {

                            if (y - (wordLength - 1) >= 0) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x][y - l] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }

                                }
                                if (flag) {
                                    Word find = new Word(word);

                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y - (wordLength - 1), x);
                                    result.add(find);
                                }
                            }
                            if (y - (wordLength - 1) >= 0 && x - (wordLength - 1) >= 0) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x - l][y - l] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    Word find = new Word(word);
                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y - (wordLength - 1), x - (wordLength - 1));
                                    result.add(find);
                                }
                            }
                            if (y - (wordLength - 1) >= 0 && x + wordLength - 1 <= crossword.length - 1) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x + l][y - l] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    Word find = new Word(word);
                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y - (wordLength - 1), x + wordLength - 1);
                                    result.add(find);
                                }
                            }

                            if (y + wordLength - 1 <= crossword[x].length - 1) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x][y + l] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    Word find = new Word(word);
                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y + wordLength - 1, x);
                                    result.add(find);
                                }
                            }
                            if (y + wordLength - 1 <= crossword[x].length - 1 && x - (wordLength - 1) >= 0) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x - l][y + l] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    Word find = new Word(word);
                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y + wordLength - 1, x - (wordLength - 1));
                                    result.add(find);
                                }
                            }
                            if (y + wordLength - 1 <= crossword[x].length - 1 && x + wordLength - 1 <= crossword.length - 1) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x + l][y + l] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    Word find = new Word(word);
                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y + wordLength - 1, x + wordLength - 1);
                                    result.add(find);
                                }
                            }

                            if (x - (wordLength - 1) >= 0) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x - l][y] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    Word find = new Word(word);
                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y, x - (wordLength - 1));
                                    result.add(find);
                                }
                            }
                            if (x + wordLength - 1 <= crossword.length - 1) {
                                boolean flag = false;
                                for (int l = 1; l < wordLength; l++) {
                                    if (crossword[x + l][y] == word.charAt(l)) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    Word find = new Word(word);
                                    find.setStartPoint(y, x);
                                    find.setEndPoint(y, x + wordLength - 1);
                                    result.add(find);
                                }
                            }


                        }
                    }

                }
            }

        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
