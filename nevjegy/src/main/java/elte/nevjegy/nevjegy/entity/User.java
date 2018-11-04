package elte.nevjegy.nevjegy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import elte.nevjegy.nevjegy.enumtype.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(joinColumns=@JoinColumn(name = "USER_ID"), inverseJoinColumns=@JoinColumn(name = "BUSINESS_CARD_ID"))
    @JsonIgnore
    private List<BusinessCard> businessCard;

    @OneToMany(mappedBy = "owner")
    private List<BusinessCard> ownedBusinessCard;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Feedback> feedbacks;
}
