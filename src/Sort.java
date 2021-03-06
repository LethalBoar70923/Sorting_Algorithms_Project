public class Sort {
    int mutation = 0;
    int comparison = 0;

    void SelectionSort(int[] arr) {
        int ArraySize = arr.length;
        comparison = 0;
        mutation = 0;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < ArraySize - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < ArraySize; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
                comparison++;

            }
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            mutation++;
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
        comparison = 0;
        mutation = 0;
        int ArrayLength = arr.length;
        for (int i = 0; i < ArrayLength - 1; i++) {
            for (int j = 0; j < ArrayLength - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    comparison++;
                }

            }
            mutation++;

        }
    }


    void InsertionSort(int[] arr) {
        comparison = 0;
        mutation = 0;
        int ArrayLength = arr.length;
        for (int i = 1; i < ArrayLength; i++) {
            int key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                comparison++;
                mutation++;
            }
            arr[j + 1] = key;
            comparison++;
        }
    }

    // Java program for implementation of QuickSort


        /* This function takes last element as pivot,
           places the pivot element at its correct
           position in sorted array, and places all
           smaller (smaller than pivot) to left of
           pivot and all greater elements to right
           of pivot */

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void QuickSort(int[] arr, int low, int high) {
        mutation++;
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
            comparison++;
            // Recursively sort elements before
            // partition and after partition
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    void heapSort(int[] arr, int size, int i) {
        mutation++;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int temp;

        if (left < size && arr[left] > arr[largest]) {

            largest = left;
            comparison++;
        }

        if (right < size && arr[right] > arr[largest]) {

            largest = right;
            comparison++;
        }

        if (largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapSort(arr, size, largest);
            comparison++;
        }


    }

    void heapSort(int[] arr, int size) {

        int i;
        int temp;
        for (i = size / 2 - 1; i >= 0; i--) {

            heapSort(arr, size, i);
        }
        for (i = size - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, i, 0);
        }

    }


    void ShellSort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
    }


}
