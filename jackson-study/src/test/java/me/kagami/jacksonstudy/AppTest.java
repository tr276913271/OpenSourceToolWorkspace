package me.kagami.jacksonstudy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import me.kagami.jacksonstudy.User;

public class AppTest {

	@Test
	public void createJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonGenerator jsonGenerator = mapper.getFactory().createGenerator(new File("student.json"), JsonEncoding.UTF8);

			jsonGenerator.writeStartObject();
			// "name" : "Mahesh Kumar"
			jsonGenerator.writeStringField("name", "Mahesh Kumar");
			// "age" : 21
			jsonGenerator.writeNumberField("age", 21);
			// "verified" : false
			jsonGenerator.writeBooleanField("verified", false);
			// "marks" : [100, 90, 85]
			jsonGenerator.writeFieldName("marks");
			// [
			jsonGenerator.writeStartArray();
			// 100, 90, 85
			jsonGenerator.writeNumber(100);
			jsonGenerator.writeNumber(90);
			jsonGenerator.writeNumber(85);
			// ]
			jsonGenerator.writeEndArray();
			// }
			jsonGenerator.writeEndObject();
			jsonGenerator.close();

			Map<String, Object> dataMap = mapper.readValue(new File("student.json"), Map.class);

			System.out.println(dataMap.get("name"));
			System.out.println(dataMap.get("age"));
			System.out.println(dataMap.get("verified"));
			System.out.println(dataMap.get("marks"));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void jsonToList() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<User> userList = mapper
					.readValue(
							"[{\"name\":\"天\",\"password\":\"1234\",\"age\":0,\"money\":0.0},{\"name\":\"润\",\"password\":\"1235\",\"age\":0,\"money\":0.0},{\"name\":\"是\",\"password\":\"1236\",\"age\":0,\"money\":0.0},null]",
							new TypeReference<List<User>>() {
							});
			System.out.println(userList);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void jsonToBean() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			User user = mapper.readValue("{\"name\":\"天\",\"password\":\"123\",\"age\":\"0\",\"money\":\"0.0\"}", User.class);
			System.out.println(user);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void objectToJson() {
		User user = new User(); // Java Object
		user.setName("天");
		user.setPassword("123");

		ObjectMapper mapper = new ObjectMapper();
		// 设置将对象转换成JSON字符串时候:包含的属性不能为空或"";
		// Include.Include.ALWAYS 默认
		// Include.NON_DEFAULT 属性为默认值不序列化
		// Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化
		// Include.NON_NULL 属性为NULL 不序列化
		mapper.setSerializationInclusion(Include.NON_NULL);
		// Feature.WRITE_NUMBERS_AS_STRINGS 输出数字时是否加双引号
		// Feature.ESCAPE_NON_ASCII 输出非ascii码的字符时的输出方式，例子：username=“天”
		// 输出“\u5929”
		mapper.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);
		// 设置有属性不能映射成PO时不报错
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		try {
			String userstr = mapper.writeValueAsString(user);
			System.out.println(userstr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void listToJson() {
		User user1 = new User(); // Java Object
		user1.setName("天");
		user1.setPassword("1234");
		User user2 = new User(); // Java Object
		user2.setName("润");
		user2.setPassword("1235");
		User user3 = new User(); // Java Object
		user3.setName("是");
		user3.setPassword("1236");
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(null);

		ObjectMapper mapper = new ObjectMapper();
		try {
			String list4json = mapper.writeValueAsString(userList);
			System.out.println(list4json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mapToJson() {
		User user1 = new User(); // Java Object
		user1.setName("天");
		user1.setPassword("1234");
		User user2 = new User(); // Java Object
		user2.setName("润");
		user2.setPassword("1235");
		User user3 = new User(); // Java Object
		user3.setName("是");
		user3.setPassword("1236");
		Map<String, User> userMap = new HashMap<String, User>();
		userMap.put("1", user1);
		userMap.put("2", user2);
		userMap.put("3", user3);
		userMap.put("4", null);

		ObjectMapper mapper = new ObjectMapper();
		// 设置将MAP转换为JSON时候只转换值不等于NULL的 ; 设置为true的时候，key 为 4 的value 不会输出
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		try {
			String map4json = mapper.writeValueAsString(userMap);
			System.out.println(map4json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
