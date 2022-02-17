import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGaurdService implements CanActivate{

  constructor(
    private _router: Router,
    private _authserv:AuthService
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    if (sessionStorage['token']) {
      let jwt = sessionStorage['token']
      let decodedJwtData = JSON.parse(window.atob(jwt.split('.')[1]))
      if (decodedJwtData.isAdmin)
        return true
      else
      this._authserv.logout();
    }
    this._router.navigate(['/auth/login'])
    return false
  }
}
