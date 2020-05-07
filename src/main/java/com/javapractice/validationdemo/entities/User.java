package com.javapractice.validationdemo.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.javapractice.validationdemo.validations.NameConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class User implements Serializable{
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "id", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotBlank(message = "First Name cannot be blank")
    @Size(min = 2, max = 20, message = "Name cannot be more than 20 characters")
    @NameConstraint
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Size(min = 2, max = 20, message = "Name cannot be more than 20 characters")
    @NameConstraint
    private String lastName;

    @NotBlank
    @Email(message = "not a valid email")
    private String email;
    
}