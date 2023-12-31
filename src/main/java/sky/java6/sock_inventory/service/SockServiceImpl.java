package sky.java6.sock_inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import sky.java6.sock_inventory.DTO.NewMoving;
import sky.java6.sock_inventory.DTO.Operation;
import sky.java6.sock_inventory.model.Socks;
import sky.java6.sock_inventory.repository.SocksRepository;


@Component
@RequiredArgsConstructor
public class SockServiceImpl implements SockService {
    private final SocksRepository repository;

    @Override
    public Integer getReport(String color, Operation operation, Integer cottonPart) {

        if (operation == Operation.valueOf(String.valueOf(Operation.moreThan))) {
            return repository.getQuantityByColorAndCottonPartMoreThen(color, cottonPart);
        } else if (operation == Operation.valueOf(String.valueOf(Operation.lessThan))) {
            return repository.getQuantityByColorAndCottonPartLessThen(color, cottonPart);
        } else {
            return repository.getQuantityByColorAndCottonPartEqualsThen(color, cottonPart);
        }
    }

    @Override
    public void income(NewMoving newMoving) {
        Socks socks = repository.findByColorAndCottonPart(newMoving.getColor(), newMoving.getCottonPart());
        if (newMoving.getQuantity() < 1 || newMoving.getCottonPart() > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else if (socks == null) {
            repository.save(NewMoving.toSocks(newMoving));
        } else {
            socks.setQuantity(socks.getQuantity() + newMoving.getQuantity());
            repository.save(socks);
        }
    }

    @Override
    public void outcome(NewMoving newMoving) {
        Socks socks = repository.findByColorAndCottonPart(newMoving.getColor(), newMoving.getCottonPart());
        if (socks == null || newMoving.getQuantity() > socks.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            socks.setQuantity(socks.getQuantity() - newMoving.getQuantity());
            repository.save(socks);
        }
    }
}
