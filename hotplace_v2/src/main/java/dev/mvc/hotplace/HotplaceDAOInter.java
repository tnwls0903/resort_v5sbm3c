package dev.mvc.hotplace;

import java.util.ArrayList;
import java.util.Map;

public interface HotplaceDAOInter {
  /**
   * 등록
   * insert id="create" parameterType="dev.mvc.hotplace.HotplaceVO"
   * @param hotplaceVO
   * @return 등록한 레코드 갯수
   */
  public int create(HotplaceVO hotplaceVO);
  
  /**
   * 전체 목록
   * select id="list_all" resultType="dev.mvc.hotplace.HotplaceVO"     
   * @return 레코드 목록
   */
  public ArrayList<HotplaceVO> list_all();
  
  /**
   * 조회
   * select id="read" resultType="dev.mvc.hotplace.HotplaceVO" parameterType="int"
   * @param hotplaceno
   * @return
   */
  public HotplaceVO read(int hotplaceno);
  
  /**
   * 수정
   * update id="update" parameterType="dev.mvc.hotplace.HotplaceVO"    
   * @param hotplaceVO
   * @return 수정된 레코드 갯수
   */
  public int update(HotplaceVO hotplaceVO);
  
  /**
   * delete
   * delete id="delete" parameterType="Integer"
   * @param hotplaceno
   * @return
   */
  public int delete(int hotplaceno);

  /**
   * 우선 순위 높임, 10 등 -> 1 등
   * update id="update_seqno_forward" parameterType="Integer"
   * @param hotplaceno
   * @return 수정한 레코드 갯수
   * */
  public int update_seqno_forward(int hotplaceno);
  
  /**
   * 우선 순위 낮춤, 1 등 -> 10 등
   * update id="update_seqno_backward" parameterType="Integer"
   * @param hotplaceno
   * @return 수정한 레코드 갯수
   * */
  public int update_seqno_backward(int hotplaceno);
  
  /**
   * 카테고리 공개 설정
   * update id="update_visible_y" parameterType="int"
   * @param hotplaceno
   * @return
   */
  public int update_visible_y(int hotplaceno);

  /**
   * 카테고리 비공개 설정
   * update id="update_visible_n" parameterType="int"
   * @param hotplaceno
   * @return
   */
  public int update_visible_n(int hotplaceno);
    
  /**
   * 회원/비회원에게 공개할 중분류 목록 
   * select id="list_all_y" resultType="dev.mvc.hotplace.HotplaceVO"     
   * @return
   */
  public ArrayList<HotplaceVO> list_all_a_y();
  
  /**
   * 회원/비회원에게 공개할 소분류 목록 
   * select id="list_all_b_y" resultType="dev.mvc.hotplace.HotplaceVO" parameterType="String"
   * @return
   */
  public ArrayList<HotplaceVO> list_all_b_y(String a);    
  
  /**
   * 관리자용 검색 목록
   * select id="list_search" resultType="dev.mvc.hotplace.HotplaceVO" parameterType="String"
   * @param map
   * @return 조회한 레코드 목록
   */
  public ArrayList<HotplaceVO> list_search(String word);    
  
  /**
   * 검색목록 페이징
   * select id="list_search_paging" resultType="dev.mvc.hotplace.HotplaceVO" parameterType="Map"
   * @param map
   * @return 조회한 레코드 목록
   */
  public ArrayList<HotplaceVO> list_search_paging(Map<String, Object> map);
  
  /**
   * 검색된 레코드 수
   * @param word
   * @return
   */
  public int list_search_count(String word);
  
}








