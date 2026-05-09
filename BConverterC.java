import java.util.Scanner;

public class BConverterC {

    public static String convertToBinary(int decimalValue) {

        if (decimalValue == 0) {
            return "0";
        }

        String binaryResult = "";
        int tempValue = decimalValue;

        while (tempValue > 0) {

            int remainderValue = tempValue % 2;

            binaryResult = remainderValue + binaryResult;

            tempValue = tempValue / 2;
        }

        return binaryResult;
    }

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userInput = inputScanner.nextInt();

        String outputBinary = convertToBinary(userInput);

        System.out.println("Binary: " + outputBinary);

        inputScanner.close();
    }
}