import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends Thread
{

	static int SIZE_X = 2560;	
	static int SIZE_Y = 1440;	

	Flight List[] = new Flight [25];	//Max number of Flights
	User users[] = new User [15];		//Max numer of Users

	Flight searchResults[] = new Flight[10];

	int userCount = 0;
	User currentUser;
	Booking currentBooking;
	Booking selectedBooking;
	Flight currentFlight;


	Main()	throws InterruptedException
	{

		start();	//Start filling up flights
		Thread.sleep(1000);//First Round done

		JFrame frame = new JFrame("Flight Manager");
		frame.setSize(SIZE_X, SIZE_Y);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CardLayout card = new CardLayout();
		Container c = frame.getContentPane();
		c.setLayout(card);

		Page.loadPages(this, card,c);
	}

	public void run()
	{
		/*	Thread Responsible for populating new Flights	*/
		try
		{
			Flight.simulate(this);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String []args)
	{
		try
		{
			new Main();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
///////////////////////////////////////////////////////////////
	public boolean login (String email, String password)
	{
		currentUser = User.searchUser(this, email);
		if(currentUser  != null && password.equals(currentUser.password))
		{

			return true;
		}
		else
			return false;
	}

	public boolean signUp(String name, String dob, char gender, String email, String pass, String rePass)
	{
		if(pass.equals(rePass) == false)
			return false;
		else
		{
			currentUser = User.createUser(this, name, dob, gender, email, pass);
			return true;
		}
	}

	public boolean editUser(String name, String dob, char gender, String email, String pass)
	{
		return currentUser.editUser(name, dob, gender, email, pass);
	}

	public boolean makeBooking(String from, String to, String date,int n)
	{
		return Flight.search(this, from, to, date, n);	//load into search results
	}

	public void cancelBooking()
	{
		currentUser.deleteBooking(selectedBooking);
	}

	public void selectFlight(String flightNo)
	{
		currentFlight = Flight.getFlight(this, flightNo);
	}
	public void selectBooking(String flight)
	{
		selectedBooking = currentUser.getBooking(flight);
	}
	public boolean ticketDetails(String name, String dob, char gender)
	{
		currentBooking = Booking.createBooking(currentUser, currentFlight, name, dob, gender);
		return true;
	}

	public boolean checkout (String name, String card, String expiry, String code)
	{
		//Assuming valid
		return currentBooking.addTransaction(name, card, expiry, code);
	}
}
