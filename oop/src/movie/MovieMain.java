package movie;

import java.util.ArrayList;

public class MovieMain {

  public static void main(String[] args) {
    MovieProcInter movieProc = new MovieProc();
    
//    MovieVO movieVO = new MovieVO("더 라이트", 9.5, "안소니 홉킨스");
//    int count = movieProc.create(movieVO);
//    System.out.println("count: " + count);

//    ArrayList<MovieVO> list =movieProc.list();
    // System.out.println(list.size());
    
//    for (MovieVO movieVO : list) {
//      System.out.print(movieVO.getMovieno() + ". ");
//      System.out.print(movieVO.getTitle() + " ");
//      System.out.print(" (" + movieVO.getScore() + ") ");
//      System.out.print(" 출연: " + movieVO.getActor() + " ");
//      System.out.print(movieVO.getRdate().substring(0,  10)); // 시작 index, 끝 index-1
//      System.out.println();
//    }
    
//    MovieVO movieVO = movieProc.read(1);
//    
//    System.out.print(movieVO.getMovieno() + ". ");
//    System.out.print(movieVO.getTitle() + " ");
//    System.out.print(" (" + movieVO.getScore() + ") ");
//    System.out.print(" 출연: " + movieVO.getActor() + " ");
//    System.out.print(movieVO.getRdate().substring(0,  10)); // 시작 index, 끝 index-1

//    MovieVO movieVO = new MovieVO(7, "엑소시스트", 1000, "배우");
//    int count = movieProc.update(movieVO);
//    System.out.println("count: " + count);
    
//    int count = movieProc.delete(10);
//    System.out.println("count: " + count);
    
    int count = movieProc.count();
    System.out.println("count: " + count);
    
  }

}

