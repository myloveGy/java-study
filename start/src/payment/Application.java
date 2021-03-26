package payment;

public class Application {
    public static void main(String[] args) {
        boolean isFlag = true;

        String details = "";
        int total = 0;

        while (isFlag) {
            System.out.println("--- 收账系统 ---\n");
            System.out.println("1. 收支明细");
            System.out.println("2. 登记收入");
            System.out.println("3. 登记支出");
            System.out.println("4. 退   出\n");
            System.out.println("--- 收账系统 ---\n");
            System.out.println("请选择您的操作 [1-4]:\n");

            // 获取用户选择
            char selection = Helper.readMenuSelection();
            switch (selection) {
                case '1':
                    System.out.println("---------- 收支明细 ----------");
                    System.out.println("收支\t账号金额\t收支金额\t说明\n");
                    System.out.println("---------------------------------------------------");
                    System.out.println(details);
                    System.out.println("---------------------------------------------------");
                    break;
                case '2':
                    System.out.println("---------- 录入收入金额 ----------");
                    System.out.print("本次收入金额:");
                    int money = Helper.readNumber();
                    System.out.print("本次收入说明:");
                    String description = Helper.readString();
                    total += money;
                    details += "收入\t" + total + "\t" + money + "\t" + description + "\n";
                    System.out.println("---------- 录入收入成功 ----------");
                    break;
                case '3':
                    System.out.println("---------- 录入支出金额 ----------");
                    System.out.print("本次支出金额:");
                    int money1 = Helper.readNumber();
                    System.out.print("本次支出说明:");
                    String description1 = Helper.readString();
                    total -= money1;
                    details += "支出\t" + total + "\t" + money1 + "\t" + description1 + "\n";
                    System.out.println("---------- 录入支出成功 ----------");
                    break;
                case '4':
                    System.out.println("您确定需要退出该系统? (Y/N)");
                    if ('Y' == Helper.readConfirmSelection()) {
                        isFlag = false;
                    } else continue;
                break;
            }
        }
    }
}