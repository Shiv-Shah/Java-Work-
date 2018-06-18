import java.util.*;
import java.lang.*;
/**
 *  Implements a Binary Search Tree
 *
 * @author     G. Peck
 * @created    July 2, 2003
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */

public class BinarySearchTreeStrings{
    private TreeNode myRoot;

    public BinarySearchTreeStrings()
    {
        myRoot = null;
    }

    public void insert(Comparable next)
    {
        //         post: next added to tree so as to preserve binary search tree
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

    private TreeNode insertHelper(TreeNode root, Comparable next)
    {
        //         pre : root points to a binary search tree
        //         post: next added to tree so as to preserve binary search tree
        if(next.compareTo((String)root.getValue())<0)        
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

    public Object find(Comparable target)
    {
        if(target != null )
        {
            return (Comparable)findHelper(myRoot, target);
        }
        else
        {
            throw new NoSuchElementException();
        }

    }

    private Object findHelper(TreeNode root, Comparable target)
    {
        if(root != null)
        {
            if(target.compareTo((String)root.getValue()) == 0)
            {
                return(root.getValue());
            }
            else if(target.compareTo((String)root.getValue()) < 0)
            {                                
                return findHelper(root.getLeft(),target);                
            }
            else
            {
                return findHelper(root.getRight(),target);                
            }
        }
        return null;
    }

    public int countNodes()
    {
        int count = 0;
        count = countNodesHelper(myRoot);
        return count;
    }

    private int countNodesHelper(TreeNode root)
    {
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

    public void printInorder()
    {
        //         post: prints the data fields of the tree, one per line  
        printInorderHelper(myRoot);
    }

    private void printInorderHelper(TreeNode root)
    {
        //         pre : root points to a binary search tree
        //         post: prints the data fields of the tree using an inorder traversal  
        if (root != null) {
            printInorderHelper (root.getLeft());
            System.out.print(root.getValue() + ", ");
            printInorderHelper (root.getRight());

        }
    }

    public void printPreorder()
    {
        //         post: prints the data fields of the tree, one per line  
        printPreorderHelper(myRoot);
    }

    private void printPreorderHelper(TreeNode root)
    {
        //         pre : root points to a binary search tree
        //         post: prints the data fields of the tree using an inorder traversal  
        if (root!= null) {
            System.out.print(root.getValue() + ", ");
            printPreorderHelper (root.getLeft());
            printPreorderHelper (root.getRight());
        }
    }

    public void printPostorder(){
        //         post: prints the data fields of the tree, one per line  
        printPostorderHelper(myRoot);
    }

    private void printPostorderHelper(TreeNode root)
    {
        // pre : root points to a binary search tree
        //post: prints the data fields of the tree using an inorder traversal  
        if (root != null) {
            printPostorderHelper (root.getLeft());            
            printPostorderHelper (root.getRight());
            System.out.print(root.getValue() + ", ");
        }

    }

    public void delete(Comparable target)
    {
        // post: deletes a node with data equal to target, if present,
        // preserving binary search tree property
        if(target != null)
            myRoot = deleteHelper(myRoot, target);
        else
            throw new NoSuchElementException();
    }

    private TreeNode deleteHelper(TreeNode node, Comparable target)
    {
        // pre : node points to a non-empty binary search tree
        // post: deletes a node with data equal to target, if present,
        //preserving binary search tree property  
        if(node != null)
        {
            if(target.equals(node.getValue()))
            {
                return deleteTargetNode(node);
            }
            else if(target.compareTo((String)node.getValue()) < 0)
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
        return myRoot;
    }

    private TreeNode deleteTargetNode(TreeNode target)
    {
        // pre : target points to TreeNode to be deleted
        //post: returns a reference to a subtree with the target
        //TreeNode removed or null if the TreeNode is a leaf
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

    //     private TreeNode deleteTargetNode(TreeNode target){
    //         // pre : target points to TreeNode to be deleted
    //         // post: returns a reference to a subtree with the target
    //         //       TreeNode removed or null if the TreeNode is a leaf
    // 
    //     }

    public int countLeaves()
    {
        return countLeaves(myRoot);
    }

    private int countLeaves (TreeNode root)
    {
        //if (root != null)
        //             if(root.getLeft() != null && root.getRight() != null)
        //             {
        //                 countLeaves (root.getLeft());
        //                 countLeaves (root.getRight());
        //             }
        //             else if(root.getLeft() != null && root.getRight() == null)
        //             {
        //                  countLeaves (root.getLeft());
        //             }
        //             else if(root.getLeft() == null && root.getRight() != null)
        //             {
        //                 countLeaves (root.getRight());
        //             }
        //             else
        //             {
        //                 
        //             }
        // }
        if(root!=null)
        {
            if (root.getLeft() == null && root.getRight() ==null) 
            {
                return 1;
            }
            else
            {
                return (countLeaves(root.getRight()) +countLeaves(root.getLeft()));
            }
        }
        return 0;
    }

    public int height()
    {
        return  height(myRoot);
    }

    private int height (TreeNode root)
    {
        // for each row in this tree you want to add 1
        //         if (root == null) {
        //             return 1;
        //         }
        //         else
        //         {
        //             return countLeaves(root.getRight())+1);
        //         }
        if (root != null)
        {
            if(root.getRight() != null || root.getLeft() !=null)
            {
                return 1 + max(height(root.getLeft()),height(root.getRight()));
            }
            else if(root.getRight() == null || root.getLeft() !=null)
            {
                return 1 + height(root.getLeft());
            }
            else if(root.getRight() != null || root.getLeft() ==null)
            {
                return 1 + height(root.getLeft());
            }
            else 
            {
                return 1;
            }
        }
        return 0;
    }

    public int width()
    {
        return width(myRoot);
    }

    private int width (TreeNode root)
    {
        if (root != null)
        {
            int compare = (height(root.getRight()) + height(root.getLeft()) + 1); // this is the root Nodes Width
            if(root.getRight() != null || root.getLeft() !=null)
            {
                int down = max(width (root.getRight()), width(root.getLeft())); // return the max width compare the 2 widths
                return max(compare,down);
            }
            else if(root.getRight() != null || root.getLeft() ==null)
            {
                return  width(root.getLeft());
            }
            else if(root.getRight() == null || root.getLeft() !=null)
            {
                return width(root.getRight());
            }
            else
            {
                return 1 + height(root.getRight()) + height(root.getLeft());
            }
        }
        return 0;
    }

    private int max (int a, int b)
    {
        if (a < b)
            return b;
        else
            return a;
    }

    public void clearTree()
    {
        myRoot = null;
    }

    public void interchange()
    //post: tree becomes a mirror image of itself
    {
        interchange(myRoot);
    }

    private void interchange(TreeNode root)
    {
        TreeNode temp;
        if (root!=null)
        {
            if(root.getRight() != null || root.getLeft() !=null)
            {
                temp = root.getRight();
                root.setRight(root.getLeft());
                root.setLeft(temp);
                interchange(temp);
                interchange(root.getRight());

            }
        }
    }

    public boolean isAncestor(Comparable ancestor, Comparable descendant)
    {
        //post: returns true if descendant is a "child" of ancestor; false otherwise
        //i.e., true if descendant belongs to ancestor's subtree 
        if(ancestor.equals(descendant))
            return false;
        return isAncestor(myRoot, ancestor, descendant);
    }

    public boolean isAncestor(TreeNode root, Comparable a, Comparable d)
    {
        if (findPtr(findPtr(root, a), d) != null)
            return true;
        else
            return false;
    }

    private TreeNode findPtr(TreeNode root, Comparable target)
    {
        if(root != null)
        {
            if(findHelper(root, target) !=null)
            {
                if(target.compareTo(root.getValue())== 0 )
                {
                    return root;
                }
                else if(target.compareTo(root.getValue())< 0)
                {
                    return findPtr(root.getLeft(), target);
                }
                else
                {
                    return findPtr(root.getRight(), target);
                }
            }
        }
        return null;
    }

    //     public void printLevel(int level)
    //     //post: prints the data fields of the tree, one per line
    //     {
    //         if(myRoot ==  null || height() < level || level < 0)
    //             return;
    //         else
    //         {
    //             printLevel(myRoot, level);
    //         }
    //         //     }
    //     }
    // 
    //     private void printLevel(TreeNode root, int level)
    //     {
    //         if(root == null)
    //         {
    //             return;
    //         }
    //         else if(level > 0)
    //         {
    //             printLevel(root.getLeft(),level-1);
    //             printLevel(root.getRight(),level-1);           
    //         }
    //         else
    //         {
    //             System.out.print(root.getValue() + ", ");
    //         }
    //     }

    public void printLevel()
    {
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = myRoot;
        TreeNode temp; 
        queue.add(root);
        do
        {

            temp = queue.remove();
            if(temp!=null)
            {
                System.out.print(temp.getValue() + " ");
                if (temp.getLeft()!=null)
                {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight()!=null)
                {
                    queue.add(temp.getRight());
                }
            }
            else
                return;

        }
        while(root != null&&! queue.isEmpty() );//! myStack.isEmpty()); // temp2 == 1);
    }

}