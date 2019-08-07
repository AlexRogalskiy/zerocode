package org.jsmart.zerocode.core.kafka.receive.message;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.jsmart.zerocode.core.di.provider.ObjectMapperProvider;
import org.junit.Test;

public class ConsumerJsonRecordsTest {

  ObjectMapper objectMapper = new ObjectMapperProvider().get();

  @Test
  public void testDeser_singleJsonRecord() throws IOException {
    String json =
        "{\n"
            + "                \"size\": 1,\n"
            + "                \"records\": [\n"
            + "                    {\n"
            + "                        \"value\": {\n"
            + "                            \"name\": \"Jey\"\n"
            + "                        }\n"
            + "                    }\n"
            + "                ]\n"
            + "            }";

    ConsumerJsonRecords jsonRecords = objectMapper.readValue(json, ConsumerJsonRecords.class);
    assertThat(jsonRecords.getRecords().get(0).getValue().toString(), is("{\"name\":\"Jey\"}"));
    assertThat(jsonRecords.getSize(), is(1));
  }
}
