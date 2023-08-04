/*
 Group Mini Project Topic - Diet Chart
 Our Application aims to provide Diet chart for patients experiencing weight issues due to various reasons 
 This Diet Chart is applicable only for adults
Group Members:: 2454 Sai Suryawanshi
		2462 Priyal Uttarwar
 		2473 Chinmayee Yeladi
		2474 Rutuja Yeole
 */
import java.util.*;

public class Node {
	 //declaring variables
	private float lbmi;//declaring lower range of bmi
	private float rbmi;//declaring right range of bmi
	private Node left;//left address of node
	private Node right;//right address of node
	private String category;//weight category
	
	String F[]=new String[10];
	String M[]=new String[10];

	//generating a Parametric constructor 
	public Node(float lbmi, float rbmi , String[] f, String[] m,String category) {
		super();
		this.lbmi = lbmi;
		this.rbmi = rbmi;
		this.category = category;
		F = f;
		M = m;
	}
	
	//generating getters setters of all variables declared to access in other classes
		public Node getLeft() {
			return left;
		}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public float getLbmi() {
		return lbmi;
	}
	public void setLbmi(float lbmi) {
		this.lbmi = lbmi;
	}
	public float getRbmi() {
		return rbmi;
	}
	public void setRbmi(float rbmi) {
		this.rbmi = rbmi;
	}
	public String[] getF() {
		return F;
	}
	public void setF(String[] f) {
		F = f;
	}
	public String[] getM() {
		return M;
	}
	public void setM(String[] m) {
		M = m;
	}
	
}

public class Info {
	Scanner sc=new Scanner(System.in);
	Node root;
	public Info() {
		root=null;
	}
	
	void Bmicalculate(Node root,float height,float weight)
	{
		//formula to calculate bmi 
		float bmi=weight/(height*height);
		System.out.println("Calculated BMI is : "+bmi);
		search(root,bmi);//passing bmi and root to the search function
	}
	
	Node create(Node root,float lbmi,float rbmi,String[] F,String[] M,String c){
		//if tree is empty
		if(root==null)
		{
			root=new Node(lbmi,rbmi,F,M,c);
			return root;
		}
		//if lower range of bmi is less than upper range of root then move to the left of root
		if(lbmi<root.getRbmi())
		{
			root.setLeft(create(root.getLeft(),lbmi,rbmi,F,M,c));
		}
		else
		{
			root.setRight(create(root.getRight(),lbmi,rbmi,F,M,c));
		}
		return root;
	}
	
