package cinema;

import java.util.Scanner;

public class Cinema {
    public static int rows;
    public static int noOfSeats;
    public static char[][] twoDimArray;

    public static int totalSeats;
    public static int price = 0;
    public static int ticketPurchased;
    public static int currentIncome;
    public static int totalIncome;

    public static int row1;
    public static int row2;
    public static int row3;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initialize();
        menu();
        int choice;
        do {
            System.out.println("Make your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    print();
                    menu();
                }
                case 2 -> {
                    buy();
                    menu();
                }
                case 3 -> {
                    statistics();
                    menu();
                }
                case 0 -> {
                            return;
                        }
                        default -> System.out.println("Enter 1 or 2 or 0");
                    }
                }
                while (choice != 0) ;
            }

    public static void statistics() {
        System.out.println("Number of purchased tickets: " + ticketPurchased);
        double percentage = (float) ticketPurchased * 100 / (totalSeats);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Current Income: " + "$" + currentIncome);
        if (totalSeats <= 60) {
            price = 10;
            totalIncome = totalSeats * price;
            System.out.println("Total income: " + "$" + totalIncome);
        } else {
            int price1 = 10;
            int price2 = 8;
            totalIncome = (row2 * noOfSeats * price1) + (row3 * noOfSeats * price2);
            System.out.println("Total income: " + "$" + totalIncome);
        }
    }

    public static void menu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void initialize() {
        twoDimArray = new char[][] {
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
                {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'}
        };
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        while (rows < 0) {
            System.out.println("Enter positive number");
            rows = sc.nextInt();
        }
        System.out.println("Enter the number of seats in each row:");
        noOfSeats = sc.nextInt();
        while (noOfSeats < 0) {
            System.out.println("Enter positive number");
            noOfSeats = sc.nextInt();
        }

        totalSeats = rows * noOfSeats;
        row1 = rows / 2;
        row2 = rows / 2;
        row3 = rows - row2;
    }

    public static void print() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int n = 1; n <= noOfSeats; n++) {
            System.out.print(" " + n);
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < noOfSeats; j++) {
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void buy() {
        System.out.println("Enter a row number:");
        int row = sc.nextInt();
        while (row < 0) {
            System.out.println("Enter positive number");
            row = sc.nextInt();
        }
        System.out.println("Enter a seat number in that row:");
        int noOfSeat = sc.nextInt();
        while (noOfSeat < 0) {
            System.out.println("Enter positive number");
            noOfSeat = sc.nextInt();
        }

        if (row > noOfSeats || noOfSeat > rows) {
            System.out.println("Wrong input!");
            buy();
        } else if (twoDimArray[row][noOfSeat - 1] != 'S') {
            System.out.println("That ticket has already been purchased!");
            buy();
        } else if (totalSeats <= 60) {
            price = 10;
            System.out.println("Ticket price: " + "$" + price);
            for (int i = 1; i <= rows; i++) {
                for (int j = 0; j < noOfSeats; j++) {
                    twoDimArray[row][noOfSeat - 1] = 'B';
                }
            }
            ticketPurchased++;
            currentIncome = currentIncome + price;
        } else {
            if (row <= row1) {
                price = 10;
                System.out.println("Ticket price: " + "$" + price);
                for (int i = 1; i <= rows; i++) {
                    for (int j = 0; j < noOfSeats; j++) {
                        twoDimArray[row][noOfSeat - 1] = 'B';
                    }
                }
                currentIncome = currentIncome + price;
                ticketPurchased++;
            } else {
                price = 8;
                System.out.println("Ticket price: " + "$" + price);
                for (int i = 1; i <= rows; i++) {
                    for (int j = 0; j < noOfSeats; j++) {
                        twoDimArray[row][noOfSeat - 1] = 'B';
                    }
                }
                currentIncome = currentIncome + price;
                ticketPurchased++;
            }
        }
    }

}