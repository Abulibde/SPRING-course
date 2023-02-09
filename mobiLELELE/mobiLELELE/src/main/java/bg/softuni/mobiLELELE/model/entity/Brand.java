package bg.softuni.mobiLELELE.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{



    private  String name;

    //•	id – a uuid or number.
    //•	name – a name of brand.
    //•	created – a date and time.
    //•	modified – a date and time.
}
