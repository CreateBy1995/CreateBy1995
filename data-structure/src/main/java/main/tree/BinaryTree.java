package main.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-02-27
 **/
@Data
public class BinaryTree {
    private Node rootNode;

    public void insert(int value) {
        rootNode = insertNode(rootNode, value);
    }

    /**
     * 节点插入
     *
     * @param currentNode 当前节点
     * @param value       当前节点对应的值
     * @return
     */
    private Node insertNode(Node currentNode, int value) {
        // 1.当前节点为空，则创建一个节点并且返回
        if (currentNode == null) {
            currentNode = new Node(value);
            return currentNode;
        }
        // 2.值大于当前节点值，则递归查询右节点
        if (value > currentNode.getValue()) {
            currentNode.setRightNode(insertNode(currentNode.getRightNode(), value));
            // 3.值大于当前节点值，则递归查询左节点
        } else if (value < currentNode.getValue()) {
            currentNode.setLeftNode(insertNode(currentNode.getLeftNode(), value));
        }
        return currentNode;
    }

    public List<Integer> preOrderTraversal() {
        List<Integer> nodeList = preOrderTraversalNode(new ArrayList<>(), rootNode);
        return nodeList;
        // 后续遍历 Subsequent
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> nodeList = postOrderTraversalNode(new ArrayList<>(), rootNode);
        return nodeList;
    }

    // 中序遍历
    public List<Integer> inOrderTraversal() {
        List<Integer> nodeList = inOrderTraversalNode(new ArrayList<>(), rootNode);
        return nodeList;
    }

    private List<Integer> inOrderTraversalNode(List<Integer> nodeList, Node currentNode) {
        // 左根右
        if (currentNode == null) {
            return nodeList;
        }
        inOrderTraversalNode(nodeList, currentNode.getLeftNode());
        nodeList.add(currentNode.getValue());
        inOrderTraversalNode(nodeList, currentNode.getRightNode());
        return nodeList;
    }

    private List<Integer> postOrderTraversalNode(List<Integer> nodeList, Node currentNode) {
        // 左右根
        if (currentNode == null) {
            return nodeList;
        }
        postOrderTraversalNode(nodeList, currentNode.getLeftNode());
        postOrderTraversalNode(nodeList, currentNode.getRightNode());
        nodeList.add(currentNode.getValue());
        return nodeList;
    }


    private List<Integer> preOrderTraversalNode(List<Integer> nodeList, Node currentNode) {
        // 根左右
        if (currentNode == null) {
            return nodeList;
        }
        nodeList.add(currentNode.getValue());
        preOrderTraversalNode(nodeList, currentNode.getLeftNode());
        preOrderTraversalNode(nodeList, currentNode.getRightNode());
        return nodeList;
    }
}
