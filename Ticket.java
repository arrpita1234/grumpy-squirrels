import java.lang.Comparable

public class Ticket {

    private int ID;
    private boolean _solved;
    private int _priority;
    private String name;
    private String problem;
    private String solution;

    public Ticket (int UID, int priority, String UN, String desc){
	ID = UID;
	_solved = false;
	_priority = priority;
	name = UN;
	problem = desc;
	solution = "";
    }

    public void fixed(){
	_solved = true;
    }

    public void solve(String s){
	solution = s;
    }

    public int getVIP(){
	return _priority;
    }

    public String getName(){
	return name;
    }

    public int compareTo(Ticket t)
	
    }

    public String toString(){
	return ID + ":" + name;
    }

}//end class
