import com.google.gson.gson;
import com.google.gson.reflect.typetoken;
import java.lang.reflect.type;
import java.util.list;

class user {
    string name;
    int level;
}

public class main {
    public static void main(string[] args) {
        string json = "[{\"name\":\"tevyah\",\"level\":3},{\"name\":\"zach\",\"level\":5}]";

        type listtype = new typetoken<list<user>>() {}.gettype();
        list<user> users = new gson().fromjson(json, listtype);

        system.out.println(users.get(0).name + " -> " + users.get(0).level);
    }
}
