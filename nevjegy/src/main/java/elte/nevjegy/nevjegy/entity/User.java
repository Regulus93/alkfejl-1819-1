package elte.nevjegy.nevjegy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import elte.nevjegy.nevjegy.enumtype.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.context.annotation.Primary;

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

    @ManyToMany
    @JoinTable
    @JsonIgnore
    private List<BusinessCard> businessCard;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Feedback> feedbacks;
}
