package org.example;

import lombok.Getter;

import java.util.Arrays;

public enum BankEnum {
    acc("春天","1"),
    bcc("夏天","2"),
    ccc("秋天","3"),
    dcc("冬天","4");
    @Getter
    String code;
    @Getter
    String message;

    BankEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BankEnum getBankEnum(String code) {
        BankEnum[] bankEnums = BankEnum.values();
        
        for (BankEnum bankEnum : bankEnums) {
            //bankEnum中有code="春天",message="1",注意还有name=acc,所以可以用acc,春天,1来比较,只要有一个正确还回为true
            if (bankEnum.getCode().equalsIgnoreCase(code));
            {
                return bankEnum;
            }
        }
        return null;
    }


    public static BankEnum getBankEnum2(String code){
        //这段代码的作用是从BankEnum枚举类型中筛选出code属性与传入参数code相等的第一个枚举值，如果没有则返回null。
        // 步骤解释：
        //1. Arrays.stream(BankEnum.values())将BankEnum枚举类型转化为流(Stream)类型。
        //2. filter(t -> t.getCode().equalsIgnoreCase(code))对流中的每个元素进行过滤，只保留code属性与传入参数code相等的元素。
        //3. findFirst()获取流中第一个符合条件的元素。
        //4. orElse(null)如果没有符合条件的元素则返回null。
        //5. 和上一个方法相比这个方法只比较code,t.getCode就只比较code其他的都不行,会报null
        return Arrays.stream(BankEnum.values()).filter(t -> t.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        BankEnum acc1 = getBankEnum("acc");
        System.out.println("acc1 = " + acc1);
        System.out.println("acc1 = " + acc1.getCode());
        System.out.println("acc1 = " + acc1.getMessage());

        BankEnum bcc1 = getBankEnum2("acc");
        System.out.println("bcc1 = " + bcc1);
        System.out.println("bcc1 = " + bcc1.getCode());
    }




}
