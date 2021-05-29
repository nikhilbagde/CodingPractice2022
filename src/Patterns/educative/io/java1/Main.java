package Patterns.educative.io.java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        ------------------------------------ A_SlidingWindow ------------------------------------
       */
        /*
        PROBLEMS
        1. Maximum Sum Subarray of Size K (easy)
        2. Smallest Subarray with a given sum (easy)
        3. Longest Substring with K Distinct Characters (medium)
        4. Fruits into Baskets (medium)
        5. No-repeat Substring (hard)
        6. Longest Substring with Same Letters after Replacement (hard)
        7. Longest Subarray with Ones after Replacement (hard)

        Problem Challenge 1 - Permutation in a String (hard)
        Problem Challenge 2 - String Anagrams (hard)
        Problem Challenge 3 - Smallest Window containing Substring (hard)
        Problem Challenge 4 - Words Concatenation (hard)
        */

        //Max Sum SubArray of SizeK
        //Explanation: Subarray with maximum sum is [5, 1, 3].
        //Max Sum = 9
        System.out.println(A_SlidingWindow.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        //System.out.println(A_SlidingWindow.findMaxSumSubArrayBookSolution(3, new int[] {2, 1, 5, 1, 3, 2}));

        //Smallest SubArray
        //Explanation: Given an array of positive numbers and a positive number ‘S’, find the length of the
        // smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
        System.out.println(A_SlidingWindow.findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));

        //Longest Substring
        //Given a string, find the length of the longest substring in it with no more than K distinct characters.
        //Input: String="araaci", K=2
        //output 4
        System.out.println(A_SlidingWindow.longestSubstringKDistinct("cbbebi", 3));
        System.out.println(A_SlidingWindow.longestSubstringKDistinctBookSolution("cbbebi", 3));

        //fruits in a basket: Write a function to return the maximum number of fruits in both the baskets.
        //Input:  Fruit=['A', 'B', 'C', 'A', 'C']  Output: 3
        //Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
        System.out.println(A_SlidingWindow.maxFruitsIn2Baskets(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
        System.out.println(A_SlidingWindow.maxFruitsIn2BasketsBookSolution(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));

        //No-repeat Substring
        //Given a string, find the length of the longest substring which has no repeating characters.
        //Input: String="aabccbb"
        //Output: 3
        //Explanation: The longest substring without any repeating characters is "abc".
        System.out.println(A_SlidingWindow.noRepeatSubstringProblem("abccde"));
        System.out.println(A_SlidingWindow.noRepeatSubstringProblemBookSolution("abccde"));

        //Longest SubString
        //Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
        // find the length of the longest substring having the same letters after replacement.
        //Input: String="aabccbb", k=2 Output: 5
        //Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
        System.out.println(A_SlidingWindow.longestSubStringAfterReplacement("abccde", 1));
        System.out.println(A_SlidingWindow.longestSubStringAfterReplacementBookSolution("abccde", 1));

        //Longest SubArray with Ones After Replacement
        //Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
        // find the length of the longest contiguous subarray having all 1s.
        //Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        //Output: 6
        //Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
        System.out.println(A_SlidingWindow.longestSubArrayAfterReplacement(new int[]{ 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));

        //Challenge1 String Permutations
        //Given a string and a pattern, find out if the string contains any permutation of the pattern.
        //Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
        //abc, acb, bac, bca, cab, cba
        // a string has ‘n’ distinct characters it will have n!n!n! permutations.
        //Input: String="oidbcaf", Pattern="abc"
        //Output: true
        //Explanation: The string contains "bca" which is a permutation of the given pattern.
        System.out.println(A_SlidingWindow.stringPermutationOfAPattern("bcdxabcdy", "bcdyabcdx"));
        System.out.println(A_SlidingWindow.stringPermutationOfAPatternBookSolution("bcdxabcdy", "bcdyabcdx"));

        //Challenge2 String Anagrams
        //Given a string and a pattern, find all anagrams of the pattern in the given string.
        //Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
        //abc, acb, bac, bca, cab, cba
        //Input: String="abbcabc", Pattern="abc"  Output: [2, 3, 4]
        //Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
        System.out.println(A_SlidingWindow.stringAnagramsOfAPattern("abbcabc", "abc"));
        System.out.println(A_SlidingWindow.stringAnagramsOfAPatternBookSolution("abbcabc", "abc"));

        //Challenge 3 Smallest Window containing Substring
        //Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
        //Input: String="aabdec", Pattern="abc" | Output: "abdec"
        //Explanation: The smallest substring having all characters of the pattern is "abdec"
        System.out.println(A_SlidingWindow.smallestSubtringWithPattern("abdabca", "abc"));

        //Challenge 4 Word Concatenation
        //Given a string and a list of words, find all the starting indices of substrings in the given string that are a
        // concatenation of all the given words exactly once without any overlapping of words.
        // It is given that all words are of the same length.
        //Input: String="catfoxcat", Words=["cat", "fox"] | Output: [0, 3]
        //Explanation: The two substring containing both the words are "catfox" & "foxcat".
        System.out.println(A_SlidingWindow.wordsConcatenation("catcatfoxfox", new String[] {"cat", "fox"}));



        // 8. Sub-arrays with Product Less than a Target (medium)
        // Given an array of positive integers nums. Count and print the number of (contiguous) subarrays
        // where the product of all the elements in the subarray is less than target.
        //        Input: nums = [10, 5, 2, 6], k = 100
        //        Output: 8
        //        Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
        //        Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
        //        [[10], [10, 5], [5], [5, 2], [5, 2, 6], [2], [2, 6], [6]]
        System.out.println(A_SlidingWindow.subarrayProductLessThanKAccepted(new int[] {10, 5, 2, 6}, 100) );  //two pointers + sliding windows both applies here.

        /*
        ------------------------------------ B Two Pointers------------------------------------
        */


        //Pair in Array
        //Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
        //Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
        //Input: [1, 2, 3, 4, 6], target=6
        //Output: [1, 3]
        //Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
        int[] result = B_TwoPointers.pairInArray(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        //Squaring Sorting
        //Given a sorted array, create a new array containing squares of all the number of the inputEmp array in the sorted order.
        //Input: [-2, -1, 0, 2, 3] | Output: [0, 1, 4, 4, 9]
        int[] result2 = B_TwoPointers.squaringSorted(new int[] {-3, -1, 0, 1, 2});
        System.out.println("[" + result2[0] + "," + result2[1] + "," + result2[2] + "," + result2[3]+ "," + result2[4] + "]");

        //Triplet Sum to Zero
        //Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
        //Input: [-3, 0, 1, 2, -1, 1, -2] | Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        //Explanation: There are four unique triplets whose sum is equal to zero.
        System.out.println(B_TwoPointers.tripletSumToZero(new int[] {-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(B_TwoPointers.tripletSumToZeroBook(new int[] {-3, 0, 1, 2, -1, 1, -2}));

        // 6. Triplet Sum Close to Target (medium)
        // Given an array of unsorted integers. find three numbers in array s/t sum is closest to target.
        //Input: [-1,2,1,-4], target = 1 |  Output: 2
        //Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
        System.out.println(B_TwoPointers.tripletSumCloseToTarget(new int[] {-1,2,1,-4}, 1) );


        // 7. Triplets with Smaller Sum (medium)
        // Given an array of unsorted integers. find three numbers indices [i,j,k] in array s/t sum is smaller to target.
        //        Input: nums = [-2,0,1,3], and target = 2 | Output: 2
        //        Explanation: Because there are two triplets which sums are less than 2:
        //             [-2,0,1]
        //             [-2,0,3]
        System.out.println(B_TwoPointers.tripletWithSmallerSum(new int[] {-2,0,1,3}, 2) );

        // 8. Sub-arrays with Product Less than a Target (medium)
        // Given an array of positive integers nums. Count and print the number of (contiguous) subarrays
        // where the product of all the elements in the subarray is less than target.
        //        Input: nums = [10, 5, 2, 6], k = 100  | Output: 8
        //        Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
        //        Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
        //        [[10], [10, 5], [5], [5, 2], [5, 2, 6], [2], [2, 6], [6]]
        System.out.println(B_TwoPointers.subarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100) );  // Time limit


        //        9	Dutch National Flag Problem (medium)
        //        Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
        //        with the colors in the order red, white, and blue. Integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
        //         You must solve this problem without using the library's sort function.
        //        Example 1: Input: nums = [2,0,2,1,1,0] | Output: [0,0,1,1,2,2]
        //        Example 2: Input: nums = [2,0,1] | Output: [0,1,2]
        //        Example 3: Input: nums = [0] | Output: [0]
        //        Example 4: Input: nums = [1] | Output: [1]
        System.out.println(B_TwoPointers.dutchFlagSortColors(new int[] {2,0,2,1,1,0}) );


        /* Given an array  of integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
        nums[a] + nums[b] + nums[c] + nums[d] == target
        Example 1: Input: nums = [1,0,-1,0,-2,2], target = 0 | Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        Example 2: Input: nums = [2,2,2,2,2], target = 8 | Output: [[2,2,2,2]] */
        System.out.println(B_TwoPointers.searchQuadruplets(new int[] {1,0,-1,0,-2,2}, 0) );

        /**
         * --------------------------------------Pattern: Fast & Slow pointers (7)--------------------------------------
         * LinkedList Cycle (easy): LC 141
         * Start of LinkedList Cycle (medium): LC 142
         * Happy Number (medium): LC 202
         * Middle of the LinkedList (easy): LC 876
         * Problem Challenge 1: LC 234
         * Problem Challenge 2: LC 143
         * Problem Challenge 3: LC 457
         */

        /*
        LinkedList Cycle (easy): LC 141
        Given head,  determine if the linked list has a cycle in it.
        There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
        Internally, 'pos' is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
        Return true if there is a cycle in the linked list. Otherwise, return false.
         */
        System.out.println(C_FastAndSlowPointers.hasCycle(null ));

        /* Start of LinkedList Cycle (medium): LC 142
         Given a linked list, return the node where the cycle begins. If there is no cycle, return null. */
        System.out.println(C_FastAndSlowPointers.findCycleStart(null ));

        /*Happy Number (medium): LC 202
        Write an algorithm to determine if a number n is happy. A happy number is a number defined by the following process:
        Starting with any positive integer, replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
        Return true if n is a happy number, and false if not. */
        System.out.println(C_FastAndSlowPointers.happyNumber(23));
        System.out.println(C_FastAndSlowPointers.happyNumber(12));

        /*Middle of the LinkedList (easy): LC 876 */
        System.out.println(C_FastAndSlowPointers.findMiddle(null));

        /* Problem Challenge 1: Check if SLL is palindrome or not */
        System.out.println(C_FastAndSlowPointers.isPalindrome2(null));

        /* Problem Challenge 2: LC 143
        given a list, 1 ->2 ->3 ->4 ->5 ->6 -> null
        print it as 1 ->6 ->2 ->5 ->3 ->4-> null */
        System.out.println(C_FastAndSlowPointers.reorderList(null));
        C_FastAndSlowPointers.reorderList2Fastest(null);

        /* Problem Challenge 3: LC 457 */


        //-----------------------------------Merge Intervals-----------------------------------
        /*
        Pattern: Merge Intervals (7)
        Merge Intervals (medium): LC 56
        Insert Interval (medium): LC 57
        Intervals Intersection (medium): LC 986
        Conflicting Appointments (medium): LC 252
        Problem Challenge 1: LC 253
        Problem Challenge 2: new ( link )
        Problem Challenge 3: LC 759
         */

        /*Merge Intervals : Given an array of intervals merge all overlapping intervals : INPUT: [[1,3],[2,6],[8,10],[15,18]] OUTPUT: [[1,6],[8,10],[15,18]] */
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        System.out.println(D_MergeIntervals.mergeIntervals(intervals));

        /* Insert Interval : Given an non-overlapping intervals, insert a interval, merge if necessary : INPUT: [[1,3],[6,9]] & [2,5] OUTPUT: [[1,5],[6,9]]
        INPUT: [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] OUTPUT: [[1,2],[3,10],[12,16]]
         */
        System.out.println(D_MergeIntervals.insertInterval(intervals, new Interval(5, 9)));

        /* Intervals Intersection: Given two sorted interval lists which are disjoint return thr intersection of two lists
        Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]] | Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
         */
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        System.out.println(Arrays.toString(D_MergeIntervals.intervalIntersection(input1, input2)));

        /*   Problem Challenge 1:  Meeting Root, Conflicting Appointments:  Given meeting intervals, find if person can attend all meetings [[0, 30],[5, 10],[15, 20]],     O: FALSE    */
        Interval[] meetingIntervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        System.out.println(D_MergeIntervals.canAttendMeetings(meetingIntervals));

        /* Meeting Root II : Given intervals for meeting, find minimum no of conference required */
        System.out.println(D_MergeIntervals.findMinimumMeetingRooms1(intervals));
        System.out.println(D_MergeIntervals.findMinimumMeetingRooms2(input1));
        System.out.println(D_MergeIntervals.findMinimumMeetingRooms3(input1));
        System.out.println(D_MergeIntervals.findMinimumMeetingRooms4(input1));      // best explanation

        /*  Problem Challenge 2: Find Max Bandwidth
        * For n tv channels, given show start time, end time & bandwidth needed for each channels, find the maximum bandwidth required at peak.
        * a show represented as [1,30,2] meaning [show-start-time, show-end-time, bandwidth-needed].
        * e.g. n =3 channels,
        [[1,30, 2],[31,60, 4],[61,120, 3],
        [1,20,2],[21,40,4],[41,60,5],[61,120,3],
        [1,60,4],[61,120,4]]
        Ans: 13, for time slot between 41-60 each channel need 4,5,4 bandwidth respectively. 13 is highest (peek/max) bandwidth.
        Note: Min-size-of-show = 2 (min) |  Max-duration-for-show = 720 (min) same as 24hours | Max-bandwidth-per-show = 100 (mbps) | n<1000
        Some channels can decide not to broadcast any show for given time-slot, which mean there will be 0 bandwidth required for that channel for given time-slo*/
        List<Job> input = new ArrayList<>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum Bandwidth load at any time: " + D_MergeIntervals.findMaxCPUOrBandwidthLoad(input));

        /*Problem Challenge 3: Employee Free Time : given intervals of all employee return common positive-length free time for all employee
        * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]  | Output: [[3,4]] |
        * Explanation: There are a total of three employees, and all common free time intervals would be [-inf, 1], [3, 4], [10, inf].
        We discard any intervals that contain inf as they aren’t finite.
        Example 2: Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]] | Output: [[5,6],[7,9]]*/
        List<List<Interval>> inputEmp = new ArrayList<>();
        inputEmp.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        inputEmp.add(new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        System.out.println( D_MergeIntervals.findEmployeeFreeTime(inputEmp));


        //------------------------------------------------------Cyclic Sort ---------------------------------------------------------
        /*
        1. Cyclic Sort (easy): new ( link )
        2. Find the Missing Number (easy): LC 268
        3. Find all Missing Numbers (easy): LC 448
        4. Find the Duplicate Number (easy): LC 287
        5. Find all Duplicate Numbers (easy): LC 442
        6. Problem Challenge 1: LC 645
        7. Problem Challenge 2: LC 41
        8. Problem Challenge 3: new ( link )
         */
        /* 1. Cyclic Sort (easy): new ( link ):  */


        /* 2. Find the Missing Number (easy) | Array with distinct numbers from 0 to n | Return only number missing
        * Input: nums = [3,0,1] | Output: 2 | Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.*/
        System.out.println(E_CyclicSort.missingNumber2(new int[] {3,0,1}));
        System.out.println(E_CyclicSort.missingNumber3(new int[] {3,0,1}));

        /* 3. Find all Missing Numbers | Input: nums = [4,3,2,7,8,2,3,1] | Output: [5,6] */
        System.out.println(E_CyclicSort.findDisappearedNumbers( new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(E_CyclicSort.findDisappearedNumbers2( new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(E_CyclicSort.findDisappearedNumbers3( new int[]{4,3,2,7,8,2,3,1}));

        /* 4. Find the Duplicate Number | */
        System.out.println(E_CyclicSort.findDuplicate(new int[]{1,3,4,2,2}));


        //-----------------------In Place reversal of Linked List --------------------------
        /**
         * Pattern: In-place Reversal of a LinkedList (5)
         * 1. Reverse a LinkedList (easy): LC 206
         * 2. Reverse a Sub-list (medium): LC 92
         * 3. Reverse every K-element Sub-list (medium): LC 25
         * 4. Problem Challenge 1: new ( link )
         * 5. Problem Challenge 2: LC 61
         */
        /* 1. Reverse a linked list*/
        System.out.println(F_InPlaceReversalLinkedList.reverseList(null));

        /* Reverse Of linked list given two middle nodes index */
        System.out.println(F_InPlaceReversalLinkedList.reverseBetweenTwoMiddleNodes(null, 2,4));

        /* 3. Reverse every K nodes in the list, and leave out rest.*/
        System.out.println(F_InPlaceReversalLinkedList.reverseEveryKNodes(null, 2));
        System.out.println(F_InPlaceReversalLinkedList.reverseEveryKNodes(null, 3));

        /* 4. Reverse alternate K nodes in a Singly Linked List */
        System.out.println(F_InPlaceReversalLinkedList.reverseEveryKAlternateNodes(null, 3));

        /* 5. Rotate List to right by k nodes */
        System.out.println(F_InPlaceReversalLinkedList.rotateListToRightByKNodes(null, 3));


        //-----------------------------Tree BFS ----------------------------
        /**
         * Pattern: Tree Breadth First Search (9)
         * 1. Binary Tree Level Order Traversal (easy): LC 102
         * 2. Reverse Level Order Traversal (easy): LC 107
         * 3. Zigzag Traversal (medium): LC 103
         * 4. Level Averages in a Binary Tree (easy): LC 637
         * 5. Minimum Depth of a Binary Tree (easy): LC 111, LC 104
         * 6. Level Order Successor (easy): new ( link )
         * 7. Connect Level Order Siblings (medium): LC 117
         * 8. Problem Challenge 1: new ( link )
         * 9. Problem Challenge 2: LC 199
         */


        //-----------------------------Tree DFS ----------------------------

        /**
         * Pattern: Tree Depth First Search (7)
         * 1. Binary Tree Path Sum (easy): LC 112
         * 2. All Paths for a Sum (medium): LC 113, LC 257, new ( link )
         * 3. Sum of Path Numbers (medium): LC 129
         * 4. Path With Given Sequence (medium): LC 1430
         * 5. Count Paths for a Sum (medium): LC 437
         * 6. Problem Challenge 1: LC 543
         * 7. Problem Challenge 2: LC 124
         */

        //-----------------------------Two Heaps ----------------------------

        /**
         * Pattern: Two Heaps (4)
         * 1. Find the Median of a Number Stream (medium): LC 295
         * 2. Sliding Window Median (hard): LC 480
         * 3. Maximize Capital (hard): LC 502
         * 4. Problem Challenge 1: LC 436
         */

        //-----------------------------Subsets ----------------------------
        /**
         * Pattern: Subsets (9)
         * 1. Subsets (easy): LC 78
         * 2. Subsets With Duplicates (easy): LC 90
         * 3. Permutations (medium): LC 46
         * 4. String Permutations by changing case (medium): LC 784
         * 5. Balanced Parentheses (hard): LC 22
         * 6. Unique Generalized Abbreviations (hard): LC 320
         * 7. Problem Challenge 1: LC 241
         * 8. Problem Challenge 2: LC 95
         * 9. Problem Challenge 3: LC 96
         /


         //-----------------------------Modified Binary Search ----------------------------

         /**
         * Pattern: Modified Binary Search (10)
         * Order-agnostic Binary Search (easy): new (Approach 1 in link )
         * Ceiling of a Number (medium): new ( link )
         * Next Letter (medium): LC 744
         * Number Range (medium): LC 34
         * Search in a Sorted Infinite Array (medium): LC 702
         * Minimum Difference Element (medium): LC 658 (k == 1)
         * Bitonic Array Maximum (easy): new ( link )
         * Problem Challenge 1: new ( link )
         * Problem Challenge 2: LC 33, LC 81
         * Problem Challenge 3: LC 153, LC 154
         */


        //----------------------------- Bitwise XOR ----------------------------

        /**
         * Pattern: Bitwise XOR (4)
         * Single Number (easy): LC 136
         * Two Single Numbers (medium): LC 260
         * Complement of Base 10 Number (medium): LC 476
         * Problem Challenge 1: LC 832
         */


        //----------------------------- Top 'K' Elements  ----------------------------
        /**
         * Pattern: Top 'K' Elements (14)
         * Top 'K' Numbers (easy): new ( link )
         * Kth Smallest Number (easy): LC 215 (smallest instead of largest)
         * K' Closest Points to the Origin (easy): LC 973
         * Connect Ropes (easy): LC 1167
         * Top 'K' Frequent Numbers (medium): LC 347
         * Frequency Sort (medium): LC 451
         * Kth Largest Number in a Stream (medium): LC 703
         * K' Closest Numbers (medium): LC 658
         * Maximum Distinct Elements (medium): new ( link )
         * Sum of Elements (medium): new ( link )
         * Rearrange String (hard): LC 767
         * Problem Challenge 1: LC 358
         * Problem Challenge 2: LC 621
         * Problem Challenge 3: LC 895
         */


        //----------------------------- K-way merge----------------------------
        /**
         * Pattern: K-way merge (5)
         * Merge K Sorted Lists (medium): LC 23
         * Kth Smallest Number in M Sorted Lists (Medium): new ( link )
         * Kth Smallest Number in a Sorted Matrix (Hard): LC 378
         * Smallest Number Range (Hard): LC 632
         * Problem Challenge 1: LC 373 (largest sum instead of smallest sum)
         * Pattern : 0/1 Knapsack (Dynamic Programming) (6)
         * 0/1 Knapsack (medium): new ( link )
         * Equal Subset Sum Partition (medium): LC 416
         * Subset Sum (medium): new ( link )
         * Minimum Subset Sum Difference (hard): new ( link )
         * Problem Challenge 1: new ( link )
         * Problem Challenge 2: LC 494
         */

        //----------------------------- Topological Sort (Graph) ----------------------------

        /**
         * Pattern: Topological Sort (Graph) (7)
         * Topological Sort (medium): new ( link )
         * Tasks Scheduling (medium): LC 207
         * Tasks Scheduling Order (medium): LC 210
         * All Tasks Scheduling Orders (hard): LC 210 (output all possible solutions)
         * Alien Dictionary (hard): LC 269
         * Problem Challenge 1: LC 444
         * Problem Challenge 2: LC 310
         * Miscellaneous (1)
         * Kth Smallest Number (hard): LC 215 (smallest instead of largest)
         */
    }


}
