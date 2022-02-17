import { Component, OnInit } from '@angular/core';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-rejected-tutor',
  templateUrl: './rejected-tutor.component.html',
  styleUrls: ['./rejected-tutor.component.scss']
})
export class RejectedTutorComponent implements OnInit {
  tutorList :any;
  constructor(private _tutorser:TutorService) { }
  ngOnInit(): void {
    this.getApprovedStudentlist()
  }

  getApprovedStudentlist(){
this._tutorser.getAllRejectedTutor().subscribe(data=>{
this.tutorList=data;
})
}
}
