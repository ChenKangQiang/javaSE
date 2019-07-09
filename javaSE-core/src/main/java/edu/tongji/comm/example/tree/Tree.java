package edu.tongji.comm.example.tree;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018-12-26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tree<T> {

    private TreeNode<T> root;


    public static void main(String[] args) {

        TreeNode nodeA = new TreeNode();
        nodeA.setName("A");

        TreeNode nodeB = new TreeNode();
        nodeB.setName("B");

        TreeNode nodeC = new TreeNode();
        nodeC.setName("C");

        TreeNode nodeD = new TreeNode();
        nodeD.setName("D");

        TreeNode nodeE = new TreeNode();
        nodeE.setName("E");


        List<TreeNode> lstB = Lists.newArrayList();
        lstB.add(nodeC);
        lstB.add(nodeD);
        nodeB.setChildren(lstB);

        List<TreeNode> lstA = Lists.newArrayList();
        lstA.add(nodeB);
        lstA.add(nodeE);
        nodeA.setChildren(lstA);

        Tree tree = new Tree();
        tree.setRoot(nodeA);

        List<String> path = Lists.newArrayList();
        tree.traverse(nodeA, path);
        System.out.println(JSON.toJSONString(path));

        List<List<String>> allPath = tree.getAllPath(nodeA);
        System.out.println(JSON.toJSONString(allPath));

    }







    public void traverse(TreeNode<T> treeNode, List<String> path) {
        List<TreeNode<T>> children = treeNode.getChildren();
        if (CollectionUtils.isNotEmpty(children)) {
            for (TreeNode<T> child : children) {
                traverse(child, path);
            }
        } else {
            path.add(treeNode.getName());
        }
    }



    public List<List<String>> getAllPath(TreeNode treeNode) {
        List<List<String>> allPath = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        this.iteratorNode(treeNode, stack, allPath);
        return allPath;
    }


    public void iteratorNode(TreeNode n, Stack<TreeNode> stack, List<List<String>> listList) {
        stack.push(n);//入栈
        List<TreeNode> children = n.getChildren();
        if (CollectionUtils.isEmpty(children)) { //没有孩子则是叶子结点
            List<String> lst = Lists.newArrayList();
            for (TreeNode treeNode : stack) {
                lst.add((treeNode).getName());

            }
            listList.add(lst);
        } else {
            for (TreeNode child : children) {
                iteratorNode(child, stack, listList);//深度优先 进入递归
                stack.pop();//回溯时候出栈
            }

        }

    }




}
