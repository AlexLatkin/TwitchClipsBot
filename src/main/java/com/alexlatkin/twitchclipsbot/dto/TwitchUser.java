package com.alexlatkin.twitchclipsbot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchUser {
    public int id;
    public String login;
    public String display_name;
    public String type;
    public String broadcaster_type;
    public String description;
    public String profile_image_url;
    public String offline_image_url;
    public int view_count;
    public Date created_at;
}
