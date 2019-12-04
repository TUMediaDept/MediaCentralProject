package com.tumedia.mediaandroidpractice.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SearchRepoModel {
    @SerializedName("id")
    private int id;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("owner")
    private RepoOwner owner;

    @SerializedName("private")
    private boolean _private;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("fork")
    private String forkState;

    @SerializedName("url")
    private String url;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("pushed_at")
    private Date pushedAt;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("size")
    private int size;

    @SerializedName("stargazers_count")
    private int stargazersCnt;

    @SerializedName("watchers_count")
    private int watchersCnt;

    @SerializedName("language")
    private String language;

    @SerializedName("forks_count")
    private int forksCnt;

    @SerializedName("open_issues_count")
    private int openIssuesCnt;

    @SerializedName("master_branch")
    private String masterBranch;

    @SerializedName("default_branch")
    private String defaultBranch;

    @SerializedName("score")
    private double score;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public RepoOwner getOwner() {
        return owner;
    }

    public void setOwner(RepoOwner owner) {
        this.owner = owner;
    }

    public boolean isPrivateVal() {
        return _private;
    }

    public void setPrivateVal(boolean _private) {
        this._private = _private;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForkState() {
        return forkState;
    }

    public void setForkState(String forkState) {
        this.forkState = forkState;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(Date pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStargazersCnt() {
        return stargazersCnt;
    }

    public void setStargazersCnt(int stargazersCnt) {
        this.stargazersCnt = stargazersCnt;
    }

    public int getWatchersCnt() {
        return watchersCnt;
    }

    public void setWatchersCnt(int watchersCnt) {
        this.watchersCnt = watchersCnt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getForksCnt() {
        return forksCnt;
    }

    public void setForksCnt(int forksCnt) {
        this.forksCnt = forksCnt;
    }

    public int getOpenIssuesCnt() {
        return openIssuesCnt;
    }

    public void setOpenIssuesCnt(int openIssuesCnt) {
        this.openIssuesCnt = openIssuesCnt;
    }

    public String getMasterBranch() {
        return masterBranch;
    }

    public void setMasterBranch(String masterBranch) {
        this.masterBranch = masterBranch;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
