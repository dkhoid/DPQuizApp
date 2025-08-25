package com.ddk.utils.themes;
import javafx.scene.Scene;

public class ThemeManager {
    private static ThemeFactory themeFactory = new DefaultThemeFactory();

    public static void setThemeFactory(ThemeFactory aThemeFactory) {
        themeFactory = aThemeFactory;
    }
    
    public static void applyTheme(Scene scene) {
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(themeFactory.getStyleSheet());
    }
}