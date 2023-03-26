package JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONDemo {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper=new ObjectMapper();

        User user1= new User("username001","password001",123);
        System.out.println(user1);

        String jsonString1=mapper.writeValueAsString(user1);
        System.out.println(jsonString1);

        System.out.println("---------------");


        String jsonString2="{\"username\":\"username001\",\"password\":\"password001\",\"id\":123}";
        System.out.println(jsonString2);

        User user2=mapper.readValue(jsonString2, User.class);
        System.out.println(user2);

        System.out.println("---------------");


        List<User> users =new ArrayList<>();
        users.add(user1);
        users.add(user2);
        System.out.println(users);

        String jsonString3=mapper.writeValueAsString(users);
        System.out.println(jsonString3);

        System.out.println("---------------");

        String jsonString4="[{\"username\":\"username001\",\"password\":\"password001\",\"id\":123},{\"username\":\"username001\",\"password\":\"password001\",\"id\":123}]";
        System.out.println(jsonString4);

//        List<User> users2=mapper.readValue(jsonString4, new TypeReference<List<User>>() {});
        List<User> users2= Arrays.asList(mapper.readValue(jsonString4, User[].class));
        System.out.println(users2);

        for(User u: users2){
            System.out.println(u);
            System.out.println(u.getUsername());
            System.out.println(u.getPassword());
        };

    }
}
