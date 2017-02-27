public abstract class SortArray
{
    private int size;

    public SortArray();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public abstract void sort();
}
