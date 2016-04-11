package core.module5.Module52;

/**
 * Created by corner on 24.12.2015.
 */
public class ArraySort {

    public static String Sort(int[] arr) {
        SortType sortType = SortType.getRandom();
        Sort(arr, sortType);
        return sortType.name();
    }

    public static void Sort(int[] arr, SortType sortType) {
        switch (sortType) {
            case BUBBLE:
                sortBubble(arr);
                break;
            case SELECTION:
                sortSelection(arr);
                break;
            case INSERTION:
                sortInsertion(arr);
                break;
            case HEAP:
                sortHeap(arr);
                break;
            case MERGE:
                sortMerge(arr);
                break;
            case QUICKSORT:
                sortQuickSort(arr);
                break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    //---------------------------------------------------------------

    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //---------------------------------------------------------------

    private static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
            swap(arr, i, index);
        }
    }

    //---------------------------------------------------------------

    private static void sortInsertion(int[] arr) {

        for (int i = 1; i < arr.length; i++)    // Start with 1 (not 0)
        {
            int swap = arr[i];
            int j;
            for (j = i - 1; (j >= 0) && (arr[j] > swap); j--)   // Smaller values are moving up
            {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = swap;
        }
    }

    //---------------------------------------------------------------

    private static int n_heap;

    private static void maxheap(int arr[], int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= n_heap && arr[left] > arr[i])
            max = left;
        if (right <= n_heap && arr[right] > arr[max])
            max = right;

        if (max != i) {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    private static void sortHeap(int[] arr) {
        n_heap = arr.length - 1;

        for (int i = n_heap / 2; i >= 0; i--)
            maxheap(arr, i);

        for (int i = n_heap; i > 0; i--) {
            swap(arr, 0, i);
            n_heap--;
            maxheap(arr, 0);
        }

    }

    //---------------------------------------------------------------

    private static void sortMerge(int[] arr) {
        startMergeSort(0, arr.length - 1, arr);
    }

    private static void startMergeSort(int fromIndex, int toIndex, int[] arr) {

        if (fromIndex < toIndex) {
            int middle = fromIndex + (toIndex - fromIndex) / 2;
            startMergeSort(fromIndex, middle, arr);
            startMergeSort(middle + 1, toIndex, arr);
            mergeFromTo(fromIndex, middle, toIndex, arr);
        }
    }

    private static void mergeFromTo(int fromIndex, int middle, int toIndex, int[] arr) {

        int[] tempArr = new int[arr.length];

        for (int i = fromIndex; i <= toIndex; i++) {
            tempArr[i] = arr[i];
        }
        int i = fromIndex;
        int j = middle + 1;
        int k = fromIndex;
        while (i <= middle && j <= toIndex) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = tempArr[i];
            k++;
            i++;
        }

    }

    //---------------------------------------------------------------

    private static void sortQuickSort(int[] arr) {
        startQuickSort(0, arr.length - 1, arr);
    }

    private static void startQuickSort(int fromIndex, int toIndex, int[] arr) {
        int i = fromIndex, j = toIndex;
        int element = arr[fromIndex + (toIndex - fromIndex) / 2];

        while (i <= j) {
            while (arr[i] < element) {
                i++;
            }
            while (arr[j] > element) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (fromIndex < j)
            startQuickSort(fromIndex, j, arr);
        if (i < toIndex)
            startQuickSort(i, toIndex, arr);
    }


}
