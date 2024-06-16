package lessons.lesseon_05_06.taski;

public class ComporatorStack implements Comparable<Integer> {
    int value;
    @Override
    public int compareTo(Integer o) {
        return value - o;
    }
}
