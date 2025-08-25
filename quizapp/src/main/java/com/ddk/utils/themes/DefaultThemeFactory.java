package com.ddk.utils.themes;
import com.ddk.quizapp.App;

public class DefaultThemeFactory implements ThemeFactory {
    @Override
    public String getStyleSheet() {
        var resource = App.class.getResource("style.css");
        return resource != null ? resource.toExternalForm() : "";
    }
}