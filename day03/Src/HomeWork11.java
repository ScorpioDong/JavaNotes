class HomeWork11 {
    public static void main(String[] args) {
        /* 多种方法打印26个小写字母 */
        for (int i = 0; i < 26; i++) {
            System.out.println((char) ('a' + i));
        }

        char ch = 'a';
        for (int i = 0; i < 26; i++) {
            System.out.println(ch);
            ch++;
        }
    }
}