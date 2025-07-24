public static boolean isSorted(int[] arr, int index) {
    // 基本條件：如果已檢查到倒數第二個元素，代表通過
    if (index == arr.length - 1) {
        return true;
    }

    // 若發現不是升序，就回傳 false
    if (arr[index] > arr[index + 1]) {
        return false;
    }

    // 遞迴檢查下一對
    return isSorted(arr, index + 1);
}
