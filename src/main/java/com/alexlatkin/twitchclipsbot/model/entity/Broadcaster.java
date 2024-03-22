package com.alexlatkin.twitchclipsbot.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Broadcaster that = (Broadcaster) o;
        return broadcasterId.equals(that.broadcasterId) && broadcasterName.equals(that.broadcasterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(broadcasterId, broadcasterName);
    }
}
