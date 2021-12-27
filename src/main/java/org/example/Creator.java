package org.example;

public class Creator {
    private final String creator;
    private final String cloudTool;
    private final String language;
    private final String container;
    private final String buildTool;

    public Creator(String creator, String cloudTool, String language, String container, String buildTool) {
        this.creator = creator;
        this.cloudTool = cloudTool;
        this.language = language;
        this.container = container;
        this.buildTool = buildTool;
    }

    public String getContainer() {
        return container;
    }

    public String getLanguage() {
        return language;
    }

    public String getCloudTool() {
        return cloudTool;
    }

    public String getCreator() {
        return creator;
    }

    public String getBuildTool() {
        return buildTool;
    }
}
