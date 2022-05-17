import java.util.Scanner;

public class Main {
    public static void main(String[] input) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Введи арифметическое действие");
        String num = in.nextLine();
        String[] example = num.split(" ");
        String arabic = "1,2,3,4,5,6,7,8,9,10";
        String[] number = arabic.split(",");
        int n1 = 0;
        int n2 = 0;
        int count = 0;
        int answer = 0;
        if (example.length < 3) {
            throw new Exception("т.к. строка не является математической операцией");
        }
        if (example.length > 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
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
        ;
        end(count, example, send(example, n1, n2));
        if (count == 1 && example.length < 4) {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }
    }

    public static int send(String[] ex, int x1, int x2) throws Exception {
        int answer;
        switch (ex[1]) {
            case "+":
                answer = x1 + x2;
                break;
            case "-":
                answer = x1 - x2;
                break;
            case "*":
                answer = x1 * x2;
                break;
            case "/":
                answer = x1 / x2;
                break;
            default:
                throw new Exception("т.к. строка не является математической операцией");
        }
        return answer;
    }

    public static void end(int cou, String[] exa, int an) throws Exception {
        if (cou == 0 && exa.length < 4) {
            System.out.println(an);
        } else if (cou == 2 && exa.length < 4 && an > 0) {
            System.out.println(testEnum.values()[an - 1]);
        } else if (an < 1) {
            throw new Exception("т.к. в римской системе нет отрицательных чисел");
        }
    }
}
