package java8.streams.terminate.collectors;

import java8.streams.initiation.StreamFromIterable;

import java.util.*;
import java.util.stream.Collectors;

public class ToCollections {
  public static void main(String[] args) {
    StreamFromIterable si = new StreamFromIterable();

    List<String> collected1 = si.stream().collect(Collectors.toList());
    Set<String> collected2 = si.stream().collect(Collectors.toSet());

    ArrayList<String> collected3 = si.stream().collect(Collectors.toCollection(ArrayList::new));
    LinkedList<String> collected4 = si.stream().collect(Collectors.toCollection(LinkedList::new));
    PriorityQueue<String> collected5 = si.stream().collect(Collectors.toCollection(PriorityQueue::new));
    Stack<String> collected6 = si.stream().collect(Collectors.toCollection(Stack::new));
    Vector<String> collected7 = si.stream().collect(Collectors.toCollection(Vector::new));

    HashSet<String> collected8 = si.stream().collect(Collectors.toCollection(HashSet::new));
    TreeSet<String> collected9 = si.stream().collect(Collectors.toCollection(TreeSet::new));
  }
}
