package DataStructure.Trees.Methods;

/**
 * Created by Nikhil on 1/12/2017 1:50 AM.
 */
public class CreateATree {
}

class BinaryTree{
    Node root;

    BinaryTree(){
        root = null;
    }
    BinaryTree(int data){
        root = new Node(data);
    }
    public void insert(int data){
        if(root == null){
            root = new Node(data);
        }else{
            root = insertNode(root, data);
        }
    }
    private Node insertNode(Node root, int data){
        if(data < root.data){
            if(root.getLeft() == null){
                return root.left = new Node(data);
            }else{
                return root.left = insertNode(root.left , data);
            }
        }else if(data > root.data){
            if(root.right == null){
                return root.right = new Node(data);
            }else{
                return root.right = insertNode(root.right, data);
            }
        }
        return root;
    }

}
class Node{
    int data;
    Node left, right, parent;

    Node(int data){
        this.data = data;
        left = right = parent = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
