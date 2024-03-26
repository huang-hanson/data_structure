package com.hanson.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个函数，输入树的结构及关键字，返回仅包含关键字路径的一颗新树
 *
 * @author hanson
 * @date 2024/3/26 14:26
 */
public class SelectTreeNode {

    /**
     * @param root    树根节点
     * @param keyword 匹配关键字
     * @return
     */
    public static TreeNode selectTree(TreeNode root, String keyword) {
        if (root == null) {
            return null;
        }

        // 如果当前节点是关键字，直接返回它
        if (root.value.equals(keyword)) {
            return root;
        }

        // 递归筛选子节点
        List<TreeNode> selectedChildren = new ArrayList<>();
        for (TreeNode child : root.children) {
            TreeNode selectedChild = selectTree(child, keyword);
            if (selectedChild != null) {
                selectedChildren.add(selectedChild);
            }
        }

        // 如果没有找到关键字，返回null
        if (selectedChildren.isEmpty()) {
            return null;
        }

        // 否则，构建新的树节点，并将筛选后的子节点添加进去
        TreeNode newNode = new TreeNode(root.value);
        for (TreeNode child : selectedChildren) {
            newNode.addChild(child);
        }
        return newNode;
    }


    /**
     * 定义树节点
     */
    static class TreeNode {
        String value;
        List<TreeNode> children;

        TreeNode(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        void addChild(TreeNode child) {
            children.add(child);
        }
    }

    // 测试方法
    public static void main(String[] args) {
        // 构建原始树
        TreeNode root = new TreeNode("Root");
        TreeNode D = new TreeNode("D");
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode BD = new TreeNode("B");
        TreeNode BG = new TreeNode("G");
        TreeNode BC = new TreeNode("C");

        root.addChild(D);
        root.addChild(A);
        root.addChild(B);
        D.addChild(BD);
        D.addChild(BG);
        B.addChild(BC);

        // 过滤树并打印结果
        TreeNode selectTree = selectTree(root, "B");
        printTree(selectTree);
    }

    // 辅助方法，用于打印树结构
    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        for (TreeNode child : node.children) {
            printTree(child);
        }
    }
}
