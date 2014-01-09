class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.val;
		}

		int max = root.val;
		int sumMax = Integer.MIN_VALUE;
		int sum = 0;
		if (root.left != null) {
			max = Math.max(max, maxPathSum(root.left));
			sumMax = Math.max(root.left.val, sumMax);
			sum += root.left.val;
		}
		if (root.right != null) {
			max = Math.max(max, maxPathSum(root.right));
			sumMax = Math.max(root.right.val, sumMax);
			sum += root.right.val;
		}
		max = Math.max(max, sum + root.val);
		max = Math.max(max, root.val + sumMax);
		if (sumMax > 0)
			root.val += sumMax;
		return max;
	}
}
