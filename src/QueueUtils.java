import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueUtils {
    public static Queue<Integer> buildSymmetricQueue(List<Integer> source) {
        Queue<Integer> q = new LinkedList<>();
        q.addAll(source);
        for (int i = source.size() - 1; i >= 0; i--) {
            q.add(source.get(i));
        }
        return q;
    }
}
