package Contest.WeekOfCode26.Solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StreetParade {

    static class Pair implements Comparable<Pair> {
        int u;
        int v;
        public Pair(int uu, int vv) {
            this.u = uu;
            this.v = vv;
        }
        @Override
        public int compareTo(Pair o) {
            if (v < o.v)
                return -1;
            else if (v > o.v)
                return 1;
            if (u < o.u)
                return -1;
            else if (u > o.u)
                return 1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair op = (Pair) o;
                return this.u == op.u && this.v == op.v;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.u * 100001 + this.v;
        }

    }

    static class DoubleCompar implements Comparable<DoubleCompar> {

        private static final double EPSILON = 0.000001;
        public double d;
        public DoubleCompar(double dd) {
            this.d = dd;
        }
        @Override
        public int compareTo(DoubleCompar o) {
            if (this.d < o.d + EPSILON && this.d > o.d - EPSILON)
                return 0;
            if (this.d < o.d)
                return -1;
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof DoubleCompar) {
                DoubleCompar op = (DoubleCompar) o;
                return (this.d < op.d + EPSILON && this.d > op.d - EPSILON);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (int) (this.d / EPSILON);
        }

    }

    static class PairPriority implements Comparable<PairPriority> {

        public int id;

        public double val;

        public PairPriority(int iid, double vval) {
            this.id = iid;
            this.val = vval;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof PairPriority) {
                PairPriority op = (PairPriority) o;
                return this.id == op.id;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public int compareTo(PairPriority o) {
            if (this.val < o.val)
                return 1;
            if (this.val > o.val)
                return -1;
            return 0;
        }

    }

    static Scanner scan;

    static StringBuilder sb = new StringBuilder("");

    // static Random r = new Random();

    public static long res = 0;

    public static long[][] mat;

    public static int MAX_SIZE = 30;

    public static List<Integer> frequency = new ArrayList<>();

    public static final long MOD = (long) (1e9 + 7);

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int n = ni();
        long[] a = nal(n);

        long m = nl();
        long hmin = nl();
        long hmax = nl();

        // long st = System.currentTimeMillis();

        long current = a[0] - hmax;
        int currentIndex = 0;
        long currentLength = hmax;
        while (currentLength < m) {
            long toAdd;
            if (currentIndex < n - 1)
                toAdd = a[currentIndex + 1] - a[currentIndex];
            else
                toAdd = hmax;
            if (toAdd >= hmin && toAdd <= hmax) {
                currentLength += toAdd;
                currentIndex++;
            } else if (toAdd < hmin) {
                current = a[currentIndex + 1];
                currentLength = 0;
                currentIndex++;
            }
            // toAdd > hMax
            else {
                toAdd = hmax;
                if (currentLength + toAdd >= m) {
                    currentLength += toAdd;
                } else {
                    currentLength = hmax;
                    current = a[currentIndex + 1] - hmax;
                    currentIndex++;
                }
            }
        }

        System.out.println(current);

        // System.out.println((System.currentTimeMillis() - st));
    }

    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        int sqrtN = (int) Math.sqrt(n) + 1;
        for (int i = 6; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0)
                return false;
        }
        return true;
    }

    private static int getVal(int n) {
        int rem = n;
        int res = 0;
        while (rem > 0) {
            res += rem % 10;
            rem = rem / 10;
        }

        return res;
    }

    private static long xor(Long l1, Long l2) {
        return l1 ^ l2;
    }

    private static int ni() {
        return scan.nextInt();
    }

    // private static int nir(int bound) {
    // return r.nextInt(bound);
    // }

    public static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    private static long nl() {
        return scan.nextLong();
    }

    private static double nd() {
        return scan.nextDouble();
    }

    private static String ns() {
        return scan.next();
    }

    private static int[] nai(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = scan.nextInt();
        }
        return a;
    }

    private static long[] nal(int size) {
        long[] a = new long[size];
        for (int i = 0; i < size; i++) {
            a[i] = scan.nextLong();
        }
        return a;
    }

    private static double[] nad(int size) {
        double[] a = new double[size];
        for (int i = 0; i < size; i++) {
            a[i] = scan.nextDouble();
        }
        return a;
    }

    private static String[] nas(int size) {
        String[] a = new String[size];
        for (int i = 0; i < size; i++) {
            a[i] = scan.next();
        }
        return a;
    }

    private static int[][] nmi(int size1, int size2) {
        int[][] a = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        return a;
    }

    private static long[][] nml(int size1, int size2) {
        long[][] a = new long[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                a[i][j] = scan.nextLong();
            }
        }
        return a;
    }

    private static double[][] nmd(int size1, int size2) {
        double[][] a = new double[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                a[i][j] = scan.nextDouble();
            }
        }
        return a;
    }

    private static String[][] nms(int size1, int size2) {
        String[][] a = new String[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                a[i][j] = scan.next();
            }
        }
        return a;
    }

    static public class Segment implements Comparable<Segment> {

        public Segment(int s, int e) {
            if (s < e) {
                start = s;
                end = e;
            } else {
                start = e;
                end = s;
            }
        }

        int start;

        int end;

        @Override
        public int compareTo(Segment o) {
            if (this.start < o.start)
                return -1;
            else if (this.start > o.start)
                return 1;
            else {
                if (this.end < o.end)
                    return -1;
                else if (this.end > o.end)
                    return 1;
            }
            return 0;
        }

    }

    static class BST<T extends Comparable<T>, Value> {

        private Node root; // root of BST

        private class Node {

            private T key; // sorted by key

            private Value val; // associated data

            private Node left, right; // left and right subtrees

            private int size; // number of nodes in subtree

            public Node(T key, Value val, int size) {
                this.key = key;
                this.val = val;
                this.size = size;
            }
        }

        /**
         * Initializes an empty symbol table.
         */
        public BST() {
        }

        /**
         * Returns true if this symbol table is empty.
         *
         * @return {@code true} if this symbol table is empty; {@code false} otherwise
         */
        public boolean isEmpty() {
            return size() == 0;
        }

        /**
         * Returns the number of key-value pairs in this symbol table.
         *
         * @return the number of key-value pairs in this symbol table
         */
        public int size() {
            return size(root);
        }

        // return number of key-value pairs in BST rooted at x
        private int size(Node x) {
            if (x == null)
                return 0;
            else
                return x.size;
        }

        /**
         * Does this symbol table contain the given key?
         *
         * @param key the key
         * @return {@code true} if this symbol table contains {@code key} and
         * {@code false} otherwise
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public boolean contains(T key) {
            if (key == null)
                throw new NullPointerException("argument to contains() is null");
            return get(key) != null;
        }

        /**
         * Returns the value associated with the given key.
         *
         * @param key the key
         * @return the value associated with the given key if the key is in the symbol table
         * and {@code null} if the key is not in the symbol table
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public Value get(T key) {
            return get(root, key);
        }

        private Value get(Node x, T key) {
            if (x == null)
                return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                return get(x.left, key);
            else if (cmp > 0)
                return get(x.right, key);
            else
                return x.val;
        }

        /**
         * Inserts the specified key-value pair into the symbol table, overwriting the old
         * value with the new value if the symbol table already contains the specified key.
         * Deletes the specified key (and its associated value) from this symbol table
         * if the specified value is {@code null}.
         *
         * @param key the key
         * @param val the value
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public void put(T key, Value val) {
            if (key == null)
                throw new NullPointerException("first argument to put() is null");
            if (val == null) {
                delete(key);
                return;
            }
            root = put(root, key, val);
            assert check();
        }

        private Node put(Node x, T key, Value val) {
            if (x == null)
                return new Node(key, val, 1);
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x.left = put(x.left, key, val);
            else if (cmp > 0)
                x.right = put(x.right, key, val);
            else
                x.val = val;
            x.size = 1 + size(x.left) + size(x.right);
            return x;
        }

        /**
         * Removes the smallest key and associated value from the symbol table.
         *
         * @throws NoSuchElementException if the symbol table is empty
         */
        public void deleteMin() {
            if (isEmpty())
                throw new NoSuchElementException("Symbol table underflow");
            root = deleteMin(root);
            assert check();
        }

        private Node deleteMin(Node x) {
            if (x.left == null)
                return x.right;
            x.left = deleteMin(x.left);
            x.size = size(x.left) + size(x.right) + 1;
            return x;
        }

        /**
         * Removes the largest key and associated value from the symbol table.
         *
         * @throws NoSuchElementException if the symbol table is empty
         */
        public void deleteMax() {
            if (isEmpty())
                throw new NoSuchElementException("Symbol table underflow");
            root = deleteMax(root);
            assert check();
        }

        private Node deleteMax(Node x) {
            if (x.right == null)
                return x.left;
            x.right = deleteMax(x.right);
            x.size = size(x.left) + size(x.right) + 1;
            return x;
        }

        /**
         * Removes the specified key and its associated value from this symbol table
         * (if the key is in this symbol table).
         *
         * @param key the key
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public void delete(T key) {
            if (key == null)
                throw new NullPointerException("argument to delete() is null");
            root = delete(root, key);
            assert check();
        }

        private Node delete(Node x, T key) {
            if (x == null)
                return null;

            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x.left = delete(x.left, key);
            else if (cmp > 0)
                x.right = delete(x.right, key);
            else {
                if (x.right == null)
                    return x.left;
                if (x.left == null)
                    return x.right;
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.size = size(x.left) + size(x.right) + 1;
            return x;
        }

        /**
         * Returns the smallest key in the symbol table.
         *
         * @return the smallest key in the symbol table
         * @throws NoSuchElementException if the symbol table is empty
         */
        public T min() {
            if (isEmpty())
                throw new NoSuchElementException("called min() with empty symbol table");
            return min(root).key;
        }

        private Node min(Node x) {
            if (x.left == null)
                return x;
            else
                return min(x.left);
        }

        /**
         * Returns the largest key in the symbol table.
         *
         * @return the largest key in the symbol table
         * @throws NoSuchElementException if the symbol table is empty
         */
        public T max() {
            if (isEmpty())
                throw new NoSuchElementException("called max() with empty symbol table");
            return max(root).key;
        }

        public Value maxVal() {
            if (isEmpty())
                throw new NoSuchElementException("called max() with empty symbol table");
            return max(root).val;
        }

        private Node max(Node x) {
            if (x.right == null)
                return x;
            else
                return max(x.right);
        }

        /**
         * Returns the largest key in the symbol table less than or equal to {@code key}.
         *
         * @param key the key
         * @return the largest key in the symbol table less than or equal to {@code key}
         * @throws NoSuchElementException if there is no such key
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public T floor(T key) {
            if (key == null)
                throw new NullPointerException("argument to floor() is null");
            if (isEmpty())
                throw new NoSuchElementException("called floor() with empty symbol table");
            Node x = floor(root, key);
            if (x == null)
                return null;
            else
                return x.key;
        }

        private Node floor(Node x, T key) {
            if (x == null)
                return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0)
                return x;
            if (cmp < 0)
                return floor(x.left, key);
            Node t = floor(x.right, key);
            if (t != null)
                return t;
            else
                return x;
        }

        /**
         * Returns the smallest key in the symbol table greater than or equal to {@code key}.
         *
         * @param key the key
         * @return the smallest key in the symbol table greater than or equal to {@code key}
         * @throws NoSuchElementException if there is no such key
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public T ceiling(T key) {
            if (key == null)
                throw new NullPointerException("argument to ceiling() is null");
            if (isEmpty())
                throw new NoSuchElementException("called ceiling() with empty symbol table");
            Node x = ceiling(root, key);
            if (x == null)
                return null;
            else
                return x.key;
        }

        private Node ceiling(Node x, T key) {
            if (x == null)
                return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0)
                return x;
            if (cmp < 0) {
                Node t = ceiling(x.left, key);
                if (t != null)
                    return t;
                else
                    return x;
            }
            return ceiling(x.right, key);
        }

        /**
         * Return the kth smallest key in the symbol table.
         *
         * @param k the order statistic
         * @return the kth smallest key in the symbol table
         * @throws IllegalArgumentException unless {@code k} is between 0 and
         * <em>N</em> &minus; 1
         */
        public T select(int k) {
            if (k < 0 || k >= size())
                throw new IllegalArgumentException();
            Node x = select(root, k);
            return x.key;
        }

        // Return key of rank k.
        private Node select(Node x, int k) {
            if (x == null)
                return null;
            int t = size(x.left);
            if (t > k)
                return select(x.left, k);
            else if (t < k)
                return select(x.right, k - t - 1);
            else
                return x;
        }

        /**
         * Return the number of keys in the symbol table strictly less than {@code key}.
         *
         * @param key the key
         * @return the number of keys in the symbol table strictly less than {@code key}
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public int rank(T key) {
            if (key == null)
                throw new NullPointerException("argument to rank() is null");
            return rank(key, root);
        }

        // Number of keys in the subtree less than key.
        private int rank(T key, Node x) {
            if (x == null)
                return 0;
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                return rank(key, x.left);
            else if (cmp > 0)
                return 1 + size(x.left) + rank(key, x.right);
            else
                return size(x.left);
        }

        /**
         * Returns all keys in the symbol table as an {@code Iterable}.
         * To iterate over all of the keys in the symbol table named {@code st},
         * use the foreach notation: {@code for (Key key : st.keys())}.
         *
         * @return all keys in the symbol table
         */
        public Iterable<T> keys() {
            return keys(min(), max());
        }

        /**
         * Returns all keys in the symbol table in the given range,
         * as an {@code Iterable}.
         *
         * @param lo minimum endpoint
         * @param hi maximum endpoint
         * @return all keys in the symbol table between {@code lo}
         * (inclusive) and {@code hi} (inclusive)
         * @throws NullPointerException if either {@code lo} or {@code hi}
         * is {@code null}
         */
        public Iterable<T> keys(T lo, T hi) {
            if (lo == null)
                throw new NullPointerException("first argument to keys() is null");
            if (hi == null)
                throw new NullPointerException("second argument to keys() is null");

            Queue<T> queue = new Queue<T>();
            keys(root, queue, lo, hi);
            return queue;
        }

        private void keys(Node x, Queue<T> queue, T lo, T hi) {
            if (x == null)
                return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo < 0)
                keys(x.left, queue, lo, hi);
            if (cmplo <= 0 && cmphi >= 0)
                queue.enqueue(x.key);
            if (cmphi > 0)
                keys(x.right, queue, lo, hi);
        }

        /**
         * Returns the number of keys in the symbol table in the given range.
         *
         * @param lo minimum endpoint
         * @param hi maximum endpoint
         * @return the number of keys in the symbol table between {@code lo}
         * (inclusive) and {@code hi} (inclusive)
         * @throws NullPointerException if either {@code lo} or {@code hi}
         * is {@code null}
         */
        public int size(T lo, T hi) {
            if (lo == null)
                throw new NullPointerException("first argument to size() is null");
            if (hi == null)
                throw new NullPointerException("second argument to size() is null");

            if (lo.compareTo(hi) > 0)
                return 0;
            if (contains(hi))
                return rank(hi) - rank(lo) + 1;
            else
                return rank(hi) - rank(lo);
        }

        /**
         * Returns the height of the BST (for debugging).
         *
         * @return the height of the BST (a 1-node tree has height 0)
         */
        public int height() {
            return height(root);
        }

        private int height(Node x) {
            if (x == null)
                return -1;
            return 1 + Math.max(height(x.left), height(x.right));
        }

        /**
         * Returns the keys in the BST in level order (for debugging).
         *
         * @return the keys in the BST in level order traversal
         */
        public Iterable<T> levelOrder() {
            Queue<T> keys = new Queue<T>();
            Queue<Node> queue = new Queue<Node>();
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                Node x = queue.dequeue();
                if (x == null)
                    continue;
                keys.enqueue(x.key);
                queue.enqueue(x.left);
                queue.enqueue(x.right);
            }
            return keys;
        }

        /*************************************************************************
         * Check integrity of BST data structure.
         ***************************************************************************/
        private boolean check() {
            if (!isBST())
                System.err.println("Not in symmetric order");
            if (!isSizeConsistent())
                System.err.println("Subtree counts not consistent");
            if (!isRankConsistent())
                System.err.println("Ranks not consistent");
            return isBST() && isSizeConsistent() && isRankConsistent();
        }

        // does this binary tree satisfy symmetric order?
        // Note: this test also ensures that data structure is a binary tree since order is strict
        private boolean isBST() {
            return isBST(root, null, null);
        }

        // is the tree rooted at x a BST with all keys strictly between min and max
        // (if min or max is null, treat as empty constraint)
        // Credit: Bob Dondero's elegant solution
        private boolean isBST(Node x, T min, T max) {
            if (x == null)
                return true;
            if (min != null && x.key.compareTo(min) <= 0)
                return false;
            if (max != null && x.key.compareTo(max) >= 0)
                return false;
            return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
        }

        // are the size fields correct?
        private boolean isSizeConsistent() {
            return isSizeConsistent(root);
        }

        private boolean isSizeConsistent(Node x) {
            if (x == null)
                return true;
            if (x.size != size(x.left) + size(x.right) + 1)
                return false;
            return isSizeConsistent(x.left) && isSizeConsistent(x.right);
        }

        // check that ranks are consistent
        private boolean isRankConsistent() {
            for (int i = 0; i < size(); i++)
                if (i != rank(select(i)))
                    return false;
            for (T key : keys())
                if (key.compareTo(select(rank(key))) != 0)
                    return false;
            return true;
        }

    }

    static class Queue<Item> implements Iterable<Item> {

        private Node<Item> first; // beginning of queue

        private Node<Item> last; // end of queue

        private int n; // number of elements on queue

        // helper linked list class
        private static class Node<Item> {

            private Item item;

            private Node<Item> next;
        }

        /**
         * Initializes an empty queue.
         */
        public Queue() {
            first = null;
            last = null;
            n = 0;
        }

        /**
         * Returns true if this queue is empty.
         *
         * @return {@code true} if this queue is empty; {@code false} otherwise
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * Returns the number of items in this queue.
         *
         * @return the number of items in this queue
         */
        public int size() {
            return n;
        }

        /**
         * Returns the item least recently added to this queue.
         *
         * @return the item least recently added to this queue
         * @throws NoSuchElementException if this queue is empty
         */
        public Item peek() {
            if (isEmpty())
                throw new NoSuchElementException("MyQueue underflow");
            return first.item;
        }

        /**
         * Adds the item to this queue.
         *
         * @param item the item to add
         */
        public void enqueue(Item item) {
            Node<Item> oldlast = last;
            last = new Node<Item>();
            last.item = item;
            last.next = null;
            if (isEmpty())
                first = last;
            else
                oldlast.next = last;
            n++;
        }

        /**
         * Removes and returns the item on this queue that was least recently added.
         *
         * @return the item on this queue that was least recently added
         * @throws NoSuchElementException if this queue is empty
         */
        public Item dequeue() {
            if (isEmpty())
                throw new NoSuchElementException("MyQueue underflow");
            Item item = first.item;
            first = first.next;
            n--;
            if (isEmpty())
                last = null; // to avoid loitering
            return item;
        }

        /**
         * Returns a string representation of this queue.
         *
         * @return the sequence of items in FIFO order, separated by spaces
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Item item : this)
                s.append(item + " ");
            return s.toString();
        }

        /**
         * Returns an iterator that iterates over the items in this queue in FIFO order.
         *
         * @return an iterator that iterates over the items in this queue in FIFO order
         */
        public Iterator<Item> iterator() {
            return new ListIterator<Item>(first);
        }

        // an iterator, doesn't implement remove() since it's optional
        private class ListIterator<Item> implements Iterator<Item> {

            private Node<Item> current;

            public ListIterator(Node<Item> first) {
                current = first;
            }

            public boolean hasNext() {
                return current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

    }

}