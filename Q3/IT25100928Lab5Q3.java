import java.util.Scanner;

public class IT25100928Lab5Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double ROOM_CHARGE = 48000.0;

        System.out.print("Enter Start Date (1-31): ");
        int startDate = scanner.nextInt();

        System.out.print("Enter End Date (1-31): ");
        int endDate = scanner.nextInt();

        // Validation 1: Days must be between 1 and 31
        if (startDate < 1 || startDate > 31 || endDate < 1 || endDate > 31) {
            System.out.println("Error: Days must be between 1 and 31");
            scanner.close();
            return;
        }

        // Validation 2: Start Date must be less than End Date
        if (startDate >= endDate) {
            System.out.println("Error: Start Date must be less than End Date");
            scanner.close();
            return;
        }

        int daysReserved = endDate - startDate;
        double totalAmount = daysReserved * ROOM_CHARGE;

        // Discount applicable for more than 3 days (3-4 days: 10%, 5 or more: 20%)
        double discountRate = 0.0;
        if (daysReserved >= 3 && daysReserved <= 4) {
            discountRate = 0.10;
        } else if (daysReserved >= 5) {
            discountRate = 0.20;
        }

        totalAmount = totalAmount - (totalAmount * discountRate);

        System.out.println("Room Charge Per Day: Rs. " + ROOM_CHARGE + "/=");
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be Paid: " + totalAmount);

        scanner.close();
    }
}