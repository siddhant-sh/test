import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminGaurdService } from './auth/utility/admin-gaurd.service';
import { StudentGaurdService } from './auth/utility/student-gaurd.service';
import { TutorGaurdService } from './auth/utility/tutor-gaurd.service';
import { AdminhomeComponent } from './main/components/adminhome/adminhome.component';
import { PagenotfoundComponent } from './main/components/pagenotfound/pagenotfound.component';
import { StudenthomeComponent } from './main/components/studenthome/studenthome.component';
import { TutorhomeComponent } from './main/components/tutorhome/tutorhome.component';
import { WelcomeComponent } from './main/components/welcome/welcome.component';

const routes: Routes = [
  { path: '', redirectTo: "welcome", pathMatch: 'full' },
  { path: "welcome", component: WelcomeComponent },
  { path: "auth", loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  {
    path: "adminhome",
    component: AdminhomeComponent,
    canActivate: [AdminGaurdService],
    children: [
      { path: "admin", loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) }
    ]
  },
  {
    path: "tutorhome",
    component: TutorhomeComponent,
    canActivate: [TutorGaurdService],
    children: [
      { path: "tutor", loadChildren: () => import('./tutor/tutor.module').then(m => m.TutorModule) }
    ]
  },
  {
    path: "studenthome",
    component: StudenthomeComponent,
    canActivate: [StudentGaurdService],
    children: [
      { path: "student", loadChildren: () => import('./student/student.module').then(m => m.StudentModule) }
    ]
  },
  { path: "**", component: PagenotfoundComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
