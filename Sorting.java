public class Sortting{

  /*
   * Selection Sort:
   * Linear Move Time: O(n)
   * Quadratic Comparison Time: O(n^2)
   * Overall Time: O(n) + O(n^2) = O(n^2)
   */
  public static void selectionSort(int[] arr){
      for (int i = 0; i < arr.length - 1; i++) {
          swap(arr, i, findIndexMin(arr, i));
      }
  }

  /*
   * Merge Sort:
   * Logarithmic Move Time: O(nlog(n))
   * Logarithmic Comparison Time: O(nlog(n))
   * Overall Time: O(nlog(n)) + O(nlog(n)) = O(nlog(n))
   */
  public static void mergeSort(int[] arr){
      // just a wrapper with appropriate inputs for mSort
      // else, the recursive fcn would not work
      int[] temp = new int[arr.length];
      mSort(arr, temp, 0, arr.length - 1);
  }

  // Merge Sort Recursive Function
  private static void mSort(int[] arr, int[] temp, int start, int end){
      if (start <= end)
          return;
      else  {
          int middle = (start + end)/2;

          mSort(arr, temp, start, middle);
          mSort(arr, temp, middle + 1, end);

          merge(arr, temp, start, middle, middle + 1, end);
      }
  }

  // Merge Sort Helper Function, merges two sub arrays
  private static void merge(int[] arr, int[] temp, int leftStart,
    int leftEnd, int rightStart, int rightEnd){
      int i = leftStart;
      int j = rightStart;
      int k = leftStart;

      while (i <= leftEnd && j <= rightEnd) {
        if (arr[i] < arr[j]) {
            temp[k] = arr[i];
            i++; k++;
        } else{
            temp[k] = arr[j];
            j++; k++;
        }
      }
      while (i <= leftEnd){
          temp[k] = arr[i];
          i++; k++;
      }
      while (i <= rightEnd){
          temp[k] = arr[j];
          j++; k++;
      }
      for(i = leftStart; i <= rightEnd; i++) {
          arr[i] = temp[i];
      }
  }

  /*
   * Bubble Sort:
   * Quadratic Move Time: O(n^2)
   * Quadratic Comparison Time: O(n^2)
   * Overall Time: O(n^2) + O(n^2) = O(n^2)
   */
  public static void bubbleSort(int[] arr){
      for (int i = arr.length - 1; i > 0; i--){
          for (int j = 0; j < i; j++){
              if (arr[j] > arr[j + 1]){
                 swap(arr, j, j + 1);
              }
          }
      }
  }

  /*
   * Insertion Sort:
   * Quadratic Move Time: O(n^2)
   * Quadratic Comparison Time: O(n^2)
   * Overall Time: O(n^2) + O(n^2) = O(n^2)
   */
  public static void insertionSort(int[] arr){
      for (int i = 1; i < arr.length; i++){
          if (arr[i] < arr[i - 1]) {
            int toInsert = arr[i];

            int j = i;
            do {
                arr[j] = arr[j - 1];
                j--;
            } while (j > 0 && toInsert < arr[j - 1]);

            arr[j] = toInsert;
          }
      }
  }

  /*
   * Quick Sort:
   * Move Time: O(n^2)
   * Comparison Time: O(n)
   * Overall Time: O(n^2) + O(n^2) = O(n^2)
   */
  public static void quickSort(int[] arr){
      qSort(arr, 0, arr.length - 1);
  }

  // Quick Sort Helper Recursive Function
  private static void qSort(int[] arr, int first, int last){
    int split = partition(arr, first, last);

    if (first < split)
      qSort(arr, first, split); //left sub array
    if (last > split + 1)
      qSort(arr, split + 1, last); // right sub array
  }

  // Quick Sort helper function, partitions the array
  private static int partition(int[] arr, int first, int last){
      int pivot = arr[(first + last) / 2]; // middle element
      int i = first - 1; // index going left to right
      int j = last + 1; // index going right to left
      while (true) {
          do {
              i++;
          } while (arr[i] < pivot);
          do {
              j--;
          } while (arr[j] > pivot);
          if (i < j)
            swap(arr, i , j); // arr[j] = end of left array
          else
            return j;
      }
  }

  // another version of partition
  public static int partition2(int[] arr, int first, int last){
      int pivot = arr[(first + last) / 2]; // middle element
      int i = first; // index going left to right
      int j = last; // index going right to left
      while (true) {
           while (arr[i] < pivot) {
              i++;
          }
          while (arr[j] > pivot) {
              j--;
          }
          if (i < j)
            swap(arr, i , j); // arr[j] = end of left array
          else
            return j;
      }
  }

  //Helper Function, returns Index of min val from start
  private static int findIndexMin(int[] arr, int start){
    int indexMin = start;

    for(i = start + 1; i < arr.length; i++){
        if (arr[indexMin] > arr[i]){
            indexMin = i;
        }
    }

    return indexMin;
  }

  //Helper Function swaps elements at a and b in arr
  private static void swap(int[] arr, int a, int b){
      int temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
  }
  
  public static void bubbleSort(int[] array) {
    boolean sorted = false;
    int temp;
    while(!sorted) {
        sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                sorted = false;
            }
        }
    
	}
	}
	
	public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
        int min = array[i];
        int minId = i;
        for (int j = i+1; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                minId = j;
            }
        }
        // swapping
        int temp = array[i];
        array[i] = min;
        array[minId] = temp;
    }
}
	
	
}
