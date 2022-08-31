package cinema;

import java.util.Objects;
import java.util.Scanner;

public class Cinema {
    public static int menu() {
        System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public static int price(int row, int seats, int ticketRow) {
        int price = 0;
        if (row * seats <= 60) {
            return price = 10;
        } else if (ticketRow > row / 2) {
            return price = 8;
        } else
            return price = 10;
    }
    public static int calculateTotalIncome(int rows, int seatsPerRow) {

        if (rows * seatsPerRow > 60) {
            int frontHalf = rows / 2;
            int backHalf = (rows % 2) + frontHalf;
            return (frontHalf * seatsPerRow * 10) + (backHalf * seatsPerRow * 8);
        } else if (rows * seatsPerRow <= 60) {
            return  (rows * seatsPerRow) * 10;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] matrix = new String[row][seats];
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < seats; k++) {
                matrix[j][k] = "S";
            }
        }
        int w = menu();
        int number = 0;
        int price = 0;
        double counter = (row * seats);
        int income = 0;
        int totalIncome = calculateTotalIncome(row, seats);


        while (w != 0) {
            switch (w) {
                case 1:
                    System.out.println("Cinema:");
                    System.out.print("  ");
                    for (int i = 1; i < seats + 1; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    for (int j = 1; j < row + 1; j++) {
                        System.out.print(j + " ");
                        for (int i = 0; i < seats; i++) {
                            System.out.print(matrix[j - 1][i] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    w = menu();
                    break;

                case 2:
                    System.out.println("Enter a row number:");
                    int ticketRow = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int ticketSeat = scanner.nextInt();
                    if (ticketSeat > seats || ticketRow > row) {
                        System.out.println("Wrong input!");
                        break;

                    } else if (Objects.equals(matrix[ticketRow - 1][ticketSeat - 1], "B")) {
                        System.out.println("That ticket has already been purchased!");
                        break;
                    } else {
                        price = price(row, seats, ticketRow);
//
                        System.out.println("Ticket price: " + "$" + price);
                        matrix[ticketRow - 1][ticketSeat - 1] = "B";
                        number++;
                        System.out.println();
                        income += price;
                        w = menu();
                        break;
                    }

                case 3:
                    System.out.println("Number of purchased tickets:" + " " + number);
                    System.out.println("Percentage:" + String.format("%.2f", (number * 100) / counter) + "%");
                    System.out.println("Current income:$" + income);
                    System.out.println("Total income:$" + totalIncome);
                    w = menu();
                    break;
                case 0:
                    return;
                default:
                    return;


            }
        }
    }
}


