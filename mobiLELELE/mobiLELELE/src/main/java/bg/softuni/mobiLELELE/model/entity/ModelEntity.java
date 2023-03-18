package bg.softuni.mobiLELELE.model.entity;

import bg.softuni.mobiLELELE.model.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class ModelEntity extends BaseEntity {


@Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum category;

    @Column(nullable = false)
    private String imageUrl;

    private int startYear;

    private Long endYear;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public Long getEndYear() {
        return endYear;
    }

    public void setEndYear(Long endYear) {
        this.endYear = endYear;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + (brand != null ? brand.getName() : null) +
                '}';
    }

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
