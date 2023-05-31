package by.asb.mti.config.resolver;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;

import java.util.Arrays;
import java.util.Optional;

import static by.asb.mti.config.bean.Token.ACCESS_TOKEN;
import static by.asb.mti.config.bean.Token.REFRESH_TOKEN;
import static by.asb.mti.config.bean.URL.*;

public final class JwtTokenResolver implements BearerTokenResolver {

    @Override
    public String resolve(HttpServletRequest request) {
        Optional<Cookie> returnCookie = Optional.empty();
        String contextPathToken = request.getContextPath().concat(TOKEN);
        if (!contextPathToken.concat(LOGIN).equals(request.getRequestURI())) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                if (contextPathToken.concat(REFRESH).equals(request.getRequestURI())) {
                    returnCookie = Arrays.stream(cookies)
                            .filter(cookie -> REFRESH_TOKEN.getValue().equals(cookie.getName()))
                            .findAny();
                } else {
                    returnCookie = Arrays.stream(cookies)
                            .filter(cookie -> ACCESS_TOKEN.getValue().equals(cookie.getName()))
                            .findAny();
                }
            }
        }
        return returnCookie
                .map(Cookie::getValue)
                .orElse(null);
    }

}
