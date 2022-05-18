/*
In this file i create a simple bank application. I will create a bank account object, and store information about it within it
*/

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
    //first we want to pring out a menu and ask the user to enter in their information.
    public static void main(String[] args) {
        boolean condition = true;
        ArrayList<BankAccount> list_of_accounts = new ArrayList<>();
        String new_user_input;
        Scanner sc = new Scanner(System.in);
        while (condition){
            boolean break_cond=false;

            System.out.println("Welcome. If you would like to quit, enter q at any time.");
            System.out.print("Are you a new user, Yes or No: ");
            new_user_input = sc.next();
            
            if((new_user_input.equals("Yes")) || (new_user_input.equals("yes")) || (new_user_input.equals("YES"))){
                //here we are creating the new variables that we are going to be using. That being the scanner obj that will take in input, and the string username and password
                Scanner sc2 = new Scanner(System.in);
                String new_username;
                String new_password;
                
                //Here we are printing out the menu for someone to enter their information
                System.out.println("Please enter the username and password you would like to use for your account.");
                System.out.print("Username: ");
                new_username = sc2.nextLine();
                System.out.print("Password: ");
                new_password = sc2.nextLine();


                if((new_username.equals("q")) || (new_username.equals("Q")) ){
                    break_cond = true;
                }


                //here we are creating a temperary bankaccount obj with this information
                BankAccount temp = new BankAccount(new_username, new_password);
                

                //here we are checking first that the list of existing accounts in either empty or not. If so, just add the new account to it. If not, then we go through the database and see if the account with this information already exists. If it does, then we propmt the user with a message that states that we already have an account with that information and please log in. If not, then we just add the account to the database.

                if(!break_cond){
                    if(list_of_accounts.isEmpty()){
                        list_of_accounts.add(temp);
                        System.out.println("Thank you for making an account with us. You can now use your information to log in.");
                        System.out.println();
                    }
                    else{
                        boolean does_exist = false;
                        for(int i=0; i<list_of_accounts.size(); i++){
                            if((list_of_accounts.get(i).password.equals(temp.password)) && (list_of_accounts.get(i).username.equals(temp.username))){
                                does_exist = true;
                                break;
                            }
                        }

                        if(does_exist){
                            System.out.println("Sorry, looks like you already have an account with us. Please enter your username and password to log in.");
                            System.out.println();
                        }
                        else{
                            list_of_accounts.add(temp);
                            System.out.println("Thank you for making an account with us. You can now use your information to log in.");
                            System.out.println();
                        }
                    }
                }
                

            }
            else if((new_user_input.equals("No")) || (new_user_input.equals("no")) || (new_user_input.equals("NO"))){
                //here we are now taking in the users information and checking to see if the account exists.
                Scanner sc3 = new Scanner(System.in);
                String username;
                String password;
                
                //Here we are printing out the menu for someone to enter their information
                System.out.println("Please enter the username and password you would like to use for your account.");
                System.out.print("Username: ");
                username = sc3.nextLine();
                System.out.print("Password: ");
                password = sc3.nextLine();
                System.out.println();


                if((username.equals("q")) || (username.equals("Q")) ){
                    break_cond = true;
                }


                //here we are creating a temperary bankaccount obj with this information
                BankAccount temp = new BankAccount(username, password);

                if(!break_cond){
                    for(int i=0; i<list_of_accounts.size(); i++){
                        if((list_of_accounts.get(i).password.equals(temp.password)) && (list_of_accounts.get(i).username.equals(temp.username))){
                            list_of_accounts.get(i).menu();
                            break;
                        }
                    }
                }
                    



            }

            else if((new_user_input.equals("q")) || (new_user_input.equals("Q"))){
                condition = false;
            }

            else{
                System.out.println("Sorry, it looks like you entered a invalid option. Please try again");
                System.out.println();
            }





            if(break_cond){
                break;
            }



        }


            
    }
}


class BankAccount{
    String username, password;
    double amount_in_account;


    //this method here initalizes the information into a new bank account
    BankAccount(String username, String password){
        this.username = username;
        this.password = password;
    }

    //next we are going to define some methods. one will deposit some money. another will withdraw some money. another will display a menu containing the money within the account/.
    void deposit(double amount){
        if(amount !=0){
            amount_in_account += amount;
            System.out.println(String.format("Amount deposited: %f", amount));
        }
    }

    void withdraw(double amount){
        if(amount != 0){
            amount_in_account -= amount;
            System.out.println(String.format("Amount withdrawn: %f", amount));
        }
    }

    void display_amount(double amount){
        System.out.println(String.format("Amount within account: %f", amount));
    }


    void menu(){
        Scanner sc4 = new Scanner(System.in);
        char opt;
        boolean cond = true;

        while (cond){
            System.out.println("------------------------------------");
            System.out.println(String.format("Welcome %s", username));
            System.out.println("What would you like to do?");
            System.out.println("Display amount (a)");
            System.out.println("Deposit some money (b)");
            System.out.println("Withdraw some money (c)");
            System.out.println("Log out (d)");
            System.out.print(": ");
            opt = sc4.next().charAt(0);
    
    
            if((opt == 'a') || (opt == 'A')){
                display_amount(amount_in_account);
            }
            else if((opt == 'b') || (opt == 'B')){
                double add_amount;
                System.out.print("How much money would you like to deposit: ");
                add_amount = sc4.nextDouble();

                if(add_amount < 0){
                    System.out.println("Sorry, looks like you entered an incorrect amount to deposit. Please enter a number, greater than 0, that you would like to deposit into your account.");
                }
                else{
                    deposit(add_amount);
                    System.out.println();
                    display_amount(amount_in_account);
                    System.out.println();
                }




                
            }
            else if((opt == 'c') || (opt == 'C')){
                double sub_amount;
                System.out.print("How much money would you like to withdraw: ");
                sub_amount = sc4.nextDouble();

                //here we are checking that the user cannot withdraw more money than if within the account

                if(sub_amount > amount_in_account){
                    char decission;
                    System.out.print("Sorry, the amount that you want to withdraw is more than in the account. Is this what you would like to do? Yes (y) or No (n): ");
                    decission = sc4.next().charAt(0);

                    if((decission == 'y') || (decission == 'Y')){
                        double amount_taken_out = Math.abs(amount_in_account - sub_amount);
                        withdraw(amount_taken_out);
                        System.out.println();
                        display_amount(amount_in_account);
                        System.out.println();

                    }
                    else if((decission == 'N') || (decission == 'n')){
                        System.out.println("Sorry, please try again.");
                    }
                    else{
                        System.out.println("Sorry, looks like you entered in a incorrect answer. Please try again.");
                    }
                }
                else{
                    withdraw(sub_amount);
                    System.out.println();
                    display_amount(amount_in_account);
                    System.out.println();
                }



                
                
            }
            else if((opt == 'd') || (opt == 'D')){
                cond = false;
                System.out.println();
            }
        }

       



    }
    
    

}