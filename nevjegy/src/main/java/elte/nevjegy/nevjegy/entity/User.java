package elte.nevjegy.nevjegy.entity;

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

    @ManyToMany
    @JoinTable
    private List<BusinessCard> businessCard;

    @OneToMany(mappedBy = "user")
    private List<Feedback> feedbacks;
}
