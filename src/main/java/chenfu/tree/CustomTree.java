package chenfu.tree;

import chenfu.tree.domain.Person;
import org.junit.Test;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/12 14:57
 */
public class CustomTree<T extends Comparable<T>> {

    /**
     * 根节点
     */
    private Node root;

    private int count;

    private Object[] treeData;

    private int foot;

    /**
     * 拿当前节点和二叉树进行比较，查找插入的位置
     *
     * @param t
     */
    public void add(T t) {
        if (Objects.isNull(t)) {
            throw new NullPointerException("数据不能为null");
        }
        /**
         * 二叉树可能为null
         */
        Node node = new Node(t);
        if (Objects.isNull(this.root)) {
            this.root = node;
        } else {
//            将数据插入到二叉树中
            this.root.addNode(node);
        }
        this.count++;
    }

    /**
     * 遍历二叉树
     *
     * @return
     */
    public Object[] toArray() {
        if (this.count <= 0) {
            return null;
        }
        this.foot = 0;
        treeData = new Object[this.count];
        this.root.toArrayNode();
        return this.treeData;
    }

    /**
     * 删除二叉树中的节点
     */
    public void remove(T data) {
        if (Objects.isNull(this.root)) {
            return;
        }
        if (Objects.isNull(data)) {
            throw new NullPointerException("数据为Null！");
        }
        if (this.root.contains(data)) {
            this.root.removeNode(data);
        }
    }

    @Test
    public void main() {
        CustomTree<Person> tree = new CustomTree<>();
        tree.add(new Person("张三70", 70));
        tree.add(new Person("张三50", 50));
        tree.add(new Person("张三90", 90));
        tree.add(new Person("张三30", 30));
        tree.add(new Person("张三70", 70));
        tree.add(new Person("张三60", 60));

        System.out.println(Arrays.toString(tree.toArray()));
    }

    private class Node {
        private T data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
        }

        /**
         * 查找插入的位置
         *
         * @param newNode
         */
        private void addNode(Node newNode) {
            /**
             * 判断是插入左边还是右边
             */
            if (this.data.compareTo(newNode.data) >= 0) {
                /**
                 * 查找插入左边的位置
                 */
                if (Objects.nonNull(this.left)) {
                    /**
                     * 左节点有数据继续遍历
                     */
                    this.left.addNode(newNode);
                } else {
                    /**
                     * 左节点没有数据插入,则将当前节点和二叉树关联上，即插入
                     */
                    newNode.parent = this;
                    this.left = newNode;
                }
            } else {
                /**
                 * 查找插入右边的位置
                 */
                if (Objects.nonNull(this.right)) {
                    this.right.addNode(newNode);
                } else {
                    newNode.parent = this;
                    this.right = newNode;
                }
            }
        }

        /**
         * 中序遍历
         *
         * @return
         */
        private void toArrayNode() {
            if (Objects.nonNull(this.left)) {
                this.left.toArrayNode();
            }
            CustomTree.this.treeData[CustomTree.this.foot++] = this.data;
            if (Objects.nonNull(this.right)) {
                this.right.toArrayNode();
            }
        }

        /**
         * 删除数据节点
         *
         * @param data
         */
        private void removeNode(T data) {
            if (this.data.compareTo(data) >= 0) {

            }
        }

        /**
         * 判断是否包含该节点
         *
         * @param data
         * @return
         */
        private boolean contains(T data) {
            if (this.data.compareTo(data) == 0) {
                return true;
            } else {
                if (this.data.compareTo(data) > 0) {
                    if (Objects.nonNull(this.left)) {
                        this.left.contains(data);
                    }
                } else {
                    if (Objects.nonNull(this.right)) {
                        this.right.contains(data);
                    }
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {

//        writer:
//        FileWriter a=new FileWriter();
//        new

    }

}
