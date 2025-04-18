package com.example.bigproject998;

public class ThemeManager {
    private static ThemeManager instance;
    private String currentTheme = "light.css";

    private ThemeManager() {}

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }

    public String getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(String theme) {
        this.currentTheme = theme;
    }
}