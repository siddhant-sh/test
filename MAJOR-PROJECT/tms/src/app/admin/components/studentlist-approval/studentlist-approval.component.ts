import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../utility/student.service';

@Component({
  selector: 'app-studentlist-approval',
  templateUrl: './studentlist-approval.component.html',
  styleUrls: ['./studentlist-approval.component.scss']
})
export class StudentlistApprovalComponent implements OnInit {

  studentList:any;
  msg:any
  errorMessage: any;
  constructor(private _studentser:StudentService) { }

  ngOnInit(): void {
    this.getAllStudentforApproval();
  }

  getAllStudentforApproval(){
this._studentser.getAllStudentForApproval().subscribe(data=>{
  this.studentList=data;
})
}

approved(id:any){  
this._studentser.approvedStudentById(id).subscribe({
  next: data => {
    this.msg = data
    this.ngOnInit();
    console.log(this.msg)
},

  error: error => {
    this.errorMessage = error.message;
    console.error('There was an error!', error);
}
})
}

block(id:any){  
  this._studentser.blockStudentById(id).subscribe({
    next: data => {
      this.msg = data
      this.ngOnInit();
      console.log(this.msg)
  },
  
    error: error => {
      this.errorMessage = error.message;
      console.error('There was an error!', error);
  }
  })
  }

  reject(id:any){  
    this._studentser.rejectStudentById(id).subscribe({
      next: data => {
        this.msg = data
        this.ngOnInit();
        console.log(this.msg)
    },
    
      error: error => {
        this.errorMessage = error.message;
        console.error('There was an error!', error);
    }
    })
    }

}


