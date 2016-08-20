import {Injectable} from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Router
} from '@angular/router';
import {KeycloakService} from '../../keycloak';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private _router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    if ( KeycloakService.auth.loggedIn ) {
      return true;
    }

    this._router.navigate(['home']);
    return false;
  }
}
