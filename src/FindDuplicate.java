import java.util.*;

public class FindDuplicate {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9));
        Set<Integer> set = new HashSet<>();

        list.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);

    }
}