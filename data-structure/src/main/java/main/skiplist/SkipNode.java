package main.skiplist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: dongcx
 * @Description: 跳表节点
 * @Date: 2020-12-31
 **/
@Data
@AllArgsConstructor
public class SkipNode {
    /**
     * 指向下一个节点
     */
    private SkipNode nextNode;
//    /**
//     * 指向下一个层级的节点
//     */
//    private SkipNode nextLevelNode;
    /**
     * 节点key
     */
    private Integer key;
    /**
     * 节点值
     */
    private Object value;



}
