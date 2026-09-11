import java.util.Scanner;

public class VIPcustomer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();

        if (customerId.startsWith("VIP-")) {
            System.out.println("VIP Customer");
        } else {
            System.out.println("Regular Customer");
        }

        sc.close();
    }
}