	//a function to store the data in String and assign to particular node
	Node insertData()
	{
		String[] F1= {"Breakfast(8:00-9:00)     | 1 cup milk + 1 egg/paratha/oats/upma/poha/cereal",
	                "Mid-meal(10:00-10:30)    | any one fruit + half cup yogurt",
	                "Lunch(1:00-2:00)         | 1 cup of pulse + vegetable/chicken curry + 2 chapati + one cup of rice + salad",
	                "Evening snack(5:00-5:30) | 1 cup of fruit salad/soups",
	                "Dinner(8:00-8:30)        | vegetable/fish curry + 3 chapati + salad"};
		String[] M1= {"Breakfast(8:00-9:00)      | 1 cup milk + 2 eggs/paratha/oats/upma/poha/cereal",
                "Mid-meal(10:00-10:30)     | any one fruit",
                "Lunch(1:00-2:00)          | 1 cup of pulse + vegetable/fish curry/chicken curry + 2 chapati + salad",
                "Evening snack(5:00-5:30)  | 1 cup of fruit salad/soups",
                "Dinner(8:00-8:30)         | vegetable/fish curry + 3 chapati + half cup of rice + salad"};
		String[] F2= {"Breakfast(8:00-8:30) 	 | 1 cup milk + 2 apricots + 4 raisins + 2 eggs/paratha/upma/oats/cereal",
                "Mid-meal(10:00-10:30)    | 1 cup beetroot shake/banana smoothie/buttermilk/sweet potato chat",
                "Lunch(1:00-2:00)         | 1 cup of any pulse/fish curry/rajma curry + 3 chapati + half cup of rice + salad",
                "Evening snack(4:00-4:30) | 1 cup sprouts salad/fruit salad/soups/besan cheela + half cup yogurt",
                "Dinner(8:00-8:30)        | 1 cup parval vegetable/spinach/potato/peas + 3 chapati + half cup of rice + salad"};
String[] M2= {"Breakfast(8:00-8:30)     | 1 cup milk + 2 cashews + 4 almonds + 2 walnuts + 2 eggs/paratha/upma/oats/cereal",
                "Mid-meal(10:00-10:30)    | 1 cup mango shake/banana shake/buttermilk/sweet potato chat",
                "Lunch(1:00-2:00)         | 1 cup of any pulse/chicken curry/rajma curry + 3 chapati + half cup of rice + salad",
                "Evening snack(4:00-4:30) | 1 cup sprouts salad/fruit salad/soups + 1 cup aloo chat/chila",
                "Dinner(8:00-8:30)        | 1 cup parval vegetable/cauliflower/potato/carrot peas/chicken curry + 3 chapati + half cup of rice + salad"};
String[] F3= {"Breakfast(8:00-9:00)     | Porridge with fruits/omelette/oats + 1 cup of milk",
                "Mid-meal(10:00-10:30)    | 1 bowl of Papaya/orange",
                "Lunch(1:00-2:00)         | 2 chapati + vegetable/chicken curry + one cup of rice + salad",
                "Evening snack(5:00-5:30) | half cup of buttermilk/soup + 2 dates + 3 almonds",
                "Dinner(8:00-8:30)        | dark leafy vegetables/fish curry + 2 chapati + salad"};
String[] M3= {"Breakfast(8:00-9:00)     | Porridge with fruits/2 eggs/whole multigrain paratha + 1 cup of milk",
                "Mid-meal(10:00-10:30)    | any one fruit",
                "Lunch(1:00-2:00)         | 2 chapati + vegetable/chicken curry + one cup of rice + salad",
                "Evening snack(5:00-5:30) | half bowl of soup + 2 walnuts + 3 almonds",
                "Dinner(8:00-8:30)        | dark leafy vegetables/fish curry + 2 chapati + salad"};
String[] F4= {"Breakfast(8:00-9:00)     | 1 cup milk + 2 eggs/paratha/oats/upma/poha",
                "Mid meal(10:00-10:30)    | 1 bowl of papaya/orange" ,
                "Lunch(1:00-2:00)         | 1 cup of pulse + vegetable/chicken + 2 chapati + one cup of brown rice + salad",
                "Evening snack(5:00-5:30) | 1 cup of fruit salad/spinach soup",
                "Dinner(8:00-8:30)        | vegetable/fish curry + 2 chapati + salad"};
String[] M4= {"Breakfast(8:00-9:00)     | 1 cup milk + 2 eggs/paratha/oats/upma/poha",
                "Mid meal(10:00-10:30)    | any one fruit" ,
                "Lunch(1:00-2:00)         | 1 cup of pulse + vegetable/chicken + 2 chapati + one cup of brown rice + salad",
                "Evening snack(5:00-5:30) | 1 cup of fruit salad/soups",
                "Dinner(8:00-8:30)        | vegetable/fish curry + 2 chapati + salad"};
		
		root=create(root,18.6f,24.9f,F1,M1,"Normal Weight");//normal-weight
		create(root,0f,18.5f,F2,M2,"Under Weight");//under-weight
		create(root,30f,100f,F4,M4,"Obese");//obese
		create(root,25f,29.9f,F3,M3,"Over Weight");//over-weight
		return root;
	}
	//display all the records of data available
	void display(Node root) {
		if(root==null) {
			return;
		}
		display(root.getLeft());
		System.out.println("BMI from "+root.getLbmi()+" to "+root.getRbmi());
		System.out.println("Male : ");
		for(int i=0;i<root.getM().length;i++)
		{
			System.out.println(root.getM()[i]);
		}
		System.out.println("Female : ");
		for(int i=0;i<root.getF().length;i++)
		{
			System.out.println(root.getF()[i]);
		}
		display(root.getRight());
	}
	void search(Node root,float bmi) {
		Node ptr=root;
		Node temp=null;
		while(ptr!=null)
		{
			//if the calculated bmi lies in the range of pointer then display details
			if(bmi>ptr.getLbmi() && bmi<=ptr.getRbmi())
			{
				temp=ptr;
				System.out.println("Your BMI lies in range from "+ptr.getLbmi()+" to "+ptr.getRbmi());
				System.out.println(ptr.getCategory());
				break;
			}
			//if the calculated bmi is less than the lower range of pointer then move pointer to the left  
			else if(bmi<ptr.getLbmi())
			{
				ptr=ptr.getLeft();
			}
			//if the calculated bmi is greater than the upper range of pointer then move pointer to the right  
			else if(bmi>ptr.getRbmi())
			{
				ptr=ptr.getRight();
			}
		}
		if(temp!=null)
		{
			System.out.println("Gender (M/F) : ");
			String g=sc.next();
			//comparing the gender of user
			if(g.equals("M"))
			{
				System.out.println("Your Prescribed Diet is as follows :\n ");
				for(int i=0;i<temp.getM().length;i++)
				{
					System.out.println(temp.getM()[i]);
					System.out.println("__________________________________________________________________________________________________________________");
				}
				
			}
			else if(g.equals("F"))
			{
				System.out.println("Your Prescribed Diet is as follows :\n ");
				for(int i=0;i<temp.getF().length;i++)
				{
					System.out.println(temp.getF()[i]);
					System.out.println("__________________________________________________________________________________________________________________");
				}
			}
			else
			{
				System.out.println("Doesn't Match");
			}
		}		
			
	}
}
public class Main {

