import java.util.Arrays;

class HomeWork6 {
    public static void main(String[] args) {
        // 找出数组中最大值元素，放到下标为0的位置
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 0};

        method(array);   
        System.out.println(Arrays.toString(array));

        method1(array);   
        System.out.println(Arrays.toString(array));

        method2(array);   
        System.out.println(Arrays.toString(array));
    }
    /*
        找出数组中最大值元素，放到下标为0的位置
        public static 
        返回值类型 void
        方法名 method
        形参列表（int[] arr)
    */
    /**
     * 找出数组中最大值元素，放到下标为0的位置
     * 
     * @param arr int类型数组
    */
    public static void method(int[] arr) {
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        int max = arr[maxIndex];
        for (int i = maxIndex; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = max;
    }

    /*
        找出数组中第二大值元素，放到下标为1的位置
        public static 
        返回值类型 void
        方法名 method1
        形参列表（int[] arr)
    */
    /**
     * 找出数组中第二大值元素，放到下标为1的位置
     * 
     * @param arr int类型数组
    */
    public static void method1(int[] arr) {
        int maxIndex = 1;

        for (int i = 2; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        
        int max = arr[maxIndex];
        for (int i = maxIndex; i > 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[1] = max;
    }

    /*
        找出数组中第二大值元素，放到下标为1的位置
        public static 
        返回值类型 void
        方法名 method1
        形参列表（int[] arr)
    */
    /**
     * 找出数组中第三大值元素，放到下标为2的位置
     * 
     * @param arr int类型数组
    */
    public static void method2(int[] arr) {
        int maxIndex = 2;

        for (int i = 3; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        
        int max = arr[maxIndex];
        for (int i = maxIndex; i > 2; i--) {
            arr[i] = arr[i - 1];
        }
        arr[2] = max;
    }
}