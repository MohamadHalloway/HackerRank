import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        BitSet[] b = {null, new BitSet(length), new BitSet(length)};
        in.nextLine();

        while (in.hasNextLine()){
            String[] line = in.nextLine().split(" ");
            String tOperation = line[0];
            int set = Integer.parseInt(line[1]);
            int setOrIndex = Integer.parseInt(line[2]);

            switch (tOperation){
                case "AND":
                    b[set].and(b[setOrIndex]);
                    break;
                case "OR":
                    b[set].or(b[setOrIndex]);
                    break;
                case "XOR":
                    b[set].xor(b[setOrIndex]);
                    break;
                case "FLIP":
                    b[set].flip(setOrIndex);
                    break;
                case "SET":
                    b[set].set(setOrIndex);
                    break;
            }
            System.out.println(b[1].cardinality() + " " + b[2].cardinality());
        }
    }
}
