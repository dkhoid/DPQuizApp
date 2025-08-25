package com.ddk.utils.themes;
import com.ddk.quizapp.App;

public class DarkThemeFactory implements ThemeFactory {
    @Override
    public String getStyleSheet() {
        var resource = App.class.getResource("dark.css");
        return resource != null ? resource.toExternalForm() : "";
    }
}