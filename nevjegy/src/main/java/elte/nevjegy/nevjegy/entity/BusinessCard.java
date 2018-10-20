package elte.nevjegy.nevjegy.entity;

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
public class BusinessCard extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;

    @ManyToMany(mappedBy = "businessCard")
    private List<User> user;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "businessCard")
    private List<Feedback> feedbacks;

}
