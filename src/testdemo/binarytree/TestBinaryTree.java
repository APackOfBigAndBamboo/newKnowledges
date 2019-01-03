package testdemo.binarytree;


import java.util.LinkedList;

/**
 * @author David
 * @date 2018/7/26 11:13
 * @version 1.o
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Character> binaryTree = new BinaryTree<Character>();

        //输入ABDH##I##E##CF#J##G##（#用null代替）
        LinkedList<Character> tree = new LinkedList<>();
        tree.add('A');
        tree.add('B');
        tree.add('D');
        tree.add('H');
        tree.add(null);
        tree.add(null);
        tree.add('I');
        tree.add(null);
        tree.add(null);
        tree.add('E');
        tree.add(null);
        tree.add(null);
        tree.add('C');
        tree.add('F');
        tree.add(null);
        tree.add('J');
        tree.add(null);
        tree.add(null);
        tree.add('G');
        tree.add(null);
        tree.add(null);

        TreeNode<Character> root = binaryTree.createBinaryPre(tree);

        //先序遍历（递归）
        binaryTree.printBinaryTreePreRecur(root);
        System.out.println();
        //中序遍历（递归）
        binaryTree.printBinaryTreeMidRecur(root);
        System.out.println();
        //后序遍历（递归）
        binaryTree.printBinaryTreeBacRecur(root);
        System.out.println();


        //先序遍历（非递归）
        binaryTree.printBinaryTreePreUnRecur(root);
        System.out.println();
        //中序遍历（非递归）
        binaryTree.printBinaryTreeMidUnRecur(root);
        System.out.println();
        //后序遍历（非递归）
        binaryTree.printBinaryTreeBacUnRecur(root);
        System.out.println();
        //层次遍历（非递归）
        binaryTree.printBinaryTreeLayerUnRecur(root);
        System.out.println();


    }
}
