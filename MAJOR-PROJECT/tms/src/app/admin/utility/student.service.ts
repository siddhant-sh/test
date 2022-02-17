import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  url = "http://localhost:9090/admin"
  token = sessionStorage['token']
  httpOption = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  }
  postId: any;
  errorMessage: any;

  constructor(private _http: HttpClient) { }

  getAllStudentForApproval(): Observable<any> {
    return this._http.get<any>(this.url + "/studentsForApproval", this.httpOption)
  }

  approvedStudentById(id: any): Observable<any> {
    return this._http.get<any>(this.url + "/acceptstudent/" + id, this.httpOption)
  }

  blockStudentById(id: any): Observable<any> {
    return this._http.get<any>(this.url + "/blockstudent/" + id, this.httpOption)
  }

  rejectStudentById(id: any): Observable<any> {
    return this._http.get<any>(this.url + "/rejectstudent/" + id, this.httpOption)
  }

  getAllApprovedStudent(): Observable<any> {
    return this._http.get<any>(this.url + "/approvedstudents", this.httpOption)
  }
  getAllBlockededStudent(): Observable<any> {
    return this._http.get<any>(this.url + "/blockedstudents", this.httpOption)
  }
  getAllRejectedStudent(): Observable<any> {
    return this._http.get<any>(this.url + "/rejectedstudents", this.httpOption)
  }
}
