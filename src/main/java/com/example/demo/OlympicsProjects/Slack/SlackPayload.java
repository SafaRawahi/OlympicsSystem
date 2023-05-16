package com.example.demo.OlympicsProjects.Slack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class SlackPayload {
    private String text;
    public SlackPayload(String text) {

        this.text = text;
    }
}
