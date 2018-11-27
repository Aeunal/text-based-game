import java.util.Arrays;
import java.util.Scanner;
//import java.util.ArrayList;


public class project {
	
	static Scanner input=new Scanner(System.in);//input
	
	static String help = ""
			+ "\n______________ Accesible Commands _______________"
			+ "\n"
			+ "\nhelp 		: browse commands"
			+ "\ninventory	: browse inventory"
			+ "\nlook		: look at the accesible items in room"
			+ "\nhint		: You can use when you stuck"
			+ "\nexits		: shows accesible exits"
			+ "\n"
			+ "\nexamine		: examine item"
			+ "\ntake		: take item"
			+ "\nopen		: open item"
			+ "\nclose		: close item"
			+ "\nuse		: use item"
			+ "\nmove		: Go through the given direction"
			+ "\n"
			+ "\nexit/quit	: quit the game"
			+ "\n"
			+ "\n(Unfortunately objects are case-sensitive)\n";
	
	static String[] commands = {
			"help",		// id:0
			"inventory",// id:1
			"look",
			"hint",
			"exits",
	};
	
	//open(before) and close(after) should be side by side
	static String[] verbs = {					//Verbs
			
			"examine",
			"take",
			"open",
			"close",
			"use",
			"move",
			"push",
	};
	
	static String[] items= {					//Objects 
			
			"helpSheet",		// id:0
			"depot",			// id:1
			"metalCrate",				// id:2
			"crates",		// id:3
			"door",			// id:4
			"keyCard",			// id:5
			"locker",			// id:6
			"metalBar",			// id:7
			"uniform",				// id:8
			"flashlight",			// id:9
			"doorBack",
			"door",
			"corridor",
			"corridor",
			"elevator",				// id:10
			"elevator",
			"elevator",//11
			"blueDoor",//12
			"bluedoor",
			"blueDoor",
			"blueDoor",
			"panelRoom",
			"panels",//13
			"cable",//14
			"corridor",
			"securityGuards",//15
			"pistol",//16
			"entranceCard",
			"bigDoor",
			"bigDoor",
			"laboratory",
			"enemy",
			
	};
	
	static String[] directions= {
		"back","north","east","west","south"	
	};
	
	static String[] closed = {
			"door", "locker", "metalCrate","uniform","panels","elevator","blueDoor","bigDoor"
	};
	
	static String[] locked = {
			"door", "locker","elevator","bigDoor","enemy"//,"blueDoor"
	};
	
	static String[] keys = {
			"keyCard", "metalBar","cable","entranceCard","pistol"//,"keyCard"
	};
	
	static String[][] exits = { // 1=north, 2=east, 3=west, 4=south
			{""},
			{"east"},
			{"south","west","north"},
			{"south"},
			{"south","west","north"},
			{"south"},
			{"south","west"},
			{"east"}
	};
	
	static String[][] exitRooms = { // 1=north, 2=east, 3=west, 4=south
			{},
			{"door"},
			{"elevator","doorBack","blueDoor"},
			{"blueDoor"},
			{"elevator","doorBack","blueDoor"},
			{"blueDoor"},
			{"elevator","bigDoor"},
			{"bigDoor"}
	};
	
	static int roomCount=7;
	
	//Unfortunately, this method is necessary because I can not access the objects class's location (I don't know why)
	public static int[] itemLocations = {
			10,1,1,1,1,14,1,13,1,12,2,4,2,4,2,4,6,2,4,3,5,5,5,5,6,6,6,6,6,7,7,7
	};
	
	public static int[] oldItemLocations = {
			10,1,1,1,1,14,1,13,1,12,2,4,2,4,2,4,6,2,4,3,5,5,5,5,6,6,6,6,6,7,7,7
	};
	
	/* I don't need that anymore
	// id=itemID	 item Speciliaties
	static Boolean [][] specialities= {//specialities=(examineChanged, took, opened, used, went, closed} 
			{false, null,null,null,null},		//id:0
			{false, null,null,null,null},		//id:1
			{false, false,true,false,false},	//id:2
			{false, false,false,false,false},	//id:3
			{false, false,true,true,false},		//id:4
	};
	//*/
	
	static String[] inventory = {				//Inventory 
			"Empty","Empty","Empty","Empty","Empty","Empty","Empty","Empty"
	};
	
