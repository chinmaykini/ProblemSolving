import java.util.Collections;
import java.util.PriorityQueue;


public class TaskAssignToServers {
	public static String serverLine = "8 16 8 32";
	public static String taskLine = "4 3 7 2 2 6 8 10";
//	public static String taskLine = "18 4 8 4 6 6 8 8";	// This case doesnt work with greedy approach

	public static void main(String[] args) throws Exception{
		
		System.out.println(canTaskBatchBeProcessed(taskLine,serverLine));
       		
	}

	private static boolean canTaskBatchBeProcessed(String taskLine, String serverLine) {
		
		PriorityQueue<Integer> serverQ = reversePriorityQ(serverLine);
		PriorityQueue<Integer> taskQ = reversePriorityQ(taskLine);
		
		while(!taskQ.isEmpty()){
			Integer currentTask = taskQ.poll();
			
			// no valid server available
			if(serverQ.peek()<currentTask) return false;
			
			// if server avialable
			// remove the server place the task, update the server and add it back to Queue
			Integer currentServer = serverQ.poll();
			currentServer = currentServer - currentTask;
			serverQ.add(currentServer);
		}
		
		return true;
	}
	
	
	public static PriorityQueue<Integer> reversePriorityQ(String taskLine){
		String[] tasks = taskLine.split(" ");
		PriorityQueue<Integer> taskQ = new PriorityQueue<Integer>(tasks.length, Collections.reverseOrder());
		for(String task : tasks){
			taskQ.add(Integer.parseInt(task));
		}
		
		return taskQ;
	}
	
}
