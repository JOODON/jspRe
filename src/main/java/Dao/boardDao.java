package Dao;

import Dto.boardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public boardDto getDto(String id){
        boardDto boardDto=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
            String sql="SELECT title,content FROM board WHERE title=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);

            rs= ps.executeQuery();

            if(rs.next()){
                String title=rs.getString(1);
                String content=rs.getString(2);
                boardDto=new boardDto(title,content);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(rs != null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return boardDto;
    }
    public int deleteText(String title){
        int deleteCount=0;

        Connection conn=null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,password);
            String sql="DELETE From board WHERE title=?";

            ps=conn.prepareStatement(sql);

            ps.setString(1,title);

            deleteCount=ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(ps != null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return deleteCount;
    }
    public int update(boardDto boardDto){
        int updateCount=0;

        Connection conn=null;
        PreparedStatement ps=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,password);
            String sql="update board set content=? where title=?";

            ps=conn.prepareStatement(sql);

            ps.setString(1,boardDto.getContent());
            ps.setString(2,boardDto.getTitle());

            updateCount=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(ps != null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return updateCount;
    }
}
