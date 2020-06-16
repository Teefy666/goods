import com.example.goods.entity.User;
import com.example.goods.utils.JsonUtils;
import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void test(){
        String s="{'departmentid':1,'gender':'男','name':'游客','phone':'19980780981','roleid':1}";
        System.out.println(JsonUtils.stringToObj(s, User.class));
    }
}
