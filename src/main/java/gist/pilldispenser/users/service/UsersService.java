package gist.pilldispenser.users.service;

import gist.pilldispenser.common.security.UsersDetails;
import gist.pilldispenser.common.security.jwt.JwtProvider;
import gist.pilldispenser.users.converter.UsersConverter;
import gist.pilldispenser.users.domain.entity.Users;
import gist.pilldispenser.users.domain.model.UsersHardwareNoRequest;
import gist.pilldispenser.users.domain.model.UsersRequest;
import gist.pilldispenser.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static gist.pilldispenser.common.security.jwt.JwtProperties.*;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final JwtProvider jwtProvider;
    private final UsersConverter usersConverter;

    // 카카오 로그인 -> 연동 여부에 따라 회원정보 db에 저장
    public Users loginUser(UsersRequest request) {
        if (isExistingUser(request)){
            return usersRepository.findByEmail(request.email());
        } else {
            return registerUser(request);
        }
    }

    // 등록 x인 회원 정보 저장
    private Users registerUser(UsersRequest request){
        String password = passwordEncoder.encode(request.password());
        Users users = usersConverter.toEntity(request, password);
        return usersRepository.save(users);
    }

    // 이미 등록된 회원인지 체크
    private boolean isExistingUser(UsersRequest request){
        return usersRepository.existsByEmail(request.email());
    }

    // 액세스 토큰 (2주) 발급
    public String issueAccessToken(Users users){
        return jwtProvider.createToken(users.getId(), ACCESS_TOKEN);
    }

    // 회원정보 가져오기
    public Users getUserInfo(UsersDetails usersDetails){
        return usersRepository.findFirstById(usersDetails.getId());
    }

    // 하드웨어 시리얼 넘버 추가
    public Users updateHardwareNo(String email, UsersHardwareNoRequest request){
        Users users = usersRepository.findByEmail(email);
        users.setHardwareNo(request.hardwareNo());
        return usersRepository.save(users);
    }
}