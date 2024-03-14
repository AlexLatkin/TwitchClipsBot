package com.alexlatkin.twitchclipsbot.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "broadcaster")
public class Broadcaster {
    @Id
    @Column(name = "broadcaster_id")
    private Integer broadcasterId;
    @Column(name = "broadcaster_name")
    private String broadcasterName;
    @ManyToMany(mappedBy = "followList")
    private List<User> userFollowList;
    @ManyToMany(mappedBy = "blackList")
    private List<User> userBlackList;
}
