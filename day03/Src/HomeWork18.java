class HomeWork18 {
    public static void main(String[] args) {
        /* 
                A
               ABA
              ABCBA
             ABCDCBA
            ABCDEDCBA
             ABCDCBA
              ABCBA
               ABA
                A
         */

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < Math.abs(5 - i); j++) {
                System.out.print(' ');
            }

            int loop = 5 - Math.abs(5 - i) - 1; // 0 1 2 3 4 3 2 1 0
            for (int j = 0; j < loop * 2 + 1; j++) {
                System.out.print((char) ('A' + (loop - Math.abs(loop - j))));
            }
            System.out.println("");
        }
    }
}