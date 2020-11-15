public class Sort {
    int x = 0;
    int y = 0;
    void SelectionSort(int[] arr) {
        int n = arr.length;
        x = 0;
        y = 0;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
                x++;
            }
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            y++;
        }
    }



    // Prints the array
    void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }


    void InsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    // Java program for implementation of QuickSort


        /* This function takes last element as pivot,
           places the pivot element at its correct
           position in sorted array, and places all
           smaller (smaller than pivot) to left of
           pivot and all greater elements to right
           of pivot */

        int partition(int arr[], int low, int high)
        {
            int pivot = arr[high];
            int i = (low-1); // index of smaller element
            for (int j=low; j<high; j++)
            {
                // If current element is smaller than the pivot
                if (arr[j] < pivot)
                {
                    i++;

                    // swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // swap arr[i+1] and arr[high] (or pivot)
            int temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;

            return i+1;
        }



        /* The main function that implements QuickSort()
          arr[] --> Array to be sorted,
          low  --> Starting index,
          high  --> Ending index */
        void QuickSort(int arr[], int low, int high)
        {
            if (low < high)
            {
            /* pi is partitioning index, arr[pi] is
              now at right place */
                int pi = partition(arr, low, high);

                // Recursively sort elements before
                // partition and after partition
                QuickSort(arr, low, pi-1);
                QuickSort(arr, pi+1, high);
            }
        }

        /* A utility function to print array of size n */



    /*This code is contributed by Rajat Mishra */


    static class heapSort {

        heapSort(int[] arr, int size, int i) {

            int largest = i;
            int left = 2*i + 1;
            int right = 2*i +2;
            int temp;

            if (left < size && arr[left] > arr [largest]) {

                largest = left;

            }

            if (right < size && arr[right] > arr[largest]) {

                largest = right;

            }

            if (largest != i) {

                temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                new heapSort(arr, size, largest);


            }

        }

        static void heapSort(int[] arr, int size)
        {
            int i;
            int temp;
            for (i = size / 2 - 1; i >= 0; i--) {
                new heapSort(arr, size, i);
            }

            for (i=size-1; i>=0; i--)
            {
                temp = arr[0];
                arr[0]= arr[i];
                arr[i] = temp;
                new heapSort(arr, i, 0);
            }
        }

    }

}
