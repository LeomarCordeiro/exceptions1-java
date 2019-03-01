package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String Updates(Date checkIn, Date checkOut) {
		
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation DATE for updates must be future DATES ";
		} 
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: checkOut Date for updates must be after CheckIn Date";

		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room" 
				+ roomNumber
				+ ", checkin: "
				+sdf.format(checkIn)
				+ ", checkout: "
				+sdf.format(checkOut)
				+ ", "
				+duration()
				+" nigths"; 

	}

}
