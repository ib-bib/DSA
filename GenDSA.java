public class GenDSA {

    public int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }

    public void hanoi(int discs) {
        hanoi(discs, 1, 3);
    }

    private void hanoi(int discs, int start, int end) {
        if (discs == 1) {
            pm(start, end);
        } else {
            int auxRod = 6 - (start + end);
            hanoi(discs - 1, start, auxRod);
            pm(start, end);
            hanoi(discs - 1, auxRod, end);
        }
    }

    private void pm(int start, int end) {
        System.out.println(start + " -> " + end + "\n");
    }

    public boolean isPalindrome(String x) {
        if (x.length() == 0 || x.length() == 1) {
            return true;
        }
        if (x.charAt(0) == x.charAt(x.length() - 1)) {
            return isPalindrome(x.substring(1, x.length() - 1));
        }
        return false;
    }

    public String decToBinary(int dec) {
        return convertB(dec, "");
    }
    private String convertB(int dec, String result) {
        if (dec == 0) {
            return result;
        }
        result = dec % 2 + result;
        return convertB(dec / 2, result);
    }

    public String A() {
        return "hello " + B();
    }
    private String B() {
        return "my " + C();
    }
    private String C() {
        return "friends";
    }

    public String reverseString(String x) {
        if (x.equals("")) {
            return x;
        }
        return reverseString(x.substring(1)) + x.charAt(0);
    }

    public int sum(int n) {
        return n * (n+1) / 2;
    }

    public int recursiveSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }

    public int gridPaths(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        return gridPaths(n - 1, m) + gridPaths(n, m - 1);
    }

    public int partitions(int a, int b) {
        if (a == 0) {
            return 1;
        }
        if (b == 0 || a < 0) {
            return 0;
        }
        return partitions(a - b, b) + partitions(a, b - 1);
    }

    public boolean linearSearch(int [] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean recursiveLinearSearch(int [] a, int x) {
        return recursiveLinearSearch(a, x, 0);
    }
    private boolean recursiveLinearSearch(int [] a, int x, int i) {
        if (i == a.length) {
            return false;
        }
        if (a[i] == x) {
            return true;
        }
        return recursiveLinearSearch(a, x, i + 1);
    }

    public void binarySearch(int [] a, int x) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == x) {
                System.out.println("Element " + x + " found at index: " + mid);
            }
            else if (a[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }// end of while
        System.out.println("Element not found in array");
    }// end of binarySearch(arr,x)

    public void recursiveBinarySearch(int [] a, int x) {
        recursiveBinarySearch(a, x, 0, a.length - 1);
    }
    private void recursiveBinarySearch(int [] a, int x, int left, int right) {
        if (left > right) {
            System.out.println("Element not found in array");
            return;
        }
        int mid = (left + right) / 2;
        if (a[mid] == x) {
            System.out.println("Element " + x + " found at index: " + mid);
            return;
        }
        if (a[mid] > x) {
            recursiveBinarySearch(a, x, left, mid - 1);
        }
        if (a[mid] < x) {
            recursiveBinarySearch(a, x, mid + 1, right);
        }
    }

    private void swap(int j, int[] a) {
        int temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;
    }// really nice touch

    public int [] bubbleSort(int[] a) {
        int counter = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    swap(j, a);
                }
            }
            counter++;
        }
        System.out.println(counter);
        return a;
    }

    public int [] optimizedBubbleSort(int[] a) {
        int counter = 0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    swap(j, a);
                    swapped = true;
                }
            }
            counter++;
            if (!swapped) {
                break;
            }
        }
        System.out.println(counter);
        return a;
    }

    public int [] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int j;
            for (j = i; (j > 0) && a[j-1] > val; j--) {
                a[j] = a[j - 1];
            }
            a[j] = val;
        }
        return a;
    }

    private int partition (int [] a, int lB, int uB) {
        int pInd = lB;
        int pivot = a[uB];
        for (int i = lB; i < uB; i++) {
            if (a[i] <= pivot) {
                swap(i, pInd, a);
                pInd++;
            }
        }
        swap(pInd, uB, a);
        return pInd;
    }

    private void quickSort(int [] a, int lB, int uB) {
        if (lB < uB) {
            int pivotIndex = partition(a, lB, uB);
            quickSort(a, lB, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, uB);
        }
    }

    public void quickSort(int [] a) {
        quickSort(a, 0, a.length - 1);
    }

    //Overloaded swap method to cater to different arguments passed from selectionSort(a)
    private void swap(int i, int min, int [] a) {
        int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
    }

    public int [] selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            swap(i, min, a);
        }
        return a;
    }

    private void merger (int [] a, int [] L, int [] R) {
        int nL = L.length;
        int nR = R.length;
        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < nL) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < nR) {
            a[k] = R[j];
            j++;
            k++;
        }
    }// end of algorithm

    public void mergeSort(int[] a) {
        int n = a.length;
        if (n < 2) {
            return;
        }
        int mid = (int) Math.floor(n / 2);
        int [] L = new int [mid];
        int [] R = new int [n - mid];
        for (int i = 0; i < mid; i++) {
            L[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            R[i - mid] = a[i]; 
        }
        mergeSort(L);
        mergeSort(R);
        merger(a, L, R);
    }

}// end of class