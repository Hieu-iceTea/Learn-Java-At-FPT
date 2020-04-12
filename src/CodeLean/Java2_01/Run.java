/**
 * [Java2_01] Giới Thiệu Về ArrayList Trong Java
 * https://www.codelean.vn/2019/12/java201-gioi-thieu-ve-arraylist-trong.html
 */

package CodeLean.Java2_01;

import java.util.*;

public class Run {
    public static void main(String[] args) {
        //CreateArrayListExample();
        //CreateArrayListFromCollectionExample();
        //IterateOverArrayListExample();
        //ArrayListCollectionsSortExample();
        //ArrayListSortExample();
        ArrayListObjectSortExample();
    }

    public static void CreateArrayListExample() {
        List<String> animals = new ArrayList<>();

        animals.add("dog");
        animals.add("Tiger");
        animals.add("Cat");

        System.out.println(animals);

        animals.add(2, "Rabbit");

        System.out.println(animals);

    }

    private static void CreateArrayListFromCollectionExample() {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
        first.add(10);
        first.add(25);
        System.out.println(first);

        List<Integer> second = new ArrayList<>();
        second.add(50);
        second.add(65);
        second.add(80);
        second.add(96);
        System.out.println(second);

        List<Integer> myList = new ArrayList<>(first);
        System.out.println(myList);

        myList.addAll(second);
        System.out.println(myList);

        myList.addAll(2, second);
        System.out.println(myList);

        myList.remove((Integer) 80);
        System.out.println(myList);

        myList.removeIf(n -> n.equals("a"));
    }

    private static void IterateOverArrayListExample() {
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Breaking Bad");
        tvShows.add("Game Of Thrones");
        tvShows.add("Friends");
        tvShows.add("Prison break");
        System.out.println(tvShows);

        System.out.println("=== Iterate using Java 8 forEach and lambda ===");

        tvShows.forEach(item -> {
            System.out.println(item);
        });

        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> tvShowIterator = tvShows.iterator();
        while (tvShowIterator.hasNext()) {
            String item = tvShowIterator.next();
            System.out.println(item);
        }

        /**
        System.out.println("\n=== Iterate using an iterator() and Java 8 forEachRemaining() method ===");
        tvShowIterator.forEachRemaining(item -> System.out.println(item));
        */

        System.out.println("\n=== Iterate using a listIterator() to traverse in both directions ===");
        ListIterator<String> tvShowListIterator = tvShows.listIterator(tvShows.size());
        while (tvShowListIterator.hasPrevious()) {
            String item = tvShowListIterator.previous();
            System.out.println(item);
        }

        System.out.println("\n=== Iterate using simple for-each loop ===");
        for (var item : tvShows) {
            System.out.println(item);
        }

        System.out.println("\n=== Iterate using for loop with index ===");
        for (int i = 0; i < tvShows.size(); ++i) {
            System.out.println(tvShows.get(i));
        }


    }

    private static void ArrayListCollectionsSortExample() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(13);
        numbers.add(7);
        numbers.add(18);
        numbers.add(5);
        numbers.add(2);

        System.out.println("Before : " + numbers);

        // Sorting an ArrayList using Collections.sort() method
        Collections.sort(numbers);

        System.out.println("After : " + numbers);
    }

    private static void ArrayListSortExample() {
        List<String> names = new ArrayList<>();
        names.add("Lisa");
        names.add("Jennifer");
        names.add("Mark");
        names.add("David");

        System.out.println("Names : " + names);

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                return name1.compareTo(name2);
            }
        });

        names.sort((name1, name2) -> name1.compareTo(name2));

        names.sort(Comparator.naturalOrder());

        System.out.println("Sorted Names : " + names);
    }

    private static void ArrayListObjectSortExample() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sachin", 47));
        people.add(new Person("Chris", 34));
        people.add(new Person("Rajeev", 25));
        people.add(new Person("David", 31));

        System.out.println("Person List : " + people);

        people.sort((person1, person2) -> {
            return person1.getAge() - person2.getAge();
        });

        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("Sorted Person List by Age : " + people);


        Collections.sort(people, Comparator.comparing(Person::getName));

        System.out.println("Sorted Person List by Name : " + people);
    }
}
