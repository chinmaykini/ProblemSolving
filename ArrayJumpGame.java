
public class ArrayJumpGame {

	public static int[] visited;

	public static void main(String[] args) {


		int[] array = new int[] { 1, 2, 0, 3, 2 };
		int index = 1;
		int len = array.length - 1;
		visited = new int[array.length];

		if (checkSolution(array, index, len)){
			System.out.println("Solution Present");
		} else {
			System.out.println("Solution NOT Present");
		}

		// print the visted array to check if your solution works
		StringBuilder show = new StringBuilder();
		for (int i : visited) {
			show.append(i + ",");
		}
		System.out.println(show.toString());
		System.out.println("Done");
	}

	private static boolean checkSolution(int[] array, int index, int len) {
		// TODO Auto-generated method stub

		if (index < 0 || index > len)
			return false;

		if (array[index] == 0)
			return true;

		if (visited[index] == 0) {
			
			// mark visted as true
			visited[index] = 1;
			// jump left and right
			if (checkSolution(array, index + array[index], len)
					|| checkSolution(array, index - array[index], len))
				return true;
		}
		return false;
	}

}
