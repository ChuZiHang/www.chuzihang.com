package com.chuzihang.lesson.designpatterns.abstractFactoryPattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SkinFactory factory;
        Button bt;
        TextField tf;
        ComboBox cb;

        Class<?> name = Class.forName("com.chuzihang.lesson.designpatterns.abstractFactoryPattern.SpringSkinFactory");
        factory = (SkinFactory)name.newInstance();
        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createComboBox();

        bt.display();
        tf.display();
        cb.display();
    }
}
