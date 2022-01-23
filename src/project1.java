/*
Charles Lett Jr.
Intro To Math Program
Desc: Computes quadratic equations and determines root type
 */

import java.util.ArrayList;
import java.util.Arrays;

public class project1 {
    public static void main(String[] args){
        // settings
        boolean enable_debug = true;

        // arrays that hold quadratic formula and root type
        ArrayList<String[]> data = new ArrayList<>();     // stores info

        // number storage
        int[][] number_storage = {{1, -3, 4},       // example 1
                                  {-4, 12, -9},     // example 2
                                  {2, -11, 5}};     // example 3

        // worker loop
        for (int i = 0; i < number_storage.length; i++){
            q_calc(data, number_storage[i][0], number_storage[i][1], number_storage[0][2], enable_debug);
        }

        q_display(data);        // display to user

    }

    static void q_calc(ArrayList<String[]> arrayList, int a, int b, int c, boolean enable_debug){
        // calculations and data storage

        String[] temp = new String[4];      // temp storage

        double root = (b * b) - (4 * a * c);
        double pos_formula = - b + Math.sqrt(root) / (2 * a);     // positive formula
        double neg_formula = - b - Math.sqrt(root) / (2 * a);     // negative formula

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
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(Arrays.toString(arrayList.get(i)));
        }
    }
}
