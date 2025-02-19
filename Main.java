import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение");
        String input = scanner.nextLine();
        try{
            String result = calc(input);
            System.out.println(result);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if(parts.length !=3){
            throw new Exception("Формат математической операции не удовлетворяет заданию");
        }

        int num1;
        int num2;
        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Введите целые числа от 1 до 10");
        }
        if(num1<1 || num1>10 || num2<1 || num2>10){
            throw new Exception("Одно или несколько вводимых чисел не соответствуют заданному диапазону от 1 до 10");
        }

        String operator = parts[1];
        int result;
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case  "/":
                result = num1 / num2;
            default:
                throw new Exception("Введенный оператор не соответствует условиям задания");
        }
        return String.valueOf(result);
    }
}