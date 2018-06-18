import java.util.*;
import java.io.*;

/**
 *  Implements a Binary Search Tree
 *
 * @author     G. Peck
 * @created    July 2, 2003
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */

public class BinarySearchTree{
    //
    private TreeNode myRoot;
    //     private int count2;
    public BinarySearchTree(){
        //
        myRoot = null;
        //         count2 = 0;
    }

    public void insert(Comparable next){
        // post: next added to tree so as to preserve binary search tree
        //
        if( myRoot == null)
        {
            myRoot = new TreeNode(next,null,null);          
        }        
        else if(next == null)
        {
            throw new NoSuchElementException();
        }
        else                 
            insertHelper(myRoot, next);

    }

    private TreeNode insertHelper(TreeNode root, Comparable next){
        // pre : root points to a binary search tree
        // post: next added to tree so as to preserve binary search tree
        //

        if(next.compareTo(root.getValue())<0)        
        {
            if(root.getLeft() != null)
            {

                insertHelper(root.getLeft(), next);
            }
            else
            {
                TreeNode temp = new TreeNode(next,null,null);
                root.setLeft(temp);
                return root;
            }
        }

        else
        {
            if(root.getRight() != null)
            {
                insertHelper(root.getRight(), next);
            }
            else
            {
                TreeNode temp2 = new TreeNode(next,null,null);
                root.setRight(temp2);
                return root;
            }
        }
        return null;
    }

    public Object find(Comparable target){
        // 
        if(target != null )
        {
            target = (Comparable)findHelper(myRoot, (Item)target);
        }
        return target;

    }

    private Object findHelper(TreeNode root, Comparable target){
        if(root == null)
        {
            return null;
        }
        else if(target.equals(((Item)root.getValue())))
        {
            return(root.getValue());
        }
        else if(target.compareTo(root.getValue()) < 0)
        {                                
            return findHelper(root.getLeft(),target);                
        }
        else
        {
            return findHelper(root.getRight(),target);                
        }

    }

    public int countNodes(){
        //
        int count = 0;
        count = countNodesHelper(myRoot);
        return count;
    }

    private int countNodesHelper(TreeNode root){
        //
        if (root == null) {
            //             countNodesHelper (root.getLeft());
            //             count2++;
            //             countNodesHelper (root.getRight());
            return 0;

        }
        else
        {
            return countNodesHelper(root.getRight())+ 1 +countNodesHelper(root.getLeft());
            //             countNodesHelper (root.getRight());
            //             count2++;
            //             countNodesHelper (root.getLeft());
            //             return count2;
        }

    }

    public void print(){
        // post: prints the data fields of the tree, one per line  
        //
        printInorder();
    }

    private void printInorder(){
        // pre : root points to a binary search tree
        // post: prints the data fields of the tree using an inorder traversal          //       

        //         pre : root points to a binary search tree
        //         post: prints the data fields of the tree using an inorder traversal  
        // pre : root points to a binary search tree
        // post: prints the data fields of the tree using an inorder traversal  
        //         declare a Stack of TreeNode intitalized as empty
        //         declare a temp TreeNode initialized to root
        //         do
        //         while temp is not null
        //         push a copy of temp onto the stack
        //         set temp to temp’s left subtree
        //         if the stack is not empty
        //         pop the stack into temp
        //         print the contents of temp
        //         set temp to temp’s right subtree
        //         until temp is null and the stack is empty
        Stack <TreeNode> myStack = new Stack<TreeNode>();
        TreeNode temp = myRoot;
        //int temp2 = myStack.isEmpty()?1:0;
        do
        {
            while(temp!=null)
            {
                myStack.push(temp);
                temp = temp.getLeft();
            }
            if(!myStack.isEmpty())//!myStack.isEmpty()) // temp 2 == 0)
            {
                temp = myStack.pop();
                System.out.println(temp.getValue());
                temp = temp.getRight();
            }            
        }
        while(temp != null || ! myStack.isEmpty());//! myStack.isEmpty()); // temp2 == 1);

    }

    public void delete(Comparable target){
        // post: deletes a node with data equal to target, if present,
        //       preserving binary search tree property
        // 

        myRoot = deleteHelper(myRoot, target);

    }

    private TreeNode deleteHelper(TreeNode node, Comparable target){
        // pre : node points to a non-empty binary search tree
        // post: deletes a node with data equal to target, if present,
        //       preserving binary search tree property  
        if ( node== null)
        {
            return null;
        }
        else if(target.equals(node.getValue()))
        {
            return deleteTargetNode(node);
        }
        else if(target.compareTo(node.getValue()) < 0)
        {                                
            node.setLeft(deleteHelper(node.getLeft(),target));        
            return node;
        }
        else
        {
            node.setRight(deleteHelper(node.getRight(),target));    
            return node;
        }

    }

    private TreeNode deleteTargetNode(TreeNode target){
        // pre : target points to TreeNode to be deleted
        // post: returns a reference to a subtree with the target
        //       TreeNode removed or null if the TreeNode is a leaf
        if (target.getLeft() == null) {
            return target.getRight();
        }
        else if (target.getRight() == null) {
            return target.getLeft();
        }
        else if (target.getRight().getLeft() == null) {
            target.setValue(target.getRight().getValue());
            target.setRight(target.getRight().getRight());
            return target;
        }
        else{ // left child has right child

            TreeNode marker = target.getRight();
            while (marker.getLeft().getLeft() != null)
                marker = marker.getLeft();
            target.setValue(marker.getLeft().getValue());
            marker.setLeft(marker.getLeft().getRight());
            return target;
        }
    }       

}