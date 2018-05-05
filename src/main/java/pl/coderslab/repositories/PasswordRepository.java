package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Password;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}
