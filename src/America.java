import java.util.ArrayList;
import java.util.Scanner;
/**
 * 'MURICA!
 * 
 * @author Tristan Killeen
 * @version 0
 */
public class America
{
	private ArrayList<State> states;
	private double whitevote;
	private double blackvote;
	private double asianvote;
	private double hispanicvote;
	private double othervote;
	
	public America(boolean demos)
	{
		whitevote = .39; //These numbers are used
		blackvote = .93; //When no exit polling is available
		asianvote = .71; //From a state
		hispanicvote = .73; //They are modified by the state's
		othervote = .58; //General tendency.
		states = new ArrayList<State>();
		initiateStates();
		if(demos)
			demonstration();
	}
	
	public void findDemShare(String targetState, int year)
	{
		System.out.println("In " + targetState + " in " + year + ", the Democrat wins "
				+ (getState(targetState).getDemShare(year)*100) +
				"% of the vote.");
	}
	
	public void findDemShare(String targetState, int[] years)
	{
		if(targetState.equals("Random"))
			targetState = states.get((int)((double)states.size()*Math.random())).getName();
		for(int i = 0; i < years.length; i++)
		{
			findDemShare(targetState, years[i]);
		}
	}

	public State getState(String stateName)
	{
		for(int i = 0; i < states.size(); i++)
		{
			if(states.get(i).getName().equals(stateName))
			{
				return states.get(i);
			}
		}
		return null;
	}
	
