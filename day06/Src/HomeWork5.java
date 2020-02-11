import java.util.Arrays;

class HomeWork5 {
    public static void main(String[] args) {
        // 删除数组中的指定下标的元素【难点】
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 0};
        delete(array, 2);
        
        System.out.println(Arrays.toString(array));
    }
    /*
        删除数组中的指定下标的元素
        public static 
        返回值类型 void
        方法名 delete
        形参列表（int[] arr, int index)
    */
    /**
     * 在指定位置删除指定元素
     * 
     * @param arr int类型数组
     * @param index int类型数据，要删除的位置
    */
    public static void delete(int[] arr, int index) {
        if (index > arr.length - 1 || index < 0) {
            System.out.println("删除的位置错误！！");
            System.exit(0);
        }

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = 0;
    }
}