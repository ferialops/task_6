package ru.vsu.cs.kunakhova_a_y;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x = readValue("x ", -1, 1);
        int n = (int)readValue("n ", 0);
        double E = readValue("E ", 0);
        double sumNMembersOfSequence = calculateSumOfFirstMembers(n, x, 0);
        double sumMembersOfSequenceMoreThenE = calculateSumOfFirstMembers(n, x, E);
        double sumMembersOfSequenceMoreThenEDivide10 = calculateSumOfFirstMembers(n, x, E / 10);
        double valueOfFunction = calculateValueOfFunction(x);
        printResults(sumNMembersOfSequence, sumMembersOfSequenceMoreThenE, valueOfFunction,
                sumMembersOfSequenceMoreThenEDivide10, E, n);
    }
    private static double readValue(String name) {
        System.out.println("Enter " + name + ":");
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
    private static double readValue(String name, double minValue) {
        double value = readValue(name);
        if (!( value > minValue)) {
            System.out.println("Wrong value for " + name + ". Value can only be more then " + minValue);
            return readValue(name, minValue);
        } else {
            return value;
        }
    }
    private static double readValue(String name, double minValue, double maxValue) {
        double value = readValue(name);
        if (!( value < maxValue)||!(value > minValue)) {
            System.out.println("Wrong value for " + name + ". Value can only be more then " + minValue + " and less then " + maxValue);
            return readValue(name, minValue, maxValue);
        } else {
            return value;
        }
    }
    private static double calculateSumOfFirstMembers(int n, double x, double valueForComparison) {
        double previousMemberOfSequence = 1;
        double sumNMembersOfSequence = 0;
        double temp;
        double moduleTemp;
        for (int i = 1; i <= n; i++) {
            temp = function(i, previousMemberOfSequence, x);
            if (temp < 0) {
                moduleTemp = -temp;
            } else {
                moduleTemp = temp;
            }
            if (moduleTemp > valueForComparison) {
                sumNMembersOfSequence += temp;
            }
            previousMemberOfSequence = temp;
        }
        return sumNMembersOfSequence;
    }

    private static double calculateValueOfFunction(double valueX) {
        return (1 / (1 + valueX));
    }

    private static void printResults(double sumNMembersOfSequence, double sumMembersOfSequenceMoreThenE,
                                     double valueOfFunction, double sumMembersOfSequenceMoreThenEDivide10,
                                     double E, int n) {
        System.out.printf("Sum of first %1$d members of sequence: %2$.5f \n", n, sumNMembersOfSequence);
        System.out.printf("Sum members of sequence more then E= %1$.5f : %2$.5f \n", E, sumMembersOfSequenceMoreThenE);
        System.out.printf("Sum members of sequence more then E/10: %1$.5f \n", sumMembersOfSequenceMoreThenEDivide10);
        System.out.printf("Value calculated by the function: %1$.5f", valueOfFunction);
    }

    private static double function(int n, double previousMemberOfSequence, double x) {
        if (n == 1) {
            return 1;
        }
        return previousMemberOfSequence * (-x);
    }
}

