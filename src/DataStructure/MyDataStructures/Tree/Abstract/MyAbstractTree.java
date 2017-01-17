package DataStructure.MyDataStructures.Tree.Abstract;

import DataStructure.MyDataStructures.PositionalLists.Position;
import DataStructure.MyDataStructures.Tree.Interfaces.MyTree;


/** Notice this is abstract Tree class which implements trivial methods from Tree interface.
 * Created by Nikhi on 12/16/2016 3:47 AM.
 */
public abstract class MyAbstractTree<E> implements MyTree<E> {

    //Trivial methods are implemented here.
    //To implement methods here in abstract class PUBLIC keyword is must.
    public boolean isInternal(Position<E> p) throws IllegalArgumentException{
        return (numChildren(p) > 0);
    }
    public boolean isExternal(Position<E> p) throws IllegalArgumentException{
        return (numChildren(p) == 0);
    }
    public boolean isRoot(Position<E> p) throws IllegalArgumentException{
        return (p == root());
    }
    public boolean isEmpty(){
        return (size() == 0);
    }

    //Utility Methods for Abstract Tree
    //Let p be a position within tree T. The depth of p is the number of ancestors of  p, other than p itself.
    public int depth(Position<E> p){
        if(p == root()){
            return 0;
        }else{
            return 1 + depth(parent(p));
        }
    }

    //It takes n^2 time as it calls depth.
    /**
     * height of a tree to be equal to the maximum of the depths of its positions.
       It is easy to see that the position with maximum depth must be a leaf.
     */
    private int heightBad(){
        int height = 0;
        for (Position<E> p : positions()) {
            if(isExternal(p))
                height = Math.max(height, depth(p));
        }
        return height;
    }
    /**
     * Notice this is abstract class. Hence don't worry about height best implementation.
     * We can overwrite it anytime for binary Tree when Binary Tree class will extend this MyAbstractTree class.
     * calculate the height of the subtree ROOTED at that position.
     * Formally, we define the height of a position p in a tree T as follows:
        • If p is a leaf, then the height of p is 0.
        • Otherwise, the height of p is one more than the maximum of the heights of p’s children.
     */
    public int height(Position<E> p){
        int h = 0;
        for (Position<E> child: children(p)) {
            h = Math.max(h, 1+ height(child));
        }
        return h;
    }

    //Non trivial methods will go in extended class.
    //Methods like, root(), parent(), children(), size() are algorithm specific
    //Hence those will be implemented in class which extends this abstract Tree class
}
