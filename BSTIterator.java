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
class BSTIterator {

    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack();
        dfs(root);
    }
    
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode popped = st.pop();
         if(popped.right!=null){
             dfs(popped.right);
         }
        return popped.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       if(st.isEmpty()){
           return false;
       }
       return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */