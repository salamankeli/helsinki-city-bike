package com.example.helsinkicitybike;


import com.example.helsinkicitybike.Journey.Journey;
import com.example.helsinkicitybike.Journey.JourneyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = HelsinkiCityBikeApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
class HelsinkiCityBikeApplicationTests {

    @Autowired
    JourneyRepository jRepo;

    @Autowired
    private MockMvc mvc;

    @Test
    void testAddingJourney() throws Exception {

        var journey1 = new Journey("2021-05-31T23:57:25","2021-06-01T00:05:46",94,"Laajalahden aukio",100,"Teljäntie",2043,500);
        jRepo.save(journey1);
        mvc.perform(get("/journeys/all?page=0&size=10&sortingField=departureStationId&sortingDirection=ASC")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content[0].departureTime", is("2021-05-31T23:57:25")))
                .andExpect(jsonPath("$.content[0].returnTime", is("2021-06-01T00:05:46")))
                .andExpect(jsonPath("$.content[0].departureStationId", is(94)))
                .andExpect(jsonPath("$.content[0].departureStationName", is("Laajalahden aukio")))
                .andExpect(jsonPath("$.content[0].returnStationId", is(100)))
                .andExpect(jsonPath("$.content[0].returnStationName", is("Teljäntie")))
                .andExpect(jsonPath("$.content[0].distance", is(2043)))
                .andExpect(jsonPath("$.content[0].duration", is(500)));
    }
}
