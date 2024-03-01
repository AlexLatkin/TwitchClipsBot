package com.alexlatkin.twitchclipsbot.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchClip {
    public String id;
    public String url;
    public String embed_url;
    public int broadcaster_id;
    public String broadcaster_name;
    public int creator_id;
    public String creator_name;
    public int video_id;
    public int game_id;
    public String language;
    public String title;
    public int view_count;
    public Date created_at;
    public String thumbnail_url;
    public double duration;
    public int vod_offset;
    public boolean is_featured;



    public TwitchClip() {
    }

    public TwitchClip(String id, String url, String embed_url, int broadcaster_id, String broadcaster_name, int creator_id, String creator_name, int video_id, int game_id, String language, String title, int view_count, Date created_at, String thumbnail_url, double duration, int vod_offset, boolean is_featured) {
        this.id = id;
        this.url = url;
        this.embed_url = embed_url;
        this.broadcaster_id = broadcaster_id;
        this.broadcaster_name = broadcaster_name;
        this.creator_id = creator_id;
        this.creator_name = creator_name;
        this.video_id = video_id;
        this.game_id = game_id;
        this.language = language;
        this.title = title;
        this.view_count = view_count;
        this.created_at = created_at;
        this.thumbnail_url = thumbnail_url;
        this.duration = duration;
        this.vod_offset = vod_offset;
        this.is_featured = is_featured;
    }



    @Override
    public String toString() {
        return "TwitchClip{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", embed_url='" + embed_url + '\'' +
                ", broadcaster_id=" + broadcaster_id +
                ", broadcaster_name='" + broadcaster_name + '\'' +
                ", creator_id=" + creator_id +
                ", creator_name='" + creator_name + '\'' +
                ", video_id=" + video_id +
                ", game_id=" + game_id +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", view_count=" + view_count +
                ", created_at=" + created_at +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", duration=" + duration +
                ", vod_offset=" + vod_offset +
                ", is_featured=" + is_featured +
                '}';
    }
}
