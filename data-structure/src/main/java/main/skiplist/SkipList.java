//package main.skiplist;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//import java.util.Random;
//
///**
// * @Author: dongcx
// * @Description: 跳表
// * @Date: 2020-12-31
// **/
//@Data
//public class SkipList {
//    /**
//     * 最高层级限定
//     */
//    private final int MAX_LEVEL = 32;
//    /**
//     * 当前层级
//     */
//    private int currentLevel;
//    /**
//     * 指向当前索引
//     */
//    private NodeIndex nodeIndex;
//    /**
//     * 头节点
//     */
//    private SkipNode headNode;
//    /**
//     * 头节点
//     */
//    private Index head;
//    /**
//     * 零节点
//     */
//    private final SkipNode NIL_NODE = new SkipNode(null, null, null, null);
//    private Random random;
//
//    public SkipList() {
//        init();
//    }
//
//
//    /**
//     * 跳表初始化函数
//     */
//    public void init() {
//        this.currentLevel = 1;
//        this.nodeIndex = new NodeIndex(NIL_NODE, 1);
//        this.head = new Index(new SkipNode(null, null, null), null, null, 1);
//        this.random = new Random();
//    }
//
//    /**
//     * 添加一个值到跳表中
//     *
//     * @param value
//     * @return
//     */
//    public void put(int key, Object value) {
//        // 1.确定插入层级
//        // 2.从当前跳表中寻找最接近这个key的node(preNode),并且记录需要修改指针的索引
//        // 3.将key构建为一个node(currentNode)
//        // 4.指针指向转移  由 preNode -> nextNode 变为 preNode -> currentNode -> nextNode
//        // 5.构建普通索引 普通索引数量 = 插入层级
//        // 6.构建头索引  头索引数量 = 插入层级 - 当前跳表层级
//        // 7.修改之前记录的需要修改指针的索引
////        int insertLevel = determineInsertLevel(MAX_LEVEL);
////        int arrayLength = insertLevel > head.getLevel() ? head.getLevel() : insertLevel;
////        Index[] updateIndex = new Index[arrayLength];
////        SkipNode skipNode = findInsertPosition(key, updateIndex);
////        skipNode.setNextNode(new SkipNode(null, key, value));
////        Index[] addIndex = new Index[insertLevel];
////        int headIndexCount = insertLevel - head.getLevel() > 0 ? insertLevel - head.getLevel() : 0;
////        int indexCount = insertLevel;
////        Index initIndex = new Index()
////        while (indexCount > 0){
////            addIndex[indexCount] = new Index(skipNode)
////            new Index[insertLevel];
////        }
////        while (headIndexCount-- > 0){
////
////        }
////        for (int i = 0; i < insertLevel; i++) {
////            Index index = new Index()
////        }
////        return addNode(insertLevel);
//    }
//
//    public SkipNode findInsertPosition(int key, Index[] updateIndex) {
//        Index currentIndex = head;
//        if (currentIndex.getSkipNode().getKey() == null) {
//            return currentIndex.getSkipNode();
//        }
//        int j = updateIndex.length;
//        while (true) {
//            if (currentIndex.getSkipNode().getKey() < key) {
//                if (currentIndex.getNext() != null) {
//                    currentIndex = currentIndex.getNext();
//                    continue;
//                } else if (currentIndex.getNextLevel() != null) {
//                    updateIndex[j--] = currentIndex;
//                    currentIndex = currentIndex.getNextLevel();
//                    continue;
//                } else {
//                    return currentIndex.getSkipNode();
//                }
//            } else {
//                return currentIndex.getSkipNode();
//            }
//        }
//    }
//
//    public void addNode(int insertLevel, int key, Object value) {
//        SkipNode currentNode;
//        if (insertLevel >= currentLevel) {
////            SkipNode nilNode = new SkipNode()
//        } else {
//
//        }
//    }
//
//    public SkipNode find(int key) {
//        SkipNode currentNode = headNode;
//
//
//    }
//
//    public SkipNode find(SkipNode currentNode, int key) {
//        if (currentNode.getKey() == null) {
//            return null;
//        } else {
//            if (currentNode.getKey() == key) {
//                return currentNode;
//            } else if (currentNode.getNextNode().getKey() > key) {
//                currentNode = currentNode.getNextLevelNode();
//                find(currentNode, key);
//            } else if (currentNode.getNextNode().getKey() < key) {
//                currentNode = currentNode.getNextNode();
//                find(currentNode, key);
//            }
//        }
//    }
//
//
//    /**
//     * @param currentNode 当前节点
//     * @param insertNode  待插入的节点
//     */
//    private void addNode(SkipNode currentNode, SkipNode insertNode) {
//        // 1.获取当前节点的下一个节点
//        SkipNode nextNode = currentNode.getNextNode();
//        // 2.如果下一个节点为空 或者大于待插入节点 则直接插入
//        if (nextNode == null || nextNode.getKey() > insertNode.getKey()) {
//            currentNode.setNextNode(insertNode);
//            insertNode.setNextNode(nextNode);
//        } else {
//            // 3.否则继续寻找下一个符合上述条件的节点
//            nextNode = nextNode.getNextNode();
//            addNode(nextNode, insertNode);
//        }
//    }
//
//    /**
//     * 从跳表中删除一个值
//     *
//     * @param value
//     * @return
//     */
//    public boolean remove(int value) {
//        return true;
//    }
//
//    /**
//     * 通过值查找跳表中的某个节点
//     *
//     * @param value
//     * @return
//     */
//    public SkipNode find(int value) {
//        SkipNode targetNode;
//        SkipNode compareNode = headNode;
//        while (true) {
//            if (compareNode == null) {
//                targetNode = NULL_NODE;
//                break;
//            } else {
//                if (value > compareNode.getValue()) {
//                    compareNode = compareNode.getNextNode();
//                } else if (value < compareNode.getValue()) {
//                    compareNode = compareNode.getNextLevelNode();
//                } else {
//                    targetNode = compareNode;
//                    break;
//                }
//            }
//        }
//        return targetNode;
//    }
//
//    /**
//     * 确定需要插入的层级
//     *
//     * @param max
//     * @return
//     */
//    private int determineInsertLevel(int max) {
//        int insertLevel = 0;
//        while (random.nextBoolean() && ++insertLevel != max) ;
//        return insertLevel;
//    }
//
//    /**
//     * 新增层级
//     *
//     * @param insertLevel
//     * @return
//     */
//    private boolean addLevelIfNecessary(int insertLevel) {
//        if (insertLevel > currentLevel) {
//
//        } else {
//
//        }
//        return false;
//    }
//
////    private boolean addNode(int insertLevel) {
////        if (headNode == null) {
////
////        }
////        for (int i = 0; i < insertLevel; i++) {
//////            SkipNode skipNode = new SkipNode();
////        }
////        if (insertLevel > currentLevel) {
////
////        } else {
////
////        }
////        return false;
////    }
//
//}
//
