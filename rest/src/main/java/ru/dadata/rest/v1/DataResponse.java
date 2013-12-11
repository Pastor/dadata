package ru.dadata.rest.v1;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

final class DataResponse {
    @SerializedName("detail")
    public String detail;
    @SerializedName("structure")
    public String[] structure = new String[0];
    @SerializedName("data")
    public List<EntityImpl1v[]> data = new ArrayList<EntityImpl1v[]>();
}
