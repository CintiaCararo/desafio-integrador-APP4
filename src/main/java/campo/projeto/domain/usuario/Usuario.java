package campo.projeto.domain.usuario;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 *  a interface UserDetails é parte central do Spring Security. Ela representa um usuário autenticado no sistema. 
 *  Essa interface permite que o Spring saiba quem é o usuário, suas credenciais, e seus papéis (roles)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario  implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;

     // Retorna os papéis/autoridades do usuário
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Collections.emptyList(); 
    }
    @Override
    public String getPassword() {
        return senha;
    }
    @Override
    public String getUsername() {
       return this.usuario;
    }
}
