import java.io.File;
import java.util.Scanner;

class RepSumWithoutHM {

    public static void main(String[] args) {

        File dataFile = new File("D:\\SalesEVESession.txt");
        Scanner scannerInput;
        String currentRecord;

        String[] repList = {"E011", "E012", "E013", "E014"};
        double[] repTotals = {0, 0, 0, 0};

        try {
            scannerInput = new Scanner(dataFile);

            if (scannerInput.hasNextLine()) {
                scannerInput.nextLine();
            }

            while (scannerInput.hasNextLine()) {

                currentRecord = scannerInput.nextLine();

                if (currentRecord.trim().length() == 0)
                    continue;

                String[] recordParts = currentRecord.split("\t");

                if (recordParts.length < 6)
                    continue;

                String repCode = recordParts[5];

                double quantitySold = Double.parseDouble(recordParts[3]);
                double unitPrice = Double.parseDouble(recordParts[2]);

                double totalAmount = quantitySold * unitPrice;

                for (int index = 0; index < repList.length; index++) {
                    if (repList[index].equals(repCode)) {
                        repTotals[index] += totalAmount;
                        break;
                    }
                }
            }

            scannerInput.close();

        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }

        System.out.println("=== Rep ID-wise Sales Total (No HashMap) ===");

        for (int index = 0; index < repList.length; index++) {
            System.out.println(repList[index] + " --- " + repTotals[index]);
        }
    }
}