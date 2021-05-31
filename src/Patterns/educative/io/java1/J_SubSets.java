package Patterns.educative.io.java1;

import java.util.*;

public class J_SubSets {

    public static void main(String[] args) {
        List<List<Integer>> result = J_SubSets.findSubsets(new int[] { 1, 2, 3 });
        result = J_SubSets.findSubsets2(new int[] { 1, 2, 3 });
        result = J_SubSets.findSubsets3(new int[] { 4, 2 ,3});
        System.out.println("Here is the list of subsets: " + result);

        result = J_SubSets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num: nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(subsets.get(i));
                temp.add(num);
                subsets.add(temp);
            }
        }
        return subsets;
    }


    public static List<List<Integer>> findSubsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList(), result);
        return result;
    }

    public static void generateSubsets(int index, int[] nums, List<Integer> currentList, List<List<Integer>>result){
        //add current list
        result.add(new ArrayList<>(currentList));           // add a new copy of the current as we are going to modify currentList

        // next for all elements simulate taking the number and not taking the number like a decision tree
        //depending upon the current index. Starting from index we are on in recursive call.

        //for are calling recursive method in for loop for nums.length no of times.
        //hence at each level we will have nums.length branches.
        for (int i = index; i < nums.length ; i++) {
            currentList.add(nums[i]);
            // do same for next number from array.
            generateSubsets(i + 1, nums, currentList, result);
            currentList.remove(currentList.size()-1);
        }
    }



    /*
    g->result.add( () )
            for i=0 to < length
            list.add(1) = (  1)
            g -> 0+1 -> result.add( (), (,1) )
                                 for i = 1 to < length
                                 list.add(2) = ( 1,2 )
                                 g -> 1 + 1 -> result.add( (), (1), (1,2))
                                                         for i = 2 < length
                                                         list.add(3) = (  1, 2, 3 )
                                                         g- > 2+1 -> result.add( (), (1,2), (1,2,3))
                                                                               for i = 3 < length (false)
                                                                         <-
                                                         remove (3) = ( 1,2)
                                                         for i = 3 < length (false)
                                                     <-
                                 remove (2) = (1)
                                 for i =2 to < length
                                 list.add(3) = ( 1, 3)
                                 g -> 2 + 1 -> result.add( (), (1), (1,2), (1,2,3), (1,3)
                                                        for i =3 < length (false)
                                                    <-
                                remove (3) = ( 1 )
                                for i = 3 < length (false)
                            <-
            remove (1) = ( )
            for i=1 to < length
            list.add(2)
            g -> 1+ 1 -> result.add(  (), (1), (1,2), (1,2,3), (1,3), (2) )
                                for i =2 < to length
                                list.add(3) = ( (2), (3) )
                                g -> 2+ 3 -> result.add(  (), (1), (1,2), (1,2,3), (1,3), (2), (2,3) )
                                                        for i =3 to < length (False)
                                                 <-
                                 remove(3) = list(2)
                                 for i = 3 < to length (false)
                            <-
            remove(2) = ( () )
            for i =2 to < length
            list.add(3) = ( (3) )
            g -> 2+ 1  ->    result.add(  (), (1), (1,2), (1,2,3), (1,3), (2), (2,3) , (3) )
                                        for i =3 to < length (false)
                              <-
            list.remove(3) = ( () )

     Here is the list of subsets: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

     */

    /**
     * Enumerate all Subsets of input : order doesnt matter. so 1,2 same as 2,1
     *      "abc" has subsets "a", "b", "ab", "ac"...
     *      order does not matter "ab" is same as "ba"
     *  Solving Recursively
     *      Separate one element from input
     *      can either include in current subset or not
     *      Recursively form a subset including it
     *      Recursively form subset not including it
     *      what is the base case?
     *      Remind of you any problem you have seen?
     *          same pattern often resurfaces
     *
     * Permutation/subset is all about choice
     *      both have deep /wide tree to recurse
     *      Deep represents total no of decisions made
     *      Wide of branching represents no of available options per decision
     * @param s
     * @return
     */

    public static void findSubsets2_1(String s) {
        recSubset("", s);

    }
    public static void recSubset(String soFar, String rest){
        if(rest=="") {
            System.out.println(soFar);
        } else {
                //add to subset remove from the rest, recurse
            recSubset(soFar + rest.charAt(0), rest.substring(1) );
            //don't add to subset and remove from the rest, recurse.
            recSubset(soFar , rest.substring(1) );
        }
    }
    /*
                                        subsets ( "", "abcd")
                                            /                             \
                               s("a", "bcd")                s("", "bcd")
                             /                         \
                    s("ab", "cd")               s("a","cd")
                  /                 \                 /                  \
        s("abc","d")    s("ab","d") s("ac", "d")    s("a","d")
        /               \       /           \    /               \      /            \
     abcd        abc  abd       ab acd          ac    ad            a

     left subtree is inclusion call
     right subtree is exclusion call

     Template:
         boolean solve(Configuration conf) {
            if( no more choices)  //BASE CASE
                    return (conf is a goal state);
            for( all available choices ) {
                   try one choice c;
                        //solve from here, if it works out, you are done.
                   if( solve( conf with choice c made)  ) return true;
                   unmake choice c;
            }
            return false;       //tried all choices no solution found.
         }
     */


    public static List<List<Integer>> findSubsets3(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        List<List<Integer>> resultsList = new ArrayList<>();
        int max = 1<<nums.length;
        for(int i=0; i< max; i++){
            List<Integer> list = findASubSet(i, nums);
            results.add(list);
            resultsList.add(list);
        }
        System.out.println("List - in actual binary form [000-111]" + resultsList);
        return new ArrayList<>(results);
    }
    public static List<Integer> findASubSet(int i, int[]nums){
        List<Integer> list = new ArrayList<>();
        int index = 0;
        //for every integer, number (1 to 8). e.g 4, we going to see for binary version of 4 how many 1 is there at LSB
        // we use index = 0, and increment index to fetch that number from int array
        // we use j integer, as MSB = 4 -> 4=100 & 1= 0 -> MSB j >> = 010

        // for every integer from 1 to 8, we check where we find 1 as in binary representation of that number.
        //  for write a for loop to go over that integer number, and decrement j pointer by right shift by 1.
        // and we keep track of index and increment in each iteration to see if it was 1. (add to list only when it was 1)
        for(int j=i; j>0; j>>=1){
            if((j&1)==1){                           //0=000, 1=001, 2=010 | 1&1= 001&1=1 True. | 2&1= 010&1=0 (false) | j>>=1 =1>>1=01
                list.add(nums[index]);        //i=3, 11, j=3, | 011&1=1 true -> j>>=1 100>>1= 010
            }
            index++;
        }
        return list;
    }

