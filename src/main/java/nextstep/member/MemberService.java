package nextstep.member;

import nextstep.auth.TokenRequest;
import nextstep.support.NotExistEntityException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long create(MemberRequest memberRequest) {
        return memberDao.save(memberRequest.toEntity());
    }

    public Member findById(Long id) {
        return memberDao.findById(id);
    }

    public void validateUserPassword(TokenRequest tokenRequest) {
        if (!memberDao.isUsernameAndPasswordMatch(
                tokenRequest.getUsername(),
                tokenRequest.getPassword())) {
            throw new NotExistEntityException();
        }
    }
}
