class HomeWork2 {
    public static void main(String[] args) {
        // 找出数组中指定元素的最后一次出现的下标位置
        int[] arr = new int[]{1,2,3,4,5,5,3,1,2};

        System.out.println(getLastIndexOf(arr, 1));
    }
    /*
        找出数组中指定元素的最后一次出现的下标位置
        public static
        返回值类型 int
        方法名 getLastIndexOf
        形参列表 (int[] arr, int num)

        public static int getLastIndexOf(int[] arr, int num);
    */
    /**
     * 找出数组中指定元素的最后一次出现的下标位置
     * 
     * @param arr int类型数组
     * @param num int类型数据 
     * @return int arr数组中num的最后一次出现的下标位置
     */
    public static int getLastIndexOf(int[] arr, int num) {
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                lastIndex = i;
            }
        }

        return lastIndex;
    }
}