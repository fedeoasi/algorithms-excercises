package searching;

public class Search<T extends Comparable<T>> {
    public boolean binarySearch(T[] array, T elem) {
        return binarySearchInternal(array, elem, 0, array.length - 1);
    }

    public boolean binarySearchInternal(T[] array, T elem, int start, int stop) {
        if(stop < start) {
            return false;
        }
        int mid = (start + stop) / 2;
        int comp = elem.compareTo(array[mid]);
        if(comp == 0) {
            return true;
        }
        if(comp > 0) {
            return binarySearchInternal(array, elem, mid + 1, stop);
        } else if(comp < 0) {
            return binarySearchInternal(array, elem, start, mid - 1);
        }
        return false;
    }
}
