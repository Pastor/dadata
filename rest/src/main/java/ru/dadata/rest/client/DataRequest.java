package ru.dadata.rest.client;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class DataRequest implements Serializable {
    @SerializedName("structure")
    public String[] structure = new String[0];
    @SerializedName("data")
    public List<String[]> data = new ArrayList<String[]>();
}
