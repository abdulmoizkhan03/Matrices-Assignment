import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class RepSumWithHM {

    public static void main(String[] args) {

        File salesFile = new File("D:\\SalesEVESession.txt");
        Scanner fileScanner;
        String currentLine;
        HashMap<String, Double> repTotals = new HashMap<>();

        try {
            fileScanner = new Scanner(salesFile);

            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {

                currentLine = fileScanner.nextLine();

                if (currentLine.trim().length() == 0)
                    continue;

                String[] columns = currentLine.split("\t");

                String representativeID = columns[5];

                double quantitySold = Double.parseDouble(columns[3]);
                double unitPrice = Double.parseDouble(columns[2]);

                double totalAmount = quantitySold * unitPrice;

                if (repTotals.containsKey(representativeID)) {
                    totalAmount += repTotals.get(representativeID);
                }

                repTotals.put(representativeID, totalAmount);
            }

            fileScanner.close();

        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }

        System.out.println("=== Rep ID-wise Sales Total (With HashMap) ===");

        for (Map.Entry<String, Double> entry : repTotals.entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }
    }
}