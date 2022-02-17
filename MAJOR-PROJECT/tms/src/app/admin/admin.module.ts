import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { ApprovedtutorsComponent } from './components/approvedtutors/approvedtutors.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { StudentlistApprovalComponent } from './components/studentlist-approval/studentlist-approval.component';
import { ApprovedStudentsComponent } from './components/approved-students/approved-students.component';
import { BlockedStudentsComponent } from './components/blocked-students/blocked-students.component';
import { RejectedStudentsComponent } from './components/rejected-students/rejected-students.component';
import { PendingTutorComponent } from './components/pending-tutor/pending-tutor.component';
import { BlockedTutorComponent } from './components/blocked-tutor/blocked-tutor.component';
import { RejectedTutorComponent } from './components/rejected-tutor/rejected-tutor.component';
import { TutorMaterialComponent } from './components/tutor-material/tutor-material.component';
import { BarRatingModule } from 'ngx-bar-rating';
import { TutorTechnologyComponent } from './components/tutor-technology/tutor-technology.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ChartsModule } from 'ng2-charts';
import { ReportsComponent } from './components/reports/reports.component';

@NgModule({
  declarations: [
    ApprovedtutorsComponent,   
    StudentlistApprovalComponent,
    ApprovedStudentsComponent,
    BlockedStudentsComponent,
    RejectedStudentsComponent,
    PendingTutorComponent,
    BlockedTutorComponent,
    RejectedTutorComponent,
    TutorMaterialComponent,
    TutorTechnologyComponent,
    ReportsComponent,

  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BarRatingModule,
    NgbModule,
    ChartsModule
  ]
})
export class AdminModule { }
