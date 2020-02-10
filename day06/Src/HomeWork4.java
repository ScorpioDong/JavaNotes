import java.util.Arrays;

class HomeWork4 {
    public static void main(String[] args) {
        // 在指定位置插入指定元素【难点】
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 0};
        insert(array, 2, 1);
        System.out.println(Arrays.toString(array));
    }
    /*
        在指定位置插入指定元素
        public static 
        返回值类型 void
        方法名 insert
        形参列表（int[] arr, int index, int num)
    */
    /**
     * 在指定位置插入指定元素
     * 
     * @param arr int类型数组
     * @param index int类型数据，要插入的位置
     * @param num int类型数据， 要插入的数据
    */
    public static void insert(int[] arr, int index, int num) {
        if (index > arr.length - 1) {
            System.out.println("插入的位置错误！！");
            System.exit(0);
        }

        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = num;
    }
}