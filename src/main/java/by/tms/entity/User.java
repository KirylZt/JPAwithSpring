package by.tms.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String userName;
    private String password;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    @OneToOne
    private Address address;
}
