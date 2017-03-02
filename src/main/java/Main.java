import CompareOutputs.FilterComparator;
import JsonReader.JsonReader;
import ReqResDtos.GenericHotelResponseDto;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aditya.mullela on 03/03/17.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        FilterComparator filterComparator = new FilterComparator();

        Map<String, String> filtersToBeTested = new HashMap<String, String>();
        filtersToBeTested.put("hotel_type", "resort");
        filtersToBeTested.put("award_winner", "yes");

        filterComparator.verifyFilterFunctionality(filtersToBeTested);

    }
}
