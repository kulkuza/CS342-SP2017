public abstract class SortArray
{
    private int size;
    private int[] array;

    public SortArray() {
    	size = 0;
    	array = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int compare(int i, int j) {
    	return array[i] - array[j];
    }

    public void swap(int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }

    public boolean compareAndSwap(int i, int j) {
    	if (compare(i, j) > 0) {
    		swap(i, j);
    		return true;
    	}
    	else {
    		return false;
    	}
    }


}
