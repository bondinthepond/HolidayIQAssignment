package MockFIleReader;

import JsonReader.JsonReader;
import ReqResDtos.GenericHotelResponseDto;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by aditya.mullela on 03/03/17.
 */
public class MockFileReader {

    JsonReader jsonReader = new JsonReader();

    public List<GenericHotelResponseDto> getSuperSetResponse() throws IOException {

        List<GenericHotelResponseDto> superSetResponse = jsonReader.readJson("/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/SuperSetResponse");

        //method to call message client will be present here


        return superSetResponse;
    }

    public List<GenericHotelResponseDto> getFilterBasedResponse(Map<String, String> filters) throws IOException {

        //method to call message client will be present here

        String pathName = null;
        for (String key: filters.keySet()) {
            if(key.equals("hotel_type") && filters.get(key).equals("hotel"))
                pathName = "/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/HotelType_Hotel_Response";
            else if(key.equals("hotel_type") && filters.get(key).equals("resort") && filters.containsKey("award_winner"))
                pathName = "/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/AwardWinnerYes_HotelTypeResort_Response.json";
            else if(key.equals("hotel_type") && filters.get(key).equals("resort") && !filters.containsKey("award_winner"))
                pathName = "/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/HotelType_resort_Response";
            else if(key.equals("award_winner") && filters.get(key).equals("yes"))
                pathName = "/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/AwardWinner_Yes_Response";
            else if(key.equals("award_winner") && filters.get(key).equals("no"))
                pathName = "/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/AwardWinner_No_Response";
            else if(key.equals("star_rating") && filters.get(key).equals("4"))
                pathName = "/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/StarRating_4_Response";
            else if(key.equals("star_rating") && filters.get(key).equals("1"))
                pathName = "/Users/aditya.mullela/git2/HolidayIQAssignment/src/main/resources/StarRating_1_Incorrect_Response";
            else {
                System.out.println("that search criteria has not been mocked");
                System.exit(0);
            }
        }
        
        List<GenericHotelResponseDto> filterSpecificResponse = jsonReader.readJson(pathName);

        return  filterSpecificResponse;
    }

}
