import java.io.*;
import java.util.*; 

public class BinarySearchTree { 
  public Node first;
  public void insert(int i, double d)
  {
    Node node = new Node();
    node.data1 = i;
    node.data2 = d;
    if(first == null)
    {first = node;}
    else
    {
      Node now = first;
      Node upper;
      while(true)
      {
        upper = now;
        if(i < now.data1)
        {
          now = now.left;
          if(now == null)
          {
            upper.left = node;
            return;
          }
        }
        else
        {
          now = now.right;
          if(now == null)
          { 
            upper.right = node;
            return;
          }
        }
      }
    } 
  }
  public void traverse(int n)
  {
    switch(n)
    {
      case 1: System.out.println("Preorder traversal: ");
      preOrder(first);
      break;
      case 2: System.out.println("Inorder traversal:  ");
      inOrder(first);
      break;
      case 3: System.out.println("Postorder traversal: ");
      postOrder(first);
      break;
    }
    System.out.println();
  }
  public void preOrder(Node nd)
  {
    if(nd != null)
    {
      System.out.print(nd.data1 + " ");
      preOrder(nd.left);
      preOrder(nd.right);
    }
  }
  public void inOrder(Node nd)
  {
    if(nd != null)
    {
      inOrder(nd.left);
      System.out.print(nd.data1 + " ");
      inOrder(nd.right);
    }
  }
  public void postOrder(Node nd)
  {
    if(nd != null)
    {
      postOrder(nd.left);
      postOrder(nd.right);
      System.out.print(nd.data1 + " ");
    }
  }
  public class Node {
    public int data1;
    public double data2;
    public Node left;
    public Node right;
  }
   public void displayTree()
  {
    Stack gStack = new Stack();
    gStack.push(first);
    int blank = 32;
    boolean rEmpty = false;
    System.out.println( "..........................................................");
    while(rEmpty == false)
    {
      Stack lStack = new Stack();
      rEmpty = true;
      
      for(int i = 0; i < blank; i++)
        System.out.print(' ');
      
      while(gStack.isEmpty() == false)
      {
        Node temp = (Node)gStack.pop();
        if(temp != null)
        {
          System.out.print(temp.data1);
          lStack.push(temp.left);
          lStack.push(temp.right);
          
          if(temp.left != null || temp.right != null) {
            rEmpty = false;
          }
        }
        else
        {
          System.out.print("--");
          lStack.push(null);
        }
        for(int j = 0; j < blank*2-2; j++)
        {System.out.print(' ');}
      }
      System.out.println();
      blank = blank/2;
      while(lStack.isEmpty() == false)
        gStack.push( lStack.pop() );
    } 
    System.out.println( "..........................................................");
  }
  public BinarySearchTree() {
  }
    public void BinarySearchTree()
  {
    first = null;
  }
  public static void main(String[] args) throws IOException {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(23,1.5);
    tree.insert(17,1.5);
    tree.insert(5,1.5);
    tree.insert(90,1.5);
    tree.insert(12,1.5);
    tree.insert(44,1.5);
    tree.insert(38,1.5);
    tree.insert(84,1.5);
    tree.insert(77,1.5);
    tree.insert(3,1.5);
    tree.insert(66,1.5);
    tree.insert(55,1.0);
    tree.insert(1,1.5);
    tree.insert(19,1.5);
    tree.insert(37,1.5);
    tree.insert(88,1.5);
    tree.insert(8,1.5);
    tree.insert(97,1.5);
    tree.insert(25,1.5);
    tree.insert(50,1.5);
    tree.insert(75,1.7);
    tree.insert(61,1.5);
    tree.insert(49,1.5);
    tree.displayTree();
    tree.traverse(1);
    tree.traverse(2);
    tree.traverse(3);
      }
    }
