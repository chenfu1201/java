package chenfu.tree;

import chenfu.tree.domain.Person;
import org.junit.Test;

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

    public int getCount() {
        return count;
    }

    /**
     * 拿当前节点和二叉树进行比较，查找插入的位置
     *
     * @param t
     */
    public void add(T t) {
        if (Objects.isNull(t)) {
            throw new NullPointerException("数据不能为null");
        }
        Node node = new Node(t);
//        如果当前树中没有数据，直接保存当前节点为根节点
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
     * 注意：在进行删除时，节点直接的关联操作都是考虑双向的，一定要记住这一点，否则会有点迷
     */
    public void remove(T data) {
//        二叉树没有节点
        if (Objects.isNull(this.root)) {
            return;
        } else {
//            删除的元素是根节点
            if (this.root.data.compareTo(data) == 0) {
                Node moveNode = this.root.right;
                while (Objects.nonNull(moveNode.left)) {
//                    一直找左边的节点
                    moveNode = moveNode.left;
                }
                moveNode.left = this.root.left;
                moveNode.right = this.root.right;
                moveNode.parent.left = null;
//                设置移动节点为根节点
                this.root = moveNode;
//                删除元素，树的节点个数减一
                this.count--;
//                不是根节点
            } else {
                Node removeNode = this.root.getRemoveNode(data);
                if (Objects.nonNull(removeNode)) {
//            情况一：被删除节点没有任何子节点
                    if (Objects.isNull(removeNode.left) && Objects.isNull(removeNode.right)) {
//                        说明当前删除节点是其父亲节点的左子节点
                        if (Objects.nonNull(removeNode.parent.left) && removeNode.data.compareTo(removeNode.parent.left.data) == 0) {
                            removeNode.parent.left = null;
                        } else {
                            removeNode.parent.right = null;
                        }
//                        断掉删除节点与树的联系
                        removeNode.parent = null;
//                情况二：左边节点存在，右边节点不存在
                    } else if (Objects.isNull(removeNode.right) && Objects.nonNull(removeNode.left)) {
//                        这种情况下，也会存在两种情况。
//                        代码里就不实现了，稍后画图分析
                        removeNode.parent.right = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                        removeNode.parent = null;
//                情况三：右边节点存在，左边节点不存在
                    } else if (Objects.isNull(removeNode.left) && Objects.nonNull(removeNode.right)) {
//                注意，此时应该是删除节点的父节点的左边和删除节点的右边关联
                        removeNode.parent.right = removeNode.right;
//                删除节点的右边几点和删除节点的父节点的左边进行关联
                        removeNode.right.parent = removeNode.parent;
//                情况四：两边都有节点
                    } else {
//                将右边节点最左边节点找到，改变其引用
                        Node moveNode = removeNode.right;
                        while (Objects.nonNull(moveNode.left)) {
//                          一直找左边的节点
                            moveNode = moveNode.left;
                        }
//                断开原本的连接
                        removeNode.parent.left = moveNode;
                        moveNode.parent.left = null;
                        moveNode.parent = removeNode.parent;
                        moveNode.right = removeNode.right;
                        moveNode.left = removeNode.left;
                    }
//                    删除数据，树的节点数量减一
                    this.count--;
                }
            }
//            删除元素之后，节点数量减一！
        }
    }

    @Test
    public void main() {
        CustomTree<Person> tree = new CustomTree<>();
        tree.add(new Person("张三70", 70));
        tree.add(new Person("张三35", 35));
        tree.add(new Person("张三82", 82));
        tree.add(new Person("张三60", 60));
        tree.add(new Person("张三85", 85));
        tree.add(new Person("张三30", 30));
        tree.add(new Person("张三90", 90));
        tree.add(new Person("张三50", 50));
        tree.add(new Person("张三80", 80));

        System.out.println("修改前节点数量：" + tree.getCount());
//        1.删除叶子节点
//        1.1删除右叶子节点
//        tree.remove(new Person("张三90", 90));
//        1.2删除左叶子节点
//        tree.remove(new Person("张三50", 50));
//        2.删除根节点
//        tree.remove(new Person("张三70", 70));
//        3.删除只有一个子节点的节点
//        3.1删除只有一个左子节点的节点：60
//        tree.remove(new Person("xxx", 60));
//        3.2删除只有一个右子节点的节点：85
//        tree.remove(new Person("xxx", 85));
//        4.删除左右两边都有子节点的节点：35
        tree.remove(new Person("x", 35));
        System.out.println(Arrays.toString(tree.toArray()));
        System.out.println("修改后节点数量：" + tree.getCount());
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
         * 删除节点
         *
         * @param data
         * @return
         */
        private Node getRemoveNode(T data) {
            if (data.compareTo(this.data) == 0) {
                return this;
            } else if (data.compareTo(this.data) < 0) {
                if (Objects.nonNull(this.left)) {
                    return this.left.getRemoveNode(data);
                } else {
                    return null;
                }
            } else {
                if (Objects.nonNull(this.right)) {
                    return this.right.getRemoveNode(data);
                } else {
                    return null;
                }
            }
        }
    }
}
