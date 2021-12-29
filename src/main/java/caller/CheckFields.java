package caller;

import io.restassured.response.Response;
import builder.RequestSpec;
import builder.ResponseSpec;
import static io.restassured.RestAssured.*;

public class CheckFields extends RequestSpec {

    public CheckFields() {
        super("/texts");
    }
    public String[] getFields(int statusCode){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("_quantity","1")
                        .get()
                        .then()
                        .log()
                        .all()
                        .spec(ResponseSpec.checkStatusCode(statusCode))
                        .extract()
                        .response();

        String title = response.jsonPath().getString("data[0].title");
        String author = response.jsonPath().getString("data[0].author");
        String genre = response.jsonPath().getString("data[0].genre");
        System.out.println("Book title is  " + title);
        System.out.println("Book author is  " + author);
        System.out.println("Book genre is  " + genre);
        return new String[] {title, author, genre};

    }


}
