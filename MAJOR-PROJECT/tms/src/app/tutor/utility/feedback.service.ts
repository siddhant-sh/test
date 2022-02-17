import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private url = "http://localhost:9090/tutor"
  token= sessionStorage['token']
  httpOption = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  }
  constructor(private _http:HttpClient) { }

  getFeedbacks():Observable<any> {
    return this._http.get<any>(this.url+"/feedback/getAll/"+ sessionStorage["id"],this.httpOption)
  }
}
