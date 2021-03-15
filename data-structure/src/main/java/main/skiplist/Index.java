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
public class Index {
    /**
     * 节点指针
     */
    private SkipNode skipNode;
    /**
     * 下一个索引指针
     */
    private Index next;
    /**
     * 下一层索引指针
     */
    private Index nextLevel;
    /**
     * 当前层级
     */
    private Integer level;
}
