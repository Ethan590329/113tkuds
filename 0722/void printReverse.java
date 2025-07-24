public static void printReverse(ListNode head) {
    if (head == null) return;
    printReverse(head.next);  // 先走訪後面
    System.out.print(head.val + " ");  // 再印出自己
}
