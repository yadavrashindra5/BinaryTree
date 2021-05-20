package binarysearchtree;

class Node{
    Node left;
    int data;
    Node right;
    public Node insertNode(int x,Node root)
    {
        if(root==null)
        {
            Node newnode=new Node();
            newnode.data=x;
            newnode.left=null;
            newnode.right=null;
            return newnode;
        }
        if(x<root.data)
            root.left=insertNode(x,root.left);
        if(x>root.data)
            root.right=insertNode(x,root.right);
        return root;
            
    }
    public void inOrder(Node root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public int height(Node root)
    {
        if(root==null)
            return 0;
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        if(leftheight>rightheight)
            return leftheight+1;
        else
            return rightheight+1;
        
    }
    public int numberOfNode(Node root)
    {
        if(root==null)
            return 0;
        return numberOfNode(root.left)+numberOfNode(root.right)+1;
    }
    public int internalNode(Node root)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
        {
            return 0;
        }
        int leftInternalNode=internalNode(root.left);
        int rightInternalNode=internalNode(root.right);
        return leftInternalNode+rightInternalNode+1;
    }
    public Node smallestNode(Node root)
    {
        try{
        if(root.left==null && root.right==null)
            return root;
        if(root.left==null)
            return root;
        root=smallestNode(root.left);
        }catch(NullPointerException e){};
        return root;
    }
    public Node greatestNode(Node root)
    {
        try{
            if(root.left==null && root.right==null)
            {
                return root;
            }
            if(root.right==null)
                return root;
            root=greatestNode(root.right);
        }
        catch(NullPointerException e){};
        return root;
    }
    public Node mirrorImage(Node root)
    {
        if(root!=null)
        {
            mirrorImage(root.left);
            mirrorImage(root.right);
            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        else
        {
            return null;
        }
        return root;
    }
    public Node FindMin(Node root)
    {
        if(root.left==null && root.right==null)
            return root;
        else if(root.left==null)
            return root;
        root=FindMin(root.left);
        return root;
    }
    public Node deleteNode(Node root,int x)
    {
        if(root==null)
            return root;
        else if(x<root.data)
            root.left=deleteNode(root.left,x);
        else if(x>root.data)
            root.right=deleteNode(root.right,x);
        else
        {
            if(root.left==null && root.right==null)
            {
                root=null;
            }
            else if(root.left==null)
            {
                Node temp=root;
                root=root.right;
            }
            else if(root.right==null)
            {
                Node temp=root;
                root=root.left;
            }
            else
            {
                Node temp=FindMin(root.right);
                root.data=temp.data;
                root.right=deleteNode(root.right,temp.data);
            }
        }
        return root;
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        Node n=new Node();
        Node root=null;
        root=n.insertNode(39,root);
        root=n.insertNode(27,root);
        root=n.insertNode(45,root);
        root=n.insertNode(18,root);
        root=n.insertNode(29,root);
        root=n.insertNode(40,root);
        root=n.insertNode(54,root);
        root=n.insertNode(9,root);
        root=n.insertNode(21,root);
        root=n.insertNode(28,root);
        root=n.insertNode(36,root);
        root=n.insertNode(59,root);
        root=n.insertNode(10,root);
        root=n.insertNode(19,root);
        root=n.insertNode(65,root);
        root=n.insertNode(60,root);
        n.inOrder(root);
        System.out.print("\n"+n.height(root));
        System.out.print("\n"+n.numberOfNode(root));
        System.out.print("\n"+n.internalNode(root));
        Node x=n.smallestNode(root);
        System.out.print("\n"+x.data);
        Node y=n.greatestNode(root);
        System.out.print("\n"+y.data);
        //n.mirrorImage(root);
        System.out.print("\n");
        n.deleteNode(root,28);
        n.inOrder(root);
    }
    
}
