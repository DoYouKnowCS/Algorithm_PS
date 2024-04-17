package inflearn;

class Node{ //Node 클래스
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}
public class inflearn_07_05 {
    Node root;
    public void DFS(Node root){
        if(root==null) return;
        else{
            System.out.print(root.data + " "); //전위
            DFS(root.lt);
            //여기 넣으면 중위
            DFS(root.rt);
            //후위
        }

    }

    public static void main(String[] args) {
        inflearn_07_05 tree = new inflearn_07_05();
        tree.root = new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4;
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);


    }
}
