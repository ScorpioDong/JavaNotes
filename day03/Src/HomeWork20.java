class HomeWork20 {
    public static void main(String[] args) {
        /* 
            画一个爱心 
            方程：
                (x^2 + y^2 -1)^3 = x^2 * y^3
        */
        for (float y = 1.5F; y > -1.5F; y -= 0.1F) {
            for (float x = -1.5F; x < 1.5F; x += 0.05F) {
                float a = x * x + y * y - 1;
                if (a * a * a - x * x * y * y * y <= 0){
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println("");
        
        }
    }
}