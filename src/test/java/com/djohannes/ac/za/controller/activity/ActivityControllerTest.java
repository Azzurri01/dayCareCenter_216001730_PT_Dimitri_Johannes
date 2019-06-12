package com.djohannes.ac.za.controller.activity;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ActivityControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/activity";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetActivityById() {
        Activity activity = restTemplate.getForObject(baseURL + "/activity/1", Activity.class);
        System.out.println(activity.getId());
        assertNotNull(activity);
    }

    @Test
    public void testCreateActivity() {
        Grade grade = GradeFactory.getGrade("R");
        Evaluation evaluation = EvaluationFactory.getEvaluation(8);
        Alphabet alphabet = AlphabetFactory.getAlphabet("r", evaluation);
        Counting counting = CountingFactory.getCounting(5, evaluation);
        Colour colour = ColourFactory.getColour("pink", evaluation);
        Drawing drawing = DrawingFactory.getDrawing("rectangle", evaluation);
        Playtime playtime = PlaytimeFactory.getPlaytime("good", evaluation);

        Activity activity = ActivityFactory.getActivity(grade, alphabet, counting, colour, drawing, playtime);

        ResponseEntity<Activity> postResponse = restTemplate.postForEntity(baseURL + "/create", activity, Activity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateActivity() {
        int id = 1;
        Activity activity = restTemplate.getForObject(baseURL + "/activity/" + id, Activity.class);

        restTemplate.put(baseURL + "/activitys/" + id, activity);
        Activity updatedActivity = restTemplate.getForObject(baseURL + "/Activity/" + id, Activity.class);
        assertNotNull(updatedActivity);
    }

    @Test
    public void testDeleteActivity() {
        int id = 2;
        Activity activity = restTemplate.getForObject(baseURL + "/activitys/" + id, Activity.class);
        assertNotNull(activity);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            activity = restTemplate.getForObject(baseURL + "/activitys/" + id, Activity.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
