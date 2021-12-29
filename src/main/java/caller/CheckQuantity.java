package caller;

import io.restassured.response.Response;
import builder.RequestSpec;
import builder.ResponseSpec;
import static io.restassured.RestAssured.*;

public class CheckQuantity extends RequestSpec {

    public CheckQuantity() {
        super("/addresses");
    }

    public int[] getTotalNumber(int statusCode,int quantity){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("_quantity",quantity)
                        .get()
                        .then()
                        .log()
                        .all()
                        .spec(ResponseSpec.checkStatusCode(statusCode))
                        .extract()
                        .response();

        int total  = response.jsonPath().getInt("total");
        int dataSize = response.jsonPath().getInt("data.size()");
        System.out.println("Oluşturulan adet sayısı: " + total);
        System.out.println("Oluşturulan data sayısı " + dataSize);
        return new int[] {total,dataSize};

    }
}
