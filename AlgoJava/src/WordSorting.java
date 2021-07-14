
import java.util.ArrayList;
import java.util.Scanner;

public class WordSorting {
	//a�� 97 z�� a+25
	public static int partition(Word arr[], int left, int right) {
		Word pivot = arr[(left + right) / 2];
	
		while (left < right) {
			while ((arr[left].compareTo(pivot)<0) && (left < right))
				left++;
			while ((arr[right].compareTo(pivot)>0) && (left < right))
				right--;
	
			if (left < right) {
				Word temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
	
		return left;
	}

	public static void quickSort(Word arr[], int left, int right) {

		if (left < right) {
			int pivotNewIndex = partition(arr, left, right);

			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
		}
	}
	static class Word implements Comparable<Word>{
		String w="";
		int l=0;
		boolean del=false;
		Word(String w){
			this.w=w;
			l=w.length();
		}
		public int compareTo(Word that){
			if(del){
				return 0;
			}
			if(this.w.equals(that.w)){
				return 0;
			}
			else{
				if(this.l==that.l){
					for(int i=0;i<l;i++){
						if(this.w.charAt(i)==that.w.charAt(i)){
							continue;
						}
						return (this.w.charAt(i)>that.w.charAt(i))?1:-1;
					}
					return 0;
				}
				else{
					return (this.l>that.l)?1:-1;
				}
			}
		}
	}
	public static boolean has(ArrayList<Word> arr, Word w){
		for(Word i:arr){
			if(i!=null){
			if(w.compareTo(i)==0){
				return false;
			}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		ArrayList<Word> arrL = new ArrayList<Word>();
		for(int i=0;i<n;i++){
			Word w = new Word(sc.nextLine());
			if(!has(arrL,w)){
				continue;
			}
			arrL.add(w);
		}
		int s=arrL.size();
		Word[] arr = new Word[s];
		for(int i=0;i<s;i++){
			arr[i]=arrL.get(i);
		}
		quickSort(arr,0,arr.length-1);
		for(Word w:arr)
		{
			System.out.println(w.w);
		}
	}

}
