package org.tfoc;

import java.util.Arrays;

/**
 * The class containing the solution to this exercise
 */
public class Solution {
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        var arrayA = a.codePoints().sorted().toArray();
        var arrayB = b.codePoints().sorted().toArray();
        return Arrays.equals(arrayA, arrayB);
    }
}