	public void initiateStates()
	{
		states = new ArrayList<State>();
		State alabama = new State("Alabama", "AL", 4800736, .670, .15, .262, .95,
				.011, 0.73, .039, 0.71, .021, 0.58, 0.44);
		State alaska = new State("Alaska", "AK", 740231, .641, 0.39, .033, 0.93,
				0.054, 0.71, 0.055, 0.73, .231, 0.40 , 1.495);
		State arizona = new State("Arizona", "AZ", 6694017, .578, 0.32, 0.041, 0.93,
				0.028, 0.71, 0.296, 0.74, 0.082, 0.58, 0.87);
		State arkansas = new State("Arkansas", "AR", 2937979, .745, .86*whitevote, .0154, blackvote,
				0.012, asianvote, 0.064, hispanicvote, 0.03, othervote, 0.57);
		State california = new State("California", "CA", 38041430.0, .401, .45918, .062, .9696, 
				.013, .79, .376, .7272, .063, .5934, 1.055);
		State colorado = new State("Colorado", "CO", 5229196, 0.70, 0.44, 0.04, blackvote,
				0.028, asianvote, 0.207, 0.75, 0.046, othervote, 1.575);
		State connecticut = new State("Connecticut", "CT", 3580709, 0.712, 0.51, 0.101, 0.93,
				0.038, asianvote, 0.134, 0.79, 0.029, othervote, 0.225);
		State delaware = new State("Delaware", "DE", 947934, 0.653, whitevote*1.11, 0.214, blackvote*1.11,
				0.032, asianvote*1.11, 0.082, hispanicvote*1.11, 0.032, othervote*1.11, 1.065);
		State florida = new State("Florida", "FL", 19057542, 0.579, 0.364, 0.160, 0.95,
				0.024, 0.65, 0.225, 0.6, 0.03, 0.59, 1.375);
		State georgia = new State("Georgia", "GA", 9792653, 0.559, whitevote*0.85, 0.16, blackvote*0.87,
				0.032, asianvote*0.92, 0.088, hispanicvote*0.92, 0.025, othervote*0.92, 1.2);
		State hawaii = new State("Hawaii", "HI", 1400301, 0.227, 0.5, 0.016, blackvote,
				0.386, 0.72, 0.089, 0.8, 0.339, 0.75, 1.175);
		State idaho = new State("Idaho", "ID", 1607582, 0.84, whitevote*.75, 0.006, blackvote,
				0.012, asianvote, 0.112, hispanicvote, 0.04, othervote, 0.9);
		State illinois = new State("Illinois", "IL", 12869257, 0.637, 0.46, 0.145, 0.96,
				0.046, asianvote, 0.158, 0.81, 0.026, othervote, 0.175);
		State indiana = new State("Indiana", "IN", 6589802, 0.815, 0.38, 0.091, 0.89,
				0.016, asianvote, 0.06, hispanicvote, 0.023, othervote, 0.415);
		State iowa = new State("Iowa", "IA", 3246355, 0.887, 0.5, 0.029, blackvote,
				0.017, asianvote, 0.05, hispanicvote, 0.023, othervote, 0.455);
		State kansas = new State("Kansas", "KS", 2963118, 0.782, whitevote, 0.059, blackvote,
				0.024, asianvote, 0.105, hispanicvote, 0.064, othervote, 0.575);
		State kentucky = new State("Kentucky", "KY", 4369356, 0.863, .87*whitevote, 0.078, .87*blackvote,
				0.011, .87*asianvote, 0.031, .87*hispanicvote, 0.02, .87*othervote, 0.475);
		State louisiana = new State("Louisiana", "LA", 4673372, 0.603, 0.7*whitevote, 0.32, 0.75*blackvote,
				0.015, 0.75*asianvote, 0.042, 0.75*hispanicvote, 0.023, 0.75*othervote, 0.755);
		State maine = new State("Maine", "ME", 1401361, 0.944, .56, 0.012, blackvote,
				0.01, asianvote, 0.013, hispanicvote, 0.022, othervote, 0.03);
		State maryland = new State("Maryland", "MD", 5873552, 0.547, 0.43, 0.294, 0.97,
				0.053, asianvote, 0.082, hispanicvote, 0.034, othervote, 0.96);
		State massachusetts = new State("Massachusetts", "MA", 6601629, 0.761, 0.57, 0.066, 0.92,
				0.053, asianvote, 0.096, hispanicvote, 0.029, othervote, 0.495);
		State michigan = new State("Michigan", "MI", 9876187, 0.766, 0.464, 0.142, 0.95,
				0.024, asianvote, 0.044, 0.63, 0.029, othervote, 0.03);
		State minnesota = new State("Minnesota", "MN", 5403925, 0.831, 0.49, 0.052, blackvote,
				0.04, asianvote, 0.047, hispanicvote, 0.035, othervote, 0.71);
		State mississippi = new State("Mississippi", "MS", 3009297, 0.58, .11, 0.37, .96,
				0.009, asianvote, 0.027, hispanicvote, 0.016, othervote, 0.295);
		State missouri = new State("Missouri", "MO", 5988927, 0.81, 0.355, 0.116, 0.94,
				0.016, asianvote, 0.035, hispanicvote, 0.027, othervote, 0.275);
		State montana = new State("Montana", "MT", 998199, 0.878, 0.38, 0.004, blackvote,
				0.006, asianvote, 0.029, hispanicvote, 0.089, 0.74, 0.795);
		State nebraska = new State("Nebraska", "NE", 1842641, 0.821, .875*whitevote, 0.045, .875*blackvote,
				0.018, .875*asianvote, 0.092, .875*hispanicvote, 0.033, .875*othervote, 0.8);
		State nevada = new State("Nevada", "NV", 2723322, 0.541, 0.43, 0.081, 0.92,
				0.072, 0.5, 0.265, 0.71, 0.061, 0.52, 1.08);
		State newhampshire = new State("New Hampshire", "NH", 1318194, 0.923, 0.51, 0.011, blackvote,
				0.022, asianvote, 0.028, hispanicvote, 0.018, othervote, 0.16);
		State newjersey = new State("New Jersey", "NJ", 8821155, 0.593, 0.49, 0.0137, 0.96,
				0.083, 1.18*asianvote, 0.177, 1.18*hispanicvote, 0.03, 1.18*othervote, 0.415);
		State newmexico = new State("New Mexico", "NM", 2082224, 0.405, 0.41, 0.021, blackvote,
				0.014, asianvote, 0.463, 0.65, 0.132, 0.65, 0.64);
		State newyork = new State("New York", "NY", 19465197, 0.583, 0.49, 0.159, 0.94,
				0.073, asianvote, 0.176, 0.89, 0.036, othervote, 0.75);
		State northcarolina = new State("North Carolina", "NC", 9656401, 0.653, 0.31, 0.215, 0.96,
				0.022, asianvote, 0.084, 0.68, 0.036, 0.547, 1.135);
		State northdakota = new State("North Dakota", "ND", 682591, 0.889, 0.925*whitevote, 0.012, blackvote,
				0.01, asianvote, 0.02, hispanicvote, 0.072, othervote, 2.01);
		State ohio = new State("Ohio", "OH", 11736504, 0.79, 0.41, 0.15, 0.96,
				0.017, asianvote, 0.031, 0.5625, 0.023, othervote, 0.035);
		State oklahoma = new State("Oklahoma", "OK", 3821351, 0.687, 0.7*whitevote, 0.074, 0.8*blackvote,
				0.017, 0.647*asianvote, 0.089, 0.647*hispanicvote, 0.146, 0.647*othervote, 0.845);
		State oregon = new State("Oregon", "OR", 3851074, 0.785, 0.515, 0.018, blackvote,
				0.037, asianvote, 0.117, hispanicvote, 0.055, othervote, 0.89);
		State pennsylvania = new State("Pennsylvania", "PA", 12902376, 0.795, 0.45, 0.108, 0.95,
				0.027, asianvote, 0.057, 0.80, 0.021, 0.7, 0.24);
		State rhodeisland = new State("Rhode Island", "RI", 1060567, 0.764, 1.45*whitevote, 0.057, 1.25*blackvote,
				0.029, 1.25*asianvote, 0.124, 1.25*hispanicvote, 0.068, 1.25*othervote, -0.11);
		State southcarolina = new State("South Carolina", "SC", 4825364, 0.641, 0.80*whitevote, 0.279, 0.80*blackvote,
				0.013, 0.86*asianvote, 0.051, 0.86*hispanicvote, 0.022, 0.86*othervote, 1.065);
		State southdakota = new State("South Dakota", "SD", 900020, 0.847, .9*whitevote, 0.013, blackvote,
				0.009, asianvote, 0.027, hispanicvote, 0.118, othervote, 1.18);
		State tennessee = new State("Tennessee", "TN", 6446105, 0.756, .7*whitevote, 0.167, blackvote,
				0.014, asianvote, 0.046, hispanicvote, 0.021, othervote, 1.155);
		State texas = new State("Texas", "TX", 25901361, 0.453, 0.6*whitevote, 0.118, 0.6*blackvote,
				0.038, asianvote, 0.376, hispanicvote, 0.035, othervote, 1.815);
		State utah = new State("Utah", "UT", 2863885, 0.804, .5*whitevote, 0.011, blackvote,
				0.02, asianvote, 0.13, .9*hispanicvote, 0.048, othervote, 1.655);
		State vermont = new State("Vermont", "VT", 685741, 0.943, 0.66, 0.01, blackvote,
				0.013, asianvote, 0.015, hispanicvote, 0.021, othervote, 0.02);
		State virginia = new State("Virginia", "VA", 685741, 0.648, 0.37, 0.194, 0.93,
				0.055, 0.66, 0.079, 0.64, 0.034, othervote, 1.255);
		State washington = new State("Washington", "WA", 6830038, 0.725, 0.53, 0.036, blackvote,
				0.072, asianvote, 0.112, hispanicvote, 0.068, othervote, 1.28);
		State westvirginia = new State("West Virginia", "WV", 1882994, 0.932, .87*whitevote, 0.034, blackvote,
				0.007, asianvote, 0.012, hispanicvote, 0.017, othervote, 0.065);
		State wisconsin = new State("Wisconsin", "WI", 5726986, 0.833, 0.48, 0.063, 0.94,
				0.023, asianvote, 0.059, 0.66, 0.028, othervote, 0.345);
		State wyoming = new State("Wyoming", "WY", 600626, .859, .6*whitevote, 0.008, blackvote,
				0.008, asianvote, 0.089, hispanicvote, 0.047, othervote, 1.135);
		states.add(alabama);
		states.add(alaska);
		states.add(arizona);
		states.add(arkansas);
		states.add(california);
		states.add(colorado);
		states.add(connecticut);
		states.add(delaware);
		states.add(florida);
		states.add(georgia);
		states.add(hawaii);
		states.add(idaho);
		states.add(illinois);
		states.add(indiana);
		states.add(iowa);
		states.add(kansas);
		states.add(kentucky);
		states.add(louisiana);
		states.add(maine);
		states.add(maryland);
		states.add(massachusetts);
		states.add(michigan);
		states.add(minnesota);
		states.add(mississippi);
		states.add(missouri);
		states.add(montana);
		states.add(nebraska);
		states.add(nevada);
		states.add(newhampshire);
		states.add(newjersey);
		states.add(newmexico);
		states.add(newyork);
		states.add(northcarolina);
		states.add(northdakota);
		states.add(ohio);
		states.add(oklahoma);
		states.add(oregon);
		states.add(pennsylvania);
		states.add(rhodeisland);
		states.add(southcarolina);
		states.add(southdakota);
		states.add(tennessee);
		states.add(texas);
		states.add(utah);
		states.add(vermont);
		states.add(virginia);
		states.add(washington);
		states.add(westvirginia);
		states.add(wisconsin);
		states.add(wyoming);
	}
	
