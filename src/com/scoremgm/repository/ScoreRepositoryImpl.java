package com.scoremgm.repository;

import java.util.Iterator;
import java.util.List;

import com.scoremgm.model.MemberVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class ScoreRepositoryImpl extends DBConn 
			implements GenericRepositoryInterface<MemberVo>{
	
	public ScoreRepositoryImpl() { super(); } 
	
	@Override
	public boolean insert(MemberVo member) {
		if(member == null) return false;
		return storage.add(member);		
	}
	
//	@Override
//	public void remove(String no) {
//		no = "2025-" + no;
//		Iterator<MemberVo> ie = storage.iterator();
//		while(ie.hasNext()) {
//			MemberVo memeber = ie.next();
//			if(memeber.getNo().equals(no)) {
//				ie.remove();
//				break;
//			}
//		}
//	}
//	
//	
//	@Override
//	public void update(MemberVo member) {
//		int idx = -1;
//		for(int i=0; i<storage.size();i++) {
//			MemberVo m = storage.get(i);
//			if(m.getNo().equals(member.getNo())) {
//				idx = i;
//				break;
//			}
//		}
//		
//		storage.set(idx, member);
//	}
//	
//	
//	@Override
//	public MemberVo find(String no) {
//		no = "2025-" + no;
//		MemberVo member = null;
//		
//		if(no != null) {
//			for(MemberVo m : storage) {
//				if(m.getNo().equals(no)) {
//					member = m;
//				}	
//			}
//		}
//		
//		return member;
//	}
//	
//	@Override
//	public List<MemberVo> findAll() {
//		return storage;
//	}
//	
//	@Override
//	public int getCount() {
//		return storage.size();
//	}
	
	
}












