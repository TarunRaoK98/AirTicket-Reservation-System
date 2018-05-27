
class Booking
{
	Flight flight;
	String name;
	String dob;
	char gender;

	String cardName, card, expiry, code;
	public static Booking createBooking (User currentUser, Flight currentFlight, String name, String dob, char gender)
	{
		Booking b = new Booking();
		b.flight = currentFlight;
		b.name = name;
		b.dob = dob;
		b.gender = gender;
		currentUser.bookings[currentUser.bookingCount++] = b;
		return b;
	}	

	public boolean addTransaction(String name, String card, String expiry, String code)
	{
		this.cardName = name;
		this.card = card;
		this.expiry = expiry;
		this.code =code;
		return true;
	}
	
}
