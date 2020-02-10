class HomeWork1 {
    public static void main(String[] args) {
        // 找出数组中最小值的下标位置s
        int[] arr = new int[] {1,2,3,4,5,0,1,2};

        System.out.println(minIndexOf(arr));
    }
    /*
        找出数组中最小值的下标
        public static 
        返回值类型 int
        方法名 minIndexOf
        形参列表 (int[] arr)

        public static int minIndexOf(int[] arr);
    */
    /**
     *  找出数组中最小值的下标
     * 
     * @param arr int类型数组
     * @return int 返回数组中最小值的下标
     */
    public static int minIndexOf(int[] arr) {
        int minIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }

        return minIndex;
    }
}