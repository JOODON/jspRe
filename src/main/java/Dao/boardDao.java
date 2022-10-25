package Dao;

import Dto.boardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class boardDao {
    //1단계 Import java.sql.*
    //2단계 드라이버를 로드한다.
    //3단계 컨 객체 생성 //데이터베이스 연결
    //4단계 Stat먼트 객체 생성//sql문장 수행
    //SQL문에 결과물이 있다면 ResultSet를 생성//결과값 가져오기
    //객체 닫아주기!
    private static String url="jdbc:mysql://localhost:3307/bynsdb";
    private static String user="root";
    private static String password="kkjjss103@";

    public int addUser(boardDto boardDto){
        int insertCount=0;

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="INSERT INTO board (title,content) VALUES (?,?)";

        try(Connection conn= DriverManager.getConnection(url,user,password);
            PreparedStatement ps=conn.prepareStatement(sql)){

            ps.setString(1, boardDto.getTitle());
            ps.setString(2,boardDto.getContent());

            insertCount=ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return insertCount;
    }
    
}
