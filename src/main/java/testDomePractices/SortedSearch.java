package testDomePractices;

/*
* Implement function countNumbers that accepts a sorted array of unique integers and,
* efficiently with respect to time used, counts the number of array elements that are less than the parameter lessThan.

For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4)
* should return 2 because there are two array elements less than 4.
* */
public class SortedSearch {
    /*    public static int countNumbers(int[] sortedArray, int lessThan) {
            int i = java.util.Arrays.binarySearch(sortedArray, lessThan);
            if (i < 0) {
                return -i - 1;
            } else {
                // in case of duplicates, find first occurrence
                for (; i > 0 && sortedArray[i - 1] == lessThan; i--);
                return i;
            }
        } */
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int i = searchKey(sortedArray, 0, sortedArray.length, lessThan);
        if (i < 0) {
            return -i - 1;
        } else {
            // in case of duplicates, find first occurrence
            for (; i > 0 && sortedArray[i - 1] == lessThan; i--) ;
            return i;
        }
    }

    private static int searchKey(int[] sortedArray, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = sortedArray[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }

        }

        return -(low + 1);
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
    }
}
