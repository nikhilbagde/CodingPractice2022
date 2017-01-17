package CompanyCompetetions.IPSoft;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;


/**
 * Created by Nikhi on 12/1/2016.
 */
public class JavaHeapPriorityQueue {
    public static void main(String[] args) {
         PriorityQueue<Integer> priorityQueueMaxHeap =new PriorityQueue<>((o1, o2) -> {
             if(o1>o2){
                 return -1;
             }else if(o1<o2){
                 return 1;
             }
             return 0;
         });

        priorityQueueMaxHeap.add(3);
        priorityQueueMaxHeap.add(5);
        priorityQueueMaxHeap.add(7);
        System.out.println(priorityQueueMaxHeap.peek());  //see top
        System.out.println(priorityQueueMaxHeap.poll()); // remove top
        System.out.println(priorityQueueMaxHeap.peek()); //see top
        System.out.println(priorityQueueMaxHeap.poll()); //remove top
        System.out.println(priorityQueueMaxHeap.peek());  //see top ?
        System.out.println(priorityQueueMaxHeap.poll());  // remove top
        System.out.println(priorityQueueMaxHeap.peek());  //see top ?
        System.out.println(priorityQueueMaxHeap.poll());  // remove top


        PriorityQueue<Integer> priorityQueueMinHeap = new PriorityQueue<>((o1,o2) ->
                o1 > o2 ? 1 : (o1< o2? -1: 0)
        );

        priorityQueueMinHeap.offer(10);
        priorityQueueMinHeap.offer(15);
        priorityQueueMinHeap.offer(5);
        priorityQueueMinHeap.offer(-1);
        priorityQueueMinHeap.offer(0);
        priorityQueueMinHeap.offer(100);

        System.out.println("Second PQ");
        for ( int a: priorityQueueMinHeap ) {
            System.out.println(a);
        }

        System.out.println("Array");
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            int temp  = new Random().nextInt(100) ;
            System.out.print(temp+" ");
            array[i] = temp;
        }

        //constructing a min Heap;
        priorityQueueMaxHeap.clear();
        priorityQueueMinHeap.clear();
        for (int i = 0; i < array.length; i++) {
            priorityQueueMinHeap.offer(array[i]);
            priorityQueueMaxHeap.offer(array[i]);
        }
        System.out.println("Priinting Min Heap");
        printHeap(priorityQueueMinHeap);
        System.out.println("Printing Max Heap");
        printHeap(priorityQueueMaxHeap);

        System.out.println("Print first five of minHeap");
        printFirstFiveElemet(priorityQueueMinHeap);
        System.out.println("Print first five of MaxHeap");
        printFirstFiveElemet(priorityQueueMaxHeap);


        // Given array of 20 size find first 3 maximum elements.
        System.out.println("Problem starts here");
        int [] a = new int[20];
        for (int i = 0; i <20 ; i++) {
            int temp =  (new java.util.Random(10).nextInt(10) * i )+ new java.util.Random(50).nextInt(50);
           // System.out.print(temp+" ");
            a[i] = temp;
        }
        int [] b = {6,2,9,10,1,7,4,8,3,5};

        
        //use a min Heap to find max 'k' element 
        // use a max heap to find mind 'k' element
        
        //put only k element in min heap
        //say k = 4;
        int k = 4;
        priorityQueueMinHeap.clear();
        for (int i = 0; i < k; i++) {
            priorityQueueMinHeap.offer(b[i]);       //[6,2,9] -> [2,6] -> [2,6,9]
        }
        for (int i = k; i < b.length; i++) {
            if(b[i] > priorityQueueMinHeap.peek()){
                priorityQueueMinHeap.poll();
                priorityQueueMinHeap.offer(b[i]);
            }
        }
        printHeap(priorityQueueMinHeap);
        System.out.println("I am at 105");
        printFromRootToEnd(priorityQueueMinHeap);


        //Section two:
        System.out.println("Section 2: Get Orderly traversal of priority queue using Arrays.sort()pq.toArray()");/*
        // Iterator will not  The Iterator provided in method {@link
        * #iterator()} is not guaranteed to traverse the elements of
        * the priority queue in any particular order. If you need ordered
        * traversal, consider using {@code Arrays.sort(pq.toArray())}.*/


        //Section 3:
        //Comaprator things
        /*
        0)
            ArtistCompare artistCompare = new ArtistCompare();
            Collections.sort(songList, Collections.reverseOrder(artistCompare));
        1)
            Comparator<Song> songRatingComparator = Comparator.comparing(Song::getRating);
            Collections.sort(songList, songRatingComparator.reversed());
            And you can, of course, also use the Streams framework:

        2)
            List<Song> sortedSongList = songList.stream()
                .sorted(Comparator.comparing(Song::getRating).reversed())
                .collect(Collectors.toList());*/

        }
    private static void printHeap(PriorityQueue<Integer> priorityQueue){
        System.out.println("Printing Heap");
        for (int a :priorityQueue) {
            System.out.print( a + " ");
        }
    }
    private static void printFirstFiveElemet(PriorityQueue<Integer> priorityQueue){
        System.out.println("Printing heap from root to end");
        for (int i = 0; i < 5; i++) {
            System.out.println(priorityQueue.poll());
        }
    }
    private static void printFromRootToEnd(PriorityQueue<Integer> priorityQueue){
        //had to save size as if I directly use it,
        // as size is dynamically decreasing
        // So loop will run for less than total size, as pri.size() is less now.
        // in fact it will only run half of the time.
        int size = priorityQueue.size();

        for (int i = 0; i < size; i++) {
            System.out.print(priorityQueue.poll());
        }
    }
}
