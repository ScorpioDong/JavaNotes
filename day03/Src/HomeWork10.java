class HomeWork10 {
    public static void main(String[] args) {

        /* 逢7过！！ */

        int sum = 0;

        for (int i = 0; i <= 1000; i++) {
            if (Integer.toString(i).indexOf('7') == -1) {
                System.out.print(i + " ");
            }
        }
    }
}