class Solution {
    private void delete(TreeNode root, int target) {
        if (root == null) return;
        if (root.val > target) {
            if (root.left == null) return;
            if (root.left.val == target) {
                TreeNode l = root.left;
                if (l.left == null && l.right == null) root.left = null;
                else if (l.left == null || l.right == null) {
                    root.left = (l.left != null) ? l.left : l.right;
                } else {
                    TreeNode curr = l;
                    TreeNode pred = curr.left;
                    while (pred.right != null) pred = pred.right;
                    delete(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.left = pred; 
                }
            } else delete(root.left, target);
        } else {
            if (root.right == null) return;
            if (root.right.val == target) {
                TreeNode r = root.right;
                if (r.left == null && r.right == null) root.right = null;
                else if (r.left == null || r.right == null) {
                    root.right = (r.left != null) ? r.left : r.right;
                } else {
                    TreeNode curr = r;
                    TreeNode pred = curr.left;
                    while (pred.right != null) pred = pred.right;
                    delete(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.right = pred; // ✅ corrected here
                }
            } else delete(root.right, target);
        }
    }

    public TreeNode deleteNode(TreeNode root, int target) {
        TreeNode temp = new TreeNode(Integer.MAX_VALUE);
        temp.left = root;
        delete(temp, target);
        return temp.left;
    }
}
