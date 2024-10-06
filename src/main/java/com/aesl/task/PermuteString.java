package com.aesl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermuteString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        List<String> permutations = getPermutations(input);
        System.out.println("All permutations of the string are:");
        for (String perm : permutations) {
            System.out.println(perm);
        }
        scanner.close();
    }

    private static List<String> getPermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return result;
        }

        result.add(String.valueOf(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            List<String> newPerms = new ArrayList<>();

            for (String perm : result) {
                for (int j = 0; j <= perm.length(); j++) {
                    newPerms.add(perm.substring(0, j) + currentChar + perm.substring(j));
                }
            }

            result = newPerms;
        }

        return result;
    }
}
