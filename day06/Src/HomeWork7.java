import java.util.Arrays;

class HomeWork7 {
    public static void main(String[] args) {
        // 选择排序算法
        int[] array = {1, 3, 9, 7, 5, 17, 15, 11, 13, 0};
        sort(array);
        
        System.out.println(Arrays.toString(array));
    }

    /*
        选择排序算法
        public static 
        返回值类型 void
        方法名 sort
        形参列表 (int[] arr)
    */
    /**
     * 选择排序算法
     * 
     * @param arr int类型数组
     */
    public static void sort(int[] arr) {
        int maxIndex = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }

            int max = arr[maxIndex];
            for(int j = maxIndex; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[i] = max;
        }
    }
}