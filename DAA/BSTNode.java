package DAA;

public class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BSTTree{
    BSTNode root;
    BSTTree (){
        root = null;
    }

    void insert(int data){
        root = insertion(data, root);
    }
    BSTNode insertion(int data, BSTNode root){

        if (root == null) {
            root = new BSTNode(data);
            return root;
        }
        else if (root.data > data){
            root.left = insertion(data, root.left);
        }
        else if (root.data < data){
            root.right = insertion(data, root.right);
        }
        return root;
    }

    void postorder(BSTNode node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + "->");
    }

    void inorder(BSTNode node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + "->");
        inorder(node.right);
    }

    void preorder(BSTNode node) {
        if (node == null)
            return;
        System.out.print(node.data + "->");
        preorder(node.left);
        preorder(node.right);
    }


    public static void main(String[] args) {

        BSTTree tree = new BSTTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("This is Inorder DFS: ");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("This is Preorder DFS: ");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("This is Postorder DFS: ");
        tree.postorder(tree.root);
    }
}