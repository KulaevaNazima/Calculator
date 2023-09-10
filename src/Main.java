import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите пример c целыми числами от 1 до 10: ");
            String str = in.nextLine();
            String[] data = str.split("[+\\-*/]");
            for (var i : data) {
                if (Integer.parseInt(i) > 10 || Integer.parseInt(i) < 1) {
                    throw new Exception("Числа должны быть от 1 до 10");
                }
            }
            result(data, str);
        }
        catch(NumberFormatException e){
            System.out.println("Введен неверный арифметический знак");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Программа завершена");
    }
    private static int calculate (int num1, int num2, String op) {
        int result = 0;
        switch (op) {
            case "*":
                result =  num1 * num2;
                break;
            case "/":
                result =  num1 / num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
        }
        return result;
    }
    private static void result (String[] data, String str) {
            int result;
            char[] ops = new char[2];
            if (data.length == 3) {
                if (Integer.parseInt(data[0]) == 10) {
                    str = str.substring(str.indexOf(data[0])+2);
                } else
                {
                    str = str.substring(str.indexOf(data[0])+1);
                }
                ops[0]= str.charAt(0);
                if (Integer.parseInt(data[1]) == 10) {
                    str = str.substring(str.indexOf(data[1])+2);
                } else {
                    str = str.substring(str.indexOf(data[1])+1);
                }

                ops[1]= str.charAt(0);
                result = calculate(Integer.parseInt(data[0]), Integer.parseInt(data[1]), String.valueOf(ops[0]));
                result = calculate(result, Integer.parseInt(data[2]), String.valueOf(ops[1]));
                System.out.println("Результат = " + result);
            }
            else if (data.length == 2) {
                if (Integer.parseInt(data[0]) == 10) {
                    str = str.substring(str.indexOf(data[0])+2);
                } else
                {
                    str = str.substring(str.indexOf(data[0])+1);
                }
                ops[0]= str.charAt(0);
                result = calculate(Integer.parseInt(data[0]), Integer.parseInt(data[1]), String.valueOf(ops[0]));
                System.out.println("Результат = " + result);
            }
    }
}