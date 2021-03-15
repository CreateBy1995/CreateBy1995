package main.tree;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-03-01
 **/
public class TestBinaryTree {
    public static void main(String[] args) {
        int arr[] = new int[]{6, 2, 8, 0, 4, 9, 1, 5};
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.postOrderTraversal());
        System.out.println(tree.inOrderTraversal());
    }
}
