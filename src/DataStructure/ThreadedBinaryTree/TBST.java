package DataStructure.ThreadedBinaryTree;

//Author:   Arpan Kotecha
//Task: A Threaded binary search tree
public class TBST {
    private class treeNode {
        int entry;
        Object fullObject;
        treeNode left;
        treeNode right;
        boolean isLeftThread;
        boolean isRightThread;


        private treeNode() {
            left = null;
            isLeftThread = false;
            fullObject = null;
            int entry;
            isRightThread = false;
            right = null;
        }

        private treeNode(Object fullObject, int entry) {
            left = null;
            isLeftThread = false;
            this.fullObject = fullObject;
            this.entry = entry;
            isRightThread = false;
            right = null;
        }
    }

    public int totalNodes = 0;
    private treeNode root = null;
    private treeNode minNode = null;
    private treeNode maxNode = null;

    //Purpose:  Finds the predecessor of a key (the element that comes right before it)
    //Preconditions: none
    //PostCondition: A treeNode
    public treeNode predecessor(int key) {
        treeNode returnNode = minNode;
        boolean found = false;
        int count = 0;

        while (!found && count < totalNodes) {
            if (key > returnNode.entry) {
                if (key > returnNode.right.entry) {
                    returnNode = returnNode.right;
                } else {
                    found = true;
                }
            } else if (returnNode.isLeftThread) {
                returnNode = returnNode.left;
            } else {
                found = true;
            }
            ++count;
        }
        return returnNode;
    }

    public void insertAtLeft(treeNode node, treeNode parent) {
        if (node.entry >= minNode.entry) {
            node.left = parent.left;
        } else {
            minNode = node;
        }
        parent.left = node;
        parent.isLeftThread = true;
        node.right = parent;
    }

    //Purpose:  Finds the successor of a key (the element that comes right after the key)
    //Preconditions: none
    //PostCondition: A treeNode
    public treeNode successor(int key) {
        treeNode returnNode = minNode;
        boolean found = false;
        int count = 0;

        while (!found && count < totalNodes) {
            if (key > returnNode.entry) {
                returnNode = returnNode.right;
            } else if (key == returnNode.entry) {
                if (returnNode.isLeftThread && returnNode.left.right != returnNode) {
                    returnNode = returnNode.left;
                }
            } else {
                found = true;
            }
            ++count;
        }
        return returnNode;
    }

    public void insertAtRight(treeNode node, treeNode parent) {
        if (node.entry <= maxNode.entry) {
            node.right = parent.right;
        } else {
            maxNode = node;
        }
        parent.right = node;
        parent.isRightThread = true;

        node.left = parent;
    }

    public void insert(Object o, int key) {
        treeNode insertNode = new treeNode(o, key);
        treeNode tree = root;
        boolean found = false;

        if (totalNodes == 0) {
            root = insertNode;
            minNode = insertNode;
            maxNode = insertNode;
        } else {
            while (!found) {
                if (key < tree.entry) {
                    if (!tree.isLeftThread) {
                        insertAtLeft(insertNode, tree);
                        found = true;
                    } else {
                        tree = tree.left;
                    }
                } else {
                    if (!tree.isRightThread) {
                        insertAtRight(insertNode, tree);
                        found = true;
                    } else {
                        tree = tree.right;
                    }
                }
            }
        }
        ++totalNodes;
    }

