import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> subarrayCurrent = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int largestUniqueNumbers = 0;
        int largestElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            if (num > largestElement) largestElement = num;
        }

        int[] foundElements = new int[largestElement + 1];

        for (int i = 0; i < m; i++) {
            int element = deque.poll();
            subarrayCurrent.add(element);
            if (foundElements[element]++ == 0) largestUniqueNumbers++;
        }
        int currentUnique = largestUniqueNumbers;
        while (!deque.isEmpty()) {
            int newElement = deque.poll();
            int firstElement = subarrayCurrent.pollFirst();
            subarrayCurrent.add(newElement);
            if (newElement == firstElement) continue;
            if (--foundElements[firstElement] == 0) --currentUnique;
            if (foundElements[newElement]++ == 0) currentUnique++;
            if (currentUnique > largestUniqueNumbers) largestUniqueNumbers = currentUnique;
        }
        System.out.println(largestUniqueNumbers);
    }
}



