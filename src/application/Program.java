package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int n = sc.nextInt();
		System.out.print("CheckIn (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("CheckOut (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("error: Input Date");

		} 
		else {
			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Reservation :" + reservation);
			System.out.println();
			System.out.println("Updates Reservation");
			System.out.print("CheckIn (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			
			String error = reservation.Updates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error reservation :" + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
			

		}

		sc.close();

	}

}
