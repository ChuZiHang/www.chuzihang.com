package com.chuzihang.lesson.designpatterns.abstractFactoryPattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public interface SkinFactory {

    Button createButton();

    TextField createTextField();

    ComboBox createComboBox();
}
