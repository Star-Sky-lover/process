package com.itheima.tree

class BinaryTree {
  var root: TreeNode = _

  //后序遍历
  def postOrder(): Unit = {
    if (root != null) {
      root.postOrder()
    } else {
      println("当前二叉树为空，不能遍历")
    }
  }

  //中序遍历
  def infixOrder(): Unit = {
    if (root != null) {
      root.infixOrder()
    } else {
      println("当前二叉树为空，不能遍历")
    }
  }

  //前序遍历
  def preOrder(): Unit = {
    if (root != null) {
      root.preOrder()
    } else {
      println("当前二叉树为空，不能遍历")
    }
  }

  //后序遍历查找
  def postOrderSearch(no: Int): TreeNode = if (root != null) {
    root.postOrderSearch(no)
  } else {
    null
  }

  //中序遍历查找
  def infixOrderSeacher(no: Int): TreeNode = {
    if (root != null) {
      root.infixOrderSearch(no)
    } else {
      null
    }
  }

  //前序查找
  def preOrderSearch(no: Int): TreeNode = {

    if (root != null) {
      root.preOrderSearch(no)
    } else {
      //println("当前二叉树为空，不能查找")
      null
    }
  }

  //删除节点
  def delNode(no: Int): Unit = {
    if (root != null) {
      //先处理一下root是不是要删除的
      if (root.no == no) {
        root = null
      } else {
        root.delNode(no)
      }
    }

  }
}