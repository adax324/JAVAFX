package com.adaxator.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tempClass {

    private StringProperty stringProperty=new SimpleStringProperty();
    private BooleanProperty visible=new SimpleBooleanProperty(false);
    public StringProperty getStringProperty() {
        return stringProperty;
    }
    public BooleanProperty getVisible(){
        return this.visible;
    }
    public tempClass(){
        visible.bind(stringProperty.isNotEmpty());
    }
}
