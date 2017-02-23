public abstract class Array
{
    private int size;

    public Array();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public abstract void sort();
}
