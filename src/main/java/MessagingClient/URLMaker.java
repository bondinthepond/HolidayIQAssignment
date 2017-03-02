package MessagingClient;

import ReqResDtos.GenericHotelListRequestParams;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by aditya.mullela on 03/03/17.
 */
public class URLMaker {

        GenericHotelListRequestParams genericHotelListRequestParams = new GenericHotelListRequestParams();

        public String makeURL() throws URISyntaxException {

            String currentUrl = "http://127.0.0.1/get_hotel/";

            appendURL(currentUrl, genericHotelListRequestParams.getCity());
            appendURL(currentUrl, genericHotelListRequestParams.getCheckinDate());
            appendURL(currentUrl, genericHotelListRequestParams.getCheckoutDate());
            appendURL(currentUrl, Integer.toString(genericHotelListRequestParams.getPage()));

            System.out.println(currentUrl);

            return currentUrl;

        }

        public String appendURL(String currentUri, String appendQuery) throws URISyntaxException {

            URI oldUri = new URI(currentUri);

            String newQuery = oldUri.getQuery();

            if (newQuery == null) {
                newQuery = appendQuery;
            } else {
                newQuery += "&" + appendQuery;
            }

            URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
                    oldUri.getPath(), newQuery, oldUri.getFragment());

            return newUri.toString();
        }
}
