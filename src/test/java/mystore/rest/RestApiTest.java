package mystore.rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class RestApiTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Test
    public void displayAll() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/posts/");

        System.out.println("Response Body is => " + response.asString());

        JsonPath jsonPath = response.body().jsonPath();
        String[] ids = jsonPath.get("userId").toString().split(", ");

        for (String userId : ids) {
            System.out.println("My UserId " + userId);
        }
    }

    @Test
    public void shouldReturnMaxForUserId() { //task 1
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/posts?userId=1");
        JsonPath jsonPath = response.body().jsonPath();
        String[] ids = jsonPath.get("id").toString().split(", ");

        List<String> myList = new ArrayList<>();
        for (String id : ids) {
            myList.add(id.replaceAll("\\D", ""));
        }

        int maxId = myList.stream().mapToInt(Integer::parseInt).max().orElseThrow(NoSuchElementException::new);

        System.out.println("Max idUser is : " + maxId);
        Assert.assertEquals(maxId, 10);
    }

    @Test
    public void shouldReturnMaxIdForUserId() //task 2
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/posts?userId=10");
        JsonPath jsonPath = response.body().jsonPath();

        String[] ids = jsonPath.get("id").toString().split(", ");

        List<String> myList = new ArrayList<>();
        for (String id : ids) {
            myList.add(id.replaceAll("\\D", ""));
        }

        int maxId = myList.stream().mapToInt(Integer::parseInt).max().orElseThrow(NoSuchElementException::new);

        System.out.println("Max id for userId=10 is : " + maxId);
        Assert.assertEquals(maxId, 100);
    }

    @Test
    public void shouldAddComment() { //task 3 - no spec about rest methods like swagger
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/comments";
        RequestSpecification httpRequest = given();

        Map<String, String> myMap = new HashMap();
//        myMap.put("postId", "100");
//        myMap.put("id", "10");
//        myMap.put("name", "test");
//        myMap.put("email", "test@email.com");
//        myMap.put("body", " hello, this is my comment");

        Response res = RestAssured.with().body(myMap).post("https://jsonplaceholder.typicode.com/comments");

    }

}


