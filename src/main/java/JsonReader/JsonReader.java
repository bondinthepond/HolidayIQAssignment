package JsonReader;

import ReqResDtos.GenericHotelResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by aditya.mullela on 03/03/17.
 */
public class JsonReader {

    ObjectMapper mapper;

    public JsonReader(){

        this.mapper = new ObjectMapper();
    }

    public List<GenericHotelResponseDto> readJson(String pathName) throws IOException {

    List<GenericHotelResponseDto> responsePayload = mapper.readValue(new File(pathName), new TypeReference<List<GenericHotelResponseDto>>() { });
        GenericHotelResponseDto[] array = mapper.readValue(new File(pathName), GenericHotelResponseDto[].class);
        return responsePayload;
}
}
