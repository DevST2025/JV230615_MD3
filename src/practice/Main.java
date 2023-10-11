package practice;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Hàm đệ quy để duyệt theo thứ tự post-order
    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // Duyệt cây con bên trái
        postOrderTraversal(node.left);

        // Duyệt cây con bên phải
        postOrderTraversal(node.right);

        // Truy cập nút gốc
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