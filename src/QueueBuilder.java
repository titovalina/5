import java.util.List;

public class QueueBuilder {
    public List<Integer> source;

    public QueueBuilder(List<Integer> source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return source.toString();
    }
}
