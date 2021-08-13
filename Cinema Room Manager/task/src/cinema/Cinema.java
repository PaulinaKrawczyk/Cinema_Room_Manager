package cinema;

import java.util.Scanner;

public class Cinema {

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

		System.out.println("Cinema:");
		System.out.print("  ");
		for (int i = 1; i < seats + 1; i++) {
			System.out.print(i + " ");
		System.out.println();
		for (int j = 1; j < row + 1; j++) {
			System.out.print(j + " ");
			for (int i = 0; i < seats; i++) {
				System.out.print(matrix[j - 1][i] + " ");
			}
			System.out.println();
		}


		System.out.println("Enter a row number:");
		int ticketRow = scanner.nextInt();
		System.out.println("Enter a seat number in that row:");
		int ticketSeat = scanner.nextInt();

		int price = 0;
		if (row *seats < 60){
			price = 10;
		} else if (ticketRow > row/2){
			price = 8;
		} else
			price = 10;

		System.out.println("Ticket price: " +"$" + price);

		matrix[ticketRow-1][ticketSeat-1] = "B";

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

	}

}

