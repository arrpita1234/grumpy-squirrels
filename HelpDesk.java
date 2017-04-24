import java.util.Scanner;

public class HelpDesk{
    
    private ArrayPriorityQueue<Ticket> dumbLine;
    private Scanner userInput;
    private boolean isRunning;
    public int ID;
    
    public HelpDesk(){
	   dumbLine = new ArrayPriorityQueue<Ticket>();
       userInput = new Scanner(System.in);
       isRunning = true;
       ID = 0;
    }
    
    public int addTicket(String name, String problem, int priority){
        int id = ID += 1;
        Ticket newUser = new Ticket(id, priority, name, problem);
        dumbLine.add(newUser);
        return id;
    }
    
    public void removeFrontUser(){
        dumbLine.removeMin();
    }
    
    public Ticket frontUser(){
       return dumbLine.peekMin();
    }
    
    public String toString(){
        return dumbLine.toString();
    }
    
    public void mode1(){
        if(dumbLine.isEmpty()){
            System.out.println("There are no users in the queue right now, please check back later.");
            return;
        }
        
        System.out.println("Press 0 to see all tickets, 1 to see front ticket, or any other key to handle the front ticket");
        System.out.print("Enter: ");
        String tickets = userInput.next();
        if(tickets.equals("0")){
            System.out.println(this + "\n");
            return;
        }
        else if(tickets.equals("1")){
            Ticket front = frontUser();
            System.out.println("These still need to be solved:\n");
            System.out.println(front);
            return;
        }
        
        Ticket f = frontUser();
        System.out.println(f + ", Solution: " + f.getSolution() + "\nTo change solution, enter your solution below:\n");
        
        System.out.print("Solution: ");
        String soln = userInput.nextLine();
        f.setSolution(soln);
        
        while(soln.equals("")){
            System.out.print("Solution: ");
		    soln = userInput.nextLine();
            f.setSolution(soln);
	     }
        System.out.println("This is the final result: " + f.getName() + ", " + f.getID() + ", Solution: " + f.getSolution());
        System.out.println("This solution will be presented to the user to wait for response. Please check back later.");
        return;
        
    }
    
    
    public void mode2(){
        System.out.println("Press 0 if you are an old user, any other key if new user");
        System.out.print("Enter: ");
        String tickets = userInput.next();
        if(tickets.equals("0")){
            if(dumbLine.isEmpty()){
                System.out.println("There are no users in the queue right now, so you must be mistaken. Please check back later.");
                return;
            }
            
            int uID = 0;
            System.out.println("Please enter user ID:");
            try{
                uID = userInput.nextInt();
            }
            catch (Exception e){
                System.out.println("Could not process ID. Go back to try again.");
                return;
            }
            
            if (uID == frontUser().getID()){
                String soln = frontUser().getSolution();
                if(soln.equals("")) {
                    System.out.println("Sorry, we haven't found any solutions for you yet. Please try again later.");
                    return;
                }
                else{ 
                    System.out.println("This is the solution our operators have gotten for you is: " + soln);
                    System.out.print("Did this work for you? Press y or n for yes or no: ");
                    String input = userInput.next();
                    if(input.equals("y")) {
                        System.out.println("Horray! Thank you for using HelpDesk. Come back another time!");
                        dumbLine.removeMin();
                        return;
                    }
                    else{
                        System.out.println("Sorry, please check back later for a better solution.");
                        giveUpMenu();
                        return;
                    }
                }
            }
            
            else{
                System.out.println("Sorry, you must still wait on line. We cannot get to you at this moment. Come back later.");
                return;
            }
        }
        
        else{
            System.out.println("Hello, new user!");
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
            
            int ID = addTicket(name, problem, priority);
            
            System.out.println("You have been added to our queue. This your information:\nName:" + name + "\nProblem: " + problem + "\nThis is your user ID. Please remember it for later: " + ID);
        }
        return;
    }
    
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
    
    public void startMenu(){
        System.out.println("\n\n\n\nHi, welcome to the HelpDesk. To begin:\nPress 0 if you are an operator\n1 if you are an user\n2 if you'd like to quit.");
        System.out.print("Enter: ");
        String mode = userInput.next();
        if(mode.equals("0")) {
                mode1();
        }
        else if(mode.equals("1")) {
            
                mode2();
        }
        else if(mode.equals("2")) {
            isRunning = false;
            return;
        }
            
       else {    
        System.out.println("Sorry, we cannot process your request at this time. Please try again another time.");
        return; 
       }
    }
        
    public static void main(String[] args){
        HelpDesk h = new HelpDesk();
        while(h.isRunning){
            h.startMenu();
        }
        System.out.println("Program has completed. Thank you for using HelpDesk.");
    }  
    
}
