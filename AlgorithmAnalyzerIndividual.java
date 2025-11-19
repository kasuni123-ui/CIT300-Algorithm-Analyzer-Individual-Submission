import java.util.Arrays;
import java.util.Random;

public class AlgorithmAnalyzerIndividual {
    
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == key) {
                return mid;
            }
            
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    public static int[] generateRandomArray(int size) {
        Random random = new Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }
    
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    public static void testLinearSearch() {
        int[] sizes = {100, 500, 1000};
        
        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            int key = arr[size / 2];
            
            long startTime = System.nanoTime();
            linearSearch(arr, key);
            long endTime = System.nanoTime();
            
            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-10d | %-10.6f\n", size, timeMs);
        }
        System.out.println();
    }
    
    public static void testBinarySearch() {
        int[] sizes = {100, 500, 1000};
        
        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            Arrays.sort(arr);
            int key = arr[size / 2];
            
            long startTime = System.nanoTime();
            binarySearch(arr, key);
            long endTime = System.nanoTime();
            
            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-10d | %-10.6f\n", size, timeMs);
        }
        System.out.println();
    }
    
    public static void testBubbleSort() {
        int[] sizes = {100, 500, 1000};
        
        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            int[] arrCopy = copyArray(arr);
            
            long startTime = System.nanoTime();
            bubbleSort(arrCopy);
            long endTime = System.nanoTime();
            
            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-10d | %-10.6f\n", size, timeMs);
        }
        System.out.println();
    }
    
    public static void testQuickSort() {
        int[] sizes = {100, 500, 1000};
        
        System.out.println("Algorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            int[] arrCopy = copyArray(arr);
            
            long startTime = System.nanoTime();
            quickSort(arrCopy);
            long endTime = System.nanoTime();
            
            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-10d | %-10.6f\n", size, timeMs);
        }
        System.out.println();
    }
    
    public static void verifyAlgorithms() {
        System.out.println("ALGORITHM VERIFICATION");
        System.out.println("======================");
        
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        int[] sortedArray = copyArray(testArray);
        Arrays.sort(sortedArray);
        
        int searchKey = 22;
        int linearResult = linearSearch(testArray, searchKey);
        System.out.println("Linear Search for " + searchKey + ": " + 
                          (linearResult != -1 ? "Found at index " + linearResult : "Not found"));
        
        int binaryResult = binarySearch(sortedArray, searchKey);
        System.out.println("Binary Search for " + searchKey + ": " + 
                          (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));
        
        int[] bubbleArray = copyArray(testArray);
        bubbleSort(bubbleArray);
        System.out.println("Bubble Sort result matches expected: " + 
                          Arrays.equals(bubbleArray, sortedArray));
        
        int[] quickArray = copyArray(testArray);
        quickSort(quickArray);
        System.out.println("Quick Sort result matches expected: " + 
                          Arrays.equals(quickArray, sortedArray));
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("CIT300 Individual Algorithm Analyzer");
        System.out.println("====================================");
        System.out.println("Completed individually with all 4 algorithms\n");
        
        verifyAlgorithms();
        
        testLinearSearch();
        testBinarySearch();
        testBubbleSort();
        testQuickSort();
        
        System.out.println("All algorithms tested successfully!");
    }
}