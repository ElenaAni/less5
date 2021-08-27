package dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
public class Product {
    Integer Id;
    String title;
    Integer price;
    String categoryTitle;
}
