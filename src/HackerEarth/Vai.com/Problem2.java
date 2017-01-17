package HackerEarth.Vai.com;

/**
 * Created by Nikhi on 10/16/2016.
 */
public class Problem2 {
}


/*
Question 2. Max. Marks 100
Albums
Alice loves dancing ! She is on the lookout for CD albums for her new dancing sessions. The albums may be of the same or different price. As she browses the music section of the store for new albums, she finds that there are N albums . All of the Alice's favourite albums lie in a range [L,R] (1<=L<=R<=N).

Alice wants to buy as many albums as possible. She wants to choose albums in such a way that price of each albums is evenly divisible by K, her favourite number.

Given N(number of albums) and price of each album you have to answer Q queries of form L R K where you have to tell maximum number of albums that Alice can buy in the range [L,R] and are perfectly divisible by K.

Input:

First line contain N i.e number of albums.
Next line contains N integers denoting price of each album.
Next line contains Q i.e number of queries.
Next Q line contains three integers L R K.
Output:

For each query print maximum number of albums that Alice can buy satisfying her conditions.
Constraints

1<=N<=10^5
1<=Cost of each Album<=10^4
1<=Q<=10^6
1<=L<=R<=N
1<=K<=10^4
Sample Input(Plaintext Link)
 5
1 2 3 4 5
2
1 3 2
1 5 2
Sample Output(Plaintext Link)
 1
2
Explanation
Price of albums {1 , 2 , 3 , 4 , 5}

Query 1 :- {1 3 2} she can only choose one album in the range (i.e album with price 2) such that it is divisible by 2.

Query 2 :- {1 5 2} she can choose two albums in the range (i.e album with price 2 and 4) such that both are divisible by 2.

Time Limit: 1.0 sec(s) for each input file.
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes.
Allowed languages: JavaReview, JavaReview 8
 */