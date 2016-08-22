import {KeycloakService} from './keycloak';
import {BaseRequestOptions, Headers} from '@angular/http';

export class MyBaseRequestOptions extends BaseRequestOptions {
  public headers: Headers = new Headers({
    'X-Requested-With': 'XMLHttpRequest',
    'Authorization': 'BEARER ' + KeycloakService.auth.authObj.token,
    'Accept': 'application/json'
  });
  withCredentials: boolean = true;
}
