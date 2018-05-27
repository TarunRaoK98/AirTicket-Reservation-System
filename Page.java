import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Page extends JPanel implements ActionListener
{
	/*
		Color Pallete
		Etihad 
			gold : 	#d5a63b
			white :	#e0dcd4
			brown :	#270014	
		beige_brown   : #9a8772
		Dark Blue 
			background : #48647c
			foreground : #7891B1
			accent     : #2c3e50
	*/
	CardLayout card;
	Container c;
	static Main main;
	static String currentPage = "Home";

	JTextField nameField, dobField, emailField, dateField, ticketField, cardField, expiryField, codeField;
	JPasswordField passField, rePassField;
	JRadioButton male, female;

	JComboBox<String>  fromField, toField;
	JCheckBox  matchingFlights[], bookings[];

	static final int borderSize = (int)(Main.SIZE_X/85);
	static final int btnSizeX = (int)(Main.SIZE_X/8);
	static final int btnSizeY = (int)(Main.SIZE_Y/15);
	static final int BtnFontSize = (int)(Main.SIZE_X/64);

	static final Color backgroundColor = Color.decode("#e0dcd4");
	static final Color foregroundColor = Color.decode("#d5a63b");
	static final Color accentColor = Color.decode("#270014");

	static final Font headerFont = new Font("Verdana",Font.BOLD,borderSize*2);
	static final Font normalFont = new Font("Verdana",Font.PLAIN,(int)(Main.SIZE_X/64));

	static final Dimension headerSize = new Dimension(Main.SIZE_X,(int) ( Main.SIZE_Y/6));
	static final Dimension buttonSize = new Dimension(btnSizeX,btnSizeY);
	static final Dimension bigButtonSize = new Dimension((int)(btnSizeX*1.66), btnSizeY);
	static final Dimension pageSize = new Dimension(Main.SIZE_X, Main.SIZE_Y);

	Page(CardLayout card, Container c, String tag)
	{
		this.card = card;
		this.c = c;
		setBounds(0, 0, Main.SIZE_X, Main.SIZE_Y);
		setBackground(Color.gray);
		c.add(tag, this);
	}

	static void loadPages(Main obj, CardLayout card, Container c)
	{
		Page.main = obj;
		new Page(card, c, "Home").home();
		new Page(card, c, "SignUp").signUp();
		new Page(card, c, "DashBoard").dashBoard();
		new Page(card, c, "EditProfile").editProfile();

		new Page(card, c, "CancelBooking").cancelBooking();
		new Page(card, c, "MakeBooking").makeBooking();

		new Page(card, c, "TicketDetails").ticketDetails();
		new Page(card, c, "Checkout").checkout();
		new Page(card, c, "Confirmation").confirmation();

	}

	void home ()
	{
		JLabel title = new JLabel("FLIGHT MANAGER",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel emailID = new JLabel("Email", JLabel.LEFT);
		emailID.setFont(normalFont);
		emailField = new JTextField();
		emailField.setFont(normalFont);

		JLabel password = new JLabel("Password", JLabel.LEFT);
		password.setFont(normalFont);
		passField = new JPasswordField();
		passField.setFont(normalFont);
		passField.setEchoChar('*');

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(emailID);		body.add(emailField);
		body.add(password);		body.add(passField);

		/*	Body end	*/

		JButton b1 = new JButton ("Log In");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(buttonSize);
		b1.setActionCommand("DashBoard");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Sign Up");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(buttonSize);
		b2.setActionCommand("SignUp");
		b2.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);
		buttons.add(b2);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);
	}

	void signUp()
	{
		JLabel title = new JLabel("SIGN UP",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel name = new JLabel("Name",JLabel.LEFT);
		name.setFont(normalFont);
		nameField = new JTextField();
		nameField.setFont(normalFont);


		JLabel dob = new JLabel("Date of Birth",JLabel.LEFT);
		dob.setFont(normalFont);
		dobField = new JTextField();
		dobField.setFont(normalFont);

		//Radio Buttons start

		JLabel gender = new JLabel("Gender",JLabel.LEFT);
		gender.setFont(normalFont);

		male = new JRadioButton("Male");
		male.setFont(normalFont);
		male.setBackground(backgroundColor);
		male.setPreferredSize(new Dimension(btnSizeX, btnSizeY-borderSize));

		female = new JRadioButton("Female");
		female.setFont(normalFont);
		female.setBackground(backgroundColor);
		female.setPreferredSize(new Dimension(btnSizeX, btnSizeY-borderSize));

		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);


		JPanel radioGroup = new JPanel(new FlowLayout());
		radioGroup.setBackground(backgroundColor);
		radioGroup.add(male);
		radioGroup.add(female);

		//Radio Buttons end

		JLabel emailID = new JLabel("Email", JLabel.LEFT);
		emailID.setFont(normalFont);
		emailField = new JTextField();
		emailField.setFont(normalFont);

		JLabel password = new JLabel("Password", JLabel.LEFT);
		password.setFont(normalFont);
		passField = new JPasswordField();
		passField.setFont(normalFont);
		passField.setEchoChar('*');

		JLabel rePassword = new JLabel("Re-Enter Password", JLabel.LEFT);
		rePassword.setFont(normalFont);
		rePassField = new JPasswordField();
		rePassField.setFont(normalFont);
		rePassField.setEchoChar('*');

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(name);			body.add(nameField);
		body.add(dob);			body.add(dobField);
		body.add(gender);		body.add(radioGroup);
		body.add(emailID);		body.add(emailField);
		body.add(password);		body.add(passField);
		body.add(rePassword);		body.add(rePassField);

		/*	Body end	*/

		JButton b1 = new JButton ("Submit");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(buttonSize);
		b1.setActionCommand("DashBoard");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Cancel");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(buttonSize);
		b2.setActionCommand("Home");
		b2.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);
		buttons.add(b2);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void dashBoard()
	{

		JLabel title = new JLabel("DASHBOARD",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);

		JButton b1 = new JButton ("Edit Profile");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(bigButtonSize);
		b1.setActionCommand("EditProfile");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Make Booking");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(bigButtonSize);
		b2.setActionCommand("MakeBooking");
		b2.addActionListener(this);

		JButton b3 = new JButton ("Manage Bookings");
		b3.setFont(normalFont);
		b3.setBackground(foregroundColor);
		b3.setPreferredSize(bigButtonSize);
		b3.setActionCommand("ManageBookings");
		b3.addActionListener(this);

		JButton b4 = new JButton ("Log Out");
		b4.setFont(normalFont);
		b4.setBackground(foregroundColor);
		b4.setPreferredSize(bigButtonSize);
		b4.setActionCommand("Home");
		b4.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);		buttons.add(b2);
		buttons.add(b3);		buttons.add(b4);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void editProfile()
	{
		JLabel title = new JLabel("EDIT PROFILE",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel name = new JLabel("Name",JLabel.LEFT);
		name.setFont(normalFont);
		nameField = new JTextField();
		nameField.setFont(normalFont);


		JLabel dob = new JLabel("Date of Birth",JLabel.LEFT);
		dob.setFont(normalFont);
		dobField = new JTextField();
		dobField.setFont(normalFont);

		//Radio Buttons start

		JLabel gender = new JLabel("Gender",JLabel.LEFT);
		gender.setFont(normalFont);

		male = new JRadioButton("Male");
		male.setFont(normalFont);
		male.setBackground(backgroundColor);
		male.setPreferredSize(new Dimension(btnSizeX, btnSizeY-borderSize));

		female = new JRadioButton("Female");
		female.setFont(normalFont);
		female.setBackground(backgroundColor);
		female.setPreferredSize(new Dimension(btnSizeX, btnSizeY-borderSize));

		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);


		JPanel radioGroup = new JPanel(new FlowLayout());
		radioGroup.setBackground(backgroundColor);
		radioGroup.add(male);
		radioGroup.add(female);

		//Radio Buttons end

		JLabel emailID = new JLabel("Email", JLabel.LEFT);
		emailID.setFont(normalFont);
		emailField = new JTextField();
		emailField.setFont(normalFont);

		JLabel password = new JLabel("Password", JLabel.LEFT);
		password.setFont(normalFont);
		passField = new JPasswordField();
		passField.setFont(normalFont);
		passField.setEchoChar('*');

		JLabel rePassword = new JLabel("Re-Enter Password", JLabel.LEFT);
		rePassword.setFont(normalFont);
		rePassField = new JPasswordField();
		rePassField.setFont(normalFont);
		rePassField.setEchoChar('*'); 				;

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(name);			body.add(nameField);
		body.add(dob);			body.add(dobField);
		body.add(gender);		body.add(radioGroup);;
		body.add(emailID);		body.add(emailField);
		body.add(password);		body.add(passField);
		body.add(rePassword);		body.add(rePassField);

		JButton b1 = new JButton ("Save");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(buttonSize);
		b1.setActionCommand("DashBoard_submit");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Cancel");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(buttonSize);
		b2.setActionCommand("DashBoard");
		b2.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);
		buttons.add(b2);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void manageBookings()
	{
		JLabel title = new JLabel("MANAGE BOOKINGS",JLabel.CENTER);
    	title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);

		bookings = new JCheckBox[main.currentUser.bookingCount];

		for(int i = 0; i<bookings.length;i++)
		{
			bookings[i] = new JCheckBox(main.currentUser.bookings[i].flight.fl_no);
			bookings[i].setFont(normalFont);
			bookings[i].setBackground(backgroundColor);
			body.add(bookings[i]);
		}

		/*	Body	End	*/
		JButton b1 = new JButton ("Make Booking");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(bigButtonSize);
		b1.setActionCommand("MakeBooking");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Cancel Booking");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(bigButtonSize);
		b2.setActionCommand("CancelBooking");
		b2.addActionListener(this);

		JButton b3 = new JButton ("Back");
		b3.setFont(normalFont);
		b3.setBackground(foregroundColor);
		b3.setPreferredSize(bigButtonSize);
		b3.setActionCommand("DashBoard");
		b3.addActionListener(this);


		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);		buttons.add(b2);
		buttons.add(b3);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void cancelBooking()
	{

		JLabel title = new JLabel("CANCEL CONFIRMATION",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/6), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/6), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel prompt = new JLabel("Are you sure you want to cancel this Flight?",JLabel.CENTER);
    		prompt.setFont(headerFont);

		JPanel body = new JPanel (new BorderLayout());
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(prompt, BorderLayout.CENTER);

		JButton b1 = new JButton ("Yes");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(bigButtonSize);
		b1.setActionCommand("DashBoard_submit");
		b1.addActionListener(this);

		JButton b2 = new JButton ("No");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(bigButtonSize);
		b2.setActionCommand("DashBoard");
		b2.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);		buttons.add(b2);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);
	}

	void makeBooking()
	{
		JLabel title = new JLabel("SEARCH FLIGHT",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel from = new JLabel("From",JLabel.LEFT);
		from.setFont(normalFont);
		fromField = new JComboBox<String>(Flight.Cities);
		fromField.setFont(normalFont);

		JLabel to = new JLabel("To",JLabel.LEFT);
		to.setFont(normalFont);
		toField = new JComboBox<String>(Flight.Cities);
		toField.setFont(normalFont);

		JLabel date = new JLabel("Date", JLabel.LEFT);
		date.setFont(normalFont);
		dateField = new JTextField();
		dateField.setFont(normalFont);

		JLabel ticket = new JLabel("No. of tickets", JLabel.LEFT);
		ticket.setFont(normalFont);
		ticketField = new JTextField();
		ticketField.setFont(normalFont);

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(from);			body.add(fromField);
		body.add(to);			body.add(toField);
		body.add(date);			body.add(dateField);
		body.add(ticket);		body.add(ticketField);


		JButton b1 = new JButton ("Search");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(buttonSize);
		b1.setActionCommand("MatchingFlights");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Back");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(buttonSize);
		b2.setActionCommand("DashBoard");
		b2.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);
		buttons.add(b2);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void matchingFlights()
	{

		JLabel title = new JLabel("MATCHING FLIGHTS",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);


		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JPanel body = new JPanel (new GridLayout(12, 3, 0, 0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);


		matchingFlights = new JCheckBox[(main.searchResults.length)];
		ButtonGroup flightGroup = new ButtonGroup();
		for(int i = 0; i<matchingFlights.length;i++)
		{
			matchingFlights[i] = new JCheckBox(main.searchResults[i].fl_no);
			matchingFlights[i].setFont(normalFont);
			matchingFlights[i].setBackground(backgroundColor);
			flightGroup.add(matchingFlights[i]);
			body.add(matchingFlights[i]);
		}

		/*	Body End	*/
		JButton b1 = new JButton ("Next");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(buttonSize);
		b1.setActionCommand("TicketDetails");
		b1.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void ticketDetails()
	{

		JLabel title = new JLabel("TICKET DETAILS",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel name = new JLabel("Name of Passenger",JLabel.LEFT);
		name.setFont(normalFont);
		nameField = new JTextField();
		nameField.setFont(normalFont);


		JLabel dob = new JLabel("Date of Birth",JLabel.LEFT);
		dob.setFont(normalFont);
		dobField = new JTextField();
		dobField.setFont(normalFont);

		//Radio Buttons start

		JLabel gender = new JLabel("Gender",JLabel.LEFT);
		gender.setFont(normalFont);

		male = new JRadioButton("Male");
		male.setFont(normalFont);
		male.setBackground(backgroundColor);
		male.setPreferredSize(new Dimension(btnSizeX, btnSizeY-borderSize));

		female = new JRadioButton("Female");
		female.setFont(normalFont);
		female.setBackground(backgroundColor);
		female.setPreferredSize(new Dimension(btnSizeX, btnSizeY-borderSize));

		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);


		JPanel radioGroup = new JPanel(new FlowLayout());
		radioGroup.setBackground(backgroundColor);
		radioGroup.add(male);
		radioGroup.add(female);

		//Radio Buttons end

		JLabel seatpref = new JLabel("Seat Preference", JLabel.LEFT);
		seatpref.setFont(normalFont);
		JComboBox<String> seat = new JComboBox<String>();
		seat.setFont(normalFont);
		seat.addItem("Window");
		seat.addItem("Aisle");
		seat.addItem("Front row");
		seat.addItem("Exit row");
		seat.addItem("No preference");

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(name);			body.add(nameField);
		body.add(dob);			body.add(dobField);
    body.add(gender);		body.add(radioGroup);
		body.add(seatpref);		body.add(seat);

		/*	Body End	*/
		JButton b1 = new JButton ("Checkout");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(buttonSize);
		b1.setActionCommand("Checkout");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Back");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(buttonSize);
		b2.setActionCommand("MakeBooking");
		b2.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);
		buttons.add(b2);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void checkout()
	{

		JLabel title = new JLabel("CHECKOUT",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/3), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel card = new JLabel("Card number",JLabel.LEFT);
		card.setFont(normalFont);
		cardField = new JTextField();
		cardField.setFont(normalFont);

		JLabel name = new JLabel("Name on card",JLabel.LEFT);
		name.setFont(normalFont);
		nameField = new JTextField();
		nameField.setFont(normalFont);

		JLabel typecard = new JLabel("Type of card", JLabel.LEFT);
		typecard.setFont(normalFont);
		JComboBox<String> type = new JComboBox<String>();
		type.setFont(normalFont);
		type.addItem("Visa");
		type.addItem("Mastercard");
		type.addItem("American Express");
		type.addItem("Discover");

		JLabel expiry = new JLabel("Expiry date", JLabel.LEFT);
		expiry.setFont(normalFont);
		expiryField = new JTextField();
		expiryField.setFont(normalFont);

		JLabel code = new JLabel("Security code", JLabel.LEFT);
		code.setFont(normalFont);
		codeField = new JTextField();
		codeField.setFont(normalFont);

		JPanel body = new JPanel (new GridLayout(12,1,0,0));
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(card);			body.add(cardField);
		body.add(name);			body.add(nameField);
		body.add(typecard);			body.add(type);
		body.add(expiry);		body.add(expiryField);
		body.add(code);		body.add(codeField);

		JButton b1 = new JButton ("Confirm");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(buttonSize);
		b1.setActionCommand("Confirmation");
		b1.addActionListener(this);

		JButton b2 = new JButton ("Cancel");
		b2.setFont(normalFont);
		b2.setBackground(foregroundColor);
		b2.setPreferredSize(buttonSize);
		b2.setActionCommand("MakeBooking");
		b2.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);
		buttons.add(b2);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}

	void confirmation()
	{

		JLabel title = new JLabel("CONFIRMATION",JLabel.CENTER);
    		title.setFont(headerFont);

		JPanel head = new JPanel (new BorderLayout());
		head.setPreferredSize(headerSize);
		head.setBackground(foregroundColor);
		head.add(title, BorderLayout.CENTER);

		JPanel left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension((int) ( Main.SIZE_X/6), (int) ( Main.SIZE_Y)));
		left.setBackground(backgroundColor);

		JPanel right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension((int) ( Main.SIZE_X/6), (int) ( Main.SIZE_Y)));
		right.setBackground(backgroundColor);

		/*	Body	*/

		JLabel prompt = new JLabel("Your Air ticket was Booked Successfully",JLabel.CENTER);
    		prompt.setFont(headerFont);

		JPanel body = new JPanel (new BorderLayout());
		body.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		body.setBackground(backgroundColor);
		body.add(prompt, BorderLayout.CENTER);

		JButton b1 = new JButton ("DashBoard");
		b1.setFont(normalFont);
		b1.setBackground(foregroundColor);
		b1.setPreferredSize(bigButtonSize);
		b1.setActionCommand("DashBoard");
		b1.addActionListener(this);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, borderSize,0));
		buttons.setBackground(backgroundColor);
		buttons.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
		buttons.add(b1);

		JPanel tail = new JPanel (new BorderLayout(borderSize, borderSize));
		tail.setBackground(backgroundColor);
		tail.setPreferredSize(headerSize);
		tail.add(buttons,BorderLayout.SOUTH);

		JPanel page = new JPanel(new BorderLayout(borderSize, borderSize));
		page.setBorder(BorderFactory.createLineBorder(accentColor, borderSize));
		page.setBackground(backgroundColor);
		page.setPreferredSize(pageSize);
		page.add(head , BorderLayout.NORTH);
		page.add(right, BorderLayout.EAST);
		page.add(body , BorderLayout.CENTER);
		page.add(left , BorderLayout.WEST);
		page.add(tail , BorderLayout.SOUTH);
		add(page);

	}


	public void actionPerformed (ActionEvent e)
	{
		String nextPage = e.getActionCommand();
		//action
		if(nextPage.equals("ManageBookings"))
			new Page(card, c, "ManageBookings").manageBookings();
		if(currentPage.equals("Home") && nextPage.equals("DashBoard"))	//Log in Button Pressed
		{
			String email = 	emailField.getText();
			String password = String.valueOf(passField.getPassword());
			if(main.login(email, password) == false)
				nextPage = currentPage;
		}
		else if(currentPage.equals("SignUp") && nextPage.equals("DashBoard"))	// new user submit pressed
		{
			String name = nameField.getText();
			String dob = dobField.getText();
			char gender = 'f';
			if(male.isSelected())
				gender = 'm';
			String email = 	emailField.getText();
			String password = String.valueOf(passField.getPassword());
			String rePassword = String.valueOf(rePassField.getPassword());
			if(main.signUp(name, dob, gender, email, password, rePassword) == false)
				nextPage = currentPage;
		}
		else if(currentPage.equals("ManageBookings") && nextPage.equals("CancelBooking"))
		{
			String b="";
			for(JCheckBox booking : bookings)
			{
				if(booking.isSelected())
					b = booking.getText();
			}
			if(b.equals(""))
				nextPage = currentPage;
			else
				main.selectBooking(b);
		}
		else if(currentPage.equals("CancelBooking") && nextPage.equals("DashBoard_submit"))
		{
			main.cancelBooking();
			nextPage = "DashBoard";
		}
		else if(currentPage.equals("EditProfile") && nextPage.equals("DashBoard_submit"))	// edit user submit pressed
		{
			String name = nameField.getText();
			String dob = dobField.getText();
			char gender = 'f';
			if(male.isSelected())
				gender = 'm';
			String email = 	emailField.getText();
			String password = String.valueOf(passField.getPassword());
			if(main.editUser(name, dob, gender, email, password))
				nextPage = "DashBoard";
			else
				nextPage = currentPage;
		}
		else if(currentPage.equals("MakeBooking") && nextPage.equals("MatchingFlights"))	//search button pressed
		{

			String from = Flight.Cities[fromField.getSelectedIndex()];
			String to = Flight.Cities[toField.getSelectedIndex()];
			String date = dateField.getText();
			int no_of_tickets;
			if(ticketField.getText().equals(""))
				no_of_tickets = 0;
			else
				no_of_tickets = Integer.parseInt(ticketField.getText());
			if(main.makeBooking(from, to, date, no_of_tickets) == false)
				nextPage = currentPage;
			new Page(card, c, "MatchingFlights").matchingFlights();
		}

		else if(currentPage.equals("MatchingFlights") && nextPage.equals("TicketDetails"))
		{
			String fl="";
			for(JCheckBox cb : matchingFlights)
				if(cb.isSelected())
					fl=cb.getText();
			if(fl.equals(""))
				nextPage = currentPage;
			else
				main.selectFlight(fl);
		}
		else if(currentPage.equals("TicketDetails") && nextPage.equals("Checkout"))
		{
			String name = nameField.getText();
			String dob = dobField.getText();
			char gender = 'f';
			if(male.isSelected())
				gender = 'm';
			if(main.ticketDetails(name, dob, gender)==false)
				nextPage = currentPage;
		}
		else if(currentPage.equals("Checkout") && nextPage.equals("Confirmation"))
		{
			String name = nameField.getText();
			String card = cardField.getText();
			String expiry = expiryField.getText();
			String code = codeField.getText();
			if(main.checkout(name, card, expiry, code) == false)
				nextPage = currentPage;
		}
		//
		card.show(c,nextPage);
		currentPage = nextPage;
	}
}
