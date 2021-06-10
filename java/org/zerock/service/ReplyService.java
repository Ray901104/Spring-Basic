package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO rVO);
	
	public ReplyVO get(long rno);
	
	public int modify(ReplyVO rVO);
	
	public int remove(long rno);
	
	public List<ReplyVO> getList(Criteria cri, long bno);
}//class
