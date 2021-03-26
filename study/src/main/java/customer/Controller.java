package customer;

import payment.Helper;

public class Controller {

    private final Model model = new Model(10);

    private final View view = new View();

    public void run() {
        boolean handle = true;
        while (handle) {
            view.showMainMenu(model.getTotal());
            char selector = Helper.readMenuSelection(new char[]{'1', '2', '3', '4', '5', '6'});
            handle = switchSelector(selector);
        }
    }

    public boolean switchSelector(char c) {
        switch (c) {
            case '1':
                view.showCustomerList(model.getCustomerList());
                return true;
            case '2':
                Customer newCustomer = new Customer();

                String name = Helper.readString("请输入姓名:", true);
                newCustomer.setName(name);

                int age = Helper.readNumber("请输入年龄:", true);
                newCustomer.setAge(age);

                String gender = Helper.readString("请输入性别(男/女):", new String[]{"男", "女"});
                newCustomer.setGender(gender);

                String phone = Helper.readString("请输入电话:", true);
                newCustomer.setPhone(phone);

                String email = Helper.readString("请输入邮箱:", true);
                newCustomer.setEmail(email);

                // 修改
                if (model.create(newCustomer)) {
                    System.out.println("添加客户信息成功");
                }

                return true;
            case '3':
                int updateIndex = getIndex("请输入需要编辑的客户序号");
                if (updateIndex == -1) {
                    return true;
                }

                // 验证用户是否存在
                Customer updateCustomer = model.getCustomer(updateIndex);
                if (updateCustomer == null) {
                    System.out.println("您输入的序号不存在");
                    return switchSelector('3');
                }

                String updateName = Helper.readString("请输入姓名(留空不修改):");
                if (!updateName.equals("")) {
                    updateCustomer.setName(updateName);
                }

                int updateAge = Helper.readNumber("请输入年龄(留空不修改):", false);
                if (updateAge > 0) {
                    updateCustomer.setAge(updateAge);
                }

                String updateGender = Helper.readString("请输入性别(留空不修改):");
                if (!updateGender.equals("")) {
                    updateCustomer.setGender(updateGender);
                }

                String updatePhone = Helper.readString("请输入电话(留空不修改):");
                if (!updatePhone.equals("")) {
                    updateCustomer.setPhone(updatePhone);
                }

                String updateEmail = Helper.readString("请输入邮箱(留空不修改):");
                if (!updateEmail.equals("")) {
                    updateCustomer.setEmail(updateEmail);
                }

                // 修改
                if (model.update(updateIndex, updateCustomer)) {
                    System.out.println("修改[" + updateIndex + "]客户信息成功");
                }

                return true;
            case '4':
                // 获取序号
                int deleteIndex = getIndex("请输入需要删除的客户序号");
                if (deleteIndex == -1) {
                    return true;
                }

                // 获取序号是否存在
                Customer deleteCustomer = model.getCustomer(deleteIndex);
                if (deleteCustomer == null) {
                    System.out.println("您输入的序号不存在");
                    return switchSelector('4');
                }

                // 需要确认是否需要删除
                System.out.println("您确定需要删除[" + deleteIndex + "]客户信息? (Y/N)");
                if ('N' == Helper.readConfirmSelection()) {
                    return true;
                }

                // 执行删除客户信息
                if (model.delete(deleteIndex)) {
                    System.out.println("删除[" + deleteIndex + "]客户信息成功");
                }

                return true;
            case '5':
                // 获取序号
                int detailIndex = getIndex("请输入需要查看的客户序号");
                if (detailIndex == -1) {
                    return true;
                }

                Customer customer = model.getCustomer(detailIndex);
                if (customer == null) {
                    System.out.println("您输入的序号不存在");
                    return switchSelector('5');
                }

                view.showCustomerDetail(model.getCustomer(detailIndex));
                return true;
            case '6':
                System.out.println("您确定需要退出该系统? (Y/N)");
                return 'Y' != Helper.readConfirmSelection();
        }

        return true;
    }

    public int getIndex(String description) {
        int number = model.getTotal() - 1;
        description += number > 0 ? "[0 - "+number+"]" : "[0]";
        return Helper.readNumber(description + "(-1退出):", false);
    }
}