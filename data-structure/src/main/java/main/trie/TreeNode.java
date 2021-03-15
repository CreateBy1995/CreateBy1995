package main.trie;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-02-23
 **/
@Data
@AllArgsConstructor
public class TreeNode {
    // 子节点列表
    private Map<Character, TreeNode> childrenNodeMap;
    // 节点值
    private Character value;
    // 是否最后一个字符
    private Boolean isEnd;

    public TreeNode() {
        childrenNodeMap = new HashMap<>();
        isEnd = false;
    }

    public TreeNode(Character value) {
        this.value = value;
        childrenNodeMap = new HashMap<>();
        isEnd = false;
    }
}
