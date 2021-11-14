package webServTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webServTests.model.User;

public class WebServTest {
    private static final Logger logger = Logger.getLogger(WebServTest.class);

    public WebServTest() {
    }

    @BeforeTest
    public void initTest() {
        String host = "https://jsonplaceholder.typicode.com/users";
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
        logger.info("Test checkStatusCode() started");
        Response response = RestAssured.when()
                .get("/users")//Send the http request by using the GET method
                .andReturn();//получаем ответ
        logger.info("StatusLine is " + response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeader() {
        logger.info("Test checkResponseHeader() started");
        Response response = RestAssured.when()
                .get("/users")//Send the http request by using the GET method
                .andReturn();//получаем ответ
              String rpContentTypeHeader = response.getHeader("Content-Type");
        logger.info("Header is " + rpContentTypeHeader);
        Assert.assertNotNull(rpContentTypeHeader.length());
        logger.info("Length of  rpContentTypeHeader is " + rpContentTypeHeader.length());
        Assert.assertEquals(rpContentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBody() {
        logger.info("Test checkResponseBody() started");
        Response response = RestAssured.when()
                .get("/users")//Send the http request by using the GET method
                .andReturn();//получаем ответ
        ResponseBody responseBody = response.getBody();
        User[] usersMas = responseBody.as(User[].class);//в таком типе данных User[].class мы хотим получить результат
        logger.info("Length of  usersMas is " + usersMas.length);
        Assert.assertEquals(usersMas.length, 101);//тут специально ошибка
    }

    @AfterMethod
    public static void checkTestStatus(ITestResult result) {
        if (result.isSuccess()) {
            return;
        } else {
            logger.error("Error in test" + result.getMethod());
        }
    }

}


