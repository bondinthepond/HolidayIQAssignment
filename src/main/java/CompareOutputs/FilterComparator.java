package CompareOutputs;

import JsonReader.JsonReader;
import MockFIleReader.MockFileReader;
import ReqResDtos.GenericHotelResponseDto;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by aditya.mullela on 03/03/17.
 */
public class FilterComparator {

    MockFileReader fileReader = new MockFileReader();

    Map<String, String> applicableFilters;

    public void verifyFilterFunctionality(Map<String, String> filtersToBeTested) throws IOException {

        applicableFilters = filtersToBeTested;
        checkSubsets(fileReader.getSuperSetResponse(), fileReader.getFilterBasedResponse(applicableFilters));
    }

    public void checkSubsets(List<GenericHotelResponseDto> superSetPayload, List<GenericHotelResponseDto> subsetPayload){

        int i = getCountOfGenericHotelResponseDtos(superSetPayload);
        int j = getCountOfGenericHotelResponseDtos(subsetPayload);

        if(i == j){
            System.out.println("filters are working fine");
        } else {
            System.out.println("filters are not working");
        }
        System.out.println("i =" + i + " & " + "j = " + j);

    }

    public Integer getCountOfGenericHotelResponseDtos(List<GenericHotelResponseDto> payload){

        int count = 0;
        for(int i = 0; i< payload.size(); i++){
            if(payload.get(i).compareWithAnotherMap(applicableFilters))
                count++;
        }
        return count;
    }
}
