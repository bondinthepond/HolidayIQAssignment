package ReqResDtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aditya.mullela on 02/03/17.
 */


public class GenericHotelResponseDto {

    @JsonProperty("filters")
    Map<String, String> filter;

    @JsonProperty("hotel_id")
    int hotelId;

    @JsonProperty("hotel_name")
    String hotelName;

    @JsonProperty("price")
    int price;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<String, String> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, String> filter) {
        this.filter = filter;
    }

    public String getValueOfGivenKey(String key){
        return filter.get(key);
    }

    public Boolean compareWithAnotherMap(Map<String, String> anotherFilter) {

        if (filter == null || anotherFilter == null)
            return false;

        ArrayList<String> keyList = new ArrayList<String>();
        for (Object o : anotherFilter.keySet().toArray()) {
            keyList.add((String) o);
        }

        ArrayList<Boolean> arrayOfBoolean = new ArrayList<Boolean>();

        for (String key1 : anotherFilter.keySet()) {
                if (filter.containsKey(key1)) {
                    if (anotherFilter.get(key1).equals(filter.get(key1))) arrayOfBoolean.add(true);
                    else arrayOfBoolean.add(false);
                } else arrayOfBoolean.add(false);
            }

        if(arrayOfBoolean.contains(false))
            return false;
        else
            return true;
        }
    }

//    public boolean compareAllEntriesInHashMap(Map<String, String> anotherFilter, ArrayList<String> keyList){
//
//        Boolean[] listOfBooleanOutputs
//    }

