import java.util.Arrays;

public class dialogue {
	
	public static void load(String verb, String object){
		
		//Boolean isChanged=false;
		
		if(Arrays.asList(project.verbs).contains(verb)){
			
			int row		= Arrays.asList(project.items).indexOf(object);
			int column	= Arrays.asList(project.verbs).indexOf(verb);
			
			//isChanged=events.isChanged(row, column);
			
			//if(!isChanged) {
				project.say(dialogue.dialogs[row][column]);
			//} else {
				// so there will be (verb+1)*object*length dialogs
			//	project.say(dialogue.dialogs[row][column+project.verbs.length]);
			//}
			
			
		} else {
			project.say("I think there is some kind of misunderstanding...");
		}
	}
	
	//verbs without objects = commands
		public static void load(String command,int roomID) {
			if (Arrays.asList(project.commands).contains(command)) {
				
				//int column	= Arrays.asList(project.commands).indexOf(command);
				
				if(command.equals("help")) {
					project.say(dialogue.dialogs[0][0]);		
				}
				
				//different from verb-look
				if(command.equals("look")) {
					project.say(dialogue.dialogs[0][roomID]);		
				}
				
				if(command.equals("hint")) {
					project.say(dialogue.dialogs[0][roomID+project.roomCount]);		
				}
				
			}
		}	
	
	//verb error messages
	public static void error() {
		project.say("I couldn't do that!");
	}
	
	//object error messages
		public static void error(String verb) {
			if(verb.equals("move")) {
				project.say("I couldn't "+verb+" there!");
			} else if(verb.equals("examine")){
				project.say("I couldn't "+verb+" that!");
			} else {
				project.say("I couldn't "+verb+" that!");
			}
		}
	
