package HackerEarth.Vai.com;

/**
 * Created by Nikhi on 10/16/2016.
 */
public class Problem3 {
}

/*
Question 3. Max. Marks 100
Bob and Alphabet
Bob has arranged
N
N boxes in a straight line. Each box has a Latin Character(′a′−′z′)(′a′−′z′) written on it. He wants to chain26
26 boxes in such a way that the chain starts from box with alphabet
′a′′a′ and contains all Latin Characters exactly once in increasing lexicographic order, ending at
′z′′z′. In other words, the chain must form the following sequence:
 ′abcdefghijklmnopqrstuvwxyz′
 ′abcdefghijklmnopqrstuvwxyz′

To join a box
bibi andbj
bj with chain, the length of the chain to be used is
|i−j||i−j|.
Help Bob to minimize the total length of the chain used to make the desired sequence.

Input Format:
First line of input contains of a single integer
T
T - the number of testcases.
Each testcase consists of a single line, which contains a string made up of lowercase Latin Characters -
′a′′a′ to′z′′z′. The string may have one or more occurrences of each character.

Output Format:
For each testcase, print a single integer - the minimum length of chain required to make the required sequence.

Input Constraints:
 1≤T≤10 1≤T≤10
 26≤|S|≤10626≤|S|≤106All 26 characters ('a' - 'z') are present inS S at least once.

Sample Input(Plaintext Link)
 2
abcdefghijklmnopqrstuvwxyz
ceaabcdefghijklmnopqrstuvwxyz
Sample Output(Plaintext Link)
 25
25
Explanation
Testcase 1:
There is only one way to connect the chain for this sequence. The chain starts from
S0 S0, then connects toS1S1, thenS2S2, ... ,S25S25, which creates the sequence′abcdefghijklmnopqrstuvwxyz′ ′abcdefghijklmnopqrstuvwxyz′. Hence, the answer for testcase 1 is
25
25 as the total length of the chain used is:
 (b0−>b1)+(b1−>b2)+...+(b24−>b25)=|0−1|+|1−2|+...+|24−25|=1+1+...+1=25.
(b0−>b1)+(b1−>b2)+...+(b24−>b25)=|0−1|+|1−2|+...+|24−25|=1+1+...+1=25.

Testcase 2:
There are several chain sequences that can possibly be made from the given sequence.
A few of them are:
1.S2−>S4−>S0−>S6−>S7−>S8−>...−>S25
S2−>S4−>S0−>S6−>S7−>S8−>...−>S25
2. S3−>S4−>S5−>S6−>...−>S25
S3−>S4−>S5−>S6−>...−>S25
Among the possible chain sequences, the sequence 2. listed above provides the minimum length of chain used.

Time Limit: 3.0 sec(s) for each input file.
Memory Limit: 512 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes.
Allowed languages: JavaReview, JavaReview 8
 */
