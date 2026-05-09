import java.util.Scanner;

public class BConverterA {
    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int decimalNumber = inputReader.nextInt();

        int remainderValue;
        String binaryResult = "";

        while (decimalNumber > 0) {
            remainderValue = decimalNumber % 2;
            binaryResult = remainderValue + binaryResult;
            decimalNumber = decimalNumber / 2;
        }

        System.out.println("Binary: " + binaryResult);
    }
}
