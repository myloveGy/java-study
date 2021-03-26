package customer;

public class View {

    public void showMainMenu(int num) {
        System.out.println("\n ------ 客户信息管理软件 ------ \n");
        if (num > 0) {
            System.out.println("1. 查看客户列表");
        }

        System.out.println("2. 添加客户信息");

        // 存在客户信息
        if (num > 0) {
            System.out.println("3. 更新客户消息");
            System.out.println("4. 删除客户信息");
            System.out.println("5. 查看客户详情");
        }

        System.out.println("6. 退出系统\n");
        System.out.println("请选择你需要进行的操作(1 - 6): ");
    }

    public void showCustomerList(Customer[] customers) {
        System.out.println("\n ------ 客户信息列表 ------ \n");
        System.out.println("序号\t姓名\t性别\t年龄\t电话\t邮箱");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(
                    i + "\t" +
                            customers[i].getName() + "\t" +
                            customers[i].getGender() + "\t" +
                            customers[i].getAge() + "\t" +
                            customers[i].getPhone() + "\t" +
                            customers[i].getEmail()
            );
        }

        System.out.println("\n");
    }

    public void showCustomerDetail(Customer customer) {
        System.out.println("\n ------ 客户信息详情 ------ \n");
        System.out.println("姓名: " + customer.getName());
        System.out.println("性别: " + customer.getGender());
        System.out.println("年龄: " + customer.getAge());
        System.out.println("电话: " + customer.getPhone());
        System.out.println("邮箱: " + customer.getEmail() + "\n");
    }
}