import java.util.Scanner;

public class HelpDesk{


    //===============Instance Vars==================
    
    private ArrayPriorityQueue<Ticket> dumbLine;
    private Scanner userInput;
    private boolean isRunning;
    public int ID;
    
    //==============================================

    //=================Constructor==================
    
    public HelpDesk(){
	   dumbLine = new ArrayPriorityQueue<Ticket>();
       userInput = new Scanner(System.in);
       isRunning = true;
       ID = 0;
    }

    //==============================================


    //=====================Methods==================

    //Adds a ticket to the queue
    public int addTicket(String name, String problem, int priority){
        int id = ID += 1;
        Ticket newUser = new Ticket(id, priority, name, problem);
        dumbLine.add(newUser);
        return id;
    }

    //Removes ticket in front of queue
    public void removeFrontUser(){
        dumbLine.removeMin();
    }

    //Returns information of user in front of queue
    public Ticket frontUser(){
       return dumbLine.peekMin();
    }
    
    public String toString(){
        return dumbLine.toString();
    }

    //Mode for operators
    public void mode1(){

	//if there are no one in queue
        if(dumbLine.isEmpty()){
            System.out.println("There are no users in the queue right now, please check back later.");
            return;
        }

	//options for operator
        System.out.println("Press 0 to see all tickets, 1 to see front ticket, or any other key to handle the front ticket");
        System.out.print("Enter: ");
        String tickets = userInput.next();

	//If operator wants to see all tickets in queue
        if(tickets.equals("0")){
            System.out.println(this + "\n"); //prints out information of everyone in queue
            return;
        }

	//If operator wants to see information of user in front of queue
        else if(tickets.equals("1")){
            Ticket front = frontUser();
            System.out.println("These still need to be solved:\n"); //prints information of user in front of queue
            System.out.println(front);
            return;
        }

	//===================================For Operator to give solution to a user=======================================
        Ticket f = frontUser();
        System.out.println(f + ", Solution: " + f.getSolution() + "\nTo change solution, enter your solution below:\n");
        
        
        String soln = userInput.nextLine();
        f.setSolution(soln);   //Gives user their solution from operator

	//if no solution is inputted
        while(soln.equals("")){
            System.out.print("Solution: ");
		    soln = userInput.nextLine();
            f.setSolution(soln);
	     }
        System.out.println("This is the final result: " + f.getName() + ", " + f.getID() + ", Solution: " + f.getSolution());
        System.out.println("This solution will be presented to the user to wait for response. Please check back later.");
        return;
	//=================================================================================================================        
    }


    //Mode for users
    public void mode2(){
        System.out.println("Press 0 if you are an old user, any other key if new user");
        System.out.print("Enter: ");
        String tickets = userInput.next();

	//If user claims to have been here before
        if(tickets.equals("0")){

	    //There is no one in queue and the user is lying. Ban him/her.
            if(dumbLine.isEmpty()){
                System.out.println("There are no users in the queue right now, so you must be mistaken. Please check back later.");
                return;
            }

	    //If user is not lying:
            int uID = 0;
            System.out.println("Please enter user ID:");
            try{
                uID = userInput.nextInt();   //USer inputs their UID
            }
            catch (Exception e){
                System.out.println("Could not process ID. Go back to try again.");
                return;
            }

	    //If user is the person in front of the line
            if (uID == frontUser().getID()){
                String soln = frontUser().getSolution();

		//If no solution has been supplied by operator
                if(soln.equals("")) {
                    System.out.println("Sorry, we haven't found any solutions for you yet. Please try again later.");
                    return;
                }

		//If there is a solution available
                else{ 
                    System.out.println("This is the solution our operators have gotten for you is: " + soln);
                    System.out.print("Did this work for you? Press y or n for yes or no: ");
                    String input = userInput.next();

		    //Prolem solved
                    if(input.equals("y")) {
                        System.out.println("Horray! Thank you for using HelpDesk. Come back another time!");
                        dumbLine.removeMin();
                        return;
                    }

		    //Useless Operator
                    else{
                        System.out.println("Sorry, please check back later for a better solution.");
                        giveUpMenu();
                        return;
                    }
                }
            }

	    //If no solution were given yet
            else{
                System.out.println("Sorry, you must still wait on line. We cannot get to you at this moment. Come back later.");
                return;
            }
        }

	//New User:
        else{
            System.out.println("Hello, new user!");
	    
	    //===================Asks for information on User====================
	    String name = "";
            while(name.equals("")) {
                System.out.print("Enter your name: ");
                name = userInput.nextLine();
            }
            String problem = "";
            while(problem.equals("")) {
                System.out.print("Enter your problem: ");
                problem = userInput.nextLine();
            }
            int priority = -1;
            while(priority == -1) {
                System.out.print("Enter your rank on a scale of 0-99: ");
                try {
                    priority = userInput.nextInt();
                }
                catch(Exception e){
                    System.out.println("Cannot process request at this time, please try again later.");
                    return;
                }
            }
            
            priority = (priority % 100);
            //====================================================================

	    //enqueues new user
            int ID = addTicket(name, problem, priority);
            
            System.out.println("You have been added to our queue. This your information:\nName:" + name + "\nProblem: " + problem + "\nThis is your user ID. Please remember it for later: " + ID);
        }
        return;
	
    }

    //Leave the help desk:
    public void giveUpMenu(){
        System.out.print("If you'd like to give up now and try a different help desk,\n press 0: ");
        String in = userInput.nextLine();
        if(in.equals("0")){
            dumbLine.removeMin();
            System.out.println("Thank you for trying HelpDesk. Good luck with your issue.");
        }
        else if(in.equals("")){
            System.out.println("Alright, come back later to check for a better result.");
        }
        else{
            System.out.println("Alright, come back later to check for a better result.");
        }
        return;
    }

    //Initiates help desk
    public void startMenu(){
        System.out.println("\n\n\n\nHi, welcome to the HelpDesk. To begin:\nPress 0 if you are an operator\n1 if you are an user\n2 if you'd like to quit.");
        System.out.print("Enter: ");
        String mode = userInput.next();

	//Person is Operator
        if(mode.equals("0")) {
                mode1();
        }

	//Person is User
        else if(mode.equals("1")) {
            
                mode2();
        }

	//Person wanna quit
        else if(mode.equals("2")) {
            isRunning = false;
            return;
        }

	//Person can't read
       else {    
        System.out.println("Sorry, we cannot process your request at this time. Please try again another time.");
        return; 
       }
    }

    //==============================================

    
    //Running Help Desk
    public static void main(String[] args){
        HelpDesk h = new HelpDesk();
        while(h.isRunning){
            h.startMenu();
        }
        System.out.println("Program has completed. Thank you for using HelpDesk.");
    }  //end main
    
}//end class
