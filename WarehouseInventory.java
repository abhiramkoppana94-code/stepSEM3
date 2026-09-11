import java.util.Scanner;

public class WarehouseInventory {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int sumA = 0;
        int sumB = 0;

        
        for (int i = 0; i < sectionA.length; i++) {

            sumA = sumA + sectionA[i];
            sumB = sumB + sectionB[i];

        }

        
        if (sumA == sumB) {

            System.out.println("Status : Balanced");

        } else {

            System.out.println("Status : Not Balanced");

        }

        
        int max = sectionA[0];
        int section = 1;
        int index = 0;

        for (int i = 0; i < sectionA.length; i++) {

            if (sectionA[i] > max) {

                max = sectionA[i];
                section = 1;
                index = i;

            }

        }

        for (int i = 0; i < sectionB.length; i++) {

            if (sectionB[i] > max) {

                max = sectionB[i];
                section = 2;
                index = i;

            }

        }

        System.out.println("Section A Total : " + sumA);
        System.out.println("Section B Total : " + sumB);

        System.out.println("Highest Quantity : "
                + max
                + " (Section "
                + (section == 1 ? "A" : "B")
                + ", Item "
                + (index + 1)
                + ")");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items : ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter quantities for Section A");

        for (int i = 0; i < n; i++) {

            sectionA[i] = sc.nextInt();

        }

        System.out.println("Enter quantities for Section B");

        for (int i = 0; i < n; i++) {

            sectionB[i] = sc.nextInt();

        }

        analyzeInventory(sectionA, sectionB);

        sc.close();

    }

}