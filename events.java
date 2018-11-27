import java.util.Arrays;

public class events {

	
	public static Boolean[][] eventList = {
		//{	examin,	take,	open,	close,	use,	move,	push,	}	
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	false,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			{null,	null,	null,	null,	null,	null,	null,	},
			
	};
	
	
	
	//item(id).examineChanged ???
	
	//at the end make a copy of it and name it memory and campare with new one to make auto change detection.
	
	
	
	void eventHappen(String verb,String object) {
		
		int row		= Arrays.asList(project.items).indexOf(object);
		int column	= Arrays.asList(project.verbs).indexOf(verb);
		
		if(eventList[row][column]!=null) {
			if(!eventList[row][column]) {
				
				eventList[row][column]=true;
				
			} else {
				
			}
		} else {
			project.say("nothing new happened..");
		}
		
	}
	
	
	
	public static int id(String object) {
		int id=Arrays.asList(project.items).indexOf(object);
		return id;
	}
	
	
	
	public static boolean isChanged(int row,int column) {
		if(events.eventList[row][column]!=null) {
			if(events.eventList[row][column]) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	
	boolean isLocked(String object) {
		
		int item=Arrays.asList(project.items).indexOf(object);
		boolean result=false;
		
		for (int i = 0; i < eventList[item].length; i++) {
			if(eventList[item][i]==false) {
				result=true;
			}
		}
		return result;
	}
	
	
	
	public static void chestOpened(int chestID) {
		
	}
	
	public static void doorOpened(int doorID) {
		
	}
	
	public static void wasBroken(int a) {
		
	}
	
	
	
	public static void lockOpen(String object) {
		
		//object = key
		int order = Arrays.asList(project.keys).indexOf(object);
		//project.say(order+"");
		String lock = project.locked[order];
		//project.say(lock+"");
		if(Arrays.asList(project.locked).contains(lock)) {
			
			if(Arrays.asList(project.inventory).contains(object)) {
				project.locked[order]="";
			}
			
		} else {
			project.say("It was not locked.");
		}
	}
	
	
	
	static void open(String object) {
		
		//SSystem.out.println(Arrays.toString(project.locked));
		
		if(Arrays.asList(project.closed).contains(object)) {
			
			if(project.item(object).opened!=null){
				
				//if(Arrays.asList(specialities[1]).contains(verb)) {
				if(!Arrays.asList(project.locked).contains(object)) {
						
						if(!project.item(object).opened) {
							
							project.item(object).opened=true;
							project.item(object).closed=false;
							
							int order = Arrays.asList(project.closed).indexOf(object) + 1;
							
							for (int i = 0; i < project.itemLocations.length; i++) {
								
								if(project.itemLocations[i]==(10+order)) {
									project.itemLocations[i]=project.roomID;
								}
							}
							
							dialogue.load("open", object);
							
						} else {
							
							project.say("I already opened that");
						
						}
					
				} else {
					project.say("it was locked. I should have to used something to open it.");
				}
				
				//project.itemLocations[id]=0;
				
			} else {
				dialogue.error("open");
			}
			
		} else {
			project.say("It wasn't closed.");
		}
	}
	
	
	
	public static void examine(String object) {

		if(project.item(object).examineChanged!=null) {
			dialogue.load("examine", object);
		} else {
			dialogue.error("examine");
		}
		
	}
	
	
	
	public static void close(String object) {
		
		int id=id(object);
		int order = Arrays.asList(project.closed).indexOf(object) + 1;
		
		if(project.item(object).closed!=null){
			
			//if(Arrays.asList(specialities[1]).contains(verb)) {
			if(!project.item(object).closed) {
				
				if(project.itemLocations[id]!=0) {
					
					//if(Arrays.asList(project.itemLocations).contains(object))
					for (int i = 0; i < project.itemLocations.length; i++) {
						
						if(project.oldItemLocations[i]==(10+order)) {
							project.itemLocations[i]=project.oldItemLocations[i];
						}
					}
				}
				
				project.item(object).closed=true;
				project.item(object).opened=false;
				
				dialogue.load("close", object);
				
			} else {
				project.say("It was already closed");
			}
			
			// itemlerin lokasyonlarý update edildi" kodu
			
		} else {
			dialogue.error("close");
		}
		
	}
	
	
	
	public static void take(String object) {
		
		int id=id(object);
		
		if(project.item(object).taken!=null){
			
			//if(Arrays.asList(specialities[1]).contains(verb)) {
			if(!project.item(object).taken) {
				
				project.item(object).taken=true;
				dialogue.load("take", object);
				
				project.itemLocations[id]=0;
				
			} else {
				project.say("I've already taken it.");
			}
			
		} else {
			dialogue.error("take");
		}
		
	}
	
	public static boolean itemAcquired(String object) {
		
		boolean isAcquired=false;
		
		if(project.item(object).taken!=null){
			
			if(!project.item(object).taken) {
				isAcquired = true;
			}
		}
		return isAcquired;
	}
	
	
	
	
	public static void use(String object) {
		
		int order=0;
		
		//if(object.equals("keyCard")&&project.roomID==2) {
		//	order=3;
		//} else {
			order=Arrays.asList(project.keys).indexOf(object);
		//}
		
		if(project.item(object).used!=null){
			
			//if(Arrays.asList(specialities[1]).contains(verb)) {
			if(!project.item(object).used) {
				
				if(project.itemLocations[id(project.locked[order])]==project.roomID) {
					
					if(!object.equals("keyCard")) {
						project.item(object).used=true;
					}
					
					dialogue.load("use", object);
					
					if(Arrays.asList(project.keys).contains(object)) {
						lockOpen(object);
					}
				} else {
					project.say("I couldn't use it in there.");
				}
				
			} else {
				project.say("I already used it");
			}
			
			//itemLocations[id]=0; //maybe it can change
			
		} else {
			dialogue.error("use");
		}
	}
	
	
	public static void push(String object) {
		

		if(project.item(object).pushed!=null) {
			
			if(!project.item(object).pushed) {
				
				project.item(object).pushed=true;
				dialogue.load("push", object);
				
			} else {
				project.say("I already pushed that!");
			}
			
		} else {
			dialogue.error("push");
		}
		
	}
	
	/*
	public static void goRoom(int roomID,int toRoomID) {
		for (int i = 0; i < project.exitRooms[project.roomID].length; i++) {
			if(project.item(project.exitRooms[project.roomID][i]).opened) {
				project.roomID=roomID;	
			}
		}
	}
	*/
	
	public static Boolean isOpen(String object) {
		return project.item(object).opened;
	}
	
}
