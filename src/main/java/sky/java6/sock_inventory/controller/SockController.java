package sky.java6.sock_inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sky.java6.sock_inventory.DTO.NewMoving;
import sky.java6.sock_inventory.DTO.Operation;
import sky.java6.sock_inventory.service.SockService;

@RestController
@RequestMapping("/api/socks")
@RequiredArgsConstructor
public class SockController {
    private final SockService service;

    @GetMapping
    public Integer getReport(@RequestParam String color,
                             Operation operation,
                             Integer cottonPart
    ) {
        return service.getReport(color, operation, cottonPart);
    }

    @PostMapping("/income")
    public void income(@RequestBody NewMoving newMoving) {
        service.income(newMoving);
    }

    @PostMapping("/outcome")
    public void outcome(@RequestBody NewMoving newMoving) {
        service.outcome(newMoving);
    }
}
