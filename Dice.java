package qaProjects;
import java.util.Random;
import java.util.Scanner;



public class Dice {
	static int inputType;
	static String attempts;
	static int sides;
	String result;	

	public Dice(int sides){

		Dice.sides = sides;
	}

	public String getResult(){
		if(sides==2||sides==4||sides==6)
			return this.result;
		return "Invalid Type of Dice";
	}

	public void rolldice(){


		Random random = new Random(); 
		int result = random.nextInt(sides)+1;
		this.result = getSide(result);

	}

	public static String getSide(int n){

		if(sides==2){
			switch(n){
			case 1: return "Heads";
			case 2:return "Tails";
			}

		}
		else if(sides == 4) {
			switch(n){
			case 1: return "One";
			case 2:return "Two";
			case 3:return "Three";
			case 4:return "Four";
			}
		}
		else{
			switch(n){
			case 1: return "One";
			case 2:return "Two";
			case 3:return "Three";
			case 4:return "Four";
			case 5: return "Five";
			case 6: return "Six";
			}
		}

		return null;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do{
			System.out.println("Enter the Type of dice");
			Scanner sc = new Scanner(System.in);
			inputType = sc.nextInt();
			Dice dice  = new Dice(inputType);
			dice.rolldice();
			System.out.println(dice.getResult());
			System.out.println("Do You wish to continue press Y or N");
			Scanner sc1 = new Scanner(System.in);
			attempts = sc1.nextLine();
			if(!attempts.equalsIgnoreCase("Y")) {
				System.out.println("Thank you");
				System.exit(0);
			}
		}while("Y".equalsIgnoreCase(attempts));


	}



}




