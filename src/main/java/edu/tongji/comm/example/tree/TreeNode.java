package edu.tongji.comm.example.tree;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018-12-26
 */
@Data
public class TreeNode<T> {
    private int level;
    private String name;
    private TreeNode<T> parent;
    private T data;
    private List<TreeNode<T>> children;


    public boolean isLeaf() {
        return CollectionUtils.isEmpty(this.children);
    }


    public void addChildNode(TreeNode treeNode) {
        if (CollectionUtils.isEmpty(this.children)) {
            this.children = Lists.newArrayList();
        }
        children.add(treeNode);
    }


    /* 返回当前节点的父辈节点集合 */
    public List<TreeNode<T>> getElders() {
        List<TreeNode<T>> elderList = Lists.newArrayList();
        TreeNode<T> parent = this.parent;
        if (parent == null) {
            return elderList;
        } else {
            elderList.add(parent);
            elderList.addAll(parent.getElders());
            return elderList;
        }
    }


    /* 返回当前节点的晚辈集合 */
    public List<TreeNode<T>> getJuniors() {
        List<TreeNode<T>> juniorList = Lists.newArrayList();
        List<TreeNode<T>> children = this.children;
        if (CollectionUtils.isEmpty(children)) {
            return juniorList;
        } else {
            for (TreeNode<T> junior : children) {
                juniorList.add(junior);
                juniorList.addAll(junior.getJuniors());
            }
            return juniorList;
        }
    }



    /* 删除当前节点的某个子节点 */
    public void deleteOneChildNode(String name) {
        List<TreeNode<T>> children = this.children;
        for (TreeNode<T> child : children) {
            if (name.equals(child.getName())) {
                children.remove(child);
                return;
            }
        }
    }


    public void print(String content) {
        System.out.println(content);
    }

    public void print(int content) {
        System.out.println(String.valueOf(content));
    }


}
