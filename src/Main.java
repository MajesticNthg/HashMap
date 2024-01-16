import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static ArrayList<Integer> list (int[] randNumber, int N) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        HashMap<Integer, Integer> finalNumbers = new HashMap<Integer, Integer>(); // итоговый словарь

        for(int i = 0; i < randNumber.length; i++) {
            int x = randNumber[i];
            if (finalNumbers.containsKey(x)) {
                finalNumbers.put(x, finalNumbers.get(x)+1);
            } else {
                finalNumbers.put(x, 1);
            }
            if (finalNumbers.get(x) == N)
                r.add(x);
        }
        return r;
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