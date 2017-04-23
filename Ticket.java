public class Ticket implements Comparable<Ticket> {

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

    public int compareTo(Ticket t){
	if (_priority > t.getVIP())
	    return 1;
	else if (_priority < t.getVIP())
	    return -1;
	else
	    return 0;
    }

    public String toString(){
	return ID + ":" + name;
    }

}//end class
