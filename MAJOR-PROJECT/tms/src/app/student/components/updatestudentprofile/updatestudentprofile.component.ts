import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { ValidatorService } from 'src/app/auth/utility/validator.service';
import { StudentService } from '../../utility/student.service';

@Component({
  selector: 'app-updatestudentprofile',
  templateUrl: './updatestudentprofile.component.html',
  styleUrls: ['./updatestudentprofile.component.scss']
})
export class UpdatestudentprofileComponent implements OnInit {

  username = ""
  email =  ""
  qualification = ""
  updateProfileForm: FormGroup;
  submitted = false;

  constructor(private toastr: ToastrService,
  private modal: NgbActiveModal,
  private _studentService: StudentService,
  private fb: FormBuilder,
  private _validatserv : ValidatorService
  ) {
    
  }

  ngOnInit(): void {
    this.updateProfileForm=this.fb.group({
      name:['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      qualification:['',Validators.required]
    },
    {  
      validator: this._validatserv.MatchEmail(this.email, 'email')  
    }
    )
    this.updateProfileForm.setValue({
      name:this.username,
      email:this.email,
      qualification:this.qualification
    })
  }

  get f() { return this.updateProfileForm.controls; }

  onUpdate(updateProfile: FormGroup) {
    this.submitted = true;
    if (this.updateProfileForm.invalid) {
      return;
    }
    this._studentService.updateStudent(updateProfile.value)
      .subscribe(response => {
        if (response != null) {
          this.modal.dismiss('ok')
          this.toastr.success(this.username+" Profile updated successfully")
        } else {
          this.toastr.error(response['error'])
        }
      })
  }

  onCancel() {
    this.modal.dismiss('cancel')
  }
}
