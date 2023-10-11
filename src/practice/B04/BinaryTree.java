package practice.B04;

public class BinaryTree {
    Node root;
    public BinaryTree() {
        root = null;
    }
    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.key + " ");
    }
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.print("Post-order traversal of the binary tree: ");
        tree.postOrderTraversal();
    }
}
