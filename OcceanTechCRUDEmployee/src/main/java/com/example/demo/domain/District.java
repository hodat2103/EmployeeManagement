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
@Table(name = "tbl_district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int districtId;
    @Column(name = "district_name")
    private String districtName;

    @ManyToOne
    @JoinColumn(name = "province_id")
    Province province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    List<Commune> communes;

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    @Override
    public String toString() {
        return "District{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", province=" + province +
                ", communes=" + communes +
                '}';
    }
}
