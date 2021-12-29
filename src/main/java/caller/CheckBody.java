package caller;

import io.restassured.response.Response;
import builder.RequestSpec;
import builder.ResponseSpec;
import static io.restassured.RestAssured.*;

public class CheckBody extends RequestSpec {

    public CheckBody() {
        super("/custom");
    }
    public String[] getFields(int statusCode){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("_quantity","1")
                        .queryParam("name","name")
                        .queryParam("lmd","dateTime")
                        .queryParam("phoneNumber","phone")
                        .queryParam("description","text")
                        .get()
                        .then()
                        .log()
                        .all()
                        .spec(ResponseSpec.checkStatusCode(statusCode))
                        .extract()
                        .response();

        String name = response.jsonPath().getString("data[0].name");
        String lmd = response.jsonPath().getString("data[0].lmd");
        String date = response.jsonPath().getString("data[0].lmd.date");
        String timezoneType = response.jsonPath().getString("data[0].lmd.timezone_type");
        String timezone = response.jsonPath().getString("data[0].lmd.timezone");
        String phoneNumber = response.jsonPath().getString("data[0].phoneNumber");
        String description = response.jsonPath().getString("data[0].description");

        System.out.println("Name  " + name);
        System.out.println("Date is  " + date);
        System.out.println("Timezone Type is " + timezoneType);
        System.out.println("Timezone is " + timezone);
        System.out.println("Phonenumber is  " + phoneNumber);
        System.out.println("Description is  " + description);
        return new String[] {name,date,timezoneType,timezone,phoneNumber,description};

    }


}