package com.itheima.tree

class TreeNode(treeNo: Int) {
  val no: Int = treeNo
  var left: TreeNode = _
  var right: TreeNode = _

  //后序遍历
  def postOrder(): Unit = {
    //向左递归输出左子树
    if (this.left != null) {
      this.left.postOrder()
    }
    //向右递归输出右子树
    if (this.right != null) {
      this.right.postOrder()
    }

    //输出当前节点值
    printf("节点信息 no=%d \n", no)
  }

  //中序遍历
  def infixOrder(): Unit = {
    //向左递归输出左子树
    if (this.left != null) {
      this.left.infixOrder()
    }

    //输出当前节点值
    printf("节点信息 no=%d \n", no)

    //向右递归输出右子树
    if (this.right != null) {
      this.right.infixOrder()
    }
  }

  //前序遍历
  def preOrder(): Unit = {
    //输出当前节点值
    printf("节点信息 no=%d \n", no)

    //向左递归输出左子树
    if (this.left != null) {
      this.left.postOrder()
    }

    //向右递归输出右子树
    if (this.right != null) {
      this.right.preOrder()
    }
  }

  //后序遍历查找
  def postOrderSearch(no: Int): TreeNode = {
    //向左递归输出左子树
    var resNode: TreeNode = null
    if (this.left != null) {
      resNode = this.left.postOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    if (this.right != null) {
      resNode = this.right.postOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    println("ttt~~")
    if (this.no == no) {
      return this
    }
    resNode
  }

  //中序遍历查找
  def infixOrderSearch(no: Int): TreeNode = {

    var resNode: TreeNode = null
    //先向左递归查找
    if (this.left != null) {
      resNode = this.left.infixOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    println("yyy~~")
    if (no == this.no) {
      return this
    }
    //向右递归查找
    if (this.right != null) {
      resNode = this.right.infixOrderSearch(no)
    }
    resNode

  }

  //前序查找
  def preOrderSearch(no: Int): TreeNode = {
    if (no == this.no) {
      return this
    }
    //向左递归查找
    var resNode: TreeNode = null
    if (this.left != null) {
      resNode = this.left.preOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    //向右边递归查找
    if (this.right != null) {
      resNode = this.right.preOrderSearch(no)
    }

    resNode
  }

  //删除节点
  //删除节点规则
  //1如果删除的节点是叶子节点，则删除该节点
  //2如果删除的节点是非叶子节点，则删除该子树

  def delNode(no: Int): Unit = {
    //首先比较当前节点的左子节点是否为要删除的节点
    if (this.left != null && this.left.no == no) {
      this.left = null
      return
    }
    //比较当前节点的右子节点是否为要删除的节点
    if (this.right != null && this.right.no == no) {
      this.right = null
      return
    }
    //向左递归删除
    if (this.left != null) {
      this.left.delNode(no)
    }
    //向右递归删除
    if (this.right != null) {
      this.right.delNode(no)
    }
  }
}