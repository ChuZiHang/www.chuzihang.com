package com.chuzihang.lesson.designpatterns.abstractFactoryPattern;

/**
 * Created by Q_先生 on 2019/1/2.
 */
public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
