import java.io.File;
import java.util.Scanner;

class ProductSumWithoutHM {

    public static void main(String[] args) {

        File salesFile = new File("D:\\SalesEVESession.txt");
        Scanner fileReader;
        String lineData;

        String[] itemNames = {"Product A", "Product B", "Product C", "Product D"};
        double[] itemTotals = {0, 0, 0, 0};

        try {
            fileReader = new Scanner(salesFile);

            if (fileReader.hasNextLine()) {
                fileReader.nextLine();
            }

            while (fileReader.hasNextLine()) {

                lineData = fileReader.nextLine();

                if (lineData.trim().length() == 0)
                    continue;

                String[] rowParts = lineData.split("\t");

                if (rowParts.length < 4)
                    continue;

                String productName = rowParts[1];
                double quantitySold = Double.parseDouble(rowParts[3]);
                double unitPrice = Double.parseDouble(rowParts[2]);

                double totalAmount = quantitySold * unitPrice;

                for (int index = 0; index < itemNames.length; index++) {
                    if (itemNames[index].equals(productName)) {
                        itemTotals[index] += totalAmount;
                        break;
                    }
                }
            }

            fileReader.close();

        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }

        System.out.println("=== Product-wise Sales Total (No HashMap) ===");

        for (int index = 0; index < itemNames.length; index++) {
            System.out.println(itemNames[index] + " --- " + itemTotals[index]);
        }
    }
}