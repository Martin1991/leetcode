
public class FlatternTree {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public static void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(root.left);
        flatten(root.right);
        root.left = null;
        root.right = left;
        while(root.right != null) root = root.right;
        root.right = right;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		flatten(root);
	}

}
