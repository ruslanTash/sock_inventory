package sky.java6.sock_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sky.java6.sock_inventory.model.Socks;

import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Long> {
    Socks findByColorAndCottonPart(String color, Integer cottonPart);


    @Query("select sum(quantity) from Socks where color = :color and cotton_part > :cottonPart")
    Integer getQuantityByColorAndCottonPartMoreThen(@Param("color") String color,
                                                    @Param("cottonPart") Integer cottonPart);

    @Query("select sum(quantity) from Socks where color = :color and cotton_part < :cottonPart")
    Integer getQuantityByColorAndCottonPartLessThen(@Param("color") String color,
                                                    @Param("cottonPart") Integer cottonPart);

    @Query("select quantity from Socks where color = :color and cotton_part = :cottonPart")
    Integer getQuantityByColorAndCottonPartEqualsThen(@Param("color") String color,
                                                      @Param("cottonPart") Integer cottonPart);

}
