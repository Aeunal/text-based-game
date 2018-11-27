//import java.util.ArrayList;

public class objects {
	
	
	String name="";
	int location;
	Boolean opened, closed, examineChanged, taken, used, went,pushed,locked;
	
	String[] dialogs= {
			"opened",
			"closed",
			"examined",
			"taken",
			"used",
			"went"
	};
	
	
	//* - construct on/off
	public objects(	Boolean examineChanged,	Boolean taken, 	Boolean opened,	Boolean closed,	
					Boolean used,			Boolean went,	Boolean pushed,	int location) {
		
		this.examineChanged	= examineChanged;
		this.taken 			= taken;
		this.opened			= opened;
		this.closed			= closed;
		this.used			= used;
		this.went			= went;
		this.pushed			=pushed;
		//this.locked			=locked;
		
		this.location		=location;
		
	}
	//*/
	
	/*
	public objects(	int examineChanged,	int taken, 	int opened,	int closed,	
					int used,			int went, 	int location) {
		
		switch (examineChanged) {
		case 1	: this.examineChanged = true;	break;
		case 0	: break;
		case -1	: this.examineChanged = false;	break;
		}
		
		switch (taken) {
		case 1	: this.taken = true;	break;
		case 0	: break;
		case -1	: this.taken = false;	break;
		}
		
		switch (opened) {
		case 1	: this.opened = true;	break;
		case 0	: break;
		case -1	: this.opened = false;	break;
		}
		
		switch (closed) {
		case 1	: this.closed = true;	break;
		case 0	: break;
		case -1	: this.closed = false;	break;
		}
		
		switch (used) {
		case 1	: this.used = true;		break;
		case 0	: break;
		case -1	: this.used = false;	break;
		}
		
		switch (went) {
		case 1	: this.went = true;		break;
		case 0	: break;
		case -1	: this.went = false;	break;
		}
		
		this.location = location;
	}
	//*/
	
	
	
	/*
	ArrayList<String> objects = new ArrayList<String>() {{
		add("help");
		add("building");
		add("door");
		add("room");
		add("table");
		add("chest");
		add("books");
	}};
	*/
	
	/*
	public static void open(int id) {
		switch(id) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
	}
	*/
	
	
	/*
	public static objects door=new openable(false,true) {{
		door.examineChanged=false;
	}};
	*/
	

}

