/*
Inside this java file, i build a calculator that takes input from the user. It will ask whether the user wants to perform one of 4 operations. Add, subtract, multiply, or divide. For simplicity, i will configure the calculator such that will work with floating point numbers.
*/
//here i am defining the public class calculator 
import java.util.*;


public class calculator {
    public static void main(String[] args) {
        //first we need to take in the input from the user and define our variables. I will be using the scanner class to do this
        double first, second;
        String input_condition;

        Scanner sc = new Scanner(System.in);

        boolean condition = true;
        while(condition){
            System.out.println("       Welcome\n------------------------\nWhat would you like to do\nAdd (a)\nSubtract (s)\nMultiply (m)\nDivide (d)\nQuit (q)");
            input_condition = sc.nextLine();

            if((input_condition.equals("m")) || (input_condition.equals("M"))){
                System.out.print("Please enter the first number: ");
                first = sc.nextDouble();
                System.out.print("Please enter the second number: ");
                second = sc.nextDouble();
                double output = first * second;
                System.out.print(String.format("The multiplication of %.2f and %.2f is: ", first, second));
                System.out.print(output);
            }

            else if((input_condition.equals("a")) || (input_condition.equals("A"))){
                System.out.print("Please enter the first number: ");
                first = sc.nextDouble();
                System.out.print("Please enter the second number: ");
                second = sc.nextDouble();
                double output = first+second;
                System.out.print(String.format("The addition of %.2f and %.2f is: ", first, second));
                System.out.print(output);
            }
            else if((input_condition.equals("s")) || (input_condition.equals("S"))){
                System.out.print("Please enter the first number: ");
                first = sc.nextDouble();
                System.out.print("Please enter the second number: ");
                second = sc.nextDouble();
                double output = first-second;
                System.out.print(String.format("The subtraction of %.2f and %.2f is: ", first, second));
                System.out.print(output);
            }
            else if((input_condition.equals("d")) || (input_condition.equals("D"))){
                System.out.print("Please enter the first number: ");
                first = sc.nextDouble();
                System.out.print("Please enter the second number: ");
                second = sc.nextDouble();
                double output = first/second;
                System.out.print(String.format("The division of %.2f and %.2f is: ", first, second));
                System.out.print(String.format("%.2f", output));
            }
            else if((input_condition.equals("q")) || (input_condition.equals("Q"))){
                break;
            }
            else{
                System.out.println("Sorry, but it looks like you entered an incorrect choice. Please try again.");
            }
            System.out.println();
            sc.nextLine();
            
        }
        sc.close();
        
    }
    
}
