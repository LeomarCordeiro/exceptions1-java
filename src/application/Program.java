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
		
		if(!checkOut.after(checkIn)) {
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
			
			
			Date now = new Date();
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation DATE for updates must be future DATES ");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: checkOut Date for updates must be after CheckIn Date");
				
			}
				
			else {
				reservation.Updates(checkIn, checkOut);
				System.out.println("Reservation :" + reservation);
			}
			
			
			
			
		}

		
		
		sc.close();

	}

}