	public void demonstration()
	{
		Scanner pauser = new Scanner(System.in);
		System.out.println("First Example: How will Iowa vote in 2020? 2050?");
		pauser.nextLine();
		int[] yearsToExamine = {2012, 2020, 2050};
		findDemShare("Iowa", yearsToExamine);
		pauser.nextLine();
		System.out.println("How about Texas?");
		pauser.nextLine();
		findDemShare("Texas", yearsToExamine);
		pauser.nextLine();
		System.out.println("Let's examine Nevada!");
		pauser.nextLine();
		int[] yearsNevada = {2008, 2012, 2016, 2030};
		findDemShare("Nevada", yearsNevada);
		pauser.nextLine();
		System.out.println("What if we increase the rate at which");
		System.out.println("hispanic people vote for the democrat");
		System.out.println("to 80% instead of 71% in 2030?");
		pauser.nextLine();
		getState("Nevada").setHispanicDem(0.80);
		findDemShare("Nevada", 2030);
		pauser.nextLine();
		System.out.println("And what if we then increase their rate");
		System.out.println("of turnout to 55% from 31.6%?");
		pauser.nextLine();
		getState("Nevada").setHispanicTurnout(0.55);
		findDemShare("Nevada", 2030);
		pauser.nextLine();
		System.out.println("Ok! The closest state in 2012 was Florida,");
		System.out.println("How will that state's vote change in future?");
		pauser.nextLine();
		int[] yearsFL = {2012, 2016, 2020};
		findDemShare("Florida", yearsFL);
		pauser.nextLine();
		System.out.println("Let's see what we could do to stop a");
		System.out.println("Democratic win in coming years!");
		pauser.nextLine();
		System.out.println("Setting Hispanic Democratic vote to");
		System.out.println("55% from 60%.");
		pauser.nextLine();
		getState("Florida").setHispanicDem(0.55);
		findDemShare("Florida", yearsFL);
		pauser.nextLine();
		System.out.println("Hmmm... how about if we instead");
		System.out.println("swap the white and hispanic growth rates of");
		System.out.println("+.1% per year and +3.1% per year respectively?");
		pauser.nextLine();
		initiateStates();
		getState("Florida").swapWhiteHispGrowth();
		findDemShare("Florida", yearsFL);
		pauser.nextLine();
		System.out.println("That's it! Pressing enter will now display");
		System.out.println("2008, 2012, 2016, and 2050 projections");
		System.out.println("for random states. Type 'exit' to end!");
		String n = pauser.nextLine();
		int[] yearsForever = {2008, 2012, 2016, 2050};
		while(!(n.equals("exit")))
		{
			findDemShare("Random", yearsForever);
			n = pauser.nextLine();
		}
	}
	
