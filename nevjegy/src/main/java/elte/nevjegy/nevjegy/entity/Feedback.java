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
@SequenceGenerator(name = "feedbackgen", sequenceName = "feedbackgen", initialValue = 6)
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "feedbackgen")
    private Integer id;

    @Version
    private int version;

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


