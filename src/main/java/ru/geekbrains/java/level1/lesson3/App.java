package ru.geekbrains.java.level1.lesson3;

import java.util.Scanner;

import static ru.geekbrains.java.level1.lesson3.GuessNumber.guessNumber;
import static ru.geekbrains.java.level1.lesson3.GuessWord.guessWord;

public class App {
    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ans; //ответ на запрос о повторе выбора игр true|false
        do {
            int choseGame = chooseGameMet(); //Выбор игры
            switch (choseGame) {
                case 1:
                    guessNumber(); //запуск игры угадай номер
                    break;
                case 2:
                    guessWord(); //запуск игры угадай слово
                    break;
            }
            ans = gameRepeatMet(); //запрос на повтор выбора игр
        } while (ans);
        System.out.println("\nДо встречи следующий раз!");

    }

    /**
     * Выбор игры
     */
    private static int chooseGameMet() {
        int ans;
        do {
            System.out.println("Выбирете игру:");
            System.out.println("Угадай число - выбери 1");
            System.out.println("Угадай слово - выбери 2");
            System.out.print("Введите номер игры: ");
            ans = sc.nextInt();
            System.out.println();
            if (ans == 2 || ans == 1) {
                break;
            }
            System.out.println("Вы ввели номер не соответствующей ни одной игре");
        } while (true);
        return ans;
    }

    /**
     * Запрос на повтор игры, возвращает true или false
     */
    public static boolean gameRepeatMet() {
        System.out.print("Хотите выбрать другую игру ? 1 – да / 0 – нет: ");
        int ans;
        do {
            ans = sc.nextInt();
            if (ans == 0 || ans == 1) {
                break;
            }
            System.out.println();
            System.out.print("Введите 1 – да / 0 – нет: ");
        } while (true);
        return ans == 1;
    }
}

