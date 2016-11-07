/*
Space: O(n) Time O(n^2)
Dfs Traverse every node, with smaller node in the left and larger node in the right,
push every root to the res and set the left, right child to the node
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>(); 
       
        return helper(1, n);
       
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {res.add(null); return res;}
        for(int i = start; i<end+1; i++){
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                    
                }
            }
        }
        return res;
    }
}