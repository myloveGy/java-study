package type;

class Integer {
    public static void main(String[] args) {
        
        // 当前时间毫秒数
        long start = System.currentTimeMillis();
        
        System.out.println(start);

        // 测试使用标签
        label:for (int i = 0; i < 100; i ++) {
            if (i == 10) {
                continue label;
            }

            System.out.println("i = " + i);
        }

        System.out.println("程序处理完成");
    }
}