package caller;

import io.restassured.response.Response;
import builder.RequestSpec;
import builder.ResponseSpec;
import static io.restassured.RestAssured.*;

public class CharacterCount extends RequestSpec {

    public CharacterCount() {
        super("/texts");
    }
    public int checkCharacterSize(int statusCode,int characters){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("_quantity","1")
                        .queryParam("_characters",characters)
                        .get()
                        .then()
                        .log()
                        .all()
                        .spec(ResponseSpec.checkStatusCode(statusCode))
                        .extract()
                        .response();

        String characterSize = response.jsonPath().getString("data[0].content");
        System.out.println("Content length is " + characterSize.length());
        return characterSize.length();

    }


}
