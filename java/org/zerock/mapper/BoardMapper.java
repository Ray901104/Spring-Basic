package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO bVO);
	
	public void insertSelectKey(BoardVO bVO);
	
	public BoardVO read(Long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO bVO);
	
	public int getTotalCount(Criteria cri);
}//interface