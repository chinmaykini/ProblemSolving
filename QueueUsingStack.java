import java.util.Stack;


public class QueueUsingStack {
	
	static Stack<Integer> myStack = new Stack<Integer>();

	public static void enque(Integer num){

	    enqueuHelper(num);

	}

	public static void enqueuHelper(Integer num){

	    if(!myStack.isEmpty()){
	        Integer temp = myStack.pop();
	        enqueuHelper(num);
	        myStack.push(temp);
	    } else {
	        myStack.push(num);
	    }
	}

	// return the top of the stack or teh front on teh queue
	// if empty return null
	public static Integer dequeue()
	{
	    if(!myStack.isEmpty())
	        return myStack.pop();
	        
	    return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		enque(1);
		enque(3);
		enque(2);
		enque(4);
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		
	}

}