	//length can be changed
	static objects[] item = new objects[100];
	
	//Charachter Location
	static int roomID=1; 
	
//////////////////////////////////////////// Useful Methods //////////////////////////////////////////////
	
	// say = System.out.println 
	public static void say(String text) {		
		System.out.println(text);
	}
	
	
	/*
	private static objects[] objeler(int ID)
	{
	    objects[] itemim = new objects[100];
	    for(int i = 0; i < itemim.length; i++)
	    {
	        itemim[i] = new objects(false,false,false,false,false,false,10);
	    }
	    return itemim;
	}
	//*/
	
	public static objects item(String name) {
		int ID=Arrays.asList(items).indexOf(name);
		return item[ID];
	}
	
	public static objects item(int id) {;
		return item[id];
	}
	
	/*
	public static void itemList() {
		objects[] item = new objects[100];
	
		for(int i = 0; i < item.length; i++)
    	{
		item[i] = new objects(null,null,null,null,null,null,10);
    	}
	}
	//*/
	
	
	// features(object, item, isExamineChanged, isTaken, isOpened, isClosed, isUsed, isWent, LOCATION);
	
	//*
	public static objects features(int ID, 		objects[] items,	Boolean examineChanged,	Boolean taken,	Boolean opened,
									Boolean closed,	Boolean used,		Boolean went,			Boolean pushed,	int location) {
		objects memory;
		items[ID] = new objects(examineChanged,taken,opened,closed,used,went,pushed,location);
		memory=items[ID];
		return memory;
	}
	//*/
	
	/*
	private static objects features(int ID, 	objects[] item,	int examineChanged,	int taken, 
									int opened,	int closed,		int used,			int went,	int location) {
		objects memory;
		item[ID] = new objects(examineChanged,taken,opened,closed,used,went,location);
		memory=item[ID];
		return memory;
	}
	//*/
	
	/*//if you want to add features by object name//
	private static objects features(String object,	objects[] item,	Boolean examineChanged,	Boolean taken,	Boolean opened,	
									Boolean closed,	Boolean used,	Boolean went,			Boolean pushed,	int location) {
		
		int ID=Arrays.asList(items).indexOf(object);
		
		objects memory;
		item[ID] = new objects(examineChanged,taken,opened,closed,used,went,pushed,location);
		memory=item[ID];
		return memory;
	}
	//*/
	
	/*
	private static objects features(String object,	objects[] item,	int examineChanged,	int taken, 	int opened,
									int closed,		int used,		int went,			int location) {
			
		int ID=Arrays.asList(items).indexOf(object);
		
		objects memory;
		item[ID] = new objects(examineChanged,taken,opened,closed,used,went,location);
		memory=item[ID];
		return memory;
	}
	//*/
	
	/*/ 	//It does not allow me to change the name without doing it static
	//AUTO assign name of item objects
	public static void nameAssign() {
		for (int i = 1; i < items.length; i++) {
			item(i).name=items[i];
		}
	}
	//*/
	
	//*/
	//AUTO assign features of items
	public static void featureAssign() {
		
		/*
		item(1).location=1;
		item(2).location=1;
		item(3).location=1;
		item(4).location=1;
		item(5).location=1;
		item(6).location=1;
		item(7).location=1;
		item(8).location=1;
		item(9).location=1;
		item(10).location=1;
		//*/
		
		Boolean[] boolList = new Boolean[verbs.length+1];
		
		for (int i = 1; i < dialogue.dialogs.length; i++) {
			
			for (int j = 0; j < verbs.length; j++) {
				if(dialogue.dialogs[i][j].equals("")||dialogue.dialogs[i][j].equals(null)) {
					boolList[j]=null;
				} else {
					if(verbs[j].equals("close")) {
						boolList[j]=true;
					} else {
						boolList[j]=false;
					}
				}
			}
			features(i, item, boolList[0], boolList[1], boolList[2], boolList[3], boolList[4], boolList[5], boolList[6], itemLocations[i]);
			
		}
	}
	//*/
	
////////////////////////////////////////////  Main Method  ///////////////////////////////////////////////
	
