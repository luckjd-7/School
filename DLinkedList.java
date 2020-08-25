{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf340
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww23480\viewh11580\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
import java.lang.*;\
import java.util.*;\
import java.io.*;\
 \
class DLinkedList\
\{\
   private int data;\
 \
   private DLinkedList next;\
   private DLinkedList prev;\
 \
   public DLinkedList()\
   \{\
      data = 0;\
      next = null;\
      prev = null;\
   \}\
 \
   public DLinkedList(int value)\
   \{\
      data = value;\
      next = null;\
      prev = null;\
   \}\
 \
   public DLinkedList InsertNext(int value)\
   \{\
      DLinkedList node = new DLinkedList(value);\
      if(this.next == null)\
      \{\
 \
            // Easy to handle\
            node.prev = this;\
            node.next = null; // already set in constructor\
            this.next = node;\
      \}\
      else\
      \{\
            // Insert in the middle\
            DLinkedList temp = this.next;\
            node.prev = this;\
            node.next = temp;\
            this.next = node;\
            temp.prev = node;\
            // temp.next does not have to be changed\
      \}\
      return node;\
   \}\
 \
   public DLinkedList InsertPrev(int value)\
   \{\
      DLinkedList node = new DLinkedList(value);\
      if(this.prev == null)\
      \{\
            node.prev = null; // already set on constructor\
            node.next = this;\
            this.prev = node;\
      \}\
      else\
      \{\
 \
            // Insert in the middle\
            DLinkedList temp = this.prev;\
            node.prev = temp;\
            node.next = this;\
            this.prev = node;\
            temp.next = node;\
            // temp.prev does not have to be changed\
      \}\
      return node;\
   \}\
 \
   public void TraverseFront()\
   \{\
      TraverseFront(this);\
   \}\
 \
   public void TraverseFront(DLinkedList node)\
   \{\
      if(node == null)\
            node = this;\
      System.out.println("\\n\\nTraversing in Forward Direction\\n\\n");\
 \
      while(node != null)\
      \{\
            System.out.println(node.data);\
            node = node.next;\
      \}\
   \}\
 \
   public void TraverseBack()\
   \{\
      TraverseBack(this);\
   \}\
 \
   public void TraverseBack(DLinkedList node)\
   \{\
      if(node == null)\
            node = this;\
      System.out.println("\\n\\nTraversing in Backward Direction\\n\\n");\
      while(node != null)\
      \{\
            System.out.println(node.data);\
            node = node.prev;\
      \}\
   \}\
 \
   public static void main(String[] args)\
   \{\
 \
      DLinkedList node1 = new DLinkedList(1);\
      DLinkedList node3 = node1.InsertNext(3);\
      DLinkedList node2 = node3.InsertPrev(2);\
      DLinkedList node5 = node3.InsertNext(5);\
      DLinkedList node4 = node5.InsertPrev(4);\
 \
      node1.TraverseFront();\
      node5.TraverseBack();\
   \}\
\} }