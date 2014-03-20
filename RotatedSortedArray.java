
public class RotatedSortedArray {

	public static void main(String[] args) {
	
		int[] arr = {4,5,6,7,1,2,3};
//		int[] arr = {4,5,6,7,8,9,1};
		System.out.println(minInRotatedSortedArray(arr) + "");

	}

	
	public static int minInRotatedSortedArray( int[] arr ){

	    int len = arr.length;
	    
	    // edge case
	    if(len <= 1 ) return 0;
	    
	    int left = 0, end =0;
	    int right = len-1;
	    
	    // easier to visualise
	    // roated case arr[left] is greater than arr[right]
	    // stop when thats not the case and return arr[left]
	    while( arr[left]>arr[right]){
   
	        int mid = (left+right)/2;
	        if( arr[mid] > arr[end] ){
	        	 left = mid+1;
	        } else {
	           end = mid;
	        }	          
	    }
	    
	    // return left not mid
	    return arr[left];

	}
}
