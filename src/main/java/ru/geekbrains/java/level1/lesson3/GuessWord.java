package ru.geekbrains.java.level1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();


    public static void guessWord(){
        gritting(); //приветствие
        boolean gameRepeat; //повтор игры
        do {
            game(); //запуск игры
            gameRepeat = gameRepeatMet(); //запрос на повтор игры
        } while (gameRepeat);
        System.out.println("Игра \"Угадай слово\" окончена");
    }

    /**
     * Приветствие
     */
    private static void gritting() {
        System.out.println("Привет! Я загадал слово, попробуй отгадать");
    }

    /**
     * Игровой цикл
     */
    private static void game() {
        int ranNum = random.nextInt(25);
        String hiddenWord = words[ranNum];
        //System.out.println(hiddenWord);
        boolean falseAns;
        do {
            System.out.print("Введите слово: ");
            String ans = sc.nextLine();
            falseAns = ans.equalsIgnoreCase(hiddenWord);
            if (!falseAns){
                System.out.print("Не верно ");
                printPlaceholder(ans, hiddenWord); //печать пласхолдера
            }
        }while (!falseAns);
        System.out.println("Вы угадали!");
    }

    /**
     *В случае не правлиьного ответа печатает пласхолдер с угаднными буквами
     */
    private static void printPlaceholder(String ans, String hiddenWord) {
        String placeholder;
        char[] placeholderCharArr = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        char[] ansCharArr = ans.toCharArray();
        char[] hiddenWordCharArr = hiddenWord.toCharArray();
        int length = Math.min(ansCharArr.length, hiddenWordCharArr.length);
        for (int i = 0; i < length; i++) {
            if (ansCharArr[i] == hiddenWordCharArr[i]){
                placeholderCharArr[i] = ansCharArr[i];
            }
        }
        placeholder = new String(placeholderCharArr);
        System.out.println(placeholder);
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
