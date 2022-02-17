import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TutorModule } from '../tutor/tutor.module';
import { ApprovedStudentsComponent } from './components/approved-students/approved-students.component';
import { ApprovedtutorsComponent } from './components/approvedtutors/approvedtutors.component';
import { BlockedStudentsComponent } from './components/blocked-students/blocked-students.component';
import { BlockedTutorComponent } from './components/blocked-tutor/blocked-tutor.component';
import { PendingTutorComponent } from './components/pending-tutor/pending-tutor.component';
import { RejectedStudentsComponent } from './components/rejected-students/rejected-students.component';
import { RejectedTutorComponent } from './components/rejected-tutor/rejected-tutor.component';
import { ReportsComponent } from './components/reports/reports.component';
import { StudentlistApprovalComponent } from './components/studentlist-approval/studentlist-approval.component';
import { TutorMaterialComponent } from './components/tutor-material/tutor-material.component';
import { TutorTechnologyComponent } from './components/tutor-technology/tutor-technology.component';

const routes: Routes = [
  {path:"studentApproval",component:StudentlistApprovalComponent},
  {path:"approvedStudent",component:ApprovedStudentsComponent},
  {path:"rejectedStudent",component:RejectedStudentsComponent},
  {path:"blockStudent",component:BlockedStudentsComponent},     
  {path:"blockedTutors",component:BlockedTutorComponent}, 
  {path:"rejectedTutors",component:RejectedTutorComponent}, 
  {path:"approvedTutors",component:ApprovedtutorsComponent}, 
  {path:"pendingTutors",component:PendingTutorComponent},
  {path:"tutor-material/:id",component:TutorMaterialComponent},
  {path:"tutor-technology/:id",component:TutorTechnologyComponent},
  {path:"reports",component:ReportsComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
