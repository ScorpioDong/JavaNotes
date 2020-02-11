# Eclipse使用和数组算法

> ScorpioDong

## 1. Eclipse常用快捷键

1. `Alt + /`:补齐代码
2. `Ctrl + /`:代码注释
3. `Ctrl + Shift + /`: 多行代码注释
4. `Ctrl + 1`: 快速修复,功能很多
5. `Ctrl + Shift + ↑/↓`:复制当前代码
6. `Ctrl + ↑/↓`: 移动当前行代码
7. `Ctrl + D`: 删除当前行代码
8. `Ctrl + +/-`: 修改当前编辑器的大小
9. `Ctrl + K`: 快速搜索
10. `Shift + Enter`: 直接回车到下一行

## 2. 数组算法

### 2.1 找出数组最小值元素的下标
```
    遍历整个数组,找最小值,记录下标
```

### 2.2 找数组指定元素最后一次出现的下标
```
    优化:
        从后向前找,找到后结束循环,返回
```

### 2.3 找出指定元素所有下标
```
    1. 尾插法思想，计数器同时也是下一次存放数据的位置
    2. 数组作为方法参数之后，是可以近似数据传导\

    返回找到的元素的个数
    传入另一个数组,存储元素的下标位置
```

### 2.4 数组指定位置插入指定元素
```
    1. 空数据，无效数据思想
    2. 数据的移动过程，粗加工，细打磨过程
    3. 时间消耗问题
```
```java
    for (int i = arr.length - 1; i > index; i--) {
        arr[i] = arr[i - 1];
    }
    
    arr[index] = insert;
```

### 2.5 删除数组指定位置元素
```java
    for (int i = index; i < arr.length - 1; i++) {
        arr[i] = arr[i + 1];
    }
    
    // 最后一位数据赋值为0，占位，同时告知用户这是一个无效数据
    arr[arr.length - 1] = 0;
    return true;
```

### 2.6 查找数组最大值,放入0位置
```java
    // 假设最大值的下标位置为0
    int index = 0;

    // 这里一定可以得到最大值所在的下标位置
    for (int i = 1; i < arr.length; i++) {
        if (arr[index] < arr[i]) {
            index = i;
        }
    }

    // 交换数据
    if (index != 0) {
        int temp = arr[0];
        arr[0] = arr[index];
        arr[index] = temp;
    }
```

### 2.7 查找数组剩余最大值,放入1位置
```java
    int index1 = 1;

    for (int i = 2; i < arr.length; i++) {
        if (arr[index1] < arr[i]) {
            index1 = i;
        }
    }

    if (index1 != 1) {
        int temp = arr[1];
        arr[1] = arr[index1];
        arr[index1] = temp;
    }

    System.out.println(Arrays.toString(arr));
```

### 2.8 查找数组剩余最大值,放入2位置
```java
    int index2 = 2;

    for (int i = 3; i < arr.length; i++) {
        if (arr[index2] < arr[i]) {
            index2 = i;
        }
    }

    if (index2 != 2) {
        int temp = arr[2];
        arr[2] = arr[index2];
        arr[index2] = temp;
    }

    System.out.println(Arrays.toString(arr));
```

### 2.9  实现选择排序算法
```java
/**
 * 选择排序算法
 * 
 * @param arr 需要进行排序的int类型数据
 */
public static void selectSort(int[] arr) {
    // 外层循环控制核心算法的循环次数
    for (int i = 0; i < arr.length - 1; i++) {
        // 从index位置开始找寻极值
        int index = i;
        
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[index] > arr[j]) {
                index = j;
            }
        }
        
        if (index != i) {
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
```

## 3. Arrays数组工具类使用
```
数组工具类:
    提供数组操作的基本方法
    sort(int[] arr);
        快速排序算法
    binarySearch(int[] arr, int find);
        二分法查询,要求数组有序
    toString(任意类型数组)
        数组内容作为字符串返回值
```
