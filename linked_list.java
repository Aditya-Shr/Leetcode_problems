import java.awt.*;

public class linked_list {
    public static void main(String[] args) {

    }

    public ListNode reverseList_206(ListNode head){
        if(head==null || head.next==null){
            return  head;
        }

        ListNode p = reverseList_206(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    public boolean hasCycle_141(ListNode head){
        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow!=fast){
            if(fast==null || fast.next ==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public ListNode mergeTwoLists_21(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }else if(list1.val<list2.val){
            list1.next = mergeTwoLists_21(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists_21(list1, list2.next);
            return list2;
        }

//        ListNode prehead = new ListNode(-1);
//        ListNode prev = prehead;
//
//        while(list1!=null && list2!=null){
//            if(list1.val<list2.val){
//                prev.next = list1;
//                list1=list1.next;
//            }else{
//                prev.next = list2;
//                list2 = list2.next;
//            }
//            prev = prev.next;
//        }
//        prev.next = list1==null ? list2:list1;
//
//        return prehead.next;
    }

    public ListNode removeNthFromEnd_19(ListNode head,int n){
//        int length = 0;
//        ListNode curr = head;
//
//        while(curr!=null){
//            curr=curr.next;
//            length++;
//        }
//
//        if(length==n){
//            return head.next;
//        }
//
//        int nthnode = length - n - 1;
//        curr = head;
//
//        for(int i=0;i<nthnode;i++){
//            curr = curr.next;
//        }
//
//        curr.next = curr.next.next;
//
//        return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=1;i<=n+1;i++){
            first=first.next;
        }

        if(first==null){
            return head.next;
        }

        while(first!=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public void reorderList(ListNode head) {

        if(head==null){
            return;
        }

        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null,curr = slow,temp;
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head, second = prev;
        while(second.next!=null){
            temp = first.next;
            first.next = prev;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }



//        Stack<ListNode> stack = new Stack();
//        ListNode node = head;
//
//        while(node!=null){
//            stack.add(node);
//            node = node.next;
//        }
//
//        node = head;
//        while(node != null){
//            ListNode next = node.next;
//            ListNode endNode = stack.pop();
//
//            node.next = endNode;
//            endNode.next = next;
//            node = next;
//
//            if(node!=null && node.next==endNode){
//                node.next = null;
//                break;
//            }
//        }
    }

}

//public class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int val,ListNode next){
//        this.val = val;
//        this.next = next;
//    }
//}
