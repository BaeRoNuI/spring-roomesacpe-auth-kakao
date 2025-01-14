package nextstep.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nextstep.member.entity.MemberEntity;
import nextstep.member.enums.Role;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Role role;
}
