package Patterns.educative.io.java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A_SlidingWindow {
    public static void main(String[] args) {

    }


    public static int findMaxSumSubArray(int k, int[] arr) {
        //Time complexity O(n)
        //Space complexity O(1)
//            long startTime = System.nanoTime();
        int start = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int end = 0; end <= arr.length - 1; end++) {
            windowSum += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[start];
                start++;
            }
        }

//            long stopTime = System.nanoTime();
//            long elapsedTime = stopTime - startTime;
//            System.out.println("elapsedTime findMaxSumSubArray: " + elapsedTime);
        return maxSum;
    }

    public static int findMaxSumSubArrayBookSolution1(int k, int[] arr) {
        //Time complexity O(n * k)
        //Space complexity O(1)
        int maxSum = 0;
        int windowSum;

        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static int findMaxSumSubArrayBookSolution2(int k, int[] arr) {
        //Time complexity O(n)
        //Space complexity O(1)
        int windowSum = 0;
        int maxSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return maxSum;
    }

    public static int findMinSubArray(int s, int[] arr) {
        //Time complexity O(n)
        //Space complexity O(1)
        int minSubArraySize = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];

            while (windowSum >= s) {
                int tempArraySize = end - start + 1;
                minSubArraySize = Math.min(tempArraySize, minSubArraySize);
                windowSum -= arr[start];
                start++;
            }
        }
        if (minSubArraySize == Integer.MAX_VALUE) return -1;
        return minSubArraySize;
    }

    public static int findMinSubArrayBookSolution(int S, int[] arr) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    static int LongestSubstringKDistinct(String str, int k) {
        //Time complexity O(n)
        //Space complexity O(k)
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        int distinct = 0;
        int windowStart = 0;
        int longestSubStr = 0;

        for (int letter = 0; letter < str.length(); letter++) {
            char character = str.charAt(letter);
            if (!charFrequencyMap.containsKey(character)) {
                if (distinct < k) {
                    charFrequencyMap.put(character, charFrequencyMap.getOrDefault(character, 0) + 1);
                    distinct++;
                } else {
                    int pointer = letter - 1;
                    longestSubStr = Math.max(longestSubStr, letter - windowStart);
                    while (distinct >= k) {
                        charFrequencyMap.put(str.charAt(pointer), charFrequencyMap.getOrDefault(str.charAt(pointer), 0) - 1);
                        if (charFrequencyMap.get(str.charAt(pointer)) == 0) {
                            charFrequencyMap.remove(str.charAt(pointer));
                            distinct--;
                            windowStart = pointer + 1;
                        } else {
                            pointer--;
                        }
                    }
                    charFrequencyMap.put(character, 1);
                    distinct++;
                }
            } else {
                charFrequencyMap.put(character, charFrequencyMap.getOrDefault(character, charFrequencyMap.get(character)) + 1);
            }
        }
        return longestSubStr;
    }

    static int LongestSubstringKDistinctBookSolution(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int start = 0, longestSubStr = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [start, windowEnd]
        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(start);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                start++; // shrink the window
            }
            longestSubStr = Math.max(longestSubStr, end - start + 1); // remember the maximum length so far
        }
        return longestSubStr;
    }

    static int maxFruitsIn2Baskets(char[] arr) {
        //Time complexity O(n)
        //Space complexity O(1)
        int baskets = 2;
        int windowStart = 0;
        int maxFruit = 0;
        int tempMaxFruit = 0;
        HashMap<Character, Integer> fruitFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);

            if (fruitFrequencyMap.size() > baskets) {
                char fruitTypeToRemove = arr[windowStart];
                while (arr[windowStart] == fruitTypeToRemove) windowStart++;
                fruitFrequencyMap.remove(fruitTypeToRemove);
            }

            tempMaxFruit = windowEnd - windowStart + 1;
            maxFruit = Math.max(maxFruit, tempMaxFruit);
        }
        return maxFruit;
    }

    static int maxFruitsIn2BasketsBookSolution(char[] arr) {
        int windowStart = 0, maxFruit = 0;
        HashMap<Character, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
        }
        return maxFruit;
    }

    static int NoRepeatSubstringProblem(String str) {
        int windowStart = 0, subStrLength = 0, tempSubStrLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            if (charIndexMap.containsKey(str.charAt(windowEnd))) {
                charIndexMap.clear();
                tempSubStrLength = windowEnd - windowStart;
                windowStart = windowEnd;
            }

            charIndexMap.put(str.charAt(windowEnd), 1);
            subStrLength = Math.max(tempSubStrLength, subStrLength);
        }
        return subStrLength;
    }

    static int NoRepeatSubstringProblemBookSolution(String str) {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    static int longestSubStringAfterReplacement2(String str, int k) {
        int counter = k, longestSubStr = 0, tempLongestSubStr = 0, windowStart = 0;
        char current = str.charAt(0);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if ((str.charAt(windowEnd) != current)) {
                counter--;
                if (counter >= 0) {
                    tempLongestSubStr = windowEnd - windowStart + 1;
                } else {
                    while (str.charAt(windowStart) == current || windowStart == windowEnd) {
                        windowStart++;
                    }
                    counter = k;
                    current = str.charAt(windowStart);
                    windowEnd = windowStart;
                }
            } else {
                tempLongestSubStr = windowEnd - windowStart + 1;
            }
            longestSubStr = Math.max(tempLongestSubStr, longestSubStr);
        }
        return longestSubStr;
    }

    static int longestSubStringAfterReplacement(String str, int k) {
        //Time complexity O(n)
        //Space complexity O(1)
        int longestSubStr = 0, windowStart = 0, replacements = 0;
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            replacements = letterFrequencyMap.get(rightChar);

            while (windowEnd - windowStart + 1 - replacements > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            longestSubStr = Math.max(windowEnd - windowStart + 1, longestSubStr);
        }
        return longestSubStr;
    }

    static int longestSubStringAfterReplacementBookSolution(String str, int k) {
        //Time complexity O(n)
        //Space complexity O(1)
        int windowStart = 0, longestSubStr = 0, maxRepeatLetterCount = 0;
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            longestSubStr = Math.max(longestSubStr, windowEnd - windowStart + 1);
        }
        return longestSubStr;
    }

    static int longestSubArrayAfterReplacement(int[] arr, int k) {
        //Time complexity O(n)
        //Space complexity O(1)
        int windowStart = 0, lengthSubArr = 0, onesRepetitions = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) onesRepetitions++;

            int totalReplacements = windowEnd - windowStart + 1 - onesRepetitions;
            if (totalReplacements > k) {
                if (arr[windowStart] == 1) onesRepetitions--;
                windowStart++;
            }

            lengthSubArr = Math.max(windowEnd - windowStart + 1, lengthSubArr);
        }
        return lengthSubArr;
    }

