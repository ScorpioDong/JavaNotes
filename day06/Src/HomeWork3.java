import java.util.Arrays;
class HomeWork3 {
    public static void main(String[] args) {
        // 找出指定元素在指定数组中所有下标位置 【难点】  不会！！！
        int[] arr = new int[]{1,2,3,4,5,4,3,4,3,5,2};
        int[] index = new int[0];
        int count = getAllIndexOf(arr, 3, index);
        System.out.println(count + "   " + Arrays.toString(index));
    }
    /*
        找出指定元素在指定数组中所有下标位置
        public static
        返回值类型 int
        方法名 getAllIndexOf
        形参列表 (int[] arr, int num,int[] index)

        public static int getAllIndexOf(int[] arr, int num,int[] index);
    */
    /** 
     * 找出指定元素在指定数组中所有下标位置
     * 
     * @param arr int类型数组
     * @param num int类型数据
     * @param index int类型数组，存储下标
     * @return int 返回arr数组中num元素的个数
     */
    public static int getAllIndexOf(int[] arr, int num,int[] index) {
        int[] indexs = new int[]{-1};
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                int[] temp = new int[indexs.length + 1];
                System.arraycopy(indexs, 0, temp, 0, indexs.length);
                indexs = temp;
                count++;
                indexs[indexs.length - 1] = i;
            }
        }
        index = indexs;
        System.out.println(Arrays.toString(index));

        return count;
    }
}