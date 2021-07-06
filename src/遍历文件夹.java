import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 递归为深度优先遍历
 * 1. BFS 使用队列
 * 2. DFS 使用栈
 */
class Test {

    private int count;

    private List<File> traversal(File file, List<File> list) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    traversal(subFile, list);
                }
            }
        } else {
            System.out.println(++count);
            list.add(file);
        }
        return list;
    }

    private List<File> traversalBFS(File file) {
        LinkedList<File> list = new LinkedList<>();
        List<File> fileList = new ArrayList<>();
        list.offer(file);
        while (!list.isEmpty()) {
            File f = list.poll();
            if (f.isDirectory()) {
                File[] subFiles = f.listFiles();
                if (subFiles != null) {
                    for (File subFile : subFiles) {
                        list.offer(subFile);
                    }
                }
            } else {
                fileList.add(f);
            }
        }
        return fileList;
    }

    private List<File> traversalDFS(File file) {
        Stack<File> list = new Stack<>();
        List<File> fileList = new ArrayList<>();
        list.push(file);
        while (!list.isEmpty()) {
            File f = list.pop();
            if (f.isDirectory()) {
                File[] subFiles = f.listFiles();
                if (subFiles != null) {
                    for (File subFile : subFiles) {
                        list.push(subFile);
                    }
                }
            } else {
                fileList.add(f);
            }
        }
        return fileList;
    }

    public static void main(String[] args) {
        Test test = new Test();
        List<File> list = test.traversalBFS(new File("/Users/hefuwei/blog"));
        System.out.println(list);
    }
}
