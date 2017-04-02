package LeetCode.Medium;

/**
 * Created by Nikhil on 4/2/2017 1:33 PM.
 */
public class P535EncodeAndDecodeTinyURL {
    private static java.util.Map<String, String> longTinyUrl = new java.util.HashMap<>();

    public static void main(String[] args) {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String longUrl1 = "https://bone.example.net/?brother=agreement&beds=bird";
        String tinyUrl = "http://tinyurl.com/4e9iAk";

        String result = encode(longUrl);
        System.out.println(result);

        System.out.println(decode(result));

    }

    private static String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        String value = generateRandomAphaNumberic();
        String result = sb.append("http://tinyurl.com/").append(value).toString();
        longTinyUrl.put(result, longUrl);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    private static String decode(String shortUrl) {
        return longTinyUrl.get(shortUrl);
    }

    private static String generateRandomAphaNumberic() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomNumber = random.nextInt(input.length());
            sb.append(input.charAt(randomNumber));
        }

        return sb.toString();
    }
}
