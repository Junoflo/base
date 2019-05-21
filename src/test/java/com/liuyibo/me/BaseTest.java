package com.liuyibo.me;

import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Map;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseTest {
    private static final Gson GSON = new Gson();

    protected void printResult(Object obj) {
        System.out.println("---------");
        String r = Thread.currentThread().getStackTrace()[2].getMethodName() + ": " + GSON.toJson(obj);
        if (obj != null) {
            if (obj instanceof Collection) {
                int size = ((Collection) obj).size();
                System.out.println("Collection Size: " + size);
                for (Object o : (Collection) obj) {
                    System.out.println(GSON.toJson(o));
                }
            } else if (obj instanceof Map) {
                int size = ((Map) obj).size();
                System.out.println("Map Size: " + size + "\n" + r);
            } else {
                System.out.println(r);
            }
        } else {
            System.out.println(r);
        }
        System.out.println("---------");
    }

}
