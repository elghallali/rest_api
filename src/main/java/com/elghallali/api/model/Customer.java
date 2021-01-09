package com.elghallali.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "The numberId shouldn't be empty")
    @Size(min = 8, max = 8, message = "The size of the document number is 8")
    @Column(nullable = false)
    private String numberId;
    @NotEmpty(message = "The first name shouldn't be empty")
    @Column(nullable = false)
    private String firstName;
    @NotEmpty(message = "The last name shouldn't be empty")
    @Column(nullable = false)
    private String lastName;
    @NotEmpty(message = "The email shouldn't be empty")
    @Column(unique = true,nullable = false)
    @Email(message = "Not a well-formed email address")
    private String email;
    @NotEmpty(message = "The username shouldn't be empty")
    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    private Date createAt;
    @NotEmpty(message = "The address should not be empty!")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties({"hibernateLazyInitialize","handler"})
    private Address address;
    private boolean enabled;
    private String state;
    private String photoUrl;
}
