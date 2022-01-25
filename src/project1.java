/*
Charles Lett Jr.
Intro To Math Program
Desc: Computes quadratic equations and determines root type
 */

import java.util.ArrayList;
import java.util.Arrays;

public class project1 {
    public static void main(String[] args){
        boolean enable_debug = false;                // if true: shows debug info

        // arrayList that hold results and root type
        ArrayList<String[]> data = new ArrayList<>();

        // number storage
        double[][] number_storage = {{1, -3, 4},       // example 1
                                     {-4, 12, -9},     // example 2
                                     {2, -11, 5}};     // example 3


        // Original for loop: for (int i = 0; i < number_storage.length; i++)
        // Enhanced for loop: for (int[] ints : number_storage) (introduced in Java 5)
        // ***Link: https://www.cis.upenn.edu/~matuszek/General/JavaSyntax/enhanced-for-loops.html***
        //      ^ simpler way, ':' equals 'in'; for value 'in' array
        //              ^ String: for (String[] strings : array_name)
        //              ^ int: for (int[] ints : array_name
        //      ^ simple but inflexible: can be used for going through elements of an array
        //        first-to-last, and you don't need to know the index of the current element.
        //        Any other causes the standard for loop should be used.

        // worker loop; inserts each number array and executes quadratic method
        for (double[] values : number_storage) {
            q_calc(data, values[0], values[1], values[2], enable_debug);
        }

        q_display(data);        // display to user

    }

    static void q_calc(ArrayList<String[]> arrayList, double a, double b, double c, boolean enable_debug){
        // calculations and data storage

        String[] temp = new String[4];      // temp storage

        double root = b * b - 4 * a * c;                            // determinate
        double pos_formula = (- b + Math.sqrt(root)) / (2 * a);     // positive formula (root 1)
        double neg_formula = (- b - Math.sqrt(root)) / (2 * a);     // negative formula (root 2)

        // debug
        if (enable_debug) {
            System.out.println(a + ", " + b + ", " + c + "\n" +
                               root + "\n" +
                               pos_formula + "\n" +
                               neg_formula + "\n");
        }

        // store String converted data
        temp[0] = String.valueOf(pos_formula);
        temp[1] = String.valueOf(neg_formula);
        temp[2] = String.valueOf(root);

        // root type check
        if (root < 0) temp[3] = "No Real Roots";
        if (root == 0) temp[3] = "One Real Root";
        if (root > 0) temp[3] = "Two Real Roots";

        arrayList.add(temp);                    // store data in array list for display
        // temp = new String[temp.length];      // purge array, not needed

    }

    static void q_display(ArrayList<String[]> arrayList){
        // display Arraylist
        System.out.println("Key = [Formula(+), Formula(-), Root, Real Root Type]");
        for (String[] values : arrayList) {
            System.out.println(Arrays.toString(values));
        }
    }
}
