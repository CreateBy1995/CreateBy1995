package main.skiplist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-01-04
 **/
@Data
@AllArgsConstructor
public class NodeIndex {
    /**
     * 指向当前索引的头节点
     */
    private SkipNode head  ;
    /**
     * 表示当前索引的层级
     */
    private int level;
}
