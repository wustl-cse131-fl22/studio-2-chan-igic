package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your starting amount: ");
		int startAmount = in.nextInt();
		System.out.print("Enter your win chance: ");
		double winChance = in.nextDouble();
		System.out.print("Enter your win limit: ");
		int winLimit = in.nextInt();
		
		System.out.print("Enter your total number of simulations: ");
		int totalSimulations = in.nextInt();
		int currentSimulation = 1;
		int ruinNum= 0;
		double expectedRuin =0;
		while (currentSimulation != totalSimulations + 1) {
			int currentAmount = startAmount ;
			int round = 0;
			while(currentAmount > 0 && currentAmount < winLimit  ) {
				double curChance = Math.random();
				if (curChance > winChance) {
					currentAmount++;
//					System.out.println("win! Current amount: " + currentAmount);
				}else {
					currentAmount--;
//					System.out.println("Lose! Current amount: " + currentAmount);
				}
				round++;
				
			}
			
			if (currentAmount == 0) {
				System.out.println("Simulation " + currentSimulation + ": " + round + " LOSE");
				ruinNum++;
				System.out.println("ruinNum: " + ruinNum );
			}else {
				System.out.println("Simulation " + currentSimulation + ": " + round + " WIN");

			}
			
			currentSimulation++;
		}
		
		if(winChance == .5)	{
			expectedRuin = 1 - ((double)startAmount / (double)winLimit);
	
		}else {
			double alpha = (1 - (double)winChance) / (double)winChance ;
			expectedRuin = ((Math.pow(alpha, (double)startAmount)) -(Math.pow(alpha, (double)winLimit)) / (1 - (Math.pow(alpha, (double)winLimit)))) ;
		}
		double ruinRate = (double)ruinNum / (double)totalSimulations;
		System.out.println("Ruin Rate from Simulation: " + ruinRate + "Expected Ruin Rate: " + expectedRuin );
	}

}
