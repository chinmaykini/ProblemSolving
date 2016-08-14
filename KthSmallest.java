
public class KthSmallest {

	public static void main(String[] args) {

		int[] arr = {1,5,2,7,4,7,9,3,23,5};
		
//		1,2,3,4,5,5,7,7,9,23,
//		swap(arr,5,8);

		
//		System.out.println(partition(arr,0,9));
//		quickSort(arr, 0, 9);
		System.out.println(kthSmallest(arr,0,9,3));
//		System.out.println(kthSmallest(arr,0,9,4));
//		System.out.println(kthSmallest(arr,0,9,15));
//		System.out.println(kthSmallest(arr,0,9,3));
//		for(int i : arr){
//			System.out.print(i + ",");
//		}

	}
	

	
	public static int randomizedPivotPartion(int[] arr, int p, int q){
		
		int randomNum = (int) Math.round(p + Math.random() * (q-p));
		swap(arr, randomNum, q);
		return partition(arr, p, q);
	}
	
	public static int partition(int[] arr, int p, int q) {
		
		// make last element as pivot
		int pivot = arr[q];
		int i = p-1;		
		
		for(int j = p; j< q; j++){
		
			if(arr[j]<=pivot){
				swap(arr,++i,j);
			}
		}
		
		// swap the pivot at it right location
		swap(arr, i+1, q);
		return i+1;
	}

	public static void swap(int[] arr, int p, int q) {
		int temp = arr[p];
		arr[p] = arr[q];
		arr[q] = temp;
	}

	public static int kthSmallest(int[] arr, int p, int q, int k){
		
		if(p<q){
			
			int pivot = partition(arr, p, q);
			
			int n = pivot - p + 1;
			
			if(k == n){
			
				return arr[pivot];
			}else if(k>n){
				
				return kthSmallest(arr,pivot+1,q,k-n);
			}else{
				
				return kthSmallest(arr,p,pivot-1,k);
			}
		}
		
		return -1;
	}
	
	public static void quickSort(int[] arr, int p, int q){
		
		if(p<q){
			int pivot = partition(arr,p,q);
			quickSort(arr, p, pivot-1);
			quickSort(arr, pivot+1, q);
		}
		return;
	}

}
