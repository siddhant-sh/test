import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FeedbackService } from '../../utility/feedback.service';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-enrolledstudentlist',
  templateUrl: './enrolledstudentlist.component.html',
  styleUrls: ['./enrolledstudentlist.component.scss']
})
export class EnrolledstudentlistComponent implements OnInit {

  enrolledStudentList = []
  feedback = []
  studentList = []
  constructor(
    private _tutorService: TutorService,
    private _router: Router,
    private _tostr: ToastrService,
    private _feedbackSer: FeedbackService) { }

  ngOnInit(): void {
    this.getEnrolledStudent();
  }

  getEnrolledStudent() {
    this._tutorService
      .getEnrolledStudentList()
      .subscribe((data) => {
        if (data != null) {
          this.enrolledStudentList = data
          this.getAllFeedbacksforTutor();
        }
        else
          this._tostr.error("Something went wrong, Please relogin")
      });
  }

  onBlockStudentForTutor(enrollid) {
    this._tutorService.blockStudent(enrollid).subscribe(data => {
      if (data != null) {
        this._tostr.success("Student Blocked Successfully")
        this.ngOnInit();
      }
      else
        this._tostr.error("Blocking Student Failed")
    })
  }

  getAllFeedbacksforTutor() {
    this._feedbackSer.getFeedbacks().subscribe(data => {
      this.feedback = data;
      this.getData();

    })
  }

  getData() {
    let i = 0;


    this.enrolledStudentList.forEach(student => {
      let rating = 0;
      let technologies = []
      let enrollid = []
      let stud
      this.feedback.forEach(feedback => {
        if (student.belongsToStudents.id == feedback.respondentid) {
          rating = feedback.rating
        }
      })
      this.enrolledStudentList.forEach(tech => {
        if (student.belongsToStudents.id == tech.belongsToStudents.id) {
          stud = student.belongsToStudents
          technologies.push(tech.belongsToTechnology);
          let enroll = { "id": tech.enrollid }
          enrollid.push(enroll)
        }

      })
      if (i > 0) {
        if (student.belongsToStudents.id != this.studentList[i - 1].student.id) {
          this.studentList[i++] = {
            "student": stud,
            "technologies": technologies,
            "rating": rating,
            "enroll": enrollid
          }
        }
      } else {
        this.studentList[i++] = {
          "student": stud,
          "technologies": technologies,
          "rating": rating,
          "enroll": enrollid
        }
      }
    })


  }

}
