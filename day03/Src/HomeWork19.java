class HomeWork19 {
    public static void main(String[] args) {
        /* 
            ###*###
            ##*#*##
            #*###*#
            *#####*
            #*###*#
            ##*#*##
            ###*###
         */

        for (int i = 1; i <= 7; i++) {
            for (int k = 0; k < Math.abs(4 - i); k++) {
                System.out.print('#');
            }

            System.out.print('*');

            if (Math.abs(4 - i) != 3) {
                for (int k = 0; k < (3 - Math.abs(4 - i) - 1) * 2 + 1; k++) {
                    System.out.print('#');
                }
                System.out.print('*');
            }

            for (int k = 0; k < Math.abs(4 - i); k++) {
                System.out.print('#');
            }
            System.out.println("");
        }
    }
}