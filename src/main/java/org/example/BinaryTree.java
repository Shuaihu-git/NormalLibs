package org.example;

public class BinaryTree<T extends Comparable<T>>  {
    private class Node{
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;
        public Node(Comparable<T> data){
            this.data=data;
        }
        public void addNode(Node newNode){
            if (newNode.data.compareTo((T)this.data)<=0){
                if (this.left==null){
                    this.left=newNode;
                    newNode.parent=this;
                }else{
                     this.left.addNode(newNode);
                }
            }else {
                if (this.right==null){
                    this.right=newNode;
                    newNode.parent=this;
                }else{
                    this.right.addNode(newNode);
                }
            }

        }
        public void toArrayNode(){
            if (this.left!=null){
                this.left.toArrayNode();
            }
            BinaryTree.this.returnData[BinaryTree.this.foot++] =this.data;
            if (this.right!=null){
                this.right.toArrayNode();
            }
        }
        public boolean containsNode(Comparable<T> data){
            if (data.compareTo((T)this.data)==0){
                return true;
            } else if (data.compareTo((T)this.data)<0) {
                if (this.left!=null){
                    return this.left.containsNode(data);
                }
                return false;
            }else {
                if (this.right!=null){
                    return this.right.containsNode(data);
                }
                return false;
            }
        }
        public Node getRemoveNode(Comparable<T> data){
            if (data.compareTo((T)this.data)==0){
                return this;
            } else if (data.compareTo((T)this.data)<0) {
                if (this.left!=null){
                    return this.left.getRemoveNode(data);
                }
                return null;
            }else {
                if (this.right!=null){
                    return this.right.getRemoveNode(data);
                }
                return null;
            }
        }

    }
    private int foot=0;
    private Node root;
    private int count;
    public Object [] returnData;

    public void add(Comparable<T> data){
        if (data==null){
            throw new NullPointerException("保存数据错误");
        }
        Node newNode =new Node(data);
        if (this.root==null){
            this.root=newNode;
            this.root.parent=newNode;
        }else {
            this.root.addNode(newNode);
        }
        this.count++;
    }
    public Object[] toArray(){
        if (this.root==null){
        return null;
        }
        this.returnData=new Object[this.count];
        this.foot=0;
        this.root.toArrayNode();
        return this.returnData;
    }
    public boolean contains(Comparable<T> data){
        if (this.count==0){
            return false;
        }
        return this.root.containsNode(data);
    }
    public void remove(Comparable<T> data){
        if (this.root==null){
            return;
        }else {
            if (this.root.data.compareTo((T)data)==0){
                Node moveNode=this.root.right;
                while (moveNode.left!=null){
                    moveNode=moveNode.left;
                }
                moveNode.left=this.root.left;
                moveNode.right=this.root.right;
                moveNode.parent.left=null;
                this.root=moveNode;

                moveNode.parent=null;


            }else {
                Node removeNode=this.root.getRemoveNode(data);
                if (removeNode!=null){
                    if (removeNode.left==null||removeNode.right==null){
                        removeNode.parent.left=null;
                        removeNode.parent.right=null;
                        removeNode.parent=null;
                    } else if (removeNode.left!=null&&removeNode.right==null) {
                        removeNode.parent.left=removeNode.left;
                        removeNode.left.parent=removeNode.parent;
                    } else if (removeNode.right!=null&&removeNode.left==null) {
                        removeNode.parent.left=removeNode.right;
                        removeNode.right.parent=removeNode.parent;
                    }else {
                        Node moveNode=removeNode.right;
                        while (moveNode.left!=null){
                            moveNode=moveNode.left;
                        }
                        removeNode.parent.left=moveNode;
                        moveNode.parent=null;
                        moveNode.parent=removeNode.parent;
                        moveNode.right=removeNode.right;
                        moveNode.left=removeNode.left;
                    }
                }
            }
            this.count--;
        }


    }


}
