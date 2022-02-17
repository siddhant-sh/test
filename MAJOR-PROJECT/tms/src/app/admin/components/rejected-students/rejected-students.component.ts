import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../utility/student.service';

@Component({
  selector: 'app-rejected-students',
  templateUrl: './rejected-students.component.html',
  styleUrls: ['./rejected-students.component.scss']
})
export class RejectedStudentsComponent implements OnInit {
  studentList: any;

  constructor(private _studentser:StudentService) { }

  ngOnInit(): void {
    this.getApprovedStudentlist()
  }

  getApprovedStudentlist(){
this._studentser.getAllRejectedStudent().subscribe(data=>{
this.studentList=data;
})
}


}
