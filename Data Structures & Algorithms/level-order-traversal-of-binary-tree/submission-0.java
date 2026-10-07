/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();

        if (root != null) {
            bfs.add(root);
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.remove();
                level.add(curr.val);

                if (curr.left != null) {
                    bfs.add(curr.left);
                }

                if (curr.right != null) {
                    bfs.add(curr.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    private void order(TreeNode root, List<List<Integer>> result) {
    }
}
