package ru.dadata.rest.v1;

import com.google.gson.annotations.SerializedName;
import ru.dadata.rest.*;

final class EntityImpl1v implements Entity, EntityAddress, EntityName, EntityPhone {
    @SerializedName("postal_code")
    private String postalCode;
    @SerializedName("country")
    private String country;
    @SerializedName("region")
    private String region;
    @SerializedName("area")
    private String area;
    @SerializedName("city")
    private String city;
    @SerializedName("settlement")
    private String settlement;
    @SerializedName("street")
    private String street;
    @SerializedName("house_type")
    private String houseType;
    @SerializedName("house")
    private String house;
    @SerializedName("block_type")
    private String blockType;
    @SerializedName("block")
    private String block;
    @SerializedName("flat_type")
    private String flatType;
    @SerializedName("flat")
    private String flat;
    @SerializedName("postal_box")
    private String postalBox;
    @SerializedName("type")
    private String type;
    @SerializedName("phone")
    private String phone;
    @SerializedName("provider")
    private String provider;
    @SerializedName("qc")
    private int qc = -1;
    @SerializedName("qc_complete")
    private int qc_complete = -1;
    @SerializedName("source")
    private String source;
    @SerializedName("surname")
    private String surname;
    @SerializedName("name")
    private String name;
    @SerializedName("patronymic")
    private String patronymic;
    @SerializedName("gender")
    private String gender;

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public String getArea() {
        return area;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getSettlement() {
        return settlement;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getHouseType() {
        return houseType;
    }

    @Override
    public String getHouse() {
        return house;
    }

    @Override
    public String getBlockType() {
        return blockType;
    }

    @Override
    public String getBlock() {
        return block;
    }

    @Override
    public String getFlatType() {
        return flatType;
    }

    @Override
    public String getFlat() {
        return flat;
    }

    @Override
    public String getPostalBox() {
        return postalBox;
    }


    @Override
    public String getSource() {
        return source;
    }

    @Override
    public QualityCode getGC() {
        return QualityCode.valueOf(qc);
    }

    @Override
    public QualityCodeComplete getGCComplete() {
        return QualityCodeComplete.valueOf(qc_complete);
    }


    private QueryFieldType fieldType = QueryFieldType.AS_IS;

    void setEntityType(QueryFieldType fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public QueryFieldType getEntityType() {
        return fieldType;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getProvider() {
        return provider;
    }
}
