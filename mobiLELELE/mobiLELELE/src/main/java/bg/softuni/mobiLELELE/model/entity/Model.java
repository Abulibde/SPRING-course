package bg.softuni.mobiLELELE.model.entity;

import bg.softuni.mobiLELELE.model.enums.CategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "model")
public class Model extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    private String imageUrl;

    private int startYear;

    private int endYear;

    //•  id – uuid or number.
    //•	name – a model name.
    //•	category – an enumeration (Car, Buss, Truck, Motorcycle)
    //•	imageUrl – the url of image with size between 8 and 512 characters.
    //•	startYear – a number.
    //•	endYear – a number.
    //•	created – a date and time.
    //•	modified – a date and time.
    //•	brand – a model brand.

}
