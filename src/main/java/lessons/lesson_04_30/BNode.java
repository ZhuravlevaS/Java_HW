package lessons.lesson_04_30;

public class BNode {
    public Integer value;
    public BNode left;
    public BNode right;

    private static boolean isNodeExist(BNode bNode) {
        return bNode != null && bNode.value != null;
    }

    private static void createNode(BNode bNode, int value) {
        bNode.left = new BNode();
        bNode.right = new BNode();
        bNode.value = value;
    }

    private static void insert(BNode bNode, int value) {
        if(!isNodeExist(bNode)) {
            createNode(bNode, value);
        } else if (value < bNode.value) {
            insert(bNode.left, value);
        } else {
            insert(bNode.right, value);
        }
    }

    private static BNode search(BNode bNode, int value) {
        if(!isNodeExist(bNode)) {
            return null;
        }

        if(bNode.value == value) {
            return bNode;
        }

        if(value < bNode.value) {
            return search(bNode.left, value);
        }

        return search(bNode.right, value);
    }

    //todo
    private static BNode getMin(BNode bNode) {
        if(isNodeExist(bNode.left)) {
            getMin(bNode.left);
        }
        return bNode;
    }

    //todo
    private static BNode getMax(BNode bNode) {
        if(isNodeExist(bNode.right)) {
            getMax(bNode.right);

        }
        return bNode;
    }

    //sort todo
    private static void inOrderTraversal(BNode bNode) {
        if(!isNodeExist(bNode)) {
            return;
        }

        inOrderTraversal(bNode.left);
        System.out.println(bNode.value);
        inOrderTraversal(bNode.right);
    }

    //del todo
    private static void postOrderTraversal(BNode bNode) {
        if(!isNodeExist(bNode)) {
            return;
        }

        postOrderTraversal(bNode.left);
        postOrderTraversal(bNode.right);
        System.out.println(bNode.value);
    }

    //copy
    private static void preOrderTraversal(BNode bNode) {
        if(!isNodeExist(bNode)) {
            return;
        }

        System.out.println(bNode.value);
        preOrderTraversal(bNode.left);
        preOrderTraversal(bNode.right);
    }

    //todo
    private static int getChildCount(BNode bNode) {
        int count = 0;
        countChildren(count, bNode);
        return count;
    }

    private static void countChildren (int count, BNode bNode) {
        if(!isNodeExist(bNode)) {
            return;
        }

        count++;
        countChildren(count, bNode.left);
        countChildren(count, bNode.right);
    }

    //todo
    private static void removeNodeWithOneOrZeroChild(BNode bNodeToDelete) {
        if(!(isNodeExist(bNodeToDelete.left) && isNodeExist(bNodeToDelete))) {
           bNodeToDelete = null;
        }
    }

    //todo
    private static boolean remove(BNode root, int value) {
        if(!isNodeExist(root)) {
            return false;
        }

        if (root.value.equals(value)){
            root = null;
        }

        if (root.value > value) {
            remove(root.right, value);
        }

        if (root.value < value) {
            remove(root.left, value);
        }

        return true;
    }


    public static void main(String[] args) {
        Integer[] digit = {2, 5, 13, 6, 10, 14};
        BNode bNode = new BNode();
        createNode(bNode, 9);
    }
}
