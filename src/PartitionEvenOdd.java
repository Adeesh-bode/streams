import java.util.*;
import java.util.stream.*;

public class PartitionEvenOdd {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9));
        Map<Boolean, List<Integer >> mp = list.stream().collect(Collectors.partitioningBy(
                s -> s % 2 ==0
        ));

        for(Map.Entry<Boolean, List<Integer>> entry : mp.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        };

    }
}