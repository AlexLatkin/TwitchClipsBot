package com.alexlatkin.twitchclipsbot.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity(name = "broadcaster")
public class Broadcaster {
    @Id
    @Column(name = "broadcaster_id")
    private Integer broadcasterId;
    @Column(name = "broadcaster_name")
    private String broadcasterName;
    @ManyToMany(mappedBy = "followList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> userFollowList;
    @ManyToMany(mappedBy = "blackList", fetch = FetchType.EAGER)
    private List<User> userBlackList;

    @Override
    public String toString() {
        return "Broadcaster{" +
                "broadcasterId=" + broadcasterId +
                ", broadcasterName='" + broadcasterName + '\'' +
                '}';
    }
}
