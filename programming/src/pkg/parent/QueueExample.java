package pkg.parent;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		//peeking head when no element is present in queue
		
//	HEAD	------------
//		    ------------ TAIL For a queue, element gets inserted at tail and removed at head
		System.out.println(q.peek());
		
		q.add(1);
		q.add(4);
		q.add(2);
		System.out.println(q.element());
		//q.remove();
		
		
		System.out.println(q);
		
		//peeking the head value
		System.out.println(q.peek());
		
		//poll prints and removes head element
		int a = q.poll();
		System.out.println("Poll element " + a);
		
		System.out.println("Peeking after a poll to see new head "+q.peek());
		
//		q.poll();
//		q.poll();
//		
//		System.out.println("Check queue after emptying queue "+q.peek());
//		
//		boolean b = q.isEmpty();
//		System.out.println("Is the queue empty? "+ b);
		
		
		//LinkedList Implementation using Queue interface
		
		LinkedList<Integer>	ba = new LinkedList<Integer>();
		ba.addAll(q);
		System.out.println(ba); //Printing all the values in the Queue q collection using LinkedList
		

	}

}
