import java.util.HashMap;
import java.util.Map;

public class Main {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
            "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
            "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
            "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit " +
            "anim id est laborum.";

    public static void main(String[] args) {

        // Здесь для каждой буквы хранится количество раз, которое она встречается
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ' && c != '.' && c != ',') { // убираем пробелы и знаки препинания

                //проверка есть ли буква в мапе
                if (map.containsKey(c)) {
                    int v = map.get(c);
                    v++;
                    map.put(c, v);
                } else {
                    map.put(c, 1);
                }
            }
        }
        System.out.println(map);
        // поиск максимального и минимального значения

        int vMax = 0;
        int vMin = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            int v = map.get(c);
            if (v > vMax) {
                vMax = v;
            }
            if (v < vMin) {
                vMin = v;
            }
        }
        System.out.println("Максимальное значение - " + vMax + ". Ему соответствуют буквы:");
        for (var kv : map.entrySet()) {
            if (kv.getValue() == vMax) {
                System.out.print(" \"" + kv.getKey() + "\" ");
            }
        }
        System.out.println();
        System.out.println("Минимальное значение - " + vMin + ". Ему соответствуют буквы:");
        for (var kv : map.entrySet()) {
            if (kv.getValue() == vMin) {
                System.out.print(" \"" + kv.getKey() + "\" ");
            }
        }
    }
}
