package task6_R;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readSomething("Enter x value = ");
        double n = readSomething("Enter sequence member number n = ");
        double e = readSomething("Enter epsilon e = ");

        if (checkLimit(x)) {
            double functionResult = calculateFunction(x);
            double sumTheSequence = calculateSumTheSequence(x, n);
            CalculateResult sumEpsilonTheSequence = calculateEpsilonSumTheSequence(x, e);
            CalculateResult sumTheSequenceEpsilonDividedBy10 = calculateEpsilonSumTheSequence(x, e / 10);

            printResalt(functionResult, sumTheSequence, sumEpsilonTheSequence, sumTheSequenceEpsilonDividedBy10, n);

        } else {
            System.out.println("Error, X is not within the limit ");
        }
    }

    public static double readSomething(String name) {
        Scanner in = new Scanner(System.in);
        System.out.print(name);
        return in.nextDouble();
    }

    public static boolean checkLimit(double x) {
        return x >= -1 && x <= 1;
    }

    public static double calculateSumTheSequence(double x, double n) {
        double x0 = x;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            double result = setMemberTheSequence(i, x0);
            if (checkParity(i)) {
                sum = x + result;
            } else {
                sum = x - result;
            }
            x = sum;
        }
        return sum;
    }

    public static double setMemberTheSequence(int i, double x) {
        return (i + 1) * (i + 2) / 2 * Math.pow(x, i);
    }

    public static CalculateResult calculateEpsilonSumTheSequence(double x, double e) {
        double sum = 1;
        double result = setMemberTheSequence(1, x);
        int quantity = 0;

        for (int i = 1; Math.abs(result) < e; ) {
            i++;
            sum += result;
            result = setMemberTheSequence(i, x);
            quantity++;
        }
        return new CalculateResult(quantity, sum);
    }

    public static double calculateFunction(double x) {
        return 1 / Math.pow((1 + x), 3);
    }

    public static boolean checkParity(int i) {
        return i % 2 != 1;
    }

    public static void printResalt(double functionResult, double sumTheSequence, CalculateResult sumEpsilonTheSequence, CalculateResult sumTheSequenceEpsilonDividedBy10, double n) {
        System.out.printf("Sum of the first %1s members of the sequence = %2s \n", n, sumTheSequence);
        System.out.printf("Sum of the first %1s members epsilon of the sequence = %2s\n", sumEpsilonTheSequence.getQuantity(), sumEpsilonTheSequence.getSum());
        System.out.printf("Sum of the first %1s members epsilon divided by 10 of the sequence = %2s \n", sumTheSequenceEpsilonDividedBy10.getQuantity(), sumTheSequenceEpsilonDividedBy10.getSum());
        System.out.printf("For function 1 / (1 + x)^3 the result is = %1s \n ", functionResult);
    }
}
