import {Injectable} from '@angular/core';

declare var Keycloak: any;
@Injectable()
export class KeycloakService {
    static auth: any = {};
    static init(): Promise<any> {
        let keycloakAuth: any = new Keycloak('../config/keycloak.json');
        keycloakAuth.onTokenExpired = function() {
            KeycloakService.refreshToken();
        };
        KeycloakService.auth.loggedIn = false;
        return new Promise((resolve, reject) => {
            keycloakAuth.init({ onLoad: 'login-required' })
                .success(() => {
                    KeycloakService.auth.loggedIn = true;
                    KeycloakService.auth.authObj = keycloakAuth;
                    console.log(KeycloakService.auth.authObj);
                    // KeycloakService.auth.logoutUrl = keycloakAuth.authServerUrl
                    // + "/realms/WFS_Test/tokens/logout?redirect_uri=http://localhost:9000/";
                    // console.log(KeycloakService.auth.logoutUrl);
                    resolve(null);
                })
                .error(() => {
                    reject(null);
                });
        });
    }
    static logout() {
        KeycloakService.auth.loggedIn = false;
        KeycloakService.auth.authz = null;
        var http = location.protocol;
        var slashes = http.concat("//");
        var host = slashes.concat(window.location.host);
        KeycloakService.auth.authObj.logout({ redirectUri: host });
        // window.location.href = KeycloakService.auth.logoutUrl;
    }
    // getToken(): Promise<string> {
    //     return new Promise<string>((resolve, reject) => {
    //         if (KeycloakService.auth.authObj.token) {
    //             KeycloakService.auth.authObj.updateToken(10).success(function() {
    //                 resolve(<string>KeycloakService.auth.authObj.token);
    //             })
    //                 .error(function() {
    //                     reject('Failed to refresh token');
    //                 });
    //         }
    //     });
    // }
       static refreshToken() {
        //    console.log('inside token refresh');
        KeycloakService.auth.authObj.updateToken(10).success(function(refreshed) {
            if (refreshed) {
            //    console.log(KeycloakService.auth.authObj);
            } else {
                // console.log('Token not refreshed, valid for ' + Math.round(KeycloakService.auth.authObj.tokenParsed.exp + KeycloakService.auth.authObj.timeSkew - new Date().getTime() / 1000) + ' seconds');
            }
        }).error(function() {
            // console.log('Failed to refresh token');
            KeycloakService.logout();
        });
       }
}
