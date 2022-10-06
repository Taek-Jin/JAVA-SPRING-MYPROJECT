package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member!=null) {
			throw new DuplicateMemberException("dup email" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		newMember.setPhoneNumber(req.getPhoneNumber());
		newMember.setAddr1(req.getAddr1());
		newMember.setAddr2(req.getAddr2());
		newMember.setAddr3(req.getAddr3());
		newMember.setAddr(req.getAddr1(), req.getAddr2(), req.getAddr3());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
