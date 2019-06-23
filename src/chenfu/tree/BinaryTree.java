package chenfu.tree;

import chenfu.tree.domain.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/11 10:49
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node root;
    /**
     * 二叉树的数量
     */
    private int count;
    /**
     * 二叉树的数据
     */
    private Object[] treeData;
    /**
     * 遍历角标
     */
    private int foot;

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(T node) {
        if (Objects.isNull(node)) {
            throw new NullPointerException("数据不能为null!");
        }
        Node newNode = new Node(node);
        if (Objects.isNull(this.root)) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
//        保存节点个数
        this.count++;
    }

    /**
     * 遍历二叉树
     *
     * @return 二叉树的数据
     */
    public Object[] toArray() {
        if (this.count == 0) {
            return null;
        }
//        清除下标
        this.foot = 0;
//        创建数据数组
        treeData = new Object[this.count];
        this.root.toArrayNode();
        return this.treeData;
    }

    @Test
    public void main() {
        BinaryTree<Person> tree = new BinaryTree<>();
        tree.add(new Person("张三70", 70));
        tree.add(new Person("张三50", 50));
        tree.add(new Person("张三90", 90));
        tree.add(new Person("张三30", 30));
        tree.add(new Person("张三70", 70));
        tree.add(new Person("张三60", 60));

        System.out.println(Arrays.toString(tree.toArray()));
    }

    private class Node {

        /**
         * 当前节点数据
         */
        private T data;

        /**
         * 父节点数据
         */
        private Node parent;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
        }

        /**
         * 添加节点
         *
         * @param newNode
         */
        public void addNode(Node newNode) {
//            判断新节点的数据是否比当前节点的数据小
            if (newNode.data.compareTo(this.data) <= 0) {
//                    判断当前节点是否有左节点
                if (Objects.isNull(this.left)) {
//                    添加新节点
                    this.left = newNode;
//                    保存父节点
                    newNode.parent = this;
                } else {
//                    已经有左节点了，继续递归遍历
                    this.left.addNode(newNode);
                }
            } else {
                if (Objects.isNull(this.right)) {
                    this.right = newNode;
                    newNode.parent = this;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        /**
         * 中序遍历
         */
        public void toArrayNode() {
            if (this.left != null) {
                this.left.toArrayNode();
            }
            BinaryTree.this.treeData[BinaryTree.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }
    }
}
