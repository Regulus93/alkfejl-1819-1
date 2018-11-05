package elte.nevjegy.nevjegy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BusinessCard")
@SequenceGenerator(name = "bcgen", sequenceName = "bcgen", initialValue = 6)
public class BusinessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bcgen")
    private Integer id;

    @Version
    private int version;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;

    @ManyToMany(mappedBy = "businessCard", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JsonIgnore
    private List<User> user;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "businessCard", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @ManyToOne
    @JsonIgnore
    private User owner;
}
