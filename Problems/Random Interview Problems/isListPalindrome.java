// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> l) {

    
    
    
    if (l == null || l.next == null){
        return true;
    }
    

    
    // Send normal ptr and fast ptr to find middle
    ListNode<Integer> ptrSlow = l;
    ListNode<Integer> ptrFast = l;
    
    while (ptrFast != null && ptrFast.next != null){
        
        ptrFast = ptrFast.next.next;
        
        if (ptrFast != null)
            ptrSlow = ptrSlow.next;
        
    }
    // ptrSlow now at middle
    
    ListNode<Integer> middle = ptrSlow;
    
    // Reverse second half of linked list
    middle.next = reverseLinkedList(middle.next);
    
    middle = middle.next;
    
    while(middle != null){
        if (l.value == middle.value){
            l = l.next;
            middle = middle.next;
        }
        else{
            return false;
        }
        
    }
    
    return true;
    
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
        
        ptrA = ptrB.next;
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