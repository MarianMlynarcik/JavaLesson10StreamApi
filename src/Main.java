import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // 1.	Using Java Stream API find out sum of all numbers between
        //      and 10000 that are dividable by both 3 and 5 but not dividable by 7

        System.out.println("Sum of all numbers between 1 and 10000 that are dividable by both 3 and 5 but not dividable by 7:");

        Integer a = Stream.iterate(1, A -> A + 1)
                .limit(10000)
                .filter(A -> (A % 5 == 0) && (A % 3 == 0) && (A % 7 != 0))
                .mapToInt(Integer::intValue).sum(); //.collect(Collectors.summingInt(Integer::intValue));
        System.out.println(a);

        // 2.   Using Java Stream API print first 100 even numbers that are not dividable by 8

        System.out.println("First 100 even numbers that are not dividable by 8:");

        Stream.iterate(1, A -> A + 1)
                .filter(A -> (A % 2 == 0) && (A % 8 != 0))
                .limit(100)
                .forEach(A -> System.out.println(A));

        // 3.

        List<Book> list = new ArrayList<>();

        list.add(new Book("Lord of the rings I.", 30));
        list.add(new Book("Harry Potter V.", 26));
        list.add(new Book("Hobbit II.", 34));
        list.add(new Book("Janka a Danka", 10));
        list.add(new Book("5 jazykov lásky", 13));
        list.add(new Book("Jesus of Nazareth I.", 21));
        list.add(new Book("Bible", 10));
        list.add(new Book("Zločin a trest", 26));

        // 3.1 Using Java Stream API print names (in alphabetic order)
        // of all books that have price smaller than 100.

        List<String> names = list.stream()
                .filter(p -> p.getPrice() < 100)
                .map(Book::getName) // .map(n -> n.getName())
                .sorted()
                .toList();

        System.out.println("Books with price smaller than 100 (alphabetic order) " + names);

        // 3.2 Using Java stream API find out how many books have name shorter than 5 characters.

        long count = list.stream()
                .filter(n -> n.getName().length() < 5)
                .count();

        System.out.println("Books which have name shorter than 5 characters: " + count);

        // 3.3 Using Java stream API find out what is the average price of the book in the list

        OptionalDouble average = list.stream()
                .mapToInt(Book::getPrice) // .mapToInt(i -> i.getPrice())
                .average();

        System.out.println("Average price of the book in the list is: " + average);

        // 3.4 Using Java stream API find out if all books in list are cheaper than 500

        boolean cheaper = list.stream()
                .allMatch(ch -> ch.getPrice() < 500);

        System.out.println("Are all books in the list cheaper than 500? " + cheaper);
    }
}