/*
CHALLENGE #1
 */
    static boolean stringPermutationOfAPattern(String str, String pattern) {
        boolean isPermutation = false;
        int patternLength = pattern.length(), matchingLetters = 0;
        HashMap<Character, Integer> patternMap = new HashMap<>();

        //add the characters of the pattern to the HashMap
        for (char chr : pattern.toCharArray())
            patternMap.put(chr, patternMap.getOrDefault(chr, 0) + 1);

        //loop through the string
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char letterInString = str.charAt(windowEnd);
            //checks for letters in the pattern
            if (patternMap.containsKey(letterInString) && patternMap.get(letterInString) > 0) {
                matchingLetters++;
                patternMap.put(letterInString, patternMap.get(letterInString) - 1);
                if (matchingLetters == patternLength) isPermutation = true;
            } else {
                matchingLetters = 0;
                for (char chr : pattern.toCharArray()) {
                    patternMap.put(chr, patternMap.getOrDefault(chr, 0) + 1);
                }
            }
        }
        return isPermutation;
    }

    static boolean stringPermutationOfAPatternBookSolution(String str, String pattern) {
        int windowStart = 0, matchingLetters = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matchingLetters++;
            }

            if (matchingLetters == charFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matchingLetters--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
/*
CHALLENGE #2
 */
    static ArrayList stringAnagramsOfAPattern(String str, String pattern) {
        int windowStart = 0;
        HashMap<Character, Integer> patternLetterFrequency = new HashMap<>();
        HashMap<Character, Integer> flexLetterFrequency = new HashMap<>();
        ArrayList<Integer> startingIndices = new ArrayList<>();

        //put pattern in a hashmap
        for (char c : pattern.toCharArray())
            patternLetterFrequency.put(c, patternLetterFrequency.getOrDefault(c, 0) + 1);

        //loop through and check the hashmap
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char chrRight = str.charAt(windowEnd);
            flexLetterFrequency.put(chrRight, flexLetterFrequency.getOrDefault(chrRight, 0) + 1);

            if (windowEnd - windowStart + 1 > pattern.length()) {
                char chrLeft = str.charAt(windowStart);
                flexLetterFrequency.put(chrLeft, flexLetterFrequency.getOrDefault(chrLeft, 0) - 1);
                windowStart++;
            }

            if (patternLetterFrequency.equals(flexLetterFrequency)) {
                startingIndices.add(windowStart);
            }
        }
        return startingIndices;
    }

    static ArrayList stringAnagramsOfAPatternBookSolution(String str, String pattern) {
        int windowStart = 0, matched = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        ArrayList<Integer> resultIndices = new ArrayList<Integer>();
        // our goal is to match all the characters from the map with the current window
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // decrement the frequency of the matched character
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == charFrequencyMap.size()) // have we found an anagram?
                resultIndices.add(windowStart);

            if (windowEnd >= pattern.length() - 1) { // shrink the window
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }

