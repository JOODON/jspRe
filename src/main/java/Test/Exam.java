package Test;

import Dto.boardDto;
import Dao.boardDao;
public class Exam {
    public static void main(String[] args) {
        boardDao dao=new boardDao();
        boardDto dto=dao.getDto("타이틀입니다2");
        System.out.println(dto);
    }
    public static void adddata(String head,String body){
        String title=head;
        String content=body;

        boardDto dto=new boardDto(title,content);

        boardDao dao=new boardDao();

        int insertCount=dao.addUser(dto);

        System.out.println(insertCount);
    }
}
