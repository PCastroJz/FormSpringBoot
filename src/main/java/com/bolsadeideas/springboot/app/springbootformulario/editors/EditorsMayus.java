package com.bolsadeideas.springboot.app.springbootformulario.editors;

import java.beans.PropertyEditorSupport;

public class EditorsMayus extends PropertyEditorSupport{

    @Override
    public void setAsText(String arg0) throws IllegalArgumentException {
        setValue(arg0.toUpperCase().trim());
    }
    
}
