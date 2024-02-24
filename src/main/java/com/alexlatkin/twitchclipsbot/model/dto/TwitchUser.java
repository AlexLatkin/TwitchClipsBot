package com.alexlatkin.twitchclipsbot.model.dto;

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

    @Override
    public String toString() {
        return "TwitchUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", display_name='" + display_name + '\'' +
                ", type='" + type + '\'' +
                ", broadcaster_type='" + broadcaster_type + '\'' +
                ", description='" + description + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", offline_image_url='" + offline_image_url + '\'' +
                ", view_count=" + view_count +
                ", created_at=" + created_at +
                '}';
    }
}
