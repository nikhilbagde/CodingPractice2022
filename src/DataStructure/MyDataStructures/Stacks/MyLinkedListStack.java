package DataStructure.MyDataStructures.Stacks;

/**
 * Created by Nikhi on 12/14/2016 2:50 AM.
 */
public class MyLinkedListStack<E> implements MyStack<E> {
    private java.util.LinkedList<E> linkedList = new java.util.LinkedList<>();
    @Override
    public void push(E e) {
        linkedList.addFirst(e);                             //Always add at the head. IN queue we used list.addLast().
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }       //always removes element at head. In queue we do same, list.removeFirst().

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean empty() {
        return linkedList.isEmpty();
    }

    @Override
    public E peek() {
        return linkedList.peekFirst();
    }
    /*
        Bracket Matching function for stack
     */
    static boolean hasMatchingBrackets(String expression){
        final String opening = "{[(";
        final String closing = "}])";
        MyStack<Character> myStack = new MyLinkedListStack<>();

        for (char c : expression.toCharArray()) {
            if(opening.indexOf(c)!=-1){
                myStack.push(c);
            }else if(closing.indexOf(c)!= -1){
                if(myStack.empty()){
                    return false;
                }
                if (closing.indexOf(c)!= opening.indexOf(myStack.pop())){
                    return false;
                }
            }
        }
        return myStack.empty();
    }
    static boolean matchHTMLTags(String html){
        MyStack<String> myStack = new MyLinkedListStack<>();
        int start = html.indexOf('<');              //get first index of '<' character if any
        while(start!=-1){
            int end = html.indexOf('>', start+1); //find '>' after '<'
            if(end == -1) return false;           //clearly not balanced.

            String tagName = html.substring(start+1, end);      //e.g.body

            if(!tagName.startsWith("/")){           //meaning its a start Tag. Push
                myStack.push(tagName);
            }else{  //meaning it is a end tag with /at start.
                if(myStack.empty()) return false;     //before me find match myStack is empty. Not balanced.

                if(!tagName.substring(1).equals(myStack.pop())){  //get tagName of end without '/' hence subString(1)
                    return false;
                }
            }
            start = html.indexOf('<', end+1);
        }
        return myStack.empty();
    }

    @Override
    public String toString() {
        return "MyLinkedListStack{" +
                "linkedList=" + linkedList +
                '}';
    }
}
