import java.util.HashMap;
import java.util.Random;

public class Main {
    static void list (int[] randNumber, int N) {
        HashMap<Integer, Integer> finalNumbers = new HashMap<Integer, Integer>(); // итоговый словарь
        int x = 0;
        for(int i = 0; i < randNumber.length; i++) {
            x = 0;
            for(int y = 0; y < randNumber.length; y++) {
                if (randNumber[i] == randNumber[y])
                    x++;
                if (x == N) {
                    finalNumbers.put(randNumber[i], i); // поскольку ключ - уникальное значение, то оно автоматически убирает дубликаты
                    break;
                }
            }
        }
        for(Integer i : finalNumbers.keySet()) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int[] randNumber = new int[100];
        for (int i = 0; i < 100; i++) {
            randNumber[i] = rand.nextInt(10) + 1;
        } // массив чисел для проверки
        list(randNumber, 12); // функция для Задания 2

        // Задание 1
        String[] Rule = new String[4]; // массив строк
        Rule[0] = "FirstRule";
        Rule[1] = "SecondRule";
        Rule[2] = "ThirdRule";
        Rule[3] = "FourthRule";

        int[] keys = new int[100]; // массив ключей
        int i = 0;
        while(i < 100) {
            int randInt = rand.nextInt(500)+1;
            boolean badRandom = false;
            for (int j = 0; j < i; j++) {
                if (keys[j] == randInt) {
                    badRandom = true;
                    break;
                }
            }
            if (badRandom) continue;
            keys[i] = randInt;
            i++;
        }

        HashMap<Integer, String> randMap = new HashMap<Integer, String>();

        for (int x = 0; x < keys.length; x++) {
            randMap.put(keys[x], Rule[rand.nextInt(4)]);
        } // словарь из 100 случайных пар

        for (Integer y : randMap.keySet()) {
            System.out.println("key " + y + " value: " + randMap.get(y));
        }
        randMap.clear();

    }
}