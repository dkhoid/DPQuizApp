package com.ddk.utils.themes;
import com.ddk.quizapp.App;

public class LightThemeFactory implements ThemeFactory {
    @Override
    public String getStyleSheet() {
        var resource = App.class.getResource("light.css");
        return resource != null ? resource.toExternalForm() : "";
    }
}