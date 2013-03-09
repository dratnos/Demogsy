/**
 * A State has a population, demographics, and demographic vote shares.
 * 
 * @author Tristan Killeen
 * @version 0
 */
public class State
{
	private String name;
	private String abbrev;
	private double numWhite;
	private double whiteDem;
	private double whiteGrowth;
	private double numBlack;
	private double blackDem;
	private double blackGrowth;
	private double numAsian;
	private double asianDem;
	private double asianGrowth;
	private double numHispanic;
	private double hispanicDem;
	private double hispanicGrowth;
	private double numOther;
	private double otherDem;
	private double otherGrowth;
	private double hispanicTurnout;
	private double blackTurnout;
	private double whiteTurnout;
	
	public State(String name, String abbrev, double statePop, double propWhite, double whiteDem,
			double propBlack, double blackDem, double propAsian, double asianDem,
			double propHispanic, double hispanicDem,
			double propOther, double otherDem, double growthCoeff)
	{
		this.name = name;
		this.abbrev = abbrev;
		this.numWhite = statePop * propWhite;
		this.whiteDem = whiteDem;
		this.whiteGrowth = 1 + (.00152173913 * growthCoeff);
		this.numBlack = statePop * propBlack;
		this.blackDem = blackDem;
		this.blackGrowth = 1 + (0.0101630434783 * growthCoeff);
		this.numAsian = statePop * propAsian;
		this.asianDem = asianDem;
		this.asianGrowth = 1 + (0.01025 * growthCoeff);
		this.numHispanic = statePop * propHispanic;
		this.hispanicDem = hispanicDem;
		this.hispanicGrowth = 1 + (0.03173813043 * growthCoeff);
		this.numOther = statePop * propOther;
		this.otherDem = otherDem;
		this.otherGrowth = 1 + (0.0101593478261 * growthCoeff);
		hispanicTurnout = .316;
		blackTurnout = .608;
		whiteTurnout = .648;
		if(name.equals("Ohio"))
		{ //Ohio's turnout is so far from the nation's that 
			hispanicTurnout += .2; //it needs to be corrected
			blackTurnout += .05; //or else the numbers end up
		} // more than 1% off.
		if(name.equals("Hawaii"))
		{ //Turnout in Hawaii is low accross the board.
			whiteTurnout -= .2;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAbbrev()
	{
		return abbrev;
	}
	
	/**
	 * Represents a race numerically.
	 * 0 = White
	 * 1 = Black
	 * 2 = Asian
	 * 3 = Hispanic
	 * 4 = Other
	 * @param race the race to be represented
	 * @return the number corresponding to the race
	 */
	public double representNumerically(String race)
	{
		race = race.toLowerCase();
		if(race.equals("white")||race.equals("caucasian")||race.equals("0"))
			return 0;
		if(race.equals("black")||race.equals("african american")||
				race.equals("1"))
			return 1;
		if(race.equals("asian")||race.equals("2"))
			return 2;
		if(race.equals("hispanic")||race.equals("latino")||race.equals("3"))
			return 3;
		if(race.equals("other")||race.equals("4"))
			return 4;
		throw new RuntimeException("Race not recognized.");
	}
	
	
	public double getNumRace(String race)
	{
		double givenRace = representNumerically(race);
		if(givenRace==0)
			return numWhite;
		if(givenRace==1)
			return numBlack;
		if(givenRace==2)
			return numAsian;
		return givenRace==3?numHispanic:numOther;
	}
	
	public double getGrowthRate(String race)
	{
		double givenRace = representNumerically(race);
		if(givenRace==0)
			return whiteGrowth;
		if(givenRace==1)
			return blackGrowth;
		if(givenRace==2)
			return asianGrowth;
		return givenRace==3?hispanicGrowth:otherGrowth;
	}
	
	public double getNumRace(double year, String race)
	{
		double initialPop = getNumRace(race);
		double growthRate = getGrowthRate(race);
		double currentPop = initialPop;
		year -= 2012;
		if(year < 0)
		{
			year = Math.abs(year);
			growthRate = (1 / growthRate);
		}
		for(double i = 0; i < year; i++)
		{
			currentPop *= growthRate;
		}
		return currentPop;
	}
	
	public double getDemShare(double year)
	{
		double newWhitePop = whiteTurnout * getNumRace(year, "White");
		double newBlackPop = blackTurnout * getNumRace(year, "Black");
		double newAsianPop = .321 * getNumRace(year, "Asian");
		double newHispanicPop = hispanicTurnout * getNumRace(year, "Hispanic");
		double newOtherPop = .582 * getNumRace(year, "Other");
		double numWhiteDem = newWhitePop * whiteDem;
		double numBlackDem = newBlackPop * blackDem;
		double numAsianDem = newAsianPop * asianDem;
		double numHispanicDem = newHispanicPop * hispanicDem;
		double numOtherDem = newOtherPop * otherDem;
		double numWhiteRep = newWhitePop * (1 - whiteDem);
		double numBlackRep = newBlackPop * (1 - blackDem);
		double numAsianRep = newAsianPop * (1 - asianDem);
		double numHispanicRep = newHispanicPop * (1 - hispanicDem);
		double numOtherRep = newOtherPop * (1 - otherDem);
		double totalDem = numWhiteDem + numBlackDem + numAsianDem + numHispanicDem + numOtherDem;
		double totalRep = numWhiteRep + numBlackRep + numAsianRep + numHispanicRep + numOtherRep;
		if(year == 2008)
		{
			return (totalDem / (totalDem + totalRep)) + .03;
		}
		return (totalDem / (totalDem + totalRep));
	}
	
	
	

}