//-------------------------------------------------------------------------------------------------------
    //Each recursion level focuses on all the following elements. We scan through all the following elements and decide whether to choose or not choose that element. (Every level split into N branches.)

    public static List<List<Integer>> subsetsWithDupMultipleRecBranch(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos) {
        res.add(new ArrayList<>(ls));
        for(int i=pos;i<nums.length;i++) {
            if(i>pos&&nums[i]==nums[i-1]) continue;
            ls.add(nums[i]);
            helper(res,ls,nums,i+1);
            ls.remove(ls.size()-1);
        }
    }

    //Each recursion level focuses on one element, we need to decide choose or not choose this element. (Every level split into 2 branches.)
    public static List<List<Integer>> subsetsWithDup2RecBranch(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0,false);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos, boolean choosePre) {
        if(pos==nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        helper(res,ls,nums,pos+1,false);
        if(pos>=1&&nums[pos]==nums[pos-1]&&!choosePre) return;
        ls.add(nums[pos]);
        helper(res,ls,nums,pos+1,true);
        ls.remove(ls.size()-1);
    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i-1]) start = end;
            end = subsets.size();
            for (int j = start; j < end; j++) {
                List<Integer> temp = new ArrayList<>(subsets.get(j));
                temp.add(nums[i]);
                subsets.add(temp);
            }
        }
        return subsets;
    }

    public static List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }

    private static  void subsetsWithDupHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        // subset means it does not need contain all elements, so the condition is <= rather than ==
        // and do not return after this statement
        if(pos <= nums.length) res.add(new ArrayList<>(tmpRes));

        for(int i=pos; i<nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;   // avoid duplicates
            tmpRes.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------------
    /*This structure might apply to many other backtracking questions, but here I am just going to demonstrate Subsets,
     Permutations, and Combination Sum. */


     //Subsets : https://leetcode.com/problems/subsets/

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack1(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack1(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    //Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack2(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    //Permutations : https://leetcode.com/problems/permutations/

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack3(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack3(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack3(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack4(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack4(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack4(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //Combination Sum : https://leetcode.com/problems/combination-sum/

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack5(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack5(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack5(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack6(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrack6(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack6(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack7(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack7(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack7(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
