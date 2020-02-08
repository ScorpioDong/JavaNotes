class HomeWork10 {
    public static void main(String[] args) {
        // 逢七过  0 ~ 100
        for (int i = 0; i <= 100; i++) {
            if (!isRelationOfSeven(i)) {
                System.out.print(i + " ");
            } 
        }
    }
    /*
		需求
			判断数字是否和7有关
		方法分析
			public static: 莫问
			返回值类型： boolean 
			方法名： isRelationOfSeven
			形参列表：(int num)
		方法声明
			public static boolean isRelationOfSeven(int num);
	*/
	/**
	* 判断数字是否和7有关 返回true or false
	*
	* @param num int类型数据
	* @return boolean类型 num和7有关返回true， 否则返回false
    */
    public static boolean isRelationOfSeven(int num) {
        return num % 7 == 0 || num % 10 == 7 || num / 10 == 7;
    }
}