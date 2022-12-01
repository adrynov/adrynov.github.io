package com.adrynov.benchmarking.models;

public enum Lingo {
    EN("English"),
    IT("Italian"),
    JA("Japanese"),
    CZ("Mandarin"),
    FR("French"),
    DE("German");

    private String label;

    Lingo(String label) {
        this.label = label;
    }

    public static Lingo findByLanguage(String label) {
        for (Lingo languages : values()) {
            if (languages.label.equalsIgnoreCase(label)) return languages;
        }
        return null;
    }
}
