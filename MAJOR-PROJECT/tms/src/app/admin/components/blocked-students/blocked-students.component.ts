import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../utility/student.service';


@Component({
  selector: 'app-blocked-students',
  templateUrl: './blocked-students.component.html',
  styleUrls: ['./blocked-students.component.scss']
})
export class BlockedStudentsComponent implements OnInit {
  studentList: any;

  constructor(private _studentser:StudentService) { }

  ngOnInit(): void {
    this.getApprovedStudentlist()
  }

  getApprovedStudentlist(){
this._studentser.getAllBlockededStudent().subscribe(data=>{
this.studentList=data;
})
}


}
