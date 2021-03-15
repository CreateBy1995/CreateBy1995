package main.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-02-27
 **/
@Data
@AllArgsConstructor
public class Node {
    private Integer value;
    private Node leftNode;
    private Node rightNode;

    public Node(Integer value) {
        this.value = value;
    }
}
