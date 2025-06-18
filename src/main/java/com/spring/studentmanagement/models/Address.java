package com.spring.studentmanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
@Entity(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @SequenceGenerator(name = "seq_address", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_address') UNIQUE")
    private Long id;

    @Column(name = "country", length = 45, nullable = false)
    private String country;

    @Column(name = "city", length = 45, nullable = false)
    private String city;

    @Column(name = "door_number", length = 10, nullable = false)
    private String doorNumber;

    @Column(name = "additional_details", length = 65)
    private String additionalDetails;

    @OneToOne(mappedBy = "address")
    private AppUser user;

}
