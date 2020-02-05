class HomeWork17 {
    public static void main(String[] args) {
        /* 
                *
               ***
              *****
             *******
            *********
             *******
              *****
               ***
                *
         */

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < Math.abs(5 - i); j++) {
                System.out.print(' ');
            }

            for (int j = 0; j < (5 - Math.abs(5 - i) - 1) * 2 + 1; j++) {
                System.out.print('*');
            }
            System.out.println("");
        }
    }
}