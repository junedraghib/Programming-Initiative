class Queue {

	protected int size;

	protected int front;
	protected int[] data;

	public Queue() {
		this.size = 0;
		this.front = 0;
		this.data = new int[5];
	}

	public Queue(int cap) {
		this.size = 0;
		this.front = 0;
		this.data = new int[cap];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length) {
			int[] oa = this.data;
			int[] na = new int[oa.length * 2];
			for (int i = 0; i < this.size(); i++) {
				int idx = (i + front) % oa.length;
				na[i] = oa[idx];
			}

			this.data = na;
			this.front = 0;
		}

		// if (this.size == this.data.length) {
		// throw new Exception("queue is full");
		// }

		this.data[(front + size) % this.data.length] = item;
		size++;

	}

	public int dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");

		}

		int rv = this.data[front];
		front = (front + 1) % this.data.length;
		size--;

		return rv;

	}

	public int getFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}

		int rv = this.data[front];

		return rv;
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			int idx = (i + front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
        System.out.print("END");
	}

	static Scanner scn = new Scanner(System.in);
    public static void hoodies(int q) throws Exception{ 
	    Queue pqueue = new Queue(100000);
	    Queue c1 = new Queue(50000);
	    Queue c2 = new Queue(50000);
	    Queue c3 = new Queue(50000);
	    Queue c4 = new Queue(50000);
	   // Scanner s = new Scanner(System.in);
	    while(q > 0){
	        char ch = scn.next().charAt(0);
	        if(ch == 'E'){
	            int x = scn.nextInt();
	            int y = scn.nextInt();
	            if(x == 1){
	                c1.enqueue(y);
	            } else if(x == 2){
	                c2.enqueue(y);
	            } else if(x== 3){
	                c3.enqueue(y);
	            } else {
	                c4.enqueue(y);
	            }
	            
	            pqueue.enqueue(x);
	            
	        } else if(ch == 'D') {
	            int front = pqueue.dequeue();
	            if(front == 1){
	                System.out.println(front+" "+c1.dequeue());
	            } else if(front == 2){
	                System.out.println(front+" "+c2.dequeue());
	            } else if(front == 3){
	                System.out.println(front+" "+c3.dequeue());
	            } else if(front == 4){
	                System.out.println(front+" "+c4.dequeue());
	            }
	        }
	    }


	
} 


	public static void main(String[] args) throws Exception {

        int n = scn.nextInt();
        
        hoodies(n);
	}

}
