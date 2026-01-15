import java.util.ArrayList;
import java.util.List;

public class ListMerger {
    public List<Integer> L1;
    public List<Integer> L2;

    public ListMerger(List<Integer> L1, List<Integer> L2) {
        this.L1 = L1;
        this.L2 = L2;
    }

    public List<Integer> merge() {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < L1.size() && j < L2.size()) {
            if (L1.get(i) <= L2.get(j)) merged.add(L1.get(i++));
            else merged.add(L2.get(j++));
        }
        while (i < L1.size()) merged.add(L1.get(i++));
        while (j < L2.size()) merged.add(L2.get(j++));
        return merged;
    }

    @Override
    public String toString() {
        return "L1: " + L1 + ", L2: " + L2;
    }
}
