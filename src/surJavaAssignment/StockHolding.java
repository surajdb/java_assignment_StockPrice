package surJavaAssignment;

public class StockHolding {

	float purchaseSharePrice;
	float currentSharePrice;
	int   numberOfShares ;
	String companyName = new String();
	
	public float costInDollars(){
		return (purchaseSharePrice * numberOfShares);
	};
	public float valueInDollars(){
		return (currentSharePrice * numberOfShares);
	};

	StockHolding(float a, float b, int c, String d)
	{
		purchaseSharePrice = a;
		currentSharePrice = b;
		numberOfShares = c;
		companyName = d;
	}

}
