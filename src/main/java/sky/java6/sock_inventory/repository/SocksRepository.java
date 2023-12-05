package sky.java6.sock_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sky.java6.sock_inventory.model.Socks;

import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Long> {
    Socks findByColorAndCottonPart(String color, Integer cottonPart);

}
