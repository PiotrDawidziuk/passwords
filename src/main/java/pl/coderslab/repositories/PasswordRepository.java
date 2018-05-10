package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Password;
import pl.coderslab.model.User;

import java.util.List;

public interface PasswordRepository extends JpaRepository<Password, Long> {

    public List<Password> findAllByUser(User id);

}
