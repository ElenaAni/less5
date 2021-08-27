package dto;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Category<Product> {
    Integer id;
    String title;
    ArrayList<Product> products;
}