    public Object delete(int k) {
        treeNode tree = root;
        treeNode deleteNode = null;
        treeNode replacer = null;
        treeNode prePredecessor = null;
        treeNode parent = null;

        boolean found = false;
        int count = 0;

        while (!found && count < totalNodes) {
            if (k == tree.entry) {
                deleteNode = tree;
                found = true;
            } else if (k > tree.entry) {
                parent = tree;
                tree = tree.right;
            } else {
                parent = tree;
                tree = tree.left;
            }
            ++count;
        }

        if (found) {
            if (deleteNode.left == null)            // Delete a node that does not have a predecessor (MinNode)
            {
                if (parent == null)             //What if the minNode is the root itself
                {
                    root = deleteNode.right;
                    minNode = deleteNode.right;
                    replacer = successor(deleteNode.entry);
                    replacer.left = minNode;
                } else if (deleteNode.isRightThread)//What if the minNode has a right Child/subtree
                {
                    parent.left = deleteNode.right;
                    replacer = successor(deleteNode.entry);
                    replacer.left = null;
                    minNode = replacer;
                } else                             //MinNode without any children.
                {
                    parent.left = null;
                    minNode = parent;
                }
            } else if (deleteNode.right == null)      //Delete a node that does not have any successor (MaxNode)
            {
                if (parent == null)             //What if the maxNode is the root itself
                {
                    root = deleteNode.left;
                    maxNode = deleteNode.left;
                    replacer = predecessor(deleteNode.entry);
                    replacer.right = maxNode;
                } else if (deleteNode.isLeftThread)//What if the maxNode has a left Child/subtree
                {
                    parent.right = deleteNode.left;
                    replacer = predecessor(deleteNode.entry);
                    replacer.right = null;
                    maxNode = replacer;
                } else                            //MaxNode without any children
                {
                    parent.right = null;
                    maxNode = parent;
                }
            } else if (!deleteNode.isRightThread && !deleteNode.isLeftThread)  //Deleting a leaf
            {
                if (parent.left == deleteNode) {
                    parent.left = predecessor(parent.entry);
                } else {
                    parent.right = successor(parent.entry);
                }
            } else                                      //Deleting an internal Node
            {
                if (!deleteNode.isLeftThread)      //An internal node with a right child/subtree only
                {
                    if (parent.left == deleteNode) {
                        parent.left = deleteNode.right;
                    } else {
                        parent.right = deleteNode.right;
                    }
                    replacer = successor(deleteNode.entry);
                    replacer.left = parent;
                } else if (!deleteNode.isRightThread) //An internal node with a left child/subtree only
                {
                    if (parent.left == deleteNode) {
                        parent.left = deleteNode.left;
                    } else {
                        parent.right = deleteNode.left;
                    }
                    replacer = predecessor(deleteNode.entry);
                    replacer.right = parent;
                } else                               //An internal node with both left and right subtree
                {
                    if (parent.left == deleteNode) {
                        parent.left = predecessor(deleteNode.entry);
                        parent.left.right = deleteNode.right;
                        parent.left.left = deleteNode.left;
                    } else {
                        parent.right = predecessor(deleteNode.entry);
                        parent.right.left = deleteNode.left;
                        parent.right.right = deleteNode.right;
                    }
                }
            }
        }
        --totalNodes;
        return deleteNode.fullObject;
    }

    public String inOrder(treeNode node) {
        String output = "";
        if (!node.isLeftThread && !node.isRightThread) {
            return (node.fullObject).toString() + " Data: " + node.entry + " \n";
        } else if (node.isLeftThread) {
            output += inOrder(node.left);
        }

        output += (node.fullObject).toString() + " Data: " + node.entry + " \n";

        if (node.isRightThread) {
            output += inOrder(node.right);
        }
        return output;
    }

    public String sort() {
        String output = "";
        treeNode start = minNode;

        for (int i = 0; i < totalNodes; ++i) {
            output += start.fullObject + "\n";
            start = start.right;
        }
        return output;
    }

    public void destroy() {
        root = null;
    }

    public Object find(int k) {
        treeNode tree = root;
        treeNode returnNode = null;
        Object returnObject = null;
        boolean found = false;
        int count = 0;

        while (!found && count < totalNodes) {
            if (k == tree.entry) {
                returnNode = tree;
                found = true;
            } else if (k > tree.entry) {
                tree = tree.right;
            } else {
                tree = tree.left;
            }
            ++count;
        }

        if (found) {
            returnObject = returnNode.fullObject;
        }
        return returnObject;
    }

    public String toString() {
        String output = inOrder(root);
        return output;
    }
}
