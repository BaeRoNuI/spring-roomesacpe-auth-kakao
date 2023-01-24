package nextstep.auth.service;


import lombok.RequiredArgsConstructor;
import nextstep.auth.dto.TokenResponse;
import nextstep.global.exception.AuthFailException;
import nextstep.global.exception.NotExistEntityException;
import nextstep.global.util.JwtTokenProvider;
import nextstep.global.util.PasswordUtility;
import nextstep.member.dao.MemberDao;
import nextstep.member.entity.MemberEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final MemberDao memberDao;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordUtility passwordUtility;

    @Override
    public TokenResponse login(String username, String password) {
        MemberEntity memberEntity = memberDao.findByUsername(username)
                .orElseThrow(NotExistEntityException::new);
        if (passwordUtility.matches(password, memberEntity.getPassword())) {
            return new TokenResponse(jwtTokenProvider.createToken(memberEntity.getId().toString()));
        }
        throw new AuthFailException();
    }
}
