package ru.geekbrains.java.level1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static private Scanner sc = new Scanner(System.in);
    static private Random random = new Random();

    public static void guessNumber() {
        gritting();
        boolean gameRepeat;
        do {
            game();
            gameRepeat = gameRepeatMet();
        } while (gameRepeat);
        System.out.println("Игра \"Угадай число\" окончена");
    }

    /**
     * Приветствие
     */
    private static void gritting() {
        System.out.println("Привет! Я загадал число от 0 до 9");
        System.out.println("У тебя есть 3 попытки угадать его");
    }

    /**
     * Игровой цикл
     */
    private static void game() {
        int number = random.nextInt(10); //выбор случайного числа от 0 до 9
        int attempt = 1; //попытки, всего 3
        int a; //число введённое пользователем
        do {
            System.out.printf("Попытка №%d: ", attempt);
            a = sc.nextInt();
            System.out.println();
            if (a < 0 || a > 9){
                System.out.println("Введите число от 0 до 9");
            } else if (a > number) {
                System.out.println("Загаданное число меньше");
            } else if (a < number) {
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Поздравляю вы выграли");
                break;
            }
            attempt++;
        } while (attempt <= 3);
        if (a != number){
            System.out.println("Попытки закончились. Вы проиграли.");
        }
    }

    /**
     * Запрос на повтор игры, возвращает true или false
     */
    public static boolean gameRepeatMet() {
        System.out.print("Повторить игру еще раз? 1 – да / 0 – нет: ");
        int ans;
        do  {
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
