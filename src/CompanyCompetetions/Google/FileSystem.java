package CompanyCompetetions.Google;


public class FileSystem {

    public class Files {
        String fileName;
        int length;
        int noOfSpaces;

        Files(String file, int lengthIn, int noOfSpacesIn) {
            this.fileName = file;
            this.length = lengthIn;
            this.noOfSpaces = noOfSpacesIn;
        }
    }
    private java.util.Stack<Files> filesStack = new java.util.Stack<>();
    public int solution(String S) {
        int sum = -1;
        String[] hierarchy = S.split("\n");
        int noOfSpaces = getNumberOfSpaces(hierarchy[0]); //hierarchy[0].length() - hierarchy[0].trim().length();
        Files file = new Files(hierarchy[0], hierarchy[0].trim().length() + 1, noOfSpaces);
        filesStack.push(file);

        for(int i = 1; i < hierarchy.length; i++) {
            //push
            if(noOfSpaces < getNumberOfSpaces(hierarchy[i])) {
                noOfSpaces = getNumberOfSpaces(hierarchy[i]);
                filesStack.push(new Files(hierarchy[i], filesStack.peek().length + hierarchy[i].trim().length() + 1, noOfSpaces));
            } else {
                while(!filesStack.isEmpty() && filesStack.peek().noOfSpaces >= getNumberOfSpaces(hierarchy[i])) {
                    filesStack.pop();
                }
                noOfSpaces = getNumberOfSpaces(hierarchy[i]);
                if(filesStack.empty())
                    filesStack.push(new Files(hierarchy[i], hierarchy[i].trim().length() + 1, noOfSpaces));
                else
                    filesStack.push(new Files(hierarchy[i], filesStack.peek().length + hierarchy[i].trim().length() + 1, noOfSpaces));
            }
            if (hierarchy[i].contains(".gif") || hierarchy[i].contains(".jpeg")) {
                if(sum < filesStack.peek().length - hierarchy[i].trim().length() - 1) {
                    sum = filesStack.peek().length - hierarchy[i].trim().length() - 1;
                }
                if(sum < filesStack.peek().length - hierarchy[i].trim().length() - 1) {
                    sum = filesStack.peek().length - hierarchy[i].trim().length() - 1;
                }
            }
        }
        return sum;
    }
    private static int getNumberOfSpaces(String string){
        return string.length() - string.trim().length();
    }

    private static int getNumberOfSpaces(String string1, String string2){
        return string1.length() - string2.trim().length();
    }



    public static void main(String args[]) {
        FileSystem s = new FileSystem();
        String S = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
        System.out.print(s.solution(S));
    }

}