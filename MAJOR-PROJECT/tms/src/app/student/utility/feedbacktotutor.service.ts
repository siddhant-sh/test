import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbacktotutorService {
  
  private url = "http://localhost:9090/student"
  token= sessionStorage['token']
  httpOption = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  }
  constructor(private _http:HttpClient) { }

  feedbackToTutor(tutorId: number, tutorUsername: string, average: number):Observable<any> {
    const body={
      receiverid:tutorId,
      respondentid:sessionStorage["id"],
      respondentname:sessionStorage["username"],
      receivername:tutorUsername,
      rating:average
    }
    return this._http.post<any>(this.url+"/feedback/add",body,this.httpOption)
  }

  getFeedback():Observable<any>{
    return this._http.get<any>(this.url+"/feedback/getAll/"+sessionStorage["id"],this.httpOption)
  }

  getAllFeedback(): Observable<any>{
    return this._http.get<any>("http://localhost:9090/user/feedback/getAll", this.httpOption)    
  }

}
