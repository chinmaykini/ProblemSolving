
public class RotatedSortedArray {

	public static void main(String[] args) {
	
		int[] arr = {9,10,11,12,13,14,1,2,3,4,5,6,7,8};

//		System.out.println(minInRotatedSortedArray(arr) + "");
		System.out.println(findPivot(arr) + "");
		System.out.println(searchInRotatedArray(arr, 12) + "");
		System.out.println(searchInRotatedArray(arr, 6) + "");
		System.out.println(searchInRotatedArray(arr, 1) + "");
		System.out.println(searchInRotatedArray(arr, 10) + "");
		System.out.println(searchInRotatedArray(arr, 15) + "");
		System.out.println(searchInRotatedArray(arr, 0) + "");


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
	
	public static int findPivot( int[] arr ){
		
		int left = 0;
		int right = arr.length -1;
		
		// Dont complicate things
		// rotated array have a property L > R, so keep doing things until thats not true
		while(arr[left]>arr[right]){
			
			int mid = left + (right - left) / 2;
			
			if(arr[mid] > arr[right]){
				// we are in the unsorted part
				left = mid + 1;
			}else{
				// we are in the sorted part
				right = mid;
			}
		}
		
		// as soon as while exits
		//arr[left] < arr[right], meaning left is pivot
		return arr[left];
	}

	public static int searchInRotatedArray( int[] arr , int num){
	
		int left = 0;
		int right = arr.length -1;
		
		// work with indexes here. less that equal. (equal to is the key)
		while(left <= right){
			int mid = left + (right - left) / 2;
			
			if(arr[mid] == num) return mid;
			
			// at any given point when u have mid, either the lower half is sorted or the upper half is sorted
			// look for number in which ever half its sorted, ekse u cant make judgement
			
			//less that equal. (equal to is the key, else for number not it array it will not exit)
			if(arr[left] <= arr[mid]){
				
				// lower half is sorted, check for number
				if(arr[left]<= num && num < arr[mid]){
					right = mid-1;
				
				} else{
					left = mid+1;
				}
			
			} else{
				// bottom half is sorted
				if(arr[mid]< num && num <= arr[right]){
					left = mid+1;
				
				} else{
					right = mid+1;
				}
			}
			
		}
		
		return -1;
	}
	
	
}
