import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        return input;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введи арифметическое действие");
        String num = in.nextLine();
        String[] example = num.split(" ");
        String arabic = "1,2,3,4,5,6,7,8,9,10";
        String[] number = arabic.split(",");
        int n1 = 0;
        int n2 = 0;
        int answer = 0;
        int count = 0;
        if (example.length < 3) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
        }
        for (int i = 0; number.length != i; i++) {
            if (example[0].equals(number[i]))
                n1 = i + 1;
        }
        if (n1 == 0) {
            testEnum test = testEnum.valueOf(example[0]);
            n1 = test.getNumber();
            count += 1;
        }
        for (int i = 0; number.length != i; i++) {
            if (example[2].equals(number[i]))
                n2 = i + 1;
        }
        if (n2 == 0) {
            testEnum test = testEnum.valueOf(example[2]);
            n2 = test.getNumber();
            count += 1;
        }
        switch (example[1]) {
            case "+":
                answer = (n1 + n2);
                break;
            case "-":
                answer = (n1 - n2);
                break;
            case "*":
                answer = (n1 * n2);
                break;
            case "/":
                answer = (n1 / n2);
                break;
            default:
                System.out.println("throws Exception //т.к. строка не является математической операцией");
        }
        if (count == 0 && example.length < 4) {
            System.out.println(answer);
        } else if (count == 2 && example.length < 4 && answer > 0) {
            System.out.println(testEnum.values()[answer - 1]);
        } else if (count == 1 && example.length < 4) {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
        } else if (answer < 1) {
            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
        } else {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
}







