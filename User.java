class User
{
	String name;
	String password;
	String dob;
	char gender;
	String email;

	Booking bookings[] = new Booking[15];	//Max number of Bookings per User
	int bookingCount = 0;

	public static User createUser(Main main, String name, String dob, char gender, String email, String pass)
	{
		User user = new User();
		main.users[main.userCount++] = user;		
		user.name = name;
		user.dob = dob;
		user.gender = gender;
		user.email = email;
		user.password = pass;	
		return user;
	} 
	
	public static User searchUser(Main main, String email)
	{
		for(int i =0;i<main.userCount;i++)
		{
			if(email.equals(main.users[i].email))
				return main.users[i];
		}
		return null;
	}

	public boolean editUser(String name, String dob, char gender, String email, String pass)
	{
		if (name.equals("")==false)
			this.name = name;
		if (dob.equals("")==false)
			this.dob = dob;
		if (email.equals("")==false)
			this.email = email;
		if (pass.equals("")==false)
			this.password = pass;
		if (gender != ' ')
			this.gender = gender;
		return true;
	}
	
	public Booking getBooking(String flightNo)
	{
		for(int i = 0; i<bookingCount;i++)
		{
			if(flightNo.equals(bookings[i].flight.fl_no))
			{
				return bookings[i];
			}			
		}
		return null;
	}

	public void deleteBooking(Booking b)
	{
		boolean deleted = false;
		for(int i = 0; i<bookingCount;i++)
		{
			if(deleted)
				bookings[i-1] = bookings[i];
			if(b.flight == bookings[i].flight)
			{
				bookings[i]=null;
				deleted = true;
			}			
		}
		bookingCount--;
	}
}
