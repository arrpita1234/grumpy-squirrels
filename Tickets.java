public class Tickets{

    private int ID;
    private int _status;
    private int _priority;
    private String name;
    private String description;

    public void Tickets (int UID, int priority, String UN, String desc){
	ID = UID;
	_status = 0;
	_priority = priority;
	name = UN;
	description = desc;
    }

    

}//end class
