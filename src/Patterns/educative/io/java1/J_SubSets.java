package Patterns.educative.io.java1;

import java.util.*;


public class J_SubSets {
    static class TreeNode2 {
        int val;
        TreeNode2 left;
        TreeNode2 right;

        TreeNode2(int x) {
            val = x;
        }
    }

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

    public static List<List<Integer>> subsetsWithDupDfs(int[] nums) {
        Arrays.sort(nums);      // SORT the array
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        helper(0, nums,currentList, res);
        return res;
    }
    public static void helper(int index, int[] nums, List<Integer> currentList, List<List<Integer>> res ) {
        res.add(new ArrayList<>(currentList));
        for(int i=index ; i<nums.length ; i++) {
            if(i > index && nums[i]==nums[i-1] ) continue; //to use this we need to make sure array is sorted.
            currentList.add(nums[i]);
            helper(i+1, nums, currentList, res);
            currentList.remove(currentList.size()-1);       // to backtrack other solutions
        }
    }
    public static List<List<Integer>> subsetsWithDupBitMaks(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();        // making it a set instead of list, to avoid duplicate list
        Arrays.sort(nums);      //need to SORT
        int max = 1 << nums.length;
        for(int i =0;i < max; i++){
            result.add(findSubSetForCurrentNum(i, nums));
        }
        return new ArrayList<>(result);     //return it as List<List<Integer>> instead of Set<List<Integer>> just by copying set to new list.
    }

