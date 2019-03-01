package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int n = sc.nextInt();
			System.out.print("CheckIn (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Reservation :" + reservation);
			System.out.println();
			System.out.println("Updates Reservation");
			System.out.print("CheckIn (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.Updates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			
		} 
		catch (ParseException e) {
			System.out.println("Invalid Date Format");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e.getMessage() );
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected Error");
		}
		finally {
			sc.close();
		}

	}

}
