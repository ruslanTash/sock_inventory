package sky.java6.sock_inventory.service;

import sky.java6.sock_inventory.DTO.NewMoving;
import sky.java6.sock_inventory.DTO.Operation;

public interface SockService {
    Integer getReport(String color, Operation operator, Integer cottonPart);

    void income(NewMoving newMoving);

    void outcome(NewMoving newMoving);
}
