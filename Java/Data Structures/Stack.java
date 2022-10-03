import java.util.*;

class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            List<Character> arrOpen = Arrays.asList('(', '[', '{');
            List<Character> arrClose = Arrays.asList(')', ']', '}');
            char[] arrInput = input.toCharArray();

            for (int i = 0; i < arrInput.length; i++) {
                char current = arrInput[i];
                if (current == '_') continue;
                if (arrClose.contains(current)) {
                    char searched = arrOpen.get(arrClose.indexOf(current));
                    for (int j = i - 1; j >= 0; j--) {
                        if ((arrInput[j] == searched) && (j - i % 2 != 0)) {
                            arrInput[i] = '_';
                            arrInput[j] = '_';
                            break;
                        }
                    }
                }
            }
            boolean res = true;
            for (char character : arrInput) {
                if (character != '_') {
                    res = false;
                    break;
                }
            }
            System.out.println(res);

        }
    }
}



