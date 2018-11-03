package elte.nevjegy.nevjegy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Feedback")
public class Feedback extends BaseEntity {

    @Column(nullable = false)
    private Integer rateValue;

    private String text;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private BusinessCard businessCard;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;
}
