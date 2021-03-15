package main.trie;

import lombok.Data;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-02-23
 **/
@Data
public class TrieTree {
    private TreeNode rootNode = new TreeNode();

    public void insert(String strValue) {
        // 1.字符串数组
        char[] charArray = strValue.toCharArray();
        TreeNode currentNode = rootNode;
        for (int i = 0; i < charArray.length; i++) {
            // 3.判断字符是否存在
            if (!currentNode.getChildrenNodeMap().containsKey(charArray[i])) {
                // 3-1.如果不存在则创建
                TreeNode nextNode = new TreeNode(charArray[i]);
                currentNode.getChildrenNodeMap().put(charArray[i], nextNode);
            }
            // 3-2.如果存在则继续查找下一个字符，
            currentNode = currentNode.getChildrenNodeMap().get(charArray[i]);
        }
        currentNode.setIsEnd(true);
    }

    public String findMaxPrefix() {
        StringBuilder maxPreFix = new StringBuilder();
        // 1.如当前节点存在多个子节点，则搜索完毕，输出现有字符串
        TreeNode currentNode = rootNode;
        // 2.如果当前节点存在多个子节点，则搜索下一个节点
        while (currentNode.getChildrenNodeMap().size() == 1) {
            currentNode = currentNode.getChildrenNodeMap().values().stream().findFirst().get();
            maxPreFix.append(currentNode.getValue());
            if (currentNode.getIsEnd()) {
                break;
            }
        }
        return maxPreFix.toString();
    }
}
