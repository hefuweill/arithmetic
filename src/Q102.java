import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        q1.add(root);
        while (!q1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                list.add(node.val);
                if (node.left != null) {
                    q2.offer(node.left);
                }
                if (node.right != null) {
                    q2.offer(node.right);
                }
            }
            Queue<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
            resultList.add(list);
        }
        return resultList;
    }
}