	public static void main(String[] args)
	{
		//This method contains old tests.
		//Use them if new stuff is added.
		
		/*America murica = */new America(true); //Change to false for debugging
		//int[] yearsToExamine = {2008, 2012, 2016, 2050};
		//murica.findDemShare("Wyoming", yearsToExamine);
		
		/*//Example 0
		int[] yearsToExamine = {2012, 2020, 2050};
		murica.findDemShare("Iowa", yearsToExamine);
		murica.findDemShare("Texas", yearsToExamine);*/
		
		/*//Example 1a
		int[] yearsToExamine = {2008, 2012, 2016, 2030};
		murica.findDemShare("Nevada", yearsToExamine); 
		//Example 1b
		murica.getState("Nevada").setHispanicDem(0.80);
		murica.findDemShare("Nevada", 2030);
		//Example 1c
		murica.getState("Nevada").setHispanicTurnout(0.55);
		murica.findDemShare("Nevada", 2030);*/
		
		/*//Example 2a
		int[] yearsToExamine = {2012, 2016, 2020};
		murica.findDemShare("Florida", yearsToExamine);
		//Example 2b
		murica.getState("Florida").setHispanicDem(0.55);
		murica.findDemShare("Florida", yearsToExamine);
		//Example 2c
		murica.findDemShare("Florida", 2032);
		//Example 2d
		murica.initiateStates();
		murica.getState("Florida").swapWhiteHispGrowth();
		murica.findDemShare("Florida", yearsToExamine);*/
		
		/*//Example 3
		int[] yearsToExamine = {2008, 2012, 2016};
		murica.findDemShare("Random", yearsToExamine);*/
	}
}
