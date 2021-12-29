package builder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static base.Data.*;

public class RequestSpec {

    RequestSpecification requestSpecification;

    public RequestSpec(String apiEndPoint){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL+apiEndPoint)
                .setAccept("*/*")
                .setContentType("application/json")
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
