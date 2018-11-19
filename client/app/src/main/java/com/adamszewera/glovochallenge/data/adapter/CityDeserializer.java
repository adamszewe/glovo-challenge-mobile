package com.adamszewera.glovochallenge.data.adapter;

import com.adamszewera.glovochallenge.data.models.City;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.*;
import com.google.maps.android.PolyUtil;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CityDeserializer implements JsonDeserializer<City> {

    @Override
    public City deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        City city = new City();
        final JsonObject jsonObject = json.getAsJsonObject();

        if (jsonObject.has("code")) city.setCode(jsonObject.get("code").getAsString());
        if (jsonObject.has("name")) city.setName(jsonObject.get("name").getAsString());
        if (jsonObject.has("country_code")) city.setCountry_code(jsonObject.get("country_code").getAsString());
        if (jsonObject.has("currency")) city.setCurrency(jsonObject.get("currency").getAsString());
        if (jsonObject.has("enabled")) city.setEnabled(jsonObject.get("enabled").getAsBoolean());
        if (jsonObject.has("busy")) city.setBusy(jsonObject.get("busy").getAsBoolean());
        if (jsonObject.has("time_zone")) city.setTime_zone(jsonObject.get("time_zone").getAsString());
        if (jsonObject.has("language_code")) city.setLanguage_code(jsonObject.get("language_code").getAsString());

        List<LatLng> allPoints = new ArrayList<>();
        final JsonArray jsonArray = jsonObject.get("working_area").getAsJsonArray();
        for (int i=0; i < jsonArray.size(); i++) {
            final JsonElement jsonPolyline = jsonArray.get(i);
            String polyline = jsonPolyline.getAsString();

            List<LatLng> path =  PolyUtil.decode(polyline);
            allPoints.addAll(path);
        }
        city.setWorking_area(allPoints);

        return city;
    }

}
