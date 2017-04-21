/*
  Team Name: 
  Team Members: Yu Qi Wu, Ri Hui Zheng, Jenny Han
  APCS2 pd3
  HW32 -- Getting Past the Velvet Rope
  2017-04-20
 */

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{
    
    private ArrayList<T> _data;
    private int _size;

    public ArrayPriorityQueue(){
	_data = new ArrayList<T>();
	_size = 0;
    }

    public void add(int var){
	if (_size == 0){
	    _data.add(var);
	    _size++;
	}
	else{
	    int index = 0;
	    for (int count = 0; count < _size; count++){
		if (var < _data.get(count)){
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

    public T peekMin(){
	return _data.get(0);
    }

    public T removeMin(){
	T temp = peekMin();
        _data.remove(0);
	_size--;
	return temp;
    }

    public static void sop(Object o){
	System.out.println(o);
    }
    
    public String toString(){
	String retStr = "";
	for (T i:_data){
	    retStr += i + " , ";
	}
	return retStr;
    }

    public static void main (String[] args){

	ArrayPriorityQueue numLine = new ArrayPriorityQueue();

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
	
	numLine.add(1);
	numLine.add(2);
	numLine.add(3);
	numLine.add(2);
	numLine.add(1);
	
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

