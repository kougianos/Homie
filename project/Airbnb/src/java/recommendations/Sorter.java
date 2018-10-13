/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendations;

import java.util.ArrayList;

/**
 *
 * @author kougi
 */

// https://stackoverflow.com/questions/16088994/sorting-an-array-of-int-using-bubblesort
public class Sorter {

    public void sort(ArrayList<Pair> pairs) {
        int n = pairs.size();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (-pairs.get(j - 1).getRate() > -pairs.get(j).getRate()) {
                    Pair temp = pairs.get(j - 1);
                    pairs.set(j - 1, pairs.get(j));
                    pairs.set(j, temp);
                }
            }
        }
    }
}