/*
CHALLENGE #3
 */
    static String smallesSubtringWithPattern(String str, String pattern) {
        String smallestSubStr = "";
        int windowStart = 0, startIndex = 0, endIndex = 0, smallestLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> patternLetterFreq = new HashMap<>();
        HashMap<Character, Integer> strLetterFreq = new HashMap<>();

        //initialize the HashMap
        for (char chr : pattern.toCharArray()) patternLetterFreq.put(chr, patternLetterFreq.getOrDefault(chr, 0) + 1);

        //loop to add/remove values to letterFreq
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightLetter = str.charAt(windowEnd);
            char leftLetter = str.charAt(windowStart);

            if (patternLetterFreq.containsKey(rightLetter)) {
                strLetterFreq.put(rightLetter, strLetterFreq.getOrDefault(rightLetter, 0) + 1);
            }

            if (strLetterFreq.get(leftLetter) > patternLetterFreq.get(leftLetter)) {
                strLetterFreq.put(rightLetter, strLetterFreq.getOrDefault(rightLetter, 0) - 1);
                windowStart++;
                leftLetter = str.charAt(windowStart);
                while (!patternLetterFreq.containsKey(leftLetter)) {
                    windowStart++;
                    leftLetter = str.charAt(windowStart);
                }
            }

            if (patternLetterFreq.equals(strLetterFreq)) {
                if (windowEnd - windowStart + 1 < smallestLength) {
                    startIndex = windowStart;
                    endIndex = windowEnd;
                    if (endIndex < str.length() - 1) {
                        smallestSubStr = str.substring(startIndex, endIndex + 1);
                    } else {
                        smallestSubStr = str.substring(startIndex);
                    }
                    if (smallestSubStr.length() == pattern.length()) return smallestSubStr;
                }
            }
        }
        return smallestSubStr;
    }
    static String smallesSubtringWithPatternBookSolution(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
                    matched++;
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--;
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }
        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    static List<Integer> wordsConcatenation(String str, String[] words) {
        ArrayList<Integer> concatenation = new ArrayList<>();
        Boolean prevWord0Match = false;
        Boolean prevWord1Match = false;

        for(int letter = 0; letter < str.length(); letter += 3){
            String oneWord = "";

            for (int character = letter; character < letter + 3; character++){
                oneWord += (str.charAt(character));
            }

            if (oneWord.equals(words[0])) prevWord0Match = true;
            else if (oneWord.equals(words[1])) prevWord1Match = true;

            if (prevWord0Match == true && prevWord1Match == true) {
                concatenation.add(letter - 3);
                if (oneWord.equals(words[0])) prevWord1Match = false;
                if (oneWord.equals(words[1])) prevWord0Match = false;
            }
        }
        return concatenation;
    }

    static List<Integer> wordsConcatenationBookSolution(String str, String[] words) {
        HashMap<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            HashMap<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
                    break;

                if (j + 1 == wordsCount) // store index if we have found all the words
                    resultIndices.add(i);
            }
        }
        return resultIndices;
    }
}
