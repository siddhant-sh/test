import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../utility/student.service';

@Component({
  selector: 'app-approved-students',
  templateUrl: './approved-students.component.html',
  styleUrls: ['./approved-students.component.scss']
})
export class ApprovedStudentsComponent implements OnInit {
  studentList: any;

  msg: any;
  errorMessage: any;

  constructor(private _studentser:StudentService) { }

  ngOnInit(): void {
    this.getApprovedStudentlist()
  }

  getApprovedStudentlist(){
this._studentser.getAllApprovedStudent().subscribe(data=>{
this.studentList=data;
})
}


block(id:any){  
  this._studentser.blockStudentById(id).subscribe({
    next: data => {
      this.msg = data
      this.ngOnInit();
  },
  
    error: error => {
      this.errorMessage = error.message;
      console.error('There was an error!', error);
  }
  })
  }


}
