package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;
import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository{
	
	List<Member> storage = new ArrayList<Member>(); 
	
	@Override
	public void update(Member member) {
		int idx = -1;
		for(int i=0; i<storage.size();i++) {
			Member m = storage.get(i);
			if(m.getNo().equals(member.getNo())) {
				idx = i;
				break;
			}
		}
		
		storage.set(idx, member);
	}
	
	
	@Override
	public Member find(String no) {
		no = "2025-" + no;
		Member member = null;
		
		if(no != null) {
			for(Member m : storage) {
				if(m.getNo().equals(no)) {
					member = m;
				}	
			}
		}
		
		return member;
	}
	
	@Override
	public List<Member> findAll() {
		return storage;
	}
	
	@Override
	public int getCount() {
		return storage.size();
	}
	
	@Override
	public boolean insert(Member member) {
		if(member == null) return false;
		return storage.add(member);		
	}
}












