package member;

import java.util.List;

public interface MemberInterface {
	public List<MemberVo> search(String name);
	public MemberVo search(int memberId);
	public int delete(int memberId);
	public int update(MemberVo memberVo);
	public List<MemberVo> listAll();
	public int insert(MemberVo memberVo);
}