    public static List<Integer> findSubSetForCurrentNum (int num, int[] nums){
        List<Integer> list = new ArrayList<>();
        int msbIndex = 0;
        for(int msb = num; msb>0; msb>>=1){
            if( (msb&1)==1){
                list.add(nums[msbIndex]);
            }
            msbIndex++;
        }
        return list;
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

    public static List<List<Integer>> subsetsWithDupIterative(int[] nums) {
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

    // 3. Permutation  -- DFS
    public static List<List<Integer>> findPermutationsDFS(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        boolean [] used = new boolean[nums.length];

        dfs(nums, used, currentList, result);
        return result;
    }
    private static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        // compare to combination here we don't directly add the current list, as in permutation we don't add blank list.
        // in permutation we keep same size, hence we need to check for size condition as base condition
        // Also in combination we used to pass index as zero as start, but here we dont pass it.
        // that index is incremented in every recursive call, and for loop starts with that index till length, which acts as a base condition.
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;             // DONT FORGET THIS.
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // here we use this boolean array, using same index we are working on.  if its already added then don't add it again.
            used[i] = true; // mark it as used in a sample case.
            list.add(nums[i]);      // same as combination logic, add current element in current list.
            dfs(nums, used, list, res); // call recursion and here we don't use index, but used array will act as checker.
            list.remove(list.size()-1);         // after element is considers in sample case, we need to remove it, so that we can perform other permutation
            used[i] = false;    // also mark it as false after removing, as for other cases we need that as pre condition of false.
        }
    }
    public static List<List<Integer>> findPermutationsDFS2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack0(list, new ArrayList<>(), nums);
        return list;
    }
    private static void backtrack0(List<List<Integer>> result, List<Integer> currentList, int [] nums){
        if(currentList.size() == nums.length){                 // for permutation we are checking the exact nums length before adding to solution result.
            result.add(new ArrayList<>(currentList));       // add copy of currentList
        } else{
            for(int i = 0; i < nums.length; i++){
                if(currentList.contains(nums[i])) continue; // element already exists, skip
                currentList.add(nums[i]);
                backtrack3(result, currentList, nums);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    public static List<List<Integer>> findPermutationsBFS(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        for (int num : nums) {
            int size = queue.size();
            while (size > 0) {
                size--;
                List<Integer> temp = queue.poll();
                int n = temp.size();
                for (int i = 0; i <= n; i++) {
                    List<Integer> newTemp = new ArrayList<>(temp);
                    newTemp.add(i, num);
                    if (newTemp.size() == nums.length) result.add(newTemp);
                    else queue.add(newTemp);
                }
            }
        }
        return result;
    }

    public static List<String> findLetterCaseStringPermutationsDFS(String str) {
        List<String> result = new ArrayList<>();
        dfs(0, new String(), str, result);
        return result;
    }

    private static void dfs(int index, String currString, String input, List<String> result ) {
        if (currString.length() == input.length()) {
            result.add(currString);
            return;     // don't forget to add return statement here. even though  its void.  Array out of bound exception
        }
        char c = input.charAt(index);
        if (!Character.isLetter(c)) {
            currString += c;
            dfs(index+1, currString, input, result);
        } else {        // for same character we need to simulate upper and lower, so call 2 times for same character.
            String s1 = currString + Character.toUpperCase(c);
            String s2 = currString + Character.toLowerCase(c);
            dfs(index+1, s1, input, result);
            dfs(index+1, s2, input, result);
        }
    }
    public static List<String> findLetterCaseStringPermutationsDFSFastest(String S) {
        List<String> ans = new ArrayList<>();
        dfs(S.toLowerCase().toCharArray(), ans, 0, S.length());
        return ans;
    }
    public  static  void dfs(char[] chArr, List result, int index, int len) {       //instead of input only length is passed with and char Array of given string
        if (index < len) {

            dfs(chArr, result, index+1, len);       //for numbers and lower case same call.

            if (Character.isLetter(chArr[index])) {
                chArr[index] = Character.toUpperCase(chArr[index]); // instead of generating new string stored at same index of charArray

                dfs(chArr, result, index+1, len);

                chArr[index] = Character.toLowerCase(chArr[index]); // changing back to lower case after recursion.
            }
        } else result.add(new String(chArr));
    }

    public static List<String> generateValidParentheses1(int n) {
        List<String> ans = new ArrayList<>();
        int openParaCount = 0;
        int closeParaCount = 0;
        backtrack(ans, new StringBuilder(), openParaCount, closeParaCount, n);
        return ans;
    }

    public static void backtrack(List<String> result, StringBuilder cur, int openPara, int closePara, int maxCount){
        if (cur.length() == maxCount * 2) {
            result.add(cur.toString());
            return;
        }

        if (openPara < maxCount) {       // do till { left para = maxCount length.  lets say n.  ((((  once done, we need to add right para )))) = both adds to 2n
            cur.append("(");
            backtrack(result, cur, openPara+1, closePara, maxCount);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (closePara < openPara) {     // this is to match left para. eventually both will be equal and = 2n.
            cur.append(")");
            backtrack(result, cur, openPara, closePara+1, maxCount);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public static List<String> generateValidParentheses2(int num) {
        List<String> result = new ArrayList<>();
        dfs(result, new String(), 0, 0, num);
        return result;
    }
    private static void dfs(List<String> result, String s, int left, int right, int num) {
        if (left == num) {
            while (right++ < num) s += ")";
            result.add(s);
            return;
        }
        String s1 = s+"(";
        String s2 = s+")";
        if (left == right) dfs(result, s1, left+1, right, num);
        else {
            dfs(result, s1, left+1, right, num);
            dfs(result, s2, left, right+1, num);
        }
    }



    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        dfs(result, word, 0, new String(), 0);
        return result;
    }
    private static void dfs(List<String> result, String word, int index, String s, int num) {
        if (index == word.length()) {
            result.add(s);
            return;
        }
        if (num != 0) {
            int temp = s.length()-1;
            while (temp >= 0 && Character.isDigit(s.charAt(temp))) temp--;
            dfs(result, word, index+1, s.substring(0,temp+1)+(num+1), num+1);
            dfs(result, word, index+1, s+word.charAt(index), 0);
        } else {
            dfs(result, word, index+1, s+word.charAt(index), 0);
            dfs(result, word, index+1, s+"1", 1);
        }
    }

    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        // TODO: Write your code here
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = new ArrayList<>(diffWaysToEvaluateExpression(input.substring(0,i)));
                List<Integer> right = new ArrayList<>(diffWaysToEvaluateExpression(input.substring(i+1)));
                for (int l: left) {
                    for (int r: right) {
                        switch (c) {
                            case '+':
                                result.add(l+r);
                                break;
                            case '-':
                                result.add(l-r);
                                break;
                            case '*':
                                result.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        return result;
    }



    public static List<TreeNode2> findUniqueTrees(int n) {
        List<TreeNode2> result = new ArrayList<>();
        return generate(1,n);
    }

    private static List<TreeNode2> generate(int start, int end) {
        List<TreeNode2> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode2> left = new ArrayList<>(generate(start, i - 1));
            List<TreeNode2> right = new ArrayList<>(generate(i + 1, end));
            for (TreeNode2 l : left) {
                for (TreeNode2 r : right) {
                    TreeNode2 temp = new TreeNode2(i);
                    temp.left = l;
                    temp.right = r;
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static int countTrees(int n) {
        // TODO: Write your code here
        if (n <= 0) return 0;
        return count(1,n);
    }

    private static int count(int start, int end) {
        if (start > end) return 1;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int left = count(start, i-1);
            int right = count(i+1, end);
            sum += left*right;
        }
        return sum;
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static int numTrees(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n <= 0) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i-1) * numTrees(n-i);
        }
        map.put(n, sum);
        return sum;
    }
//---------------------------------------------------------------------------------------------------------------------------------------
    /*This structure might apply to many other backtracking questions, but here I am just going to demonstrate Subsets,
     Permutations, and Combination Sum. */

    // 1. Subsets : https://leetcode.com/problems/subsets/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private static void backtrack1(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack1(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //2. Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack2(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //3. Permutations : https://leetcode.com/problems/permutations/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack3(list, new ArrayList<>(), nums);
        return list;
    }
    private static void backtrack3(List<List<Integer>> list, List<Integer> tempList, int [] nums){
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

    //4. Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack4(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    private static void backtrack4(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
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

    //5. Combination Sum : https://leetcode.com/problems/combination-sum/
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack5(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
    private static void backtrack5(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
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

    //6. Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack6(list, new ArrayList<>(), nums, target, 0);
        return list;

    }
    private static void backtrack6(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
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

    //7. Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack7(list, new ArrayList<>(), s, 0);
        return list;
    }
    public static void backtrack7(List<List<String>> list, List<String> tempList, String s, int start){
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
    public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
