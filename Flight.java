
import java.lang.Math.*;

class Flight
{
	String fl_no, depCity, arrCity;
	int depH, arrH, depM, arrM;
	int depDD, depMM, depYY, arrDD, arrMM, arrYY;
	float baseFare;
	static String Cities[] = {"Hyderabad", "Delhi", "Mumbai", "Banglore"};

	public static void simulate(Main main)	throws InterruptedException
	{
		for(int i=0;true;i=(i+1)%main.List.length)	//Scroll Through Buffer list
		{
			if(main.List[i]==null)	//Look for empty slot
			{
				main.List[i]=new Flight();
				main.List[i].randomize();
			}
			Thread.sleep(10);
		}		
	}

	public void randomize()
	{
		int randInt = ((int)(Math.random()*899))+100;
		this.fl_no = "6E-" + randInt;

		int indexDepCity = (int)(Math.random()*Cities.length);
		int indexArrCity = (int)(Math.random()*Cities.length); 
		while(indexArrCity == indexDepCity)
			indexArrCity = (int)(Math.random()*Cities.length); 
		this.depCity = Cities[indexDepCity];
		this.arrCity = Cities[indexArrCity];	
		this.baseFare = (float)(((int)(Math.random()*700000))+300000.0)/100;

	}
		
	public static boolean search(Main main, String from, String to, String date, int n)
	{
		for(int i =0; i < main.searchResults.length; i++)
		{
			main.searchResults[i] = main.List[i];
		}
		return true;
	}
	
	public static Flight getFlight(Main main, String flight)
	{
		for(Flight f : main.List)
		{
			if (f.fl_no.equals(flight))
				return f;
		}
		return null;
	}
}

