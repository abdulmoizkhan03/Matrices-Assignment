import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ProductSumWithHM {

    public static void main(String[] args) {

        File salesFile = new File("D:\\SalesEVESession.txt");
        Scanner fileReader;
        String currentLine;
        HashMap<String, Double> productTotals = new HashMap<>();

        try {
            fileReader = new Scanner(salesFile);
            currentLine = fileReader.nextLine();

            while (fileReader.hasNextLine()) {

                currentLine = fileReader.nextLine();

                if (currentLine.trim().length() == 0)
                    continue;

                String[] fields = currentLine.split("\t");

                String productName = fields[1];

                double quantitySold = Double.parseDouble(fields[3]);

                double unitPrice = Double.parseDouble(fields[2]);

                double totalAmount = quantitySold * unitPrice;

                if (productTotals.containsKey(productName)) {
                    totalAmount += productTotals.get(productName);
                }

                productTotals.put(productName, totalAmount);
            }

        } catch (Exception ex) {

            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("=== Product-wise Sales Total (With HashMap) ===");

        for (Map.Entry<String, Double> productEntry : productTotals.entrySet()) {

            System.out.println(productEntry.getKey() + " --- " + productEntry.getValue());
        }
    }
}