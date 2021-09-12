package br.com.fiap.upposture.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
    @NotBlank(message = "O campo e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Column(unique=true)
    private String email;

    @Size(max = 100, message = "A senha deve ter no máximo 100 caracteres")
    @NotBlank(message = "O campo password é obrigatório")
    private String password;

    @Size(max = 100 , message = "O nome deve ter no máximo 100 caracteres")
    private String name;



}
