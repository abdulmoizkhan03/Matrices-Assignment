import java.util.Scanner;

public class BConverterB {

    public static int[] convertToBinary(int decimalValue) {

        if (decimalValue == 0) {
            return new int[] { 0 };
        }

        int tempValue = decimalValue;
        int bitCount = 0;

        while (tempValue > 0) {
            bitCount++;
            tempValue = tempValue / 2;
        }

        int binaryArray[] = new int[bitCount];

        tempValue = decimalValue;

        for (int index = bitCount - 1; index >= 0; index--) {
            binaryArray[index] = tempValue % 2;
            tempValue = tempValue / 2;
        }

        return binaryArray;
    }

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userNumber = inputScanner.nextInt();

        int outputArray[] = convertToBinary(userNumber);

        System.out.print("Array: ");
        for (int i = 0; i < outputArray.length; i++) {
            System.out.print(outputArray[i]);
        }

        System.out.println();

        inputScanner.close();
    }
}