import { Component, OnInit } from '@angular/core';
import { EnrolledlistService } from '../../utility/enrolledlist.service';

@Component({
  selector: 'app-enrolled-list',
  templateUrl: './enrolled-list.component.html',
  styleUrls: ['./enrolled-list.component.scss']
})
export class EnrolledListComponent implements OnInit {
  id: any = sessionStorage['id'];
  pendingenrolledlist: any[];
  rejectedenrolledlist: any;
  constructor(private _enrolledListservice: EnrolledlistService) { }

  ngOnInit(): void {
    this.getPendingEnrolledList();
    this.getRejectedEnrolledList();

  }

  getPendingEnrolledList() {
    this._enrolledListservice.getPendingEnrolledList().subscribe((data) => {
      this.pendingenrolledlist = data.reduce((enrolledlist, pendingerolledlist) => {
        if (pendingerolledlist.belongsToStudents.id == this.id) {
          enrolledlist.push(pendingerolledlist);
          return enrolledlist;
        } else return enrolledlist;
      }, []);
    })

  }


  getRejectedEnrolledList() {
    this._enrolledListservice.getRejectedEnrolledList().subscribe((data) => {
      this.rejectedenrolledlist = data.reduce((enrolledlist, pendingerolledlist) => {
        if (pendingerolledlist.belongsToStudents.id == this.id) {
          enrolledlist.push(pendingerolledlist);
          return enrolledlist;
        } else return enrolledlist;
      }, []);
    })
  }
}
