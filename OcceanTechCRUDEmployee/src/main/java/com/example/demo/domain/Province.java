package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int provinceId;
    @Column(name = "province_name")
    private String provinceName;

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    List<District> districts;

    @Override
    public String toString() {
        return provinceName;
    }
}
