package sky.java6.sock_inventory.DTO;

import lombok.Data;
import sky.java6.sock_inventory.model.Socks;

@Data
public class NewMoving {
    private String color;
    private Integer cottonPart;
    private Integer quantity;

    public static Socks toSocks(NewMoving in){
        Socks out = new Socks();
        out.setColor(in.getColor());
        out.setCottonPart(in.getCottonPart());
        out.setQuantity(in.getQuantity());
        return out;
    }
}
