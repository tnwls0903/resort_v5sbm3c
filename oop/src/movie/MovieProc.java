package movie;

import java.util.ArrayList;

public class MovieProc implements MovieProcInter {
  private MovieDAOInter movieDAO;
  
  public MovieProc() {
    this.movieDAO = new MovieDAO();  
  }
  
  @Override
  public int create(MovieVO movieVO) {
    int count = this.movieDAO.create(movieVO);
    return count;
  }

  @Override
  public ArrayList<MovieVO> list() {
    ArrayList<MovieVO> list = this.movieDAO.list();
    return list;
  }

  @Override
  public MovieVO read(int movieno) {
    MovieVO movieVO = this.movieDAO.read(movieno);
    return movieVO;
  }

  @Override
  public int update(MovieVO movieVO) {
    int count = this.movieDAO.update(movieVO);
    return count;
  }

  @Override
  public int delete(int movieno) {
    int count = this.movieDAO.delete(movieno);
    return count;
  }

  @Override
  public int count() {
    int count = this.movieDAO.count();
    
    return count;
  }

}




