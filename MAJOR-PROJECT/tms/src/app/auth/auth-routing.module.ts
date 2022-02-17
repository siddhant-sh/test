import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterStudentComponent } from './components/register-student/register-student.component';
import { RegisterTutorComponent } from './components/register-tutor/register-tutor.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"registertutor",component:RegisterTutorComponent},
  {path:"registerstudent",component:RegisterStudentComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
