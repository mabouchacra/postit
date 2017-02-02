package com.postit.api;

import com.postit.PostitApplication;
import com.postit.entity.Postit;
import com.postit.service.PostitService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by SQLI on 02/02/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PostitApplication.class)
@WebAppConfiguration
public class PostitControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private PostitController postitController;

    @Mock
    private PostitService postitService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        postitController = new PostitController(postitService);
    }

    @Test
    public void findAll() throws Exception {

        //GIVEN
        List<Postit> postits = new ArrayList<>();
        Postit p = new Postit();
        p.setAuthor("Marc");
        p.setDescription("Essayer de faire la vaisselle régulièrement pour soulager Mme");
        p.setTitle("Faire la vaisselle");
        p.setId(UUID.randomUUID().toString());
        postits.add(p);

        //WHEN
        Mockito.doReturn(postits).when(postitService).findAll();

        //THEN
        mockMvc.perform(get("/api/postit/"))
                .andDo(print());

        Mockito.verify(postitService).findAll();
    }

}