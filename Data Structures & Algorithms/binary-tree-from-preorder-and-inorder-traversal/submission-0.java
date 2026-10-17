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

    int preOrderIndex = 0;

    Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder){

        for(int i = 0; i < inorder.length; i++){

            inOrderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right){

        if(left > right){

            return null;

        }

        int rootvalue = preorder[preOrderIndex++];

        TreeNode root = new TreeNode(rootvalue);

        int inorderindex = inOrderMap.get(rootvalue);

        root.left = build(preorder, left, inorderindex - 1);
        
        root.right = build(preorder, inorderindex + 1, right);

        return root;
    }
   
}
