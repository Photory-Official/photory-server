package com.photory.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.photory.common.exception.ErrorStatusCode.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    // 400 Bad Request
    VALIDATION_EXCEPTION(BAD_REQUEST, "잘못된 요청입니다"),
    VALIDATION_ENUM_VALUE_EXCEPTION(BAD_REQUEST, "잘못된 Enum 값 입니다"),
    VALIDATION_REQUEST_MISSING_EXCEPTION(BAD_REQUEST, "필수적인 요청 값이 입력되지 않았습니다"),
    VALIDATION_WRONG_TYPE_EXCEPTION(BAD_REQUEST, "잘못된 타입이 입력되었습니다."),
    VALIDATION_SOCIAL_TYPE_EXCEPTION(BAD_REQUEST, "잘못된 소셜 프로바이더 입니다."),
    VALIDATION_WRONG_PASSWORD_EXCEPTION(BAD_REQUEST, "잘못된 비밀번호입니다."),
    VALIDATION_EMAIL_AUTH_KEY_EXCEPTION(BAD_REQUEST, "잘못된 이메일 인증번호입니다."),

    // 401 UnAuthorized
    UNAUTHORIZED_EXCEPTION(UNAUTHORIZED, "토큰이 만료되었습니다. 다시 로그인 해주세요"),
    UNAUTHORIZED_EMAIL_EXCEPTION(UNAUTHORIZED, "인증이 완료되지 않은 이메일입니다."),

    // 403 Forbidden
    FORBIDDEN_EXCEPTION(FORBIDDEN, "허용하지 않는 요청입니다."),
    FORBIDDEN_FILE_TYPE_EXCEPTION(BAD_REQUEST, "허용되지 않은 파일 형식입니다"),
    FORBIDDEN_FILE_NAME_EXCEPTION(BAD_REQUEST, "허용되지 않은 파일 이름입니다"),
    FORBIDDEN_ROOM_OWNER_EXCEPTION(FORBIDDEN, "방장에게만 허용되는 요청입니다."),
    FORBIDDEN_ROOM_OWNER_LEAVE_LAST_EXCEPTION(FORBIDDEN, "방장은 다른 유저가 모두 나간 뒤에 나갈 수 있습니다."),
    FORBIDDEN_ROOM_OWNER_DISABLE_LAST_EXCEPTION(FORBIDDEN, "방장은 다른 유저가 모두 나간 뒤에 방을 비활성화 시킬 수 있습니다."),
    FORBIDDEN_ROOM_OWNER_LEAVE_EXCEPTION(FORBIDDEN, "방장은 방을 나갈 수 없습니다.\n방을 비활성화하면 30일 뒤에 방이 삭제됩니다."),
    FORBIDDEN_ROOM_EXCEED_CAPACITY_EXCEPTION(FORBIDDEN, "방은 최대 인원 8명을 넘을 수 없습니다."),
    FORBIDDEN_ROOM_PARTICIPANT_EXCEPTION(FORBIDDEN, "방 참가자에게만 허용되는 요청입니다."),
    FORBIDDEN_FEED_OWNER_EXCEPTION(FORBIDDEN, "피드 작성자에게만 허용되는 요청입니다."),

    // 404 Not Found
    NOT_FOUND_EXCEPTION(NOT_FOUND, "존재하지 않습니다"),
    NOT_FOUND_USER_EXCEPTION(NOT_FOUND, "탈퇴하거나 존재하지 않는 유저입니다"),
    NOT_FOUND_ROOM_EXCEPTION(NOT_FOUND, "삭제되었거나 존재하지 않는 방입니다"),
    NOT_FOUND_FEED_EXCEPTION(NOT_FOUND, "삭제되었거나 존재하지 않는 피드입니다"),
    NOT_FOUND_EMAIL_EXCEPTION(NOT_FOUND, "가입되지 않았거나 탈퇴한 이메일입니다."),

    // 405 Method Not Allowed
    METHOD_NOT_ALLOWED_EXCEPTION(METHOD_NOT_ALLOWED, "지원하지 않는 메소드 입니다"),

    // 406 Not Acceptable
    NOT_ACCEPTABLE_EXCEPTION(NOT_ACCEPTABLE, "Not Acceptable"),

    // 409 Conflict
    CONFLICT_EXCEPTION(CONFLICT, "이미 존재합니다"),
    CONFLICT_NICKNAME_EXCEPTION(CONFLICT, "이미 사용중인 닉네임입니다.\n다른 닉네임을 이용해주세요"),
    CONFLICT_EMAIL_EXCEPTION(CONFLICT, "이미 사용중인 이메일입니다.\n다른 이메일을 이용해주세요"),
    CONFLICT_USER_EXCEPTION(CONFLICT, "이미 해당 계정으로 회원가입하셨습니다.\n로그인 해주세요"),
    CONFLICT_JOIN_ROOM_EXCEPTION(CONFLICT, "이미 참가한 방입니다."),
    CONFLICT_LEAVE_ROOM_EXCEPTION(CONFLICT, "이미 나간 방입니다."),

    // 415 Unsupported Media Type
    UNSUPPORTED_MEDIA_TYPE_EXCEPTION(UNSUPPORTED_MEDIA_TYPE, "해당하는 미디어 타입을 지원하지 않습니다."),

    // 500 Internal Server Exception
    INTERNAL_SERVER_EXCEPTION(INTERNAL_SERVER, "예상치 못한 서버 에러가 발생하였습니다."),

    // 502 Bad Gateway
    BAD_GATEWAY_EXCEPTION(BAD_GATEWAY, "일시적인 에러가 발생하였습니다.\n잠시 후 다시 시도해주세요!"),

    // 503 Service UnAvailable
    SERVICE_UNAVAILABLE_EXCEPTION(SERVICE_UNAVAILABLE, "현재 점검 중입니다.\n잠시 후 다시 시도해주세요!"),
    ;

    private final ErrorStatusCode statusCode;
    private final String message;

    public int getStatus() {
        return statusCode.getStatus();
    }
}
