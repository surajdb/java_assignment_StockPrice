
package surJavaAssignment;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class StockMenu  {

	public static void main(String[] args) {

		//to sort the list in ascending order based on share purchase price
		class StockDescSort implements Comparator<StockHolding> {
		    public int compare(StockHolding stock1, StockHolding stock2) {
		    	
		    	 if (stock1.purchaseSharePrice > stock2.purchaseSharePrice) 
		    	 {   return -1;	  }
		         if (stock1.purchaseSharePrice < stock2.purchaseSharePrice) 
		         { 	return 1; 	  }
		         else  return 0;
		    }
		}
		//to sort the list in descending order based on share purchase price
		class StockAsecSort implements Comparator<StockHolding> {
		    public int compare(StockHolding stock1, StockHolding stock2) {
		    	
		    	 if (stock1.purchaseSharePrice < stock2.purchaseSharePrice) 
		    	 {   return -1;	  }
		         if (stock1.purchaseSharePrice > stock2.purchaseSharePrice) 
		         {   return 1; 	  }
		         else  return 0;
		    }
		}
		//to sort the list in descending order based on share purchase price
		class LeastProfitStock implements Comparator<StockHolding> {
		    public int compare(StockHolding stock1, StockHolding stock2) {
		    	 if (profit(stock1) < profit(stock2)) 
		    	 {   return -1;	  }
		         if (profit(stock1) > profit(stock2)) 
		         { return 1; }
		         else  return 0;
		    }
		}
		//to sort the list in ascending order based on share purchase price
		class MostProfitStock implements Comparator<StockHolding> {
		    public int compare(StockHolding stock1, StockHolding stock2) {

		    	 if (profit(stock1) > profit(stock2)) 
		    	 {   return -1;	  }
		         if (profit(stock1) < profit(stock2)) 
		         { return 1; }
		         else  return 0;
		    }
		}
		//to sort the list in Ascending order based on Company Name	
		class StockNameSort implements Comparator<StockHolding> {
		    public int compare(StockHolding stock1, StockHolding stock2) {		    	
		    	 return (stock1.companyName.compareToIgnoreCase(stock2.companyName)) ;	
		    }
		}
		//to sort the list in Descending order based on Company Name	
		class StockNameSortDesc implements Comparator<StockHolding> {
		    public int compare(StockHolding stock1, StockHolding stock2) {		    	
		    	 return (stock2.companyName.compareToIgnoreCase(stock1.companyName)) ;	
		    }
		}
		// adding objects to the list
		List<StockHolding> stocklist = new ArrayList<StockHolding>();
		StockHolding stock1 = new StockHolding( 9.2f , 11.3f, 11 ,"Pizza Pizza");
		StockHolding stock2 = new StockHolding( 16.2f , 16.3f, 11 ,"TD Bank");
		StockHolding stock3 = new StockHolding( 3.2f , 4.83f, 11 ,"RBC bank");
		ForeignStockHolding stock4 = new ForeignStockHolding( 12.2f , 14.3f, 11 ,"UK Oils",1.09f);
		ForeignStockHolding stock5 = new ForeignStockHolding( 4.2f , 2.3f, 11 ,"Indian Oil",0.89f);			
				
		stocklist.add(stock1);
		stocklist.add(stock2);
		stocklist.add(stock3);
		System.out.println("Assignment part 1 ==>");
		Collections.sort(stocklist , new StockNameSort());
		display(stocklist,-1);
		stocklist.add(stock4);
		stocklist.add(stock5);
		System.out.println("Assignment part 2 ==>");
		Collections.sort(stocklist , new StockNameSortDesc());
		display(stocklist,-1);		
		
		showmenu();
		int choice = menuInput() ;
	    while(choice !=8)
	    {
	    	switch(choice)
	    	{
	    		case 1:
	    		{
		    			if(stocklist.size()==8)
	    		    		{	
		    					System.out.println("You cannot add more than 8 stocks !! Please opt other option to continue");
		    					showmenu();
	    		    			choice = menuInput() ;
	    		    			break;
	    		    		}
		    			else{
	    				System.out.println("Press 1 for Local and 2 for Foreign Stock");
		    			String choice2 = takeInput();
		    			while(!(choice2.equals("1") || choice2.equals("2")))
		    					{
		    						System.out.println("Incorrect Value entered.Press 1 for Local and 2 for Foreign Stock");
		    						choice2 = takeInput();
		    					}
		    			// to take common input to add new object
	    				System.out.println("Please enter Share purchase Price");
	    				float purchaseSharePrice  = validfloatInput();
	    				System.out.println("Please enter Share Current Price");
	    				float currentSharePrice   = validfloatInput();
	    				System.out.println("Please enter Number of shares");
	    				int   numberOfShares      = validIntInput();
	    				System.out.println("Please enter Company name");
	    				String companyName        = takeInput();
	    				
		    			if (choice2.equals("1") )
		    			{	    				
		    				StockHolding x        =  new StockHolding( purchaseSharePrice ,currentSharePrice, 
		    													numberOfShares ,companyName);
		    				stocklist.add(x);
		    			}
		    			else 
		    			{
		    				System.out.println("Please enter Convertion Rate");
		    				float conversionRate  = validfloatInput();		    				
		    				ForeignStockHolding x =  new ForeignStockHolding( purchaseSharePrice ,currentSharePrice, 
		    																numberOfShares ,companyName,conversionRate );
		    				stocklist.add(x);
		    			}
		    	}
		    			System.out.println("Current newly added Stock can be found in the end");
		    			display(stocklist,-1);
		    			showmenu();
		    			choice = menuInput() ;
		    			break;}
	    		
	    		case 2:  
	    				System.out.println("Stock with Lowest purchase price ==>");
	    				Collections.sort(stocklist , new StockAsecSort());
		    			display(stocklist,0);
    		    		showmenu();
    		    		choice = menuInput() ;
    		    		break;
    		    		
	    		case 3:  
    					System.out.println("Stock with Highest purchase price ==>");
	    				Collections.sort(stocklist , new StockDescSort());
		    			display(stocklist,0);
			    		showmenu();
			    		choice = menuInput() ;
			    		break;
		    		
	    		case 4: 
    					System.out.println("Most Profitable Stock ==>");
	    				Collections.sort(stocklist , new   MostProfitStock());
						display(stocklist,0);
						showmenu();
						choice = menuInput() ;
	    			
	    		case 5: System.out.println("Least Profitable Stock ==>");
	    				Collections.sort(stocklist , new  LeastProfitStock ());
	    				display(stocklist,0);
	    				showmenu();
	    				choice = menuInput() ;
	    		case 6: System.out.println("Stocks arranged by Company name (A-Z) ==>"); 
		    			Collections.sort(stocklist , new StockNameSort());
		    			display(stocklist,-1);
		    			showmenu();
	    	    		choice = menuInput() ;
    	    		
	    		case 7: System.out.println("Stocks arranged by Lowest to Highest purchase value ==>"); 
		    			Collections.sort(stocklist , new StockAsecSort());
		    			display(stocklist,-1);
		    			showmenu();
	    	    		choice = menuInput() ;
	    	}
		}
	    System.out.println("Exiting the main menu. Have a great Day!!");
	}
	// function to take simple input
	public static String takeInput(){		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	    return in.nextLine();
	};
	// function to take Menu input
	public static int menuInput()
	{
		String choice = takeInput();
		while( !(choice.equals("1") || choice.equals("2")|| choice.equals("3")|| choice.equals("4")||
				 choice.equals("5") || choice.equals("6")|| choice.equals("7")|| choice.equals("8")))
				{
					showmenu();
					choice = takeInput();					
				}
		return Integer.parseInt(choice);		 
	}
	//function to display Menu
	public static void showmenu()
	{
		System.out.println("\nChose option from (1-8) below :");
		System.out.println("1 : Add Stock");
		System.out.println("2 : Display Stock with lowest value");
		System.out.println("3 : Display Stock with highest Value");
		System.out.println("4 : Display most profitable Stock");
		System.out.println("5 : Display least profitable Stock");
		System.out.println("6 : Display stocks from A-Z");
		System.out.println("7 : Display stocks lowest to highest Value");
		System.out.println("8 : Exit");
	}
	//function to take floating value as input
	public static float validfloatInput()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	    while(!(in.hasNextFloat()))
				{
					System.out.println("Enter a valid Floating value");
					in.next();
				}
		return Math.abs(in.nextFloat());		 
	}
	//function to take integer value as input
	public static int validIntInput()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while(!in.hasNextInt())
				{
					System.out.println("Enter a valid Integer value");
					in.next();
				}
		return Math.abs(in.nextInt());		 
	}
	//function to add padding for String input
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$"+length+ "s", string+"|");
	}
	//function to add padding for Integer input
	public static String fixedLengthString(int integer, int length) {
	    return String.format("%1$"+length+ "s", integer+"|");
	}
	//function to add padding for Float input
	public static String fixedLengthString(float integer, int length) {
		return String.format("%1$"+length+ "s", integer+"|");
	}
	//function to display stock base on parameter passed - ('-1' to display entire List and '0' for max or min value)
	public static void display(List<StockHolding> stocklist, int stocklenght )
	{
		String repeatedpatern= new String(new char[162]).replace('\0', '=');
		if (stocklenght == -1 )
			stocklenght = stocklist.size()-1;
		System.out.println(repeatedpatern);
		System.out.println("Sr.No.|"+"       Company name|"+" Purchase Price|"+"Current Price |"+"Number of Shares |"
							+"Total Purchase Price|"+"Total Current Price|"+"   Company Type |"+"Convrsn Rate|"+"Profit Percent|");
		System.out.println(repeatedpatern);
		for (int i = 0 ; i<= stocklenght; i++)
		{    					
			String qq = String.format("%.2f", profit(stocklist.get(i)));//round off
			String q = fixedLengthString((qq+" %"),15);//formatted profit percent
			String r = fixedLengthString(i+1, 7);
			String s = fixedLengthString(stocklist.get(i).companyName, 20);
			String t = fixedLengthString(stocklist.get(i).purchaseSharePrice, 16);
			String u = fixedLengthString(stocklist.get(i).currentSharePrice, 15);
			String v = fixedLengthString(stocklist.get(i).numberOfShares,18);
			String ww = String.format("%.2f", stocklist.get(i).costInDollars());//round off
			String w = fixedLengthString(ww,21);//formated costInDollars
			String xx = String.format("%.2f", stocklist.get(i).valueInDollars());//round off
			String x = fixedLengthString(xx,20);//formated valueInDollars
			String y = new String();
			String z = new String();

			if( stocklist.get(i) instanceof ForeignStockHolding )
				{
					y = fixedLengthString("Foreign Stock",17 );
					ForeignStockHolding a = (ForeignStockHolding)stocklist.get(i);
					z = fixedLengthString(a.conversionRate,13 );
				}
			else
				{
					y = fixedLengthString("Local Stock",17 );
					z = fixedLengthString("--",13 );
				}
			System.out.println(r+s+t+u+v+w+x+y+z+q);
		}		
		System.out.println(repeatedpatern);
	}
	//to calculate Profit Percentage
	public static float profit(StockHolding a)
	{
		return (a.currentSharePrice-a.purchaseSharePrice)*100.0f/a.purchaseSharePrice;
	}
}