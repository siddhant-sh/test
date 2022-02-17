import { Component, OnInit } from '@angular/core';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-blocked-tutor',
  templateUrl: './blocked-tutor.component.html',
  styleUrls: ['./blocked-tutor.component.scss']
})
export class BlockedTutorComponent implements OnInit {
  tutorList: any;
  constructor(private _tutorser:TutorService) { }
  ngOnInit(): void {
    this.getApprovedStudentlist()
  }

  getApprovedStudentlist(){
this._tutorser.getAllBlockededStudent().subscribe(data=>{
this.tutorList=data;
})
}
}
