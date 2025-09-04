using System;

public class Program
{
    public static void Main(string[] args)
    {
        MyLinkedList list = new();

        list.Print();

        // insert after head
        list.InsertAfterKnownNode(list.Head, new ListNode(713));
        list.Print();

        // delete after head
        list.DeleteAfterKnownNode(list.Head);
        list.Print();

        // access by index
        var third = list.AccessByIdx(list.Head, 2);
        Console.WriteLine($"Third node value: {(third != null ? third.Val : -1)}");

        // find by value
        int idx = list.FindByVal(list.Head, 5);
        Console.WriteLine($"Value 5 found at index: {idx}");
    }
}

public class MyLinkedList
{
    // entry point to the Linked List
    private ListNode _head;

    // public ListNode? Head => _head; // property
    public ListNode? Head
    {
        get { return _head; }
        private set { _head = value; } // optional; include only if you want to allow assignment
    }

    public MyLinkedList()
    {
        // initialize the nodes
        ListNode n0 = new(1);
        ListNode n1 = new(3);
        ListNode n2 = new(2);
        ListNode n3 = new(5);
        ListNode n4 = new(4);

        // connect these ListNodes
        n0.Next = n1;
        n1.Next = n2;
        n2.Next = n3;
        n3.Next = n4;

        _head = n0;
    }

    public void InsertAfterKnownNode(ListNode n0, ListNode P)
    {
        if (n0 == null) return;
        ListNode n1 = n0.Next;
        n0.Next = P;
        P.Next = n1;
    }

    public void DeleteAfterKnownNode(ListNode n0)
    {
        if (n0 == null || n0.Next == null) return;
        var n1 = n0.Next;
        var n2 = n1!.Next;
        n0.Next = n2;
    }

    public ListNode? AccessByIdx(ListNode head, int idx)
    {
        for (int i = 0; i < idx; i++)
        {
            if (head == null) return null;

            head = head.Next;
        }
        return head;
    }

    public int FindByVal(ListNode head, int val)
    {
        int count = 0;

        // while (head != null)
        // {
        //     if (head.Val == val) return count;

        //     head = head.Next;
        //     count++;
        // }

        for (ListNode curr = head; curr != null; curr = curr.Next, count++)
        {
            if (curr.Val == val) return count;
        }

        return -1;
    }

    public void Print()
    {
        Console.Write("[");
        for (ListNode curr = _head; curr != null; curr = curr.Next)
        {
            Console.Write(curr.Val);
            if (curr.Next != null) Console.Write(" -> ");
        }
        Console.Write("]");
        Console.WriteLine();
    }
}


public class ListNode
{
    //	•	Properties are written in PascalCase (Val, Next, Head).
    //  •	Fields are usually camelCase (private ones often prefixed with _, like _head).
    public int Val { get; set; } // A property looks like a field, but it’s actually syntactic sugar for methods (get and set).
    public ListNode? Next { get; set; } // they are actually methods

    public ListNode(int val)
    {
        Val = val;
        Next = null;
    }
}

public class DoublyListNode
{
    public int Val { get; set; }
    public ListNode? Next { get; set; }
    public ListNode? Prev { get; set; }

    public DoublyListNode(int val)
    {
        Val = val;
        Next = null;
        Prev = null;
    }
}