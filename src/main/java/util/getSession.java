package util;

import mapper.BrandMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class getSession {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession session;
    private static int sessionStatus=0;
    private static UserMapper userMapper;
    private static BrandMapper brandMapper;

    static {
    String resource = "mybatis_config.xml";

        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static UserMapper getUserMapper(){
        if(sessionStatus==0){
            session = sqlSessionFactory.openSession(true);
            sessionStatus=1;
        }
        userMapper=session.getMapper(UserMapper.class);
        return  userMapper;
    }

    public static BrandMapper getBrandMapper(){
        if(sessionStatus==0){
            session = sqlSessionFactory.openSession(true);
            sessionStatus=1;
        }
        brandMapper=session.getMapper(BrandMapper.class);
        return  brandMapper;
    }

    public static void closeSession(){
        if(sessionStatus==1){
            session.close();
            sessionStatus=0;
        }
    }
}
