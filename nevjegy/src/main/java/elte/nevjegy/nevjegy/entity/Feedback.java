package elte.nevjegy.nevjegy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Feedback")
public class Feedback extends BaseEntity {

    @Column(nullable = false)
    private int rateValue;
    private String text;

    @ManyToOne
    private BusinessCard businessCard;

    @ManyToOne
    private User user;
}
