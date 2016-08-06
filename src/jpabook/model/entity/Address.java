package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Kj Nam
 * @since 2016-08-06
 */
@Embeddable
public class Address {

    @Column(name = "city")
    private String city;
    private String steet;
    private String zipcode;
}