	public static void main(String[] args) {
		
		String verb="",object="";
		//String memory="";
		String[] entry;
		
		//I do not need that
		//int actionID;
		
		//int directionID;
		int id=0;
		
		//I did not hear the object
		boolean sequel=false;
		
		//program is running
		boolean isRunning=true;
		
		//boolean interacted=false;
		
		//is room changed
		boolean roomChanged=true;
		
		/*
		item("building").opened=true;
		System.out.println(items.length);
		System.out.println(item(1).location);
		//*/
		
		//it is giving error
		//nameAssign();
		
		// null=can't do    false= didn't do	
		//features(object, 	item, isExamineChanged, isTaken, isOpened, isClosed, isUsed, isWent, LOCATION);
		//features("name", 		item, 	exChng,	taken,	opened,	closed,	used,	went,	pushed,	location);
		//features("NameName",	item,	false,	null,	null,	null,	null,	null,	null,	1);
		
		featureAssign();
		
		int inventoryCount=0;
		boolean newItemAcquired=true;
		boolean arrived=false;
		//boolean arrived3=false;
		//boolean dontTalk=false;
		//boolean gone=false;
		

////////////////////////////////////////////// Start Game! ///////////////////////////////////////////////
		
		say(dialogue.dialogs[0][0]);
		
		do {
			
			//say(""+newItemAcquired);
			//say(""+inventoryCount);
			
			//inventory updater
			if(newItemAcquired) {
				for (int i = 1; i < items.length; i++) {
					if(itemLocations[i]==0) {
						inventory[inventoryCount]=items[i];
						inventoryCount++;
					}
				}
				newItemAcquired=false;
			}
			
			//check location change
			if(roomChanged) {
				dialogue.load("look", roomID);
				roomChanged=false;
			}
			
			
			entry = input.nextLine().split(" ");
			
			if(!sequel) {
				// TAKE VERB
				verb=entry[0];
			}
		
			//Terminate the program
			if(entry[0].equals("quit")||entry[0].equals("exit")) {
				isRunning = false;
			}
		
			//check running || abandon terminate
			if(!isRunning) {
				
				say("I didn't think it would be so easy to get out of here");
				String none=input.next();
				
				if(none.equals("no")) {
					say("I knew");
					isRunning=true;
				} else {
					say("so you want to finish talking, okay..\r\n");
				}
			
			} else {
			
				// is verb meaningful
				if(Arrays.asList(commands).contains(verb)) {					
					
					// call help
					if(verb.equals("help")) {
						say(help);
					}
					
					if(verb.equals("exits")) {
						say("Room : "+roomID);
						for (int j = 0; j < exitRooms[roomID].length; j++) {
							say(exits[roomID][j]+" - "+exitRooms[roomID][j]);
						}
					}
					
					// call inventory
					if(verb.equals("inventory")) {	
						if(inventoryCount<1) {
							say("I wasn't carrying anything");
						} else {
							System.out.println(Arrays.toString(inventory));
						}
						
					} 
			
					//look around
					if(verb.equals("look")) {
						say("I looked around. There were...");
				
						for(int i=0;i<itemLocations.length;i++) {
							if(itemLocations[i]==roomID) {
								say(" -" + items[i]);
							}
						}
					}
					
					if(verb.equals("hint")) {
						say("To get out of this room. You have to write..");
				
						dialogue.load("hint", roomID);
					}
					
					// call actions	
				} else if (Arrays.asList(verbs).contains(verb)) {
					
					
					// TAKE OBJECT
					if(entry.length>1||sequel) {
						
						if(sequel) {
							object=entry[0];
							sequel=false;
						} else {
							object=entry[1];
						}
						
						// is object an ->item<- or a direction
					if(Arrays.asList(items).contains(object)) {		
						
						// id assigned
						id=Arrays.asList(items).indexOf(object);
						
						//actionID=Arrays.asList(verbs).indexOf(verb);
								
						// can object accesible
						if(itemLocations[id]==roomID||itemLocations[id]==0) {	
							
							// object actions	
							
							if(verb.equals("examine")) {
								events.examine(object);
							} 
							
							if(verb.equals("take")) {
								newItemAcquired=events.itemAcquired(object);
								events.take(object);
							}
							
							if(verb.equals("open")) {
								events.open(object);
							}
							
							if(verb.equals("close")) {
								events.close(object);
							}
							
							if(verb.equals("use")) {
								events.use(object);
								
								if(roomID==3&&object.equals("flashlight")) {
									roomID=5;
									roomChanged=true;
								}
							}
							
							if(verb.equals("push")) {
								events.push(object);
							}
							
							if(verb.equals("move")) {						
								//error: move
								dialogue.error(verb);
								
							}
							
						} else {
							say("I had no "+object+ " in there!");	
						}
						
						
						// is object an item or a ->direction<-
					} else if(Arrays.asList(directions).contains(object)){
						
						// move to a location
						if(verb.equals("move")) {					
							
							
							
							//are there any exit in that direction
							//directionID = Arrays.asList(directions).indexOf(object);
							if(Arrays.asList(exits[roomID]).contains(object)) {
								
								switch (roomID) {
								
								case 1:	
									if(item("door").opened) {
										if(!arrived) {
											say(dialogue.dialogs[0][15]);
											roomID=2;	
											roomChanged=true;	
											arrived=true;
										} else {
											roomID=2;
											roomChanged=true;
										}
									}
									break;
								case 2:	
									
									if(object.equals(exits[roomID][0])) {
										if(item("elevator").opened) {
											roomID=6;
											roomChanged=true;
										}
										
									} else if(object.equals(exits[roomID][1])) {
										if(item("door").opened) {
											roomID=1;
											roomChanged=true;
										} 
										
									} else {
										if(item("flashlight").used) {
											if(item("blueDoor").opened) {
												roomID=5;
												roomChanged=true;
											}
										} else {
											if(item("blueDoor").opened) {
												roomID=3;
												roomChanged=true;
											} 
											
										}
									}
									break;	
									
								case 3:	
									if(item("blueDoor").opened) {
										roomID=2;	roomChanged=true;	
									}
									break;
								case 4:	
									
									if(object.equals(exits[roomID][0])) {
										if(item("elevator").opened) {
											roomID=6;
											roomChanged=true;
										}
									} else if(object.equals(exits[roomID][1])) {
										if(item("door").opened) {
											roomID=1;
											roomChanged=true;
										} 
									} else {
										if(item("flashlight").used) {
											if(item("blueDoor").opened) {
												roomID=5;
												roomChanged=true;
											} 
										} else {
											if(item("blueDoor").opened) {
												roomID=3;
												roomChanged=true;
											} 
										}
									}
									
									break;
									
								case 5:												
									if(item("blueDoor").opened) {
										roomID=2;
										roomChanged=true;
									} 	
									break;
									
								case 6:
									
									if(object.equals(exits[roomID][0])) {
										if(item("elevator").opened) {
											roomID=2;
											roomChanged=true;
										}
									} else {
										if(item("bigDoor").opened) {
											roomID=7;
											roomChanged=true;
										}
									}
									
									break;
									
								case 7:
									if(item("bigDoor").opened) {
										roomID=6;
										roomChanged=true;
									} 
									break;
									
								}
								
								if(roomChanged) {
									say("I went to "+object);
								} else {
									say("The door was closed");
								}
								
							} else {
								say("I couldn't move in that direction!");
							}
							
							
													//\\
												////DONT\\\\
											///////FORGET\\\\\\\
										//////////////\\\\\\\\\\\\\\
									////////////////VERY\\\\\\\\\\\\\\\\
								/////////////////IMPORTANT\\\\\\\\\\\\\\\\\\
							//////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\
							
						}
					}
					
					////////////////////////// ! Error Messages ! /////////////////////////
					else {
						//error: object
						say("I couldn't "+ verb +" this!");
					}
					
					} else {
						say(verb + " what?");
						sequel=true;
					}
				} else if(verb.equals("")){
					say("Sorry, I couldn't hear you.");
				} else {
					//error: verb
					say("I couldn't do that!");
				}
			}
			///////////////////////////////////////////////////////////////////////////////////
		} while(isRunning);
	}
}


/*if(objects.door.openAble) {
			objects.door.opened=true;
		}
		
			static String[][] specialities= {
	/*useAble/	{"cellphone"},
	/*openAble/	{"door","chest"},
	/*moveAble/	{"door"}
	};
		
		
		chestlere int deðerleri ver
		içindekilerin lokasyonu chestin deðerinin negatifi olsun
		chest açýlýrsa o lokasyon deðerine sahip 
		
		*/