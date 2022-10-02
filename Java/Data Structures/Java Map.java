//Complete this code or write your own from scratch

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> data = new TreeMap<>();
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            data.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(data.containsKey(s) ? s + "=" + data.get(s) : "Not found");
        }
    }
}