	public static void main(String[] args) {
		Node root=null;
		Info i=new Info();
		Scanner sc=new Scanner(System.in);
		root=i.insertData();
		int ch;
		System.out.println("\t\t^^^^^^^DIET PLAN^^^^^^^");
		System.out.println("__________________________________________________________________");
		do{
			//Taking Patient Details
			System.out.println("Enter Your Name : ");
			String n=sc.next();
			System.out.println("Enter Your Height (in m) : ");
			float h=sc.nextFloat();//accepting height as input
			System.out.println("Enter Your Weight (in kg) : ");
			float w=sc.nextFloat();//accepting weight as input
			System.out.println("Name : "+n);
			i.Bmicalculate(root, h, w);//calculating bmi by height and weight
			System.out.println("__________________________________________________________________________________________________________________");
			//asking to continue
			System.out.println("Do You want to check for another patient  (1/0) : ");
			ch=sc.nextInt();
			System.out.println("__________________________________________________________________________________________________________________");
		}while(ch==1);
		System.out.println("______________THANK YOU \n\t\t Do Follow Our Diet\n\t\tBest Wishes_____________");
		
	}
}
/*
OUTPUT
		^^^^^^^DIET PLAN^^^^^^^
__________________________________________________________________
Enter Your Name : 
saee
Enter Your Height (in m) : 
1.6
Enter Your Weight (in kg) : 
61
Name : saee
Calculated BMI is : 23.828123
Your BMI lies in range from 18.6 to 24.9
Normal Weight
Gender (M/F) : 
F
Your Prescribed Diet is as follows :
 
Breakfast(8:00-9:00)     | 1 cup milk + 1 egg/paratha/oats/upma/poha/cereal
__________________________________________________________________________________________________________________
Mid-meal(10:00-10:30)    | any one fruit + half cup yogurt
__________________________________________________________________________________________________________________
Lunch(1:00-2:00)         | 1 cup of pulse + vegetable/chicken curry + 2 chapati + one cup of rice + salad
__________________________________________________________________________________________________________________
Evening snack(5:00-5:30) | 1 cup of fruit salad/soups
__________________________________________________________________________________________________________________
Dinner(8:00-8:30)        | vegetable/fish curry + 3 chapati + salad
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
Do You want to check for another patient  (1/0) : 
1
__________________________________________________________________________________________________________________
Enter Your Name : 
Suchit
Enter Your Height (in m) : 
1.5
Enter Your Weight (in kg) : 
70
Name : Suchit
Calculated BMI is : 31.11111
Your BMI lies in range from 30.0 to 100.0
Obese
Gender (M/F) : 
F M
Your Prescribed Diet is as follows :
 
Breakfast(8:00-9:00)     | 1 cup milk + 2 eggs/paratha/oats/upma/poha
__________________________________________________________________________________________________________________
Mid meal(10:00-10:30)    | any one fruit
__________________________________________________________________________________________________________________
Lunch(1:00-2:00)         | 1 cup of pulse + vegetable/chicken + 2 chapati + one cup of brown rice + salad
__________________________________________________________________________________________________________________
Evening snack(5:00-5:30) | 1 cup of fruit salad/soups
__________________________________________________________________________________________________________________
Dinner(8:00-8:30)        | vegetable/fish curry + 2 chapati + salad
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
Do You want to check for another patient  (1/0) : 
1
__________________________________________________________________________________________________________________
Enter Your Name : 
Priyal
Enter Your Height (in m) : 
1.6
Enter Your Weight (in kg) : 
35
Name : Priyal
Calculated BMI is : 13.671874
Your BMI lies in range from 0.0 to 18.5
Under Weight
Gender (M/F) : 
F
Your Prescribed Diet is as follows :
 
Breakfast(8:00-8:30) 	 | 1 cup milk + 2 apricots + 4 raisins + 2 eggs/paratha/upma/oats/cereal
__________________________________________________________________________________________________________________
Mid-meal(10:00-10:30)    | 1 cup beetroot shake/banana smoothie/buttermilk/sweet potato chat
__________________________________________________________________________________________________________________
Lunch(1:00-2:00)         | 1 cup of any pulse/fish curry/rajma curry + 3 chapati + half cup of rice + salad
__________________________________________________________________________________________________________________
Evening snack(4:00-4:30) | 1 cup sprouts salad/fruit salad/soups/besan cheela + half cup yogurt
__________________________________________________________________________________________________________________
Dinner(8:00-8:30)        | 1 cup parval vegetable/spinach/potato/peas + 3 chapati + half cup of rice + salad
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
Do You want to check for another patient  (1/0) : 
1
__________________________________________________________________________________________________________________
Enter Your Name : 
Ankit
Enter Your Height (in m) : 
1.5
Enter Your Weight (in kg) : 
67
Name : Ankit
Calculated BMI is : 29.777779
Your BMI lies in range from 25.0 to 29.9
Over Weight
Gender (M/F) : 
M
Your Prescribed Diet is as follows :
 
Breakfast(8:00-9:00)     | Porridge with fruits/2 eggs/whole multigrain paratha + 1 cup of milk
__________________________________________________________________________________________________________________
Mid-meal(10:00-10:30)    | any one fruit
__________________________________________________________________________________________________________________
Lunch(1:00-2:00)         | 2 chapati + vegetable/chicken curry + one cup of rice + salad
__________________________________________________________________________________________________________________
Evening snack(5:00-5:30) | half bowl of soup + 2 walnuts + 3 almonds
__________________________________________________________________________________________________________________
Dinner(8:00-8:30)        | dark leafy vegetables/fish curry + 2 chapati + salad
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
Do You want to check for another patient  (1/0) : 
0
__________________________________________________________________________________________________________________
______________THANK YOU 
		 Do Follow Our Diet
		Best Wishes_____________
*/