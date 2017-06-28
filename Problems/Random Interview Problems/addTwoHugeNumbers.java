// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    
    if (a == null && b != null)
        return b;
    
    else if (b == null && a != null)
        return a;
    
    else if (a == null && b == null) 
        return null;
        
   
    a = reverseLinkedList(a);
    b = reverseLinkedList(b);
    
    // First reverse list
    ListNode<Integer> ptrA = a;
    ListNode<Integer> ptrB = b;
    
    // Add each value one by one and store it in a new linked list
    // Take into account the need to carry a number if value greater
    // than 9999
   
    int carry = 0;
    
    ListNode<Integer> ptrC = new ListNode<>( ((ptrA.value + ptrB.value) % 10000) + carry);
    
    ListNode<Integer> newHead = ptrC;
    
    // Take into account carry value
    if ( (ptrA.value + ptrB.value) > 9999){
            carry = 1;
        }
    
    ptrA = ptrA.next;
    ptrB = ptrB.next;
    
    
    while (ptrA != null && ptrB != null){
        
         ListNode<Integer> ptrD = new ListNode<>( ((ptrA.value + ptrB.value) % 10000) + carry);
        
        // Take into account carry value
        if ( (ptrA.value + ptrB.value) > 9999){
            carry = 1;
        }else{
            carry = 0;
        }
        
        ptrC.next = ptrD;
        ptrC = ptrD;
        
        ptrA = ptrA.next;
        ptrB = ptrB.next;
    }
    
    
    if (ptrA == null){
        ptrC.next = ptrB;
    }
    else if(ptrB == null)
        ptrC.next = ptrA;
    
    ptrC = ptrC.next;    
    
        
   
    
    while (ptrC != null){
        
        if ( (ptrC.value + carry) > 9999){
            ptrC.value = (ptrC.value + carry) % 10000;
            ptrC = ptrC.next;
        }
        else{
            ptrC.value = (ptrC.value + carry) % 10000;
            carry = 0;
            break;
        }
        
    }
    
    if (carry == 1){
        
        ListNode<Integer> ptrE = newHead;
        
        while (ptrE.next != null){
            ptrE = ptrE.next;
        }
        
        ListNode<Integer> ptrF = new ListNode<Integer>(1);
        
        ptrE.next = ptrF;
    }
    
    
    
    // while (newHead != null){
    //     System.out.print(newHead.value + " ");
    //     newHead = newHead.next;
    // }
    
    newHead = reverseLinkedList(newHead);
    
    return newHead;
}

ListNode<Integer> reverseLinkedList( ListNode<Integer> l){
  
    // Size 0 linked list
    if (l == null){
        return null;
    }
    
    // Size 1 linked list
    if (l.next == null)
        return l;
    // Size 2 linked list
    if(l.next.next == null){
        
        ListNode<Integer> ptrA = l;
        ListNode<Integer> ptrB = l.next;
        
        ptrA.next = null;
        ptrB.next = ptrA;
        
        return ptrB;
    }
    
    else{
        
        ListNode<Integer> ptrA = l;
        ListNode<Integer> ptrB = l.next;
        ListNode<Integer> ptrC = l.next.next;
        
        
        // Set first node to point to null
        ptrA.next = null;
        ptrB.next = ptrA;
        
        ptrA = ptrB;
        ptrB = ptrC;
        
        while (ptrB != null){
            ptrC = ptrC.next;
            ptrB.next = ptrA;
            ptrA = ptrB;
            ptrB = ptrC;
            
        }
        
        return ptrA;
        
    } 
    }
