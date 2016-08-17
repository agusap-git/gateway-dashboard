import {KeycloakService} from "./keycloak";
import {BaseRequestOptions, Headers} from "@angular/http";

export class MyBaseRequestOptions extends BaseRequestOptions {
  headers: Headers = new Headers({
    'X-Requested-With': 'XMLHttpRequest',
    'Authorization': 'BEARER ' + KeycloakService.auth.authObj.token,
    'Accept': 'application/json'
  });
  withCredentials: boolean = true;
}
