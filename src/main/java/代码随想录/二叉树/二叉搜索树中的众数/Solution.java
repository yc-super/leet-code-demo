package 代码随想录.二叉树.二叉搜索树中的众数;

import 代码随想录.二叉树.TreeNode;

import java.util.*;

public class Solution {
//    第一次尝试，没有利用二叉搜索树的性质
    public int[] findMode(TreeNode root) {
        map=new HashMap<>();
        maxCont=1;
        getMode(root);
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==maxCont){
                list.add(entry.getKey());
            }
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=list.get(i);
        }
        return result;
    }

    private void getMode(TreeNode root) {

        if(root.left!=null) {
            getMode(root.left);
        }

        if(map.containsKey(root.val)){
            map.put(root.val,map.get(root.val)+1);
            if(map.get(root.val)>maxCont)
                maxCont=map.get(root.val);
        }else{
            map.put(root.val,1);
        }

        if(root.right!=null) {
            getMode(root.right);
        }
    }

    private Map<Integer,Integer> map;
    private int maxCont;



    //第二次尝试，利用二叉搜索树的性质，效率非常高
    public int[] findMode2(TreeNode root) {
//        1,2,2,2,3,4,4,4,5,5
        preValue=-100001;
        llist=new ArrayList<>();
        getMode2(root);
        if(tempCount>maxCount){
            llist.clear();
            llist.add(preValue);
            maxCount=tempCount;
        }else if(tempCount==maxCount){
            llist.add(preValue);
        }
        if(llist.get(0)==-100001){
            llist.remove(0);
        }
        int[] re=new int[llist.size()];
        for (int i = 0; i < llist.size(); i++) {
            re[i]=llist.get(i);
        }
        return re;
    }

    private void getMode2(TreeNode root) {

        if(root.left!=null){
            getMode2(root.left);
        }

        if(root.val==preValue){
            tempCount++;
        }else{
            if(tempCount>maxCount){
                llist.clear();
                llist.add(preValue);
                maxCount=tempCount;
            }else if(tempCount==maxCount){
                llist.add(preValue);
            }
            tempCount=1;
            preValue=root.val;
        }

        if(root.right!=null){
            getMode2(root.right);
        }
    }

    private int preValue;
    private int tempCount=1;
    private int maxCount=1;
    private List<Integer> llist;
}
