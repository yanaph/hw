package ua.fan.service;

import lombok.Getter;

@Getter
public enum MenuActions {
    SEARCH_SMS_BY_PHRASE ("Search through SMS by phrase"),
    TOP5_SUBSCRIBERS_BY_CALLS ("TOP5 subscribers by calls"),
    TOP5_SUBSCRIBERS_BY_SMS ("TOP5 subscribers by SMS"),
    TOP5_SUBSCRIBERS_BY_INTERNET ("TOP5 subscribers by Internet requests"),
    MOST_POPULAR_SERVICE ("Most popular service"),
    MOST_POPULAR_DEVICE ("Most popular device"),
    EXIT ("Exit");

    private final String name;
    MenuActions(String name) {
        this.name = name;
    }
}
