package pkg.parent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;

public class ArrayDequeExample {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		//Deque<ArrayList> d1q = new ArrayDeque<ArrayList>();

		dq.add(0);
		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.add(4);
		dq.add(5);
		dq.add(6);

		System.out.println("First print "+dq);

		dq.clear();


		System.out.println("Elements after clear "+dq);

		dq.add(0);
		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.add(4);
		dq.add(5);
		dq.add(6);
		System.out.println("Second print "+dq);

		dq.removeFirst();
		dq.removeLast();


		System.out.println("Print after removing first and last element:"+dq);

		dq.addFirst(0);
		dq.addLast(6);

		System.out.println("Print after adding first and last element:"+dq);

		int a = dq.pop();
		System.out.println(a);
		int b = dq.poll();
		System.out.println(b);

		System.out.println("Print the queue after pop and poll "+ dq);
		int c = dq.pollFirst();
		int d = dq.pollLast();

		System.out.println("poll first " + c + " poll last "+ d);

		System.out.println("Print after poll first & last"+dq);

		System.out.println("Peek " + dq.peek());
		System.out.println("Peek First " + dq.peekFirst());
		System.out.println("Peek Last " + dq.peekLast());

		//or
		System.out.println("See the head element " + dq.element());
		System.out.println("see First element using get " + dq.getFirst());
		System.out.println("see Last element using get " + dq.getLast());

		System.out.println("Print the queue to check all the elements are still there "+ dq);
		System.out.println("Size of the deque "+ dq.size());
		Object s = dq.toArray();
		System.out.println("Print after toString method "+ s);

		dq.push(200);
		System.out.println(dq);

	}

}
