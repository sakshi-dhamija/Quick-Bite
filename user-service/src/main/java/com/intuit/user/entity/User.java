package com.intuit.user.entity;

import jakarta.persistence.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "quick_bite_user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @ElementCollection
    private List<Long> orderIds;

}
