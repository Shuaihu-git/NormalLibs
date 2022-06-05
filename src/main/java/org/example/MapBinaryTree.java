package org.example;



public class MapBinaryTree<K extends Comparable<K>,V>{
    public static class  Entry<K extends Comparable<K>,V> implements Comparable<K>{
       private V value;
       private K key;

       public Entry(K key,V value){
          this.key=key;
          this.value=value;
      }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }


        @Override
        public int compareTo(K o) {
            return this.key.compareTo(o);
        }
    }
    private class Node{
        private MapBinaryTree.Entry<K,V> data;
        private Node parent;
        private Node left;
        private Node right;
        public Node(MapBinaryTree.Entry<K,V> data){
            this.data=data;
        }
        public void addNode(Node newNode){
            if (newNode.data.key.compareTo(this.data.key)<=0){
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
            MapBinaryTree.this.returnData[MapBinaryTree.this.foot++] =this.data;
            if (this.right!=null){
                this.right.toArrayNode();
            }
        }
        public boolean containsNode(MapBinaryTree.Entry<K,V> data){
            if (data.key.compareTo(this.data.key)==0){
                return true;
            } else if (data.key.compareTo(this.data.key)<0) {
                if (this.left!=null){
                    return this.left.containsNode(data);
                }
                return false;
            }else{
                if (this.right!=null){
                    return this.right.containsNode(data);
                }
                return false;
            }
        }

    }
    private int foot=0;
    private Node root;
    private int count;
    public Object [] returnData;

    public void add(K key,V value){
        if (key==null||value==null){
            throw new NullPointerException("保存数据错误");
        }
        Node newNode =new Node(new MapBinaryTree.Entry<K,V>(key,value));
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
    public boolean contains(K key){
        if (this.count==0){
            return false;
        }
        return this.root.containsNode(new MapBinaryTree.Entry<K, V>(key,null));
    }



}
class PersonInfo {
    private String name;
    private int age;
    public  PersonInfo(String name,int age){
        this.age= age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"、年龄："+this.age;
    }




}

