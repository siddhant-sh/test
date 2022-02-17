import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url = "http://localhost:9090/";
  isExist: false
  constructor(
    private _http: HttpClient,
    private _router: Router
  ) { }


  authenticate(email: any, password: any) {
    const body = {
      email: email,
      password: password
    }
    return this._http.post<any>(this.url + 'authenticate', body);
  }

  logout() {
    sessionStorage.removeItem('id')
    sessionStorage.removeItem('username')
    sessionStorage.removeItem('token')
    this._router.navigate['/auth/login']
  }

  registerStudent(body: any) {
    return this._http.post<any>(this.url + 'student/register', body);
  }

  registerTutor(body: any) {
    return this._http.post<any>(this.url + 'tutor/register', body);
  }
}
