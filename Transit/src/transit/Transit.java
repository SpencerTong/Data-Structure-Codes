package transit;

import java.util.ArrayList;

/**
 * This class contains methods which perform various operations on a layered linked
 * list to simulate transit
 * 
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class Transit {
	private TNode trainZero; // a reference to the zero node in the train layer

	/* 
	 * Default constructor used by the driver and Autolab. 
	 * DO NOT use in your code.
	 * DO NOT remove from this file
	 */ 
	public Transit() { trainZero = null; }

	/* 
	 * Default constructor used by the driver and Autolab. 
	 * DO NOT use in your code.
	 * DO NOT remove from this file
	 */
	public Transit(TNode tz) { trainZero = tz; }
	
	/*
	 * Getter method for trainZero
	 *
	 * DO NOT remove from this file.
	 */
	public TNode getTrainZero () {
		return trainZero;
	}

	/**
	 * Makes a layered linked list representing the given arrays of train stations, bus
	 * stops, and walking locations. Each layer begins with a location of 0, even though
	 * the arrays don't contain the value 0. Store the zero node in the train layer in
	 * the instance variable trainZero.
	 * 
	 * @param trainStations Int array listing all the train stations
	 * @param busStops Int array listing all the bus stops
	 * @param locations Int array listing all the walking locations (always increments by 1)
	 */
	public void makeList(int[] trainStations, int[] busStops, int[] locations) {


	
trainZero = new TNode();
TNode t = trainZero;
TNode b = new TNode();
TNode l = new TNode();

t.setDown(b);
b.setDown(l);
l.setDown(null);

int j = 0;
int x = 0;

for (int i = 0; i<trainStations.length; i++){
	TNode next = new TNode(trainStations[i]);
	t.setNext(next);
	t = t.getNext();
	
	while(b.getLocation()!=t.getLocation()){
		TNode next2 = new TNode(busStops[j]);
		b.setNext(next2);
		b=b.getNext();
		j++;

		while(l.getLocation()!=b.getLocation()){
			TNode next3 = new TNode(locations[x]);
			l.setNext(next3);
			l=l.getNext();
			x++;
		}
		b.setDown(l);
	}
	t.setDown(b);

}

while(j<busStops.length){
	TNode next2 = new TNode(busStops[j]);
		b.setNext(next2);
		b=b.getNext();
		j++;
	while(l.getLocation()!=b.getLocation()){
		TNode next3 = new TNode(locations[x]);
			l.setNext(next3);
			l=l.getNext();
			x++;
	}
	b.setDown(l);
}

while (x<locations.length){
	TNode next3 = new TNode(locations[x]);
	l.setNext(next3);
	l=l.getNext();
	x++;
}

	}
	

	/**
	 * Modifies the layered list to remove the given train station but NOT its associated
	 * bus stop or walking location. Do nothing if the train station doesn't exist
	 * 
	 * @param station The location of the train station to remove
	 */
	public void removeTrainStation(int station) {
		TNode w = trainZero;
		TNode r = trainZero.getNext();

		while (w.getNext()!=null){
			if (r.getLocation()==station){
				w.setNext(w.getNext().getNext());
				break;
			} else{
				w = w.getNext();
				r = w.getNext();
			}
		}
	}

	/**
	 * Modifies the layered list to add a new bus stop at the specified location. Do nothing
	 * if there is no corresponding walking location.
	 * 
	 * @param busStop The location of the bus stop to add
	 */
	public void addBusStop(int busStop) {
	    
			
			TNode b = trainZero.getDown();
			TNode bR = b.getNext();

			TNode w = b.getDown();

			
		while(bR.getLocation()<busStop&&bR.getNext()!=null){
				b=bR;
				bR=bR.getNext();
			}
		
			if(bR.getLocation()>busStop){
				TNode bS = new TNode(busStop);
				bS.setNext(bR);
				b.setNext(bS);
				while(w.getLocation()!=bS.getLocation()){
					w=w.getNext();
				}
				b=b.getNext();
				b.setDown(w);
			}

			if(bR.getNext()==null){
				TNode bS = new TNode(busStop);
				bR.setNext(bS);
				bR=bR.getNext();
				while(w.getLocation()!=bR.getLocation()){
					w=w.getNext();
				}
				bR.setDown(w);
			}





	}



	
	/**
	 * Determines the optimal path to get to a given destination in the walking layer, and 
	 * collects all the nodes which are visited in this path into an arraylist. 
	 * 
	 * @param destination An int representing the destination
	 * @return
	 */
	public ArrayList<TNode> bestPath(int destination) {
			ArrayList<TNode> path = new ArrayList<TNode>();

			TNode t = trainZero; 
      TNode tR = t.getNext(); 


      while(tR.getLocation()<destination){
        path.add(t);
        t=tR;
				if(tR.getNext()==null){
					break;
				}
        tR=tR.getNext();
      }

      if(tR.getLocation()==destination){
        path.add(t);
        t=tR;
        path.add(t);
        path.add(t.getDown());
        path.add(t.getDown().getDown());
      } else {
				path.add(t);
				TNode b = t.getDown();

				if (b.getNext()!=null){
					TNode bR = b.getNext();
					path.add(b);
					while(bR.getLocation()<destination){
						b=bR;
						path.add(b);
						if(bR.getNext()==null){
							break;
						}
						bR=bR.getNext();
					}

					if(bR.getLocation()==destination){
						b=bR;
						path.add(b);
						path.add(b.getDown());
					} else {
						TNode l = b.getDown();
						path.add(l);
						while(l.getLocation()!=destination){
							l=l.getNext();
							path.add(l);
						}
				}


        
    } else {
						path.add(b);
						TNode l = b.getDown();
						path.add(l);
						while(l.getLocation()!=destination){
						l=l.getNext();
						path.add(l);
		}
	}
	}
    return path;
  }

	/**
	 * Returns a deep copy of the given layered list, which contains exactly the same
	 * locations and connections, but every node is a NEW node.
	 * 
	 * @return A reference to the train zero node of a deep copy
	 */
	public TNode duplicate() {
			TNode t = trainZero;
			TNode head = new TNode(trainZero.getLocation());
			TNode r = head; 

			TNode b = new TNode();
			TNode bOriginal = trainZero.getDown();

			TNode l = new TNode();
			TNode lOriginal = trainZero.getDown().getDown();

			head.setDown(b);
			b.setDown(l);
			l.setDown(null);

			while (t.getNext()!=null){
				TNode tNew = new TNode(t.getNext().getLocation());
				r.setNext(tNew);
				r = r.getNext();

				while(b.getLocation()<r.getLocation()){
					TNode bNew = new TNode(bOriginal.getNext().getLocation());
					b.setNext(bNew);
					b = b.getNext();

					while(l.getLocation()<b.getLocation()){
						TNode lNew = new TNode(lOriginal.getNext().getLocation());
						l.setNext(lNew);
						l = l.getNext();
						lOriginal = lOriginal.getNext();
						
					}

					b.setDown(l);
					bOriginal = bOriginal.getNext();


				}

				r.setDown(b);
				t = t.getNext();

			}

			while(bOriginal.getNext()!=null){
				TNode bNew = new TNode(bOriginal.getNext().getLocation());
				b.setNext(bNew);
				b=b.getNext();

				while(l.getLocation()<b.getLocation()){
					TNode lNew = new TNode(lOriginal.getNext().getLocation());
					l.setNext(lNew);
					l = l.getNext();
					lOriginal = lOriginal.getNext();
				}

				b.setDown(l);
				bOriginal = bOriginal.getNext();

			}

			while(lOriginal.getNext()!=null){
				TNode lNew = new TNode(lOriginal.getNext().getLocation());
				l.setNext(lNew);
				l = l.getNext();
				lOriginal = lOriginal.getNext();
			}



	    return head;
	}

	/**
	 * Modifies the given layered list to add a scooter layer in between the bus and
	 * walking layer.
	 * 
	 * @param scooterStops An int array representing where the scooter stops are located
	 */
	public void addScooter(int[] scooterStops) {

		TNode t = trainZero;
 
		TNode b = t.getDown();
		TNode l = b.getDown();
		TNode lRunner = l;
		TNode sHead = new TNode();
		TNode sRunner = sHead;
	
	
	 	//assembles scooter layer connected to walking layer up to scooter max, not walking max 
		for(int i=0; i<scooterStops.length; i++){
			while(lRunner.getLocation()<sRunner.getLocation()){
				lRunner = lRunner.getNext();
			}
			sRunner.setDown(lRunner);
			TNode scooter = new TNode(scooterStops[i]);
			sRunner.setNext(scooter);
			sRunner = sRunner.getNext();
		}
	 //

	 //creates last down connection between scooter and walk
	 while(lRunner.getLocation()<sRunner.getLocation()){
		lRunner = lRunner.getNext();
	}
	sRunner.setDown(lRunner);
 //

		while (b!=null){
			while(sHead.getLocation()<b.getLocation()){
				sHead = sHead.getNext();
			}
			b.setDown(sHead);
			b = b.getNext();
		}
	
	}

	/**
	 * Used by the driver to display the layered linked list. 
	 * DO NOT edit.
	 */
	public void printList() {
		// Traverse the starts of the layers, then the layers within
		for (TNode vertPtr = trainZero; vertPtr != null; vertPtr = vertPtr.getDown()) {
			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				// Output the location, then prepare for the arrow to the next
				StdOut.print(horizPtr.getLocation());
				if (horizPtr.getNext() == null) break;
				
				// Spacing is determined by the numbers in the walking layer
				for (int i = horizPtr.getLocation()+1; i < horizPtr.getNext().getLocation(); i++) {
					StdOut.print("--");
					int numLen = String.valueOf(i).length();
					for (int j = 0; j < numLen; j++) StdOut.print("-");
				}
				StdOut.print("->");
			}

			// Prepare for vertical lines
			if (vertPtr.getDown() == null) break;
			StdOut.println();
			
			TNode downPtr = vertPtr.getDown();
			// Reset horizPtr, and output a | under each number
			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				while (downPtr.getLocation() < horizPtr.getLocation()) downPtr = downPtr.getNext();
				if (downPtr.getLocation() == horizPtr.getLocation() && horizPtr.getDown() == downPtr) StdOut.print("|");
				else StdOut.print(" ");
				int numLen = String.valueOf(horizPtr.getLocation()).length();
				for (int j = 0; j < numLen-1; j++) StdOut.print(" ");
				
				if (horizPtr.getNext() == null) break;
				
				for (int i = horizPtr.getLocation()+1; i <= horizPtr.getNext().getLocation(); i++) {
					StdOut.print("  ");

					if (i != horizPtr.getNext().getLocation()) {
						numLen = String.valueOf(i).length();
						for (int j = 0; j < numLen; j++) StdOut.print(" ");
					}
				}
			}
			StdOut.println();
		}
		StdOut.println();
	}
	
	/**
	 * Used by the driver to display best path. 
	 * DO NOT edit.
	 */
	public void printBestPath(int destination) {
		ArrayList<TNode> path = bestPath(destination);
		for (TNode vertPtr = trainZero; vertPtr != null; vertPtr = vertPtr.getDown()) {
			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				// ONLY print the number if this node is in the path, otherwise spaces
				if (path.contains(horizPtr)) StdOut.print(horizPtr.getLocation());
				else {
					int numLen = String.valueOf(horizPtr.getLocation()).length();
					for (int i = 0; i < numLen; i++) StdOut.print(" ");
				}
				if (horizPtr.getNext() == null) break;
				
				// ONLY print the edge if both ends are in the path, otherwise spaces
				String separator = (path.contains(horizPtr) && path.contains(horizPtr.getNext())) ? ">" : " ";
				for (int i = horizPtr.getLocation()+1; i < horizPtr.getNext().getLocation(); i++) {
					StdOut.print(separator + separator);
					
					int numLen = String.valueOf(i).length();
					for (int j = 0; j < numLen; j++) StdOut.print(separator);
				}

				StdOut.print(separator + separator);
			}
			
			if (vertPtr.getDown() == null) break;
			StdOut.println();

			for (TNode horizPtr = vertPtr; horizPtr != null; horizPtr = horizPtr.getNext()) {
				// ONLY print the vertical edge if both ends are in the path, otherwise space
				StdOut.print((path.contains(horizPtr) && path.contains(horizPtr.getDown())) ? "V" : " ");
				int numLen = String.valueOf(horizPtr.getLocation()).length();
				for (int j = 0; j < numLen-1; j++) StdOut.print(" ");
				
				if (horizPtr.getNext() == null) break;
				
				for (int i = horizPtr.getLocation()+1; i <= horizPtr.getNext().getLocation(); i++) {
					StdOut.print("  ");

					if (i != horizPtr.getNext().getLocation()) {
						numLen = String.valueOf(i).length();
						for (int j = 0; j < numLen; j++) StdOut.print(" ");
					}
				}
			}
			StdOut.println();
		}
		StdOut.println();
	}
}
