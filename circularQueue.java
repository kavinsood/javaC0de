import java.util.*;

public class circularQueue {
	int size;
	int[] arr;
	int r, f;
	int c;

	circularQueue(int size) {
		f = -1;
		r = -1;
		c = 0;
		this.size = size;
		arr = new int[this.size];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter max size: ");
		circularQueue cq = new circularQueue(sc.nextInt());
		System.out.println("Enter number of elements you want to enter: ");
		cq.c = sc.nextInt();
		for (int i = 0; i < cq.c; i++) {
			cq.arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(cq.arr));
		System.out.println("Popping one element");
		System.out.println(cq.pop());
		System.out.println("Enter element to push: ");
		int e = sc.nextInt();
		sc.close();
		cq.push(e);
		System.out.println(Arrays.toString(cq.arr));
	}

	int pop() {
		if (isEmpty())
			System.out.println(Integer.MIN_VALUE);
		f %= c;
		return arr[++f];
	}

	void push(int n) {
		if (isFull())
			System.out.println(Integer.MAX_VALUE);
		r = (r + 1) % arr.length;
		arr[r] = n;
		c++;
		if (f == -1)
			f = r;
	}

	boolean isEmpty() {
		return (c == 0);
	}

	boolean isFull() {
		return (c == arr.length);
	}
}
