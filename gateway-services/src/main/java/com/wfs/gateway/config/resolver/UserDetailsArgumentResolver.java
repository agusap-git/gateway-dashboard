package com.wfs.gateway.config.resolver;

import com.wfs.gateway.model.security.CurrentUser;
import com.wfs.gateway.model.security.UserDetails;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * Created by aaltamir on 8/21/16.
 */
public class UserDetailsArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(CurrentUser.class) != null
                && methodParameter.getParameterType().equals(UserDetails.class);
    }

    /**
     *
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        if (supportsParameter(methodParameter)) {
            return createUserDetails(nativeWebRequest);
        }
        else {
            return WebArgumentResolver.UNRESOLVED;
        }
    }

    /**
     *
     * @param webRequest
     * @return
     */
    @SuppressWarnings("unchecked")
    private Object createUserDetails(NativeWebRequest webRequest) {
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal =
                (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) webRequest.getUserPrincipal();

        AccessToken token = principal.getKeycloakSecurityContext().getToken();

        return new UserDetails(token.getId(), token.getGivenName(), token.getFamilyName(), token.getEmail(),
                token.getRealmAccess().getRoles());
    }
}
