package DataStructure.MyDataStructures.Stacks;


/**
 * Created by Nikhi on 12/14/2016 2:50 AM.
 */
public class Client {
    public static void main(String[] args) {
        String testBracket = "asdq()[asdaj](((";            //Not balanced
        String testBracket1 = "asdq()[asdaj]((()))";        //balanced
        String testBracket2 = "}asdq()[asdaj]((())){";      //not balancecd
        String empytyString ="";
        //Working!
        System.out.println("Using Array, Testing");
        System.out.println(testBracket + " has "+ (MyArrayStack.hasMatchingBrackets(testBracket)? " Balanced Brackets" : "Brackets not balanced"));
        System.out.println(testBracket1 +" has "+ (MyArrayStack.hasMatchingBrackets(testBracket1)? "Balanced Brackets " : "Brackets not balanced"));
        System.out.println(testBracket2 +" has "+ (MyArrayStack.hasMatchingBrackets(testBracket2)? "Balanced Brackets " : "Brackets not balanced"));
        System.out.println(empytyString +" has "+ (MyArrayStack.hasMatchingBrackets(empytyString)? "Balanced Brackets " : "Brackets not balanced"));
        //Working!
        System.out.println("Using MyLinkedList, Testing");
        System.out.println(testBracket + " has "+ (MyLinkedListStack.hasMatchingBrackets(testBracket)? " Balanced Brackets" : "Brackets not balanced"));
        System.out.println(testBracket1 +" has "+ (MyLinkedListStack.hasMatchingBrackets(testBracket1)? "Balanced Brackets " : "Brackets not balanced"));
        System.out.println(testBracket2 +" has "+ (MyLinkedListStack.hasMatchingBrackets(testBracket2)? "Balanced Brackets " : "Brackets not balanced"));
        System.out.println(empytyString +" has "+ (MyLinkedListStack.hasMatchingBrackets(empytyString)? "Balanced Brackets " : "Brackets not balanced"));

        //Test for htmlTag
        String html1 ="<body><h1>Nikhil You are doing good </h1></body>";
        System.out.println("Test Using Arraybased MyStack");
        System.out.println(MyArrayStack.matchHTMLTags(html1) ? "Has Matching Tags" : "Doesnt have matching tags");
        System.out.println("Test Using MyLinkedListStack");
        System.out.println(MyLinkedListStack.matchHTMLTags(html1)? "Has Matching Tags" : "Doesnt have matching tags");

        //Testing LinkedStack first remove or last remove.
        System.out.println("First or Last popping test");
        MyLinkedListStack<Integer> linkedListStack = new MyLinkedListStack<>();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);
        System.out.println(linkedListStack.toString());

        //ArrayList stack test
        MyArrayListStack<Integer> stackArrayList = new MyArrayListStack<>(10);
        stackArrayList.push(1);
        stackArrayList.push(2);
        stackArrayList.push(3);
        stackArrayList.push(4);
        System.out.println(stackArrayList.toString());
        System.out.println("Remving top");
        stackArrayList.pop();
        System.out.println(stackArrayList.toString());
        System.out.println("Remving top");
        stackArrayList.pop();
        System.out.println("Remving top");
        stackArrayList.pop();
        System.out.println("Remving top");
        stackArrayList.pop();
        System.out.println(stackArrayList.toString());

        System.out.println("Remving top");          //bound?
        //stackArrayList.pop();
        System.out.println(stackArrayList.toString());


        //RemoveAll Test
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        stack.push(1);         stack.push(2);          stack.push(3);         stack.push(4);        stack.push(5);
        stack.push(6);         stack.push(7);
        stack.removeAll();
        System.out.println(stack.toString());

    }
}