	static String[][] dialogs= {
			
			// Room Descriptions	/	help	/	hints	//
			{								
				"When I open my eyes, I was in a depot. I tried to remember how did I came there."
				+ "\nI must have received a really bad blow to my head. When I regain my consciousness slowly,"
				+ "\nI wipe the blood on my face, I immediately stood up and started looking for a way "
				+ "\nto get out of this depot as soon as possible to stop him."
				+ "\n(type \"help\" for help)\n",	// id:0
				
				"I was in a locked, dark and small depot. there were a few crates and a locker."
				+ "\nOn the floor, there was a uniform that must have been dropped by an employee "
				+ "\nwhen everybody is running away. I had to find a way to open the locked door in the east.\n",	// move id:1
				
				"This long corridor seemed to collapse and I should have been quick.\n",	// id:2
				
				"I couldn't see anything. I needed to illuminate the room in some way."
				+ "\nIt was impossible to rectify a malfunction in this darkness.\n",	// id:3
				
				"This long corridor seemed to collapse and I should have been quick.\n",	// id:4
				
				"As I expected, it was a room with lots of electric panels. "
				+ "\nI was familiar with more or less about these things. "
				+ "\nApparently, it would be enough to change the cable I determined.\n",	// id:5
				
				"Seriously, it was a miracle I got out of the elevator alive. "
				+ "\nAnyway, I was in a long corridor stretching towards my left. "
				+ "\nThere was a bigDoor in the west and I knew he was there"
				+ "\nThere were a few security officers on the ground. "
				+ "\nI checked eye dilation and pulse of them but I was too late. "
				+ "\nI still could not understand why he did these, but I knew he'd pay for it.\n",	// id:6
				
				"I was realized his purpose. I thought he was joking when we talked about that."
				+ "\nHis aim was to steal the experimental virus samples that the company secretly hid, "
				+ "\nwhich he had already stolen. He was packing up his bag. He had put his gun on floor. "
				+ "\nIf I won't neutralize him now, I might never be had a chance.",	// id:7
				
				"open metalCrate, take metalBar, open uniform, "
				+ "\ntake keyCard, use metalBar, open locker,"
				+ "\ntake flashlight",	// id:8
				
				"under construction",
				
				"under construction", 
				
				"under construction", 
				
				"under construction", 
				
				"under construction", 
				
				"under construction", 
				
				"I was in a long corridor. There were broken pieces all around of this corridor. "
				+ "\nThe explosion should have been here or upstairs. I knew where he was going. "
				+ "\nThe explosion was close to the stairs and it was impossible to get out of the stairs."
				+ "\nFortunately, the elevator was not damaged. I guess, because of the explosion, "
				+ "\nthere was no electricity. I should straighten out the fault from the electrical "
				+ "\npanel room passing through the blue door in the north. and get up to the top of"
				+ "\nthe building with elevator at the south of this room.\n"		// id:15???
			},						
			
///////////////////////////////////////////////// Object Event Dialogs ////////////////////////////////////////////////////
			
			// Object: depot
			{		
				
				"The depot was very dark and small. Because of my anger, I have never had any"
				+ "\ntrouble despite I am claustrophobic, .", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"", //Changed take
				"", //Changed open
				"", //Changed close
				"", //Changed use
				"", //Changed move
				"", //Changed push
				
			},
			
			// Object: metalCrate
			{		
				
				"It was not a big crate like the others. I thought, In the explosion"
				+ "\nthe lock broken because of falling from high.", //examine
				"", //take
				"I was disappointed to see only thin metal bars in that but "
				+ "\nI should have thought something, time was running out.", //open
				"I closed the cover tightly.", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"Door Has been opened", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			// Object: crates
			{		
				
				"all the crates are locked, except those metal one.", //examine
				"", //take
				"I thought I should try to open metalCrate.", //open
				"They were already closed", //close
				"", //use
				"", //move
				"", //push
				
				"", //Changed examine
				"", //Changed take
				"", //Changed open
				"", //Changed close
				"", //Changed use
				"", //Changed move
				"", //Changed push
				
			},
			
			// Object: door	1
			{		
				
				"It was the doors that opened with cards. I had to find a way to open it.", //examine
				"", //take
				"I could finally come out of that disgusting place.", //open
				"I closed the door because I didn't want him to know that I exited from depot.", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"I couldn't open that! It was locked. I should have to used something to open it.", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			// Object: keyCard
			{		
				
				"I think that key can open door.", //examine
				"I hoped that this card's owner has been exit from this hell alive.", //take
				"", //open
				"", //close
				"I tried the card key with the door to the east. "
				+ "\nThe door unlocked by making a thin noise.", //use
				"", //move
				"",
				
				
				"loremIpsumDolorSitAmet.", //Changed examine
				"I took the key.", //Changed take
				"loremIpsumDolorSitAmet.", //Changed open
				"loremIpsumDolorSitAmet.", //Changed close
				"loremIpsumDolorSitAmet.", //Changed use
				"loremIpsumDolorSitAmet.", //Changed move
				
			},
			
			
			// Object: locker
			{		
				
				"I guess it was the closets of the employees", //examine
				"", //take
				"In the closet, the only thing that would be useful was a flashlight.", //open
				"Then I closed it. It was locked", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"an old lock was preventing to open it.", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: metalBar
			{		
				
				"It was a thin piece of metal. I thought I could use it.", //examine
				"Who knows, maybe it was a blessing", //take
				"", //open
				"", //close
				"This idea did not come to my mind at first. "
				+ "\nI could pick the old lock of the locker with that metal bar.", //use
				"", //move
				"", //push
				"",
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			// Object: uniform
			{		
				
				"This should be an employee's. I think its owner couldn't even get a jacket in a hurry."
				+ "\nI thought, maybe if I open the inside of it I could find something useful.", //examine
				"", //take
				"I found a keyCard inside. Finally, the exit way has been seen.", //open
				"Then I put the uniform on the edge.", //close
				"", //use
				"", //move
				"", //push
				"",
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			// Object: flashlight
			{		
				
				"I might have to use it in the dark.", //examine
				"That was nice, it was working.", //take
				"", //open
				"", //close
				"Now I could see even if it was too dark.", //use
				"", //move
				"", //push
				"",
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: door	2
			{		
				
				"a door", //examine
				"", //take
				"door opened", //open
				"door closed", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},


			// Object: door	4
			{		
				
				"a door", //examine
				"", //take
				"door opened", //open
				"door closed", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: corridor1	2
			{		
				
				"a long corridor", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: corridor1	4
			{		
				
				"a corridor", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: elevator	2
			{		
				
				"an elevator", //examine
				"", //take
				"elevator opened", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: elevator	4
			{		
				
				"an elevator", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: elevator	6
			{		
				
				"an elevator", //examine
				"", //take
				"elevator opened", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: blueDoor	2
			{		
				
				"electric panel room door", //examine
				"", //take
				"door opened", //open
				"door closed", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: blueDoor	4
			{		
				
				"", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: blueDoor	3
			{		
				
				"electric panel room door", //examine
				"", //take
				"opened", //open
				"closed", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: blueDoor	5
			{		
				
				"a door", //examine
				"", //take
				"opened", //open
				"closed", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: panel room
			{		
				
				"panel room", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: panels
			{		
				
				"panels. I should open and use the cable", //examine
				"", //take
				"opened", //open
				"closed", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			// Object: cable
			{		
				
				"a cable", //examine
				"now I could use it", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: carridor2	6
			{		
				
				"corridor", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"loremIpsumDolorSitAmet", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: security guards
			{		
				
				"They were dead. a pistol and a card were near them", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"loremIpsumDolorSitAmet", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: pistol
			{		
				
				"a pistol", //examine
				"I took it", //take
				"", //open
				"", //close
				"\"BANG\"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: entrance Card
			{		
				
				"", //examine
				"", //take
				"", //open
				"", //close
				"laboratory door has been opened", //use
				"", //move
				"loremIpsumDolorSitAmet", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: bigDoor	6
			{		
				
				"laboratory door", //examine
				"", //take
				"opened", //open
				"closed", //close
				"", //use
				"", //move
				"", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: bigDoor	7
			{		
				
				"door", //examine
				"", //take
				"opened", //open
				"", //close
				"", //use
				"", //move
				"loremIpsumDolorSitAmet", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			// Object: laboratory
			{		
				
				"big laboratory", //examine
				"", //take
				"", //open
				"", //close
				"", //use
				"", //move
				"loremIpsumDolorSitAmet", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			
			/*	"loremIpsumDolorSitAmet", //verb
			
			// Object: NameNameName
			{		
				
				"loremIpsumDolorSitAmet", //examine
				"loremIpsumDolorSitAmet", //take
				"loremIpsumDolorSitAmet", //open
				"loremIpsumDolorSitAmet", //close
				"loremIpsumDolorSitAmet", //use
				"loremIpsumDolorSitAmet", //move
				"loremIpsumDolorSitAmet", //push
				
				"loremIpsumDolorSitAmet", //Changed examine
				"loremIpsumDolorSitAmet", //Changed take
				"loremIpsumDolorSitAmet", //Changed open
				"loremIpsumDolorSitAmet", //Changed close
				"loremIpsumDolorSitAmet", //Changed use
				"loremIpsumDolorSitAmet", //Changed move
				"loremIpsumDolorSitAmet", //Changed push
				
			},
			
			//*/
			
			
			//
			/*
			// Object: NameNameName
			{		
				
				"That is loremIpsumDolorSitAmet.", //examine
				"You took loremIpsumDolorSitAmet.", //take
				"loremIpsumDolorSitAmet has been opened.", //open
				"loremIpsumDolorSitAmet has been closed.", //close
				"You used loremIpsumDolorSitAmet.", //use
				"You went loremIpsumDolorSitAmet.", //move
				
				
				"That is loremIpsumDolorSitAmet.", //Changed examine
				"You took loremIpsumDolorSitAmet.", //Changed take
				"loremIpsumDolorSitAmet has been opened.", //Changed open
				"loremIpsumDolorSitAmet has been closed.", //Changed close
				"You used loremIpsumDolorSitAmet.", //Changed use
				"You went loremIpsumDolorSitAmet.", //Changed move
				
			},
			//*/
			
						
		};

}
