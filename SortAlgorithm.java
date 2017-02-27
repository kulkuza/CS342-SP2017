public abstract class SortAlgorithm {
  private String name;  //name of sorting algorithm
  
  public AbstractSortAlgorithm(String name) {
    this.name = name;
  }
  
  public final String getName() {
    return name;
  }
  
  public abstract void sort(SortArray array);
}
