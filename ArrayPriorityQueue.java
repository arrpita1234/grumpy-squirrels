import java.util.ArrayList;


public class ArrayPriorityQueue implements PriorityQueue{
    
    private ArrayList<T> _data;
    private int _size;

    public ArrayPriorityQueue(){
	_data = new ArrayList<T>();
	_size = 0;
    }

    public void add(Ticket var){
	if (_size == 0){
	    _data.add(var);
	    _size++;
	}
	else{
	    int priority = var.getVIP();
	    int index = 0;
	    for (int count = 0; count < _size; count++){
		if (priority >= _data.get(count).getVIP()){
		    _data.add(count, var);
		    _size++;
		    return;
		}
	    }
	}
    }

    public boolean isEmpty(){
	return _size == 0;
    }

    public Ticket peekMin(){
	return _data.get(_size-1);
    }

    public Ticket removeMin(){
	Ticket temp = peekMin();
        _data.remove(_size -1);
	_size--;
	return temp;
    }

    public static void sop(Object o){
	System.out.println(o);
    }
    
    public String toString(){
	String retStr = "";
	for (Ticket i:_data){
	    String name = i.getName();
	    retStr += name + " , ";
	}
	return retStr;
    }

    public static void main (String[] args){

	ArrayPriorityQueue numLine = new ArrayPriorityQueue();
	Ticket dumbPersonA = new Ticket(1, 0, "Bob", "My screen is black");
	Ticket dumbPersonB = new Ticket(12, 1, "Dob", "My screen is black");
	Ticket dumbPersonC = new Ticket(13, 5, "Fob", "My screen is black");
	Ticket dumbPersonD = new Ticket(14, 2, "Gob", "My screen is black");
	Ticket dumbPersonE = new Ticket(15, 0, "Pob", "My screen is black");

	//empty queue
	sop(numLine);

	//add numbers
	/*
	int newNum = 0;
	for (int n = 0; n < 10; n++){
	    newNum = (int)(Math.random() * 10);
	    numLine.add(newNum);
	}
	*/
	/*
	numLine.add(1);
	numLine.add(2);
	numLine.add(3);
	numLine.add(2);
	numLine.add(1);
	*/
	numLine.add(dumbPersonA);
	numLine.add(dumbPersonB);
	numLine.add(dumbPersonC);
	numLine.add(dumbPersonD);
	numLine.add(dumbPersonE);

	//populated queue
	
	sop(numLine);

	//tests peek and remove

	for (int i = 0; i < 5; i++){
	    sop("\nremoving: " + numLine.peekMin());
	    numLine.removeMin();
	    sop(numLine);
	}

	
    }//end main
}//end class